package TIMEN;

import Knowledge.*;
import NUMEK.NUMEK;
import Rules.*;
import com.almworks.sqlite4java.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import utils_bk.*;

/**
 *
 * @author Hector Llorens
 * @since 2012
 */
public class TIMEN {

    public static String program_path = FileUtils.getApplicationPath() + "program-data/";
    private Locale locale;
    private NUMEK numek;
    private SQLiteConnection db;
    private Knowledge knowledge;

    public TIMEN() {
        this(Locale.getDefault());
    }

    // constructor
    public TIMEN(Locale l) {
        numek = new NUMEK(l);
        locale = l;

        // load knowledge (in the future the knowledge should be a sqlite db)
        // The sqlite is loaded into a hash in construction and then it is fast if used in tml files
        Class c;
        try {
            String lang = l.getLanguage().toUpperCase();
            c = Class.forName("Knowledge.Knowledge_" + lang);
            knowledge = (Knowledge) c.newInstance();
        } catch (Exception e) {
            System.err.println("Errors found (" + this.getClass().getSimpleName() + "):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
            // try taking default
            try {
                knowledge = (Knowledge) (Class.forName("Knowledge.Knowledge_EN")).newInstance();
            } catch (Exception ex) {
                System.err.println("Errors found (" + this.getClass().getSimpleName() + "):\n\t" + ex.getMessage() + "\n");
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }

        try {
            // disable sqlite logging
            Logger.getLogger("com.almworks.sqlite4java").setLevel(Level.OFF);
            db = new SQLiteConnection(new File(program_path + "rules_" + l.getLanguage() + ".db"));
            db.open(true);
        } catch (SQLiteException ex) {
            System.err.println("Instantiation SQLiteException: " + ex.getMessage());
        }
    }

    // destructor
    public void dispose() {
        knowledge = null;
        locale = null;
        numek = null;
        db.dispose();

    }
    public static String granul_years = "yyyy";
    public static String granul_months = "yyyy-MM";
    public static String granul_days = "yyyy-MM-dd";
    public static String granul_time = "yyyy-MM-dd'T'HH:mm";
    public static String granul_seconds = "yyyy-MM-dd'T'HH:mm:ss";
    public static String granul_weeks = "yyyy-'W'ww";

    /**
     * Simplified version of normalize (no tense, no context)
     * @param expr          the temporal expression text (multiwords use "_" for concat)
     * @param dct           date creation time
     * @return
     */
    public String normalize(String expr, String dct) {
        return this.normalize(expr, dct, "omit", dct);
    }

    /**
     * Obtains the ISO8601 normalized value for the given features.
     * @param expr          the temporal expression text (multiwords use "_" for concat)
     * @param dct           date creation time
     * @param tense         sentence tense (optional)
     * @param ref_val       reference point - last time ref (optional)
     * @return
     */
    public String normalize(String expr, String dct, String tense, String reftime) {
        /*      
         * OMITED: pos, lemma, depverb, phrase type, prep_mod
         * (prep_mod not needed since "in 3 years" does not mean "3 years now" or anything different from "during 3 years")
         *
         * In the future, anaphoric cases like 3 refering 3 hours or 3 months are out...
         * a solution is saving in addition to reftime, refduration...
        (it should be reset each 2 sentences)
         */
        // search by pattern first
        // then if more than one is found
        //      filter by other features
        // period... recursive pattern? NO
        // what happens with modifiers (almost, aproximately, ...)
        // default normalization when no pattern is found
        // in patterns, is it important to distinguish card from ordinals?


        String norm_value = "default_norm";


        try {
            if (expr == null || dct == null || tense == null || reftime == null) {
                throw new Exception("Some of the TIMEN.normalize() arguments are null.");
            }

            if (!tense.equals("omit")) {
                if (tense.startsWith("past-") || tense.startsWith("present-perfect")) {
                    tense = "past";
                } else {
                    if (tense.equals("conditional")) {
                        tense = "future";
                    } else {
                        if (tense.contains("-")) {
                            tense = tense.substring(0, tense.indexOf('-'));
                        }
                        if (!tense.matches("(?:past|present|future)")) {
                            tense = "present";
                        }
                    }
                }
            }
            String normTextandPattern = this.getNormTextandPattern(expr);
            if (normTextandPattern == null) {
                throw new Exception("Problem obtaining NormText and Pattern from: " + expr);
            }
            String[] normTextandPattern_arr = normTextandPattern.split("\\|");
            String normText = normTextandPattern_arr[0];
            String pattern = normTextandPattern_arr[1];

            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                System.err.println("\n\ntimex:" + expr + "  normtext:" + normText + "  pattern:" + pattern + "  dct:" + dct + "  reftime:" + reftime + "  tense:" + tense + "\nfound rules:");
            }

            // includes tense, DCT and reftime validation
            TIMEX_Instance timex_object = new TIMEX_Instance(normText, tense, dct, reftime);
            ArrayList<Rule> rules_found;
            for (int level = 1; level <= 3; level++) {
                rules_found = get_rules_from_db("RULES_LEVEL" + level, pattern);
                norm_value = apply_rules(rules_found, pattern, timex_object);
                if (!norm_value.equals("default_norm")) {
                    break;
                }
            }

            // reduce left-right
            while (pattern.split("_").length > 1 && norm_value.equals("default_norm")) {
                normText = normText.replaceFirst("[^_]+_", "");
                pattern = pattern.replaceFirst("[^_]+_", "");
                timex_object = new TIMEX_Instance(normText, tense, dct, reftime);
                for (int level = 1; level <= 3; level++) {
                    rules_found = get_rules_from_db("RULES_LEVEL" + level, pattern);
                    norm_value = apply_rules(rules_found, pattern, timex_object);
                    if (!norm_value.equals("default_norm")) {
                        break;
                    }
                }
            }

            // reduce right-left?

            // other heuristics?

        } catch (Exception e) {
            System.err.println("Errors found (" + this.getClass().getSimpleName() + "):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
            }
            System.exit(1);
        }




        return norm_value;
    }

    public Locale getLocale() {
        return locale;
    }

    public ArrayList<Rule> get_rules_from_db(String table, String pattern) {
        ArrayList<Rule> rules_found = new ArrayList<Rule>();
        try {
            SQLiteStatement st = db.prepare("SELECT * FROM " + table + " where pattern='" + pattern + "'");
            try {
                // st.bind(1, minimumQuantity);
                while (st.step()) {
                    //orders.add(
                    rules_found.add(new Rule(st.columnInt(0), st.columnString(1), st.columnString(2), st.columnString(3), st.columnString(4)));
                    //System.err.println("\t"+st.columnInt(0) + " " + st.columnString(1)+" rule to apply: "+st.columnString(2));
                    //);
                }
            } finally {
                st.dispose();
            }
        } catch (Exception e) {
            System.err.println("Errors found (" + this.getClass().getSimpleName() + "):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
            }
            System.exit(1);
        }
        return rules_found;
    }

    public String apply_rules(ArrayList<Rule> rules_found, String pattern, TIMEX_Instance timex_object) {
        String norm_value = "default_norm";
        try {
            if (rules_found.size() == 0) {
                // debugg (return default)
                if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                    System.err.println("\tNo rules found for: " + pattern);
                }
            } else {
                // debugg
                for (Rule rule : rules_found) {
                    if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                        System.err.println("\t" + rule.get_id() + " " + rule.get_pattern() + " rule to apply: " + rule.get_rule());
                    }
                }

                if (rules_found.size() == 1) {
                    //apply
                    norm_value = Rule_Engine.apply(rules_found.get(0), this, timex_object);
                    if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                        System.err.println("result: " + norm_value);
                    }
                } else {
                    // choose one:
                    // Disambiguation: select the first that matches all conditions
                    boolean select;
                    if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                        System.err.println("Disambiguation needed...");
                    }
                    for (Rule rule : rules_found) {
                        select = true;
                        if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                            System.err.println("\t" + rule.get_id() + " rule to apply: " + rule.get_rule() + " conditions: " + rule.get_rule_condition());
                        }
                        if (rule.get_rule_condition() != null) {
                            // TODO: WE SHOULD CREATE A CONDITION GRAMMAR TOO...
                            //BUT FOR THE MOMENT WE CAN ALLOW ONLY ONLY ONE CONDITION
                            String condition = rule.get_rule_condition().replaceAll("\\s+", "");
                            String operator = condition.replaceAll("[^!<=>]", "");
                            String[] condition_args = rule.get_rule_condition().split("(<=|>=|==|!=)");
                            if (condition_args.length < 2) {
                                condition_args = rule.get_rule_condition().split("(<|>)");
                            }
                            if (condition_args.length != 2 || operator.length() < 1) {
                                throw new Exception("Malformed condition in rule: " + rule.get_id() + " condition: " + condition);
                            }
                            // get PAT values
                            if (condition_args[0].matches("PAT\\([^)]*\\)")) {
                                condition_args[0] = timex_object.getNormTextArr()[Integer.parseInt(condition_args[0].replaceFirst("PAT\\(([^)]*)\\)", "$1"))];
                            }
                            if (condition_args[1].matches("PAT\\([^)]*\\)")) {
                                condition_args[1] = timex_object.getNormTextArr()[Integer.parseInt(condition_args[1].replaceFirst("PAT\\(([^)]*)\\)", "$1"))];
                            }
                            /*if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                            System.err.println(operator+"("+condition_args[0]+","+condition_args[1]+")");
                            } */
                            // handle operators
                            if (operator.equals("==") && !condition_args[0].equals(condition_args[1])) {
                                select = false;
                            }
                            if (operator.equals("!=") && condition_args[0].equals(condition_args[1])) {
                                select = false;
                            }
                            if (operator.equals("<=") && !(Integer.parseInt(condition_args[0]) <= Integer.parseInt(condition_args[1]))) {
                                select = false;
                            }
                            if (operator.equals(">=") && !(Integer.parseInt(condition_args[0]) >= Integer.parseInt(condition_args[1]))) {
                                select = false;
                            }
                            if (operator.equals("<") && !(Integer.parseInt(condition_args[0]) < Integer.parseInt(condition_args[1]))) {
                                select = false;
                            }
                            if (operator.equals(">") && !(Integer.parseInt(condition_args[0]) > Integer.parseInt(condition_args[1]))) {
                                select = false;
                            }
                        }
                        if (select) {
                            //apply
                            norm_value = Rule_Engine.apply(rule, this, timex_object);
                            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                                System.err.println("result (rule " + rule.get_id() + "): " + norm_value);
                            }
                            break;
                        } else {
                            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                                System.err.println("\tUnmached condition");
                            }
                        }
                    }
                }

            }
        } catch (Exception e) {
            System.err.println("Errors found (" + this.getClass().getSimpleName() + "):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
            }
            System.exit(1);
        }
        return norm_value;

    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //
    // Functions of the normalization gramar
    //
    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Returns a 4 digit year guessed from a less than 4 digit representation.
     * @param year
     * @return
     */
    public static String to_year(String year, TIMEX_Instance timex_object) {
        year = year.trim();

        // if the date is not numeric...
        if (!year.matches("[0-9]+")) {
            System.err.println("Using DCT year. Number expected in to_tyear(), found: " + year);
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                System.exit(1);
            }
            return timex_object.dct.getYear();
        }
        // ignore >4 digit dates
        if (year.length() >= 4) {
            return year;
        }

        //(1 and 3 refer to old dates--- add 0s)
        if (year.length() != 2) {
            int l = year.length();
            for (int i = l; i < 4; i++) {
                year = "0" + year;
            }
        }

        // disambiguation strategy
        int ambigyear = Integer.parseInt(year);
        String dctyear = timex_object.dct.getYear();
        int dct2dig = Integer.parseInt(dctyear.substring(2));
        int dctcentury = Integer.parseInt(dctyear.substring(0, 2));

        if (dct2dig < ambigyear && timex_object.getTense().startsWith("past")) {
            dctcentury -= 1;
        }
        return new Integer(ambigyear + dctcentury * 100).toString();
    }

    public String to_month(String month) {
        String output = "" + knowledge.Yearmonths.get(month);
        if (output.length() == 1) {
            output = "0" + output;
        }
        return output;
    }

    public String to_day(String day) {
        int dayi=Integer.parseInt(day);
        if(dayi<0 || dayi>31){
            System.err.println("Day lower than 0 or greater than 31, found: " + day);
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                System.exit(1);
            }
            dayi=1;
        }
        String output = ""+dayi;
        if (output.length() == 1) {
            output = "0" + output;
        }
        return output;
    }

    /**
     * Returns a valid TimeML period format
     * @param num
     * @param TUnit
     * @return
     */
    public String to_period(String num, String TUnit) {
        String ret = "";
        if (TUnit.matches("(hour|minute|second)")) {
            ret += "T";
        }

        // must translate e.g. 120 min into 2h?? probably not... just leave it as it is
        // knowledge main file needs TUnit equivalence relations...

        ret += num;
        ret += knowledge.TUnits.get(TUnit).substring(0, 1).toUpperCase();

        return ret;
    }

    /**
     * Adds a positive or negative integer of a chosen granularity from a specific reference (dct or reftime)
     * @param reference
     * @param granularity
     * @param quantity
     * @return
     */
    public String add(String reference, String granularity, int quantity, TIMEX_Instance timex_object) {
        Calendar cal = timex_object.dct.getCalendar();
        SimpleDateFormat formatter = new SimpleDateFormat(granul_days);

        try {

            if (reference.equalsIgnoreCase("REFTIME")) {
                cal = timex_object.reftime.getCalendar();
            }

            // get the normalized English name
            granularity = knowledge.TUnits.get(granularity);



            if (granularity.equalsIgnoreCase("year")) {
                formatter = new SimpleDateFormat(granul_years);
                cal.add(GregorianCalendar.YEAR, quantity);
            } else {
                if (granularity.equalsIgnoreCase("month")) {
                    formatter = new SimpleDateFormat(granul_months);
                    cal.add(GregorianCalendar.MONTH, quantity);
                } else {
                    if (granularity.equalsIgnoreCase("week")) {
                        formatter = new SimpleDateFormat(granul_weeks);
                        cal.add(GregorianCalendar.WEEK_OF_YEAR, quantity);
                    } else {
                        if (granularity.equalsIgnoreCase("day")) {
                            formatter = new SimpleDateFormat(granul_days);
                            cal.add(GregorianCalendar.DAY_OF_MONTH, quantity);
                        } else {
                            if (granularity.equalsIgnoreCase("hour")) {
                                formatter = new SimpleDateFormat(granul_time);
                                cal.add(GregorianCalendar.HOUR_OF_DAY, quantity);
                            } else {
                                if (granularity.equalsIgnoreCase("minute")) {
                                    formatter = new SimpleDateFormat(granul_time);
                                    cal.add(GregorianCalendar.MINUTE, quantity);

                                } else {
                                    if (granularity.equalsIgnoreCase("second")) {
                                        formatter = new SimpleDateFormat(granul_seconds);
                                        cal.add(GregorianCalendar.SECOND, quantity);
                                    } else {
                                        if (granularity.equalsIgnoreCase("quarter")) {
                                            formatter = new SimpleDateFormat(granul_months);
                                            cal.add(GregorianCalendar.MONTH, quantity * 3);
                                        } else {
                                            if (granularity.equalsIgnoreCase("semester")) {
                                                formatter = new SimpleDateFormat(granul_months);
                                                cal.add(GregorianCalendar.MONTH, quantity * 6);
                                            } else {

                                                if (granularity.equalsIgnoreCase("decade")) {
                                                    formatter = new SimpleDateFormat(granul_years);
                                                    cal.add(GregorianCalendar.YEAR, quantity * 10);
                                                } else {
                                                    if (granularity.equalsIgnoreCase("century")) {
                                                        formatter = new SimpleDateFormat(granul_years);
                                                        cal.add(GregorianCalendar.YEAR, quantity * 100);
                                                    } else {
                                                        if (granularity.equalsIgnoreCase("millennium")) {
                                                            cal.add(GregorianCalendar.YEAR, quantity * 1000);
                                                            formatter = new SimpleDateFormat(granul_years);
                                                        } else {
                                                            throw new Exception("Invalid granularity.");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("Errors found (TIMEN):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }

        return formatter.format(cal.getTime());
    }

    /**
     * Adds a positive or negative integer from a weekday given a specific reference (dct or reftime)
     * @param reference
     * @param weekday
     * @param quantity
     * @return
     */
    public String add_weekday(String reference, String weekday, int quantity, TIMEX_Instance timex_object) {
        Calendar cal = timex_object.dct.getCalendar();
        SimpleDateFormat formatter = new SimpleDateFormat(granul_days);

        try {
            if (reference.equalsIgnoreCase("REFTIME")) {
                cal = timex_object.reftime.getCalendar();
            }
            formatter = new SimpleDateFormat(granul_days);
            cal.set(GregorianCalendar.DAY_OF_WEEK, knowledge.Weekdays.get(weekday));
            cal.add(GregorianCalendar.DAY_OF_MONTH, quantity);

        } catch (Exception e) {
            System.err.println("Errors found (TIMEN):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }

        return formatter.format(cal.getTime());
    }

    public String getTOD(String tod) {
        String result = "";
        try {
            result = knowledge.TODs.get(tod);
        } catch (Exception e) {
            System.err.println("Errors found (TIMEN):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }

        return result;
    }

    public String date_weekday(String reference, String weekday, TIMEX_Instance timex_object) {
        Calendar cal = new GregorianCalendar();
        Date refdate = timex_object.dct.getCalendar().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat(granul_days);
        try {
            if (reference.equalsIgnoreCase("REFTIME")) {
                refdate = timex_object.reftime.getCalendar().getTime();
            }
            cal.setTime(refdate);
            cal.set(GregorianCalendar.DAY_OF_WEEK, knowledge.Weekdays.get(weekday));
            Date result = cal.getTime();
            if (!timex_object.getTense().startsWith("omit")) {
                if (result.before(refdate)) {
                    if (!timex_object.getTense().startsWith("past")) {
                        cal.add(GregorianCalendar.WEEK_OF_YEAR, 1);
                    }
                } else {
                    if (result.equals(refdate)) {
                        if (timex_object.getTense().equals("past")) {
                            //if (locale.getLanguage().equalsIgnoreCase("es")) {
                            cal.add(GregorianCalendar.WEEK_OF_YEAR, -1);
                            //}
                        } else {
                            cal.add(GregorianCalendar.WEEK_OF_YEAR, 1);
                        }
                    } else { // after
                        if (timex_object.getTense().startsWith("past")) {
                            cal.add(GregorianCalendar.WEEK_OF_YEAR, -1);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Errors found (TIMEN):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }

        return formatter.format(cal.getTime());
    }

    public String date_month(String reference, String month, TIMEX_Instance timex_object) {
        Calendar cal = new GregorianCalendar();
        Date refdate = timex_object.dct.getCalendar().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat(granul_months);
        try {
            if (reference.equalsIgnoreCase("REFTIME")) {
                refdate = timex_object.reftime.getCalendar().getTime();
            }
            cal.setTime(refdate);
            cal.set(GregorianCalendar.MONTH, knowledge.Yearmonths.get(month));
            Date result = cal.getTime();
            if (!timex_object.getTense().startsWith("omit")) {
                if (result.before(refdate)) {
                    if (timex_object.getTense().equals("future")) {
                        cal.add(GregorianCalendar.YEAR, 1);
                    }
                } else {
                    if (result.equals(refdate)) {
                        if (timex_object.getTense().equals("past")) {
                            cal.add(GregorianCalendar.YEAR, -1);
                        } else {
                            cal.add(GregorianCalendar.YEAR, 1);
                        }
                    } else { // after
                        if (timex_object.getTense().equals("past")) {
                            cal.add(GregorianCalendar.YEAR, -1);
                        }
                    }

                }
            }

        } catch (Exception e) {
            System.err.println("Errors found (TIMEN):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }

        return formatter.format(cal.getTime());
    }

    public String date_month_day(String reference, String month, String day, TIMEX_Instance timex_object) {
        Calendar cal = new GregorianCalendar();
        Date refdate = timex_object.dct.getCalendar().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat(granul_days);
        try {
            if (reference.equalsIgnoreCase("REFTIME")) {
                refdate = timex_object.reftime.getCalendar().getTime();
            }
            cal.setTime(refdate);
            cal.set(GregorianCalendar.MONTH, knowledge.Yearmonths.get(month));
            cal.set(GregorianCalendar.DAY_OF_MONTH, Integer.parseInt(day));
            Date result = cal.getTime();
            if (!timex_object.getTense().startsWith("omit")) {

                if (result.before(refdate)) {
                    if (timex_object.getTense().equals("future")) {
                        cal.add(GregorianCalendar.YEAR, 1);
                    }
                } else {
                    if (result.equals(refdate)) {
                        if (timex_object.getTense().equals("past")) {
                            cal.add(GregorianCalendar.YEAR, -1);
                        } else {
                            cal.add(GregorianCalendar.YEAR, 1);
                        }
                    } else { // after
                        if (timex_object.getTense().equals("past")) {
                            cal.add(GregorianCalendar.YEAR, -1);
                        }
                    }

                }
            }

        } catch (Exception e) {
            System.err.println("Errors found (TIMEN):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }

        return formatter.format(cal.getTime());
    }

    /*******************************************************************
     *  NORMALIZING TEXT INPUT
     ******************************************************************/
    /**
     * Obtains the normalized text (NormText) and Patter from a given timex textual expression
     * @param timex    the timex textual expression
     * @return         the feature-values for NormText and Pattern
     */
    @SuppressWarnings("static-access")
    public String getNormTextandPattern(String timex) {
        String normText = "";
        String pattern = "";
        try {
            // ONLY FOR SECURITY. re-normalize spaces (ensure no spaces)
            timex = timex.replaceAll("\\s+", "_"); // ONLY FOR SECURITY
            // ONLY FOR SECURITY (we expect _ already)

            timex = "_" + timex + "_";

            // remove useless symbols
            timex = timex.replaceAll("_,", ""); // tokenized commas
            timex = timex.replaceAll(",_", "_"); // untokenized commas

            // Numeric ordinals to numbers
            timex = timex.replaceAll("([0-9]+)(?:_)?(?:st|nd|rd|th)", "$1");

            // Check for separate date/time separators -> UNIFY
            timex = timex.replaceAll("([0-9]+)_([-/:])_([0-9]+|" + knowledge.TMonths_re + ")_([-/:])_([0-9]+)", "$1$2$3$4$5");
            timex = timex.replaceAll("([0-9]+[-/:])_((?:[0-9]+|" + knowledge.TMonths_re + ")[-/:])_([0-9]+)", "$1$2$3");
            timex = timex.replaceAll("([0-9]+)_([-/:](?:[0-9]+|" + knowledge.TMonths_re + "))_([-/:][0-9]+)", "$1$2$3");
            timex = timex.replaceAll("([0-9]+|" + knowledge.TMonths_re + ")_([-/:])_([0-9]+)", "$1$2$3");
            timex = timex.replaceAll("((?:[0-9]+|" + knowledge.TMonths_re + ")[-/:])_([0-9]+)", "$1$2");
            timex = timex.replaceAll("([0-9]+|" + knowledge.TMonths_re + ")_([-/:][0-9]+)", "$1$2");


            // Special for mids
            timex = timex.replaceAll("mid(?:-)?([0-9]+)", "mid_$1");
            timex = timex.replaceAll("mid-(.+)", "mid_$1");

            //Special for 80s, etc.
            timex = timex.replaceAll("([0-9]+)s", "$1_s");

            // Special adjective periods (e.g., 10-hour), and special quarter
            timex = timex.replaceAll("([^_]+)-(" + knowledge.TUnit_re + "|quarter)", "$1_$2");

            // Special for fractions (only one is normalized because there should be no more than one per timex)
            if (timex.matches("(?:.*_)?(?:[0-9]*_)?[1-9][0-9]*/[1-9][0-9]*_" + knowledge.TUnit_re + ".*")) {
                String nums2norm = timex.replaceFirst("(.*_)?((?:[0-9]*_)?[1-9][0-9]*/[1-9][0-9]*)(_" + knowledge.TUnit_re + ".*)", "$2");
                String normalizedfrac = "" + NUMEK.calc_and_sum_frac(nums2norm.replaceAll("_", " "));
                timex = timex.replaceFirst("(.*_)?((?:[0-9]*_)?[1-9][0-9]*/[1-9][0-9]*)(_" + knowledge.TUnit_re + ".*)", "$1" + normalizedfrac + "$3");
            }


            // DISAMBIGUATE IF NEEDED
            if (knowledge.ambiguous_re!=null && timex.matches(knowledge.ambiguous_re)) {
                timex = knowledge.disambiguate(timex);
            }

            // remove useless tokens (language - specific)
            // TODO... perhaps articles do not have to be removed (distinguish dates and periods)
            // the week DATE, week PERIOD
            if (locale.getLanguage().equalsIgnoreCase("en")) {
                timex = timex.replaceAll("_of_", "_");
            }
            if (locale.getLanguage().equalsIgnoreCase("es")) {
                timex = timex.replaceAll("_de_", "_"); //.replaceAll("_del_", "_").replaceAll("_el_", "_").replaceAll("_la_", "_").replaceAll("_los_", "_").replaceAll("_las_", "_");
            }

            timex = timex.substring(1, timex.length() - 1);

            String[] tempex_arr = timex.split("_");

            // check spelled nums and repair other elements (mid, sept., etc.)
            // spelled nums (e.g., one million or 25 hundred)
            // ([0-9]+(\\.[0-9]+_spelledMagnitude_))?(spelled_)+, if after [0-9] there is no spell leave as it is.
            String spelledNum = "";
            String currentPat = "";
            for (int i = 0; i < tempex_arr.length; i++) {
                if (tempex_arr[i].matches(knowledge.TOD_re)) {
                    currentPat = "TOD";
                } else {
                    if (tempex_arr[i].matches(knowledge.Seasons_re)) {
                        currentPat = "Season";
                    } else {

                        if (tempex_arr[i].matches(knowledge.TUnit_re)) {
                            tempex_arr[i] = knowledge.normalizeTUnit(tempex_arr[i]);
                            currentPat = "TUnit";
                        } else {
                            if (tempex_arr[i].matches(knowledge.TMonths_re)) {
                                tempex_arr[i] = tempex_arr[i].replaceAll("\\.", "");
                                currentPat = "TMonth";
                            } else {
                                if (tempex_arr[i].matches(knowledge.TWeekdays_re)) {
                                    tempex_arr[i] = tempex_arr[i].replaceAll("\\.", "");
                                    currentPat = "TWeekday";
                                } else {
                                    if (tempex_arr[i].matches("(?:[0-2])?[0-9][.:][0-5][0-9](?:(?:p|a)(?:\\.)?m(?:\\.)?|h)?")) {
                                        currentPat = "Time";
                                    } else {
                                        if (tempex_arr[i].matches("(?:[0-3])?[0-9][./-](?:(?:[0-3])?[0-9]|" + knowledge.TMonths_re + ")[./-][0-9]+") // dd-mm-yyyy
                                                || tempex_arr[i].matches(knowledge.TMonths_re + "[/-][0-9]+") // MM-yyyy
                                                || tempex_arr[i].matches("(?:1[0-2]|(?:0)?[1-9])[/-][1-2][0-9]{3}") // mm-yyyy
                                                || tempex_arr[i].matches("[0-9]{4}[./-](?:1[0-2]|(?:0)?[1-9])[./-](?:[0-3])?[0-9]") // ISO
                                                ) {
                                            currentPat = "Date";
                                        } else {
                                            if (tempex_arr[i].matches("[0-9]+(?:\\.[0-9]+)?") || tempex_arr[i].matches("(" + numek.numbers_re + "|" + numek.tens_re + "-" + numek.units_re + ")") || (!spelledNum.equals("") && !spelledNum.matches(".*([0-9]|" + numek.ordinals_re + ").*") && tempex_arr[i].matches(numek.numdelim))) {
                                                currentPat = "Num";
                                            } else {
                                                currentPat = tempex_arr[i].toLowerCase();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // check if a spellednum ends
                if (!spelledNum.equals("") && (!currentPat.equals("Num") || tempex_arr[i].matches("[0-9]+(?:\\.[0-9]+)?") || spelledNum.trim().matches(numek.ordinals_re) || tempex_arr[i].trim().matches(numek.ordinals_re))) {
                    //if (!spelledNum.trim().matches(numek.ordinals_re)) {
                    normText += " " + numek.text2number(spelledNum.trim());
                    //} else {
                    //    normText += " " + spelledNum.trim();
                    //}
                    pattern += " Num";
                    spelledNum = ""; // initialize
                }

                // add to normTE or to spelled num
                if (currentPat.equalsIgnoreCase("Num")) {
                    spelledNum += " " + tempex_arr[i];
                } else {
                    // Month could be replaced by a number eg Oct by 08 but since Java manages Month names is OK.
                    normText += " " + tempex_arr[i].toLowerCase().replaceAll("^sept(\\.)?$", "sep"); //.replaceFirst("^.*s$", tempex_arr[i].toLowerCase().substring(0, tempex_arr[i].length() - 1));
                    pattern += " " + currentPat;
                }
            }

            // add last spellednum if exists
            if (!spelledNum.equals("")) {
                //if (!spelledNum.trim().matches(numek.ordinals_re)) {
                normText += " " + numek.text2number(spelledNum.trim());
                //} else {
                //    normText += " " + spelledNum.trim();
                //}
                pattern += " Num";
            }

        } catch (Exception e) {
            System.err.println("Errors found (TIMEN):\n\t" + e.toString() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
            return null;
        }

        return (normText.trim() + "|" + pattern.trim()).replaceAll(" ", "_");

    }
}
