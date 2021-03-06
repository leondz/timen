package org.timen.timen;

import org.timen.timen.rules.*;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
//import java.sql.Statement;
import java.text.*;
import java.util.*;
import org.timen.timen.knowledge.time.Timek;

/**
 *
 * @author Hector Llorens
 * @since 2012
 */
public class TIMEN implements Closeable {

    public static SimpleDateFormat dct_format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
    private Locale locale;
    private Timek timek;
    private Connection connection;
    public HashMap<String, Integer> Java_Weekdays;
    public HashMap<String, Integer> Java_Yearmonths;


    public TIMEN() {
        this(Locale.getDefault());
    }

    // constructor
    public TIMEN(Locale l) {
        timek = new Timek(l,"knowledge-bases");
        locale = l;
        this.loadJavaTemporalKnowledge(l);


        // load knowledge (in the future the knowledge should be a sqlite db)
        // The sqlite is loaded into a hash in construction and then it is fast if used in tml files
        //System.out.println(locale+" "+locale.getLanguage().toUpperCase());
        //             hacer como en nlpbk pero guardar este trozo como curiosid de java

        /*Class c;
        try {
            String lang = l.getLanguage().toUpperCase();
            c = Class.forName("org.timen.knowledge.Knowledge_" + lang);
            knowledge = (Knowledge) c.getConstructor(Locale.class).newInstance(locale);
        } catch (Exception e) {
            System.err.println("Errors found (" + this.getClass().getSimpleName() + "):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
            // try taking default
            try {
                locale = Locale.getDefault();
                knowledge = (Knowledge) (Class.forName("org.timen.knowledge.Knowledge_EN")).getConstructor(Locale.class).newInstance(locale);
            } catch (Exception ex) {
                System.err.println("Errors found (" + this.getClass().getSimpleName() + "):\n\t" + ex.getMessage() + "\n");
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }*/

        String databaseName = String.format("rules_%s.db", locale.getLanguage());
        // load the driver class for SQLite
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // establish the connection to the database
        try {
            // If there is an external database in res use it otherwise try to find it in resources (all-in-one)
            URL url = TIMEN.class.getProtectionDomain().getCodeSource().getLocation();
            String applicationpath = (new File(URLDecoder.decode(url.getFile(), "UTF-8"))).getAbsolutePath();
            if (applicationpath.contains(".jar")) {
                // means that TIMEN is used as a library
                applicationpath = applicationpath.substring(0, applicationpath.lastIndexOf(File.separator) + 1);
                if (applicationpath.endsWith(File.separator + "lib" + File.separator)) {
                    applicationpath = applicationpath.substring(0, applicationpath.length() - 5);
                }
            }
            if (applicationpath.endsWith("build" + File.separator + "classes")) {
                applicationpath = applicationpath.substring(0, applicationpath.length() - 14);
            }
            // + File.separator + "res"
            // NOT USED BECAUSE IT SUPOSES THAT THE DB is inside resources
            String dbpath = applicationpath + File.separator + "rule-bases" + File.separator + databaseName;
            //System.out.println(dbpath);
           /* if ((new File(dbpath)).exists()) {
                // NOTE that if there is a rule-base out of the classpath it will be used (override the  one included in timen jar)
                if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                    //+ File.separator + "res"
                    System.err.println("Using: " + "jdbc:sqlite:" + "."  + File.separator + "rule-bases" + File.separator + databaseName);
                }
                //+ File.separator + "res"
                connection = DriverManager.getConnection("jdbc:sqlite:" + "."  + File.separator + "rule-bases" + File.separator + databaseName);
            } else {*/
                if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                    System.err.println("Using (same in win and linux): " + "jdbc:sqlite::resource:rule-bases/" + databaseName);
                }
                connection = DriverManager.getConnection("jdbc:sqlite::resource:rule-bases/" + databaseName);
            //}
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        //knowledge = null;
        locale = null;
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // destructor
    /**
     * @deprecated Use {@link #close()} instead. 
     */
    @Deprecated
    public void dispose() {
        this.close();
    }
    public static String granul_years = "yyyy";
    public static String granul_months = "yyyy-MM";
    public static String granul_days = "yyyy-MM-dd";
    public static String granul_time = "yyyy-MM-dd'T'HH:mm";
    public static String granul_seconds = "yyyy-MM-dd'T'HH:mm:ss";
    public static String granul_weeks = "yyyy-'W'ww";

    
    
     /**
     * Loads the localized java GregorianCalendar temporal knowledge (i.e., DOW, MOY) for the indicated locale l
     *
     * @param l language locale
     *
     */
    private void loadJavaTemporalKnowledge(Locale l) {
        // load Java Days-of-the-week
        Java_Weekdays = new HashMap<>();
        String[] temp = new DateFormatSymbols(l).getWeekdays();
        for (int i = 1; i < temp.length; i++) {
            Java_Weekdays.put(temp[i].toLowerCase(l), i);
        }
        temp = new DateFormatSymbols(l).getShortWeekdays();
        for (int i = 1; i < temp.length; i++) {
            Java_Weekdays.put(temp[i].toLowerCase(l), i);
        }
        //System.out.println(Java_Weekdays.toString());

        // load Months of the year
        Java_Yearmonths = new HashMap<>();
        temp = new DateFormatSymbols(l).getMonths();
        for (int i = 0; i < temp.length - 1; i++) {
            //System.out.println(i+temp[i]+ " "+l.toString());
            Java_Yearmonths.put(temp[i].toLowerCase(l), i);
        }
        temp = new DateFormatSymbols(l).getShortMonths();
        for (int i = 0; i < temp.length - 1; i++) {
            //System.out.println(i+temp[i]);
            Java_Yearmonths.put(temp[i].toLowerCase(l), i);
        }
        //System.out.println(Java_Yearmonths.toString());
    }
    

    
    /**
     * Basic version of normalize (no tense, no context,no DCT)
     * @param expr          the temporal expression text (multiwords use "_" for concat)
     * @return normalization (value)
     */
    public String normalize(String expr) {
        String dct = dct_format.format(new Date());
        return this.normalize(expr, dct, "omit", dct);
    }
    
    /**
     * Simplified version of normalize (no tense, no context)
     * @param expr          the temporal expression text (multiwords use "_" for concat)
     * @param dct           date creation time
     * @return normalization (value)
     */
    public String normalize(String expr, String dct) {
        return this.normalize(expr, dct, "omit", dct);
    }

    /**
     * Obtains the ISO8601 normalized value for the given features.
     * @param expr          the temporal expression text (multiwords use "_" for concat)
     * @param dct           date creation time
     * @param tense         sentence tense (optional)
     * @param reftime       reference point - last time ref (optional)
     * @return normalization (value)
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
                        if (!tense.matches("(?:past|present|future)")) { // closest will end up here for now
                            tense = "present";
                        }
                    }
                }
            }
            // Converting c_ord to card to be compatible with old TIMEN (without card/ord differentiation)
            String normTextandPattern = timek.getNormTextandPattern(expr).replaceAll("c_ord","c_card").replaceAll("ord__", "");
            if (normTextandPattern == null) {
                throw new Exception("Problem obtaining NormText and Pattern from: " + expr);
            }
            String[] normTextandPattern_arr = normTextandPattern.split("\\|");
            String normText = normTextandPattern_arr[0];
            String pattern = normTextandPattern_arr[1];

                //System.err.println("\n\ntimex:" + expr + "  normtext:" + normText + "  pattern:" + pattern + "  dct:" + dct + "  reftime:" + reftime + "  tense:" + tense + "\nfound rules:");
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
            while (pattern.split(" ").length > 1 && norm_value.equals("default_norm")) {
                normText = normText.replaceFirst("[^ ]+ ", "");
                pattern = pattern.replaceFirst("[^ ]+ ", "");
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

    public ArrayList<Rule> get_rules_from_db(String table, String pattern) throws SQLException {
        ArrayList<Rule> rules_found = new ArrayList<Rule>();
        // Unsafe!! it allows sql injection
        //Statement statement = connection.createStatement();
        //pattern = pattern.replaceAll("'", ""); // this is too simple and removes '
        // normally scaping is '' but it may vary among DBMSs, better use a standard way
        // SOLUTION: PreparedStatement
        String query = "SELECT * FROM " + table + " where pattern = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, pattern);
        //ResultSet resultSet = statement.executeQuery(query);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            rules_found.add(new Rule(
                    resultSet.getInt("id"),
                    resultSet.getString("pattern"),
                    resultSet.getString("rule_type"),
                    resultSet.getString("rule"),
                    resultSet.getString("rule_condition")));
            //System.err.println("\t"+st.columnInt(0) + " " + st.columnString(1)+" rule to apply: "+st.columnString(2));
        }
        return rules_found;

        //DEPRECATED sqlite4java alternative
        /* try {
        SQLiteStatement st = db.prepare("SELECT * FROM " + table + " where pattern='" + pattern + "'");
        try {
        while (st.step()) {
        rules_found.add(new Rule(st.columnInt(0), st.columnString(1), st.columnString(2), st.columnString(3), st.columnString(4)));
        }
        } finally {    st.dispose();    }
        } catch (Exception e) {
        System.err.println("Errors found (" + this.getClass().getSimpleName() + "):\n\t" + e.getMessage() + "\n");
        if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
        e.printStackTrace(System.err);
        }
        System.exit(1);
        }*/

    }

    public String apply_rules(ArrayList<Rule> rules_found, String pattern, TIMEX_Instance timex_object) {
        String norm_value = "default_norm";
        try {
            if (rules_found.isEmpty()) {
                // debugg (return default)
                if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                    System.err.println("\tNo rules found for: " + pattern);
                }
            } else {
                // debug
                    if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                for (Rule rule : rules_found) {
                        System.err.println("\t" + rule.get_id() + " " + rule.get_pattern() + " rule to apply: " + rule.get_rule());
                        //System.err.println(timex_object);
                                //, this, timex_object
                    }
                }

                if (rules_found.size() == 1) {
                    //apply
                    norm_value = Rule_Engine.apply(rules_found.get(0), this, timex_object);
                    if (norm_value == null) {
                        throw new Exception("[ERROR] Malformed rule in the used rules_xx.db: " + rules_found.get(0).get_rule());
                    }
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
                        if (rule.get_rule_condition() != null && !rule.get_rule_condition().equals("")) {
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
                            // get tense values
                            if (condition_args[0].equalsIgnoreCase("tense")) {
                                condition_args[0] = timex_object.getTense();
                            }
                            if (condition_args[1].matches("tense")) {
                                condition_args[1] = timex_object.getTense();
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
                            if (norm_value == null) {
                                throw new Exception("[ERROR] Malformed rule in the used rules_xx.db: " + rules_found.get(0).get_rule());
                            }
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
                System.exit(1);
            }
            return "default_norm";
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
     * @return string consisting of a 4-digit year
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
        String output = "" + (Java_Yearmonths.get(month.toLowerCase(locale)) + 1);
        if (output.length() == 1) {
            output = "0" + output;
        }
        return output;
    }

    public String to_day(String day) {
        int dayi = Integer.parseInt(day);
        if (dayi < 0 || dayi > 31) {
            System.err.println("Day lower than 0 or greater than 31, found: " + day);
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                System.exit(1);
            }
            dayi = 1;
        }
        String output = "" + dayi;
        if (output.length() == 1) {
            output = "0" + output;
        }
        return output;
    }

    public static String fill_zeros(String str, int quantity) {
        int filling = quantity - str.length();
        for (int i = 0; i < filling; i++) {
            str = "0" + str;
        }
        return str;
    }

    // IMPLEMENT FOR JOURNAL
    //date = date.replaceAll("mid-", "");
    //date = " " + date + " ";
    //if (locale.getLanguage().equalsIgnoreCase("en")) {
    //date = date.replaceAll(" the ", " ").replaceAll("\\s*-\\s*", "-").replaceAll("\\s*/\\s*", "/").replaceAll("\\s+", " ").trim();
    //    date = date.replaceAll("^(.*) ([0-9]+)(th|st|nd|rd) (.*)$", "$1 $2 $3 $4");
    //}
    //if (locale.getLanguage().equalsIgnoreCase("es")) {
    //    date = date.replaceAll(" (los|las|el|la|en) ", "").replaceAll("\\s*-\\s*", "-").replaceAll("\\s*/\\s*", "/").replaceAll("\\s+", " ");
    //    date = date.replaceAll(" (primero|uno) ", " 1 ").trim();
    //}
    public String to_century(String date) {
        // centuries this would be 21st or something like that
        String word_for_century = timek.phraselists.get("tunit").getMap().get(date.split(" ")[1]);
        if (word_for_century != null && word_for_century.equals("century")) {
            date = date.replaceAll(date.split(" ")[1] + "", "century");
        }
        if (date.matches("^[0-9]+ century$")) {
            return "" + (Integer.parseInt(date.split(" ")[0].replace("([0-9]{1,2}).*", "$1")));

        }
        return "default_norm";
    }

    public String to_decade(String date, TIMEX_Instance timex_object) {
        // numeric decades
        String ret = "decade";
        if (date.matches("[0-9]+")) {
            switch (date.length()) {
                case 2:
                    int cc = Integer.parseInt(timex_object.dct.getYear().substring(0, 2));
                    int cdec = Integer.parseInt(timex_object.dct.getYear().substring(2, 3));
                    int ddec = Integer.parseInt(date.substring(0,1));
                    if (cdec == 9 && ddec == 0 || (cdec == 0 || ddec > 1)) {
                        cc--;
                    }
                    return "" + cc + "" + ddec;
                //iso = to_year(date.substring(0, 2), timex_object);
                //return iso.substring(0, 3);
                case 4:
                    return date.substring(0, 3);
            }

        }
        // spelled decades
        if (timek.phraselists.get("decade").getMap().containsKey(date)) {
            return timek.phraselists.get("decade").getMap().get(date).toString();
        }
        return ret;
    }

    
    public String to_century(String date, TIMEX_Instance timex_object) {
        String ret = "unknown_century";
        if (date.matches("[0-9]+"))
                    ret=""+(Integer.parseInt(date) -1);
        return ret;
    }
    
    
    public String to_iso(String date, TIMEX_Instance timex_object) {
        String iso = null;

        // Check date granularity to return the same
        // Check language

        //System.out.println(date);
        try {
            DateFormat ofmt;



            // find the parsing format
            if (!date.contains("_")) { // UNIGRAM (ONE TOKEN DATE)
                // unformated numeric dates
                if (date.matches("[0-9]+")) {
                    switch (date.length()) {
                        case 2: // 2 digit year
                            return to_year(date, timex_object);
                        case 4: // already ISO
                            return date;
                    }

                }



                //normalize two-digit year
                if (date.matches("(?:[0-9]{1,2}[./-])?(?:[0-9]{1,2}|" + timek.phraselists.get("month").getRE() + ")[./-][0-9]{2}")) {
                    date = date.substring(0, date.length() - 2) + to_year(date.substring(date.length() - 2), timex_object);
                }
                //remove "." from dates 10/nov./2001 --> 10/nov/2001
                date = date.replaceAll("[.]([./-])", "$1");

                // check if it is already ISO but mantain the original with the granularity
                /*try {
                fmt = ISODateTimeFormat.dateOptionalTimeParser();
                fmt.parseDateTime(ISOclean(date));
                return date;
                } catch (Exception e) {
                iso = null; // just NOOP
                }*/

                /*if(date.matches(".*"+TMonths_re+"[/.-].*")){
                date=date.replaceAll("(.*)("+TMonths_re+")([/.-].*)", "$1\\I$2$3");
                }*/

                // Dates with separators / and -

                ofmt = new SimpleDateFormat(granul_seconds);
                iso = date2iso(date, new SimpleDateFormat("yyyy-MM-dd't'HH:mm:ss"), ofmt);
                if (iso != null) {
                    return iso;
                }

                ofmt = new SimpleDateFormat(granul_time);
                iso = date2iso(date, new SimpleDateFormat("yyyy-MM-dd't'HH:mm"), ofmt);
                if (iso != null) {
                    return iso;
                }


                ofmt = new SimpleDateFormat(granul_days);

                iso = date2iso(date, new SimpleDateFormat("yyyy-MM-dd"), ofmt);
                if (iso != null) {
                    return iso;
                }
                iso = date2iso(date, new SimpleDateFormat("dd-MM-yyyy"), ofmt);
                if (iso != null) {
                    return iso;
                }
                iso = date2iso(date, new SimpleDateFormat("dd/MM/yyyy"), ofmt);
                if (iso != null) {
                    return iso;
                }
                iso = date2iso(date, new SimpleDateFormat("dd-MMMM-yyyy"), ofmt);
                if (iso != null) {
                    return iso;
                }
                iso = date2iso(date, new SimpleDateFormat("dd/MMMM/yyyy"), ofmt);
                if (iso != null) {
                    return iso;
                }
                iso = date2iso(date, new SimpleDateFormat("MM-dd-yyyy"), ofmt);
                if (iso != null) {
                    return iso;
                }
                iso = date2iso(date, new SimpleDateFormat("MM/dd/yyyy"), ofmt);
                if (iso != null) {
                    return iso;
                }


                ofmt = new SimpleDateFormat(granul_months);

                iso = date2iso(date, new SimpleDateFormat("MM-yyyy"), ofmt);
                if (iso != null) {
                    return iso;
                }
                iso = date2iso(date, new SimpleDateFormat("MM/yyyy"), ofmt);
                if (iso != null) {
                    return iso;
                }
                iso = date2iso(date, new SimpleDateFormat("MMMM-yyyy"), ofmt);
                if (iso != null) {
                    return iso;
                }
                iso = date2iso(date, new SimpleDateFormat("MMMM/yyyy"), ofmt);
                if (iso != null) {
                    return iso;
                }





            }/* else { // multiword date/time
            if (locale.getLanguage().equalsIgnoreCase("en") && date.matches("(?i)(a good part of|end of|this|that|YEAR|(the )?early|(the )?late|fiscal) [0-9]+(s)?")) {
            return toISO8601(date.substring(date.lastIndexOf(' ') + 1), loc);
            }
            if (locale.getLanguage().equalsIgnoreCase("es") && date.matches("(?i)(una buena parte|al final de|este|ese|(el )?año|(a )?principios de|(a )?finales de) ([0-9]+|" + Decades_re + ")(s)?")) {
            return toISO8601(date.substring(date.lastIndexOf(' ') + 1), loc);
            }


            // useful replacements
            date = " " + date + " ";
            if (locale.getLanguage().equalsIgnoreCase("en")) {
            date = date.replaceAll(" of ", " ").replaceAll("[.,]", " ").replaceAll("\\s+", " ").trim();
            }
            if (locale.getLanguage().equalsIgnoreCase("es")) {
            date = date.replaceAll(" (?:el|la|los|las) ", " ").replaceAll(" de(?:l)? ", " ").replaceAll("[.,]", " ").replaceAll(" día ", " ").replaceAll("\\s+", " ").trim();
            }


            // spelled decades (spanish). HACK, todo década de los...
            if (date.matches(".*años.*")) {
            String date_ = date.replaceAll(" ", "_");
            date_ = date_.substring(date_.indexOf("años"));
            if (decades.containsKey(date_)) {
            return decades.get(date_).toString();
            }
            }


            // MMMM yyyy
            try {
            fmt = DateTimeFormat.forPattern("MMMM yyyy");
            DateTimeFormatter fmt_localized = fmt.withLocale(locale);
            return fmt_localized.parseDateTime(date).toString("yyyy-MM");
            } catch (Exception e) {
            iso = null;
            }

            // MMMM dd yyyy
            try {
            fmt = DateTimeFormat.forPattern("MMMM dd yyyy");
            DateTimeFormatter fmt_localized = fmt.withLocale(locale);
            return fmt_localized.parseDateTime(date).toString("yyyy-MM-dd");
            } catch (Exception e) {
            iso = null;
            }

            // dd MMMM yyyy
            try {
            fmt = DateTimeFormat.forPattern("dd MMMM yyyy");
            DateTimeFormatter fmt_localized = fmt.withLocale(locale);
            return fmt_localized.parseDateTime(date).toString("yyyy-MM-dd");
            } catch (Exception e) {
            iso = null;
            }

            // Seasons
            if (locale.getLanguage().equalsIgnoreCase("en") && date.matches("(.* )?" + Seasons_re + " [0-9]{4}")) {
            String[] temp = date.split(" ");
            if (date.matches(".*winter.*")) {
            return temp[temp.length - 1] + "-WI";
            }
            if (date.matches(".*spring.*")) {
            return temp[temp.length - 1] + "-SP";
            }
            if (date.matches(".*summer.*")) {
            return temp[temp.length - 1] + "-SU";
            }
            if (date.matches(".*(autumn|fall).*")) {
            return temp[temp.length - 1] + "-FA";
            }
            }
            if (locale.getLanguage().equalsIgnoreCase("es") && date.matches("(.* )?" + Seasons_re + " (de(l)? )?[0-9]{4}")) {
            String[] temp = date.split(" ");
            if (date.matches(".*invierno.*")) {
            return temp[temp.length - 1] + "-WI";
            }
            if (date.matches(".*primavera.*")) {
            return temp[temp.length - 1] + "-SP";
            }
            if (date.matches(".*verano.*")) {
            return temp[temp.length - 1] + "-SU";
            }
            if (date.matches(".*otoño.*")) {
            return temp[temp.length - 1] + "-FA";
            }
            }

            }*/


        } catch (Exception e) {
            System.err.println("Warnings found (TIMEK):\n\t" + e.toString() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
            return "PRESENT_REF"; // by default
        }

        return "PRESENT_REF"; // by default

    }

    public String date2iso(String date, DateFormat ifmt, DateFormat ofmt) {
        try {
            ifmt.setLenient(false);
            Date d = ifmt.parse(date);
            return ofmt.format(d);
        } catch (Exception e) {
            return null;
        }
    }

    public String to_time(String timex) {
        String ret = "12:00";
        boolean pm = false;
        timex = timex.replaceAll("\\.", "");
        if (timex.contains("pm")) {
            pm = true;
        }
        timex = timex.replaceAll("[ap]m", "");

        String[] time_arr = timex.split(":");

        for (int i = 0; i < 3; i++) {
            if (time_arr.length > i) {
                if (i == 0) {
                    ret = "";
                    if (pm) {
                        time_arr[i] = "" + (Integer.parseInt(time_arr[i]) + 12);
                    }
                } else {
                    ret += ":";
                }
                if (time_arr[i].length() == 1) {
                    time_arr[i] = "0" + time_arr[i];
                }
                ret += time_arr[i];
            }
        }

        if (ret.length() == 2) {
            ret += ":00";
        }

        return ret;
    }

    /**
     * Returns a valid TimeML period format
     * @param num
     * @param TUnit
     * @return String (valid TimeML period format)
     */
    public String to_period(String num, String TUnit) {
        String ret = "";
        if (TUnit.matches("(hour|minute|second)(s)?")) {
            ret += "T";
        }

        // must translate e.g. 120 min into 2h?? probably not... just leave it as it is
        // knowledge main file needs TUnit equivalence relations...
        // OTHER LANGS TUNITS ARE IN KNOWLEDE FILES

        ret += num;
        String punit = timek.phraselists.get("tunit").getMap().get(TUnit).substring(0, 3).toUpperCase();
        if (punit.matches("(DEC|CEN|MIL)")) {
            punit = timek.phraselists.get("tunit").getMap().get(TUnit).substring(0, 2).toUpperCase();
            if (punit.equals("MI")) {
                punit = "ML";
            }
            ret += punit;
        } else {
            ret += timek.phraselists.get("tunit").getMap().get(TUnit).substring(0, 1).toUpperCase();
        }


        return ret;
    }

    /**
     * Adds a positive or negative integer of a chosen granularity from a specific reference (dct or reftime)
     * @param reference
     * @param granularity
     * @param quantity
     * @return String (operated reference)
     */
    public String add(String reference, String granularity, int quantity, TIMEX_Instance timex_object) {
        Calendar cal = timex_object.dct.getCalendar();
        SimpleDateFormat formatter = new SimpleDateFormat(granul_days);

        try {

            if (reference.equalsIgnoreCase("REFTIME")) {
                cal = timex_object.reftime.getCalendar();
            }

            // get the normalized English name
            String gr = timek.phraselists.get("tunit").getMap().get(granularity);
            if (gr != null) {
                granularity = gr;
            }


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
     * @param quantity (new! now it is multiplied by 7)
     * @return String (operated reference)
     */
    public String add_weekday(String reference, String weekday, int quantity, TIMEX_Instance timex_object) {
        Calendar cal = timex_object.dct.getCalendar();
        SimpleDateFormat formatter = new SimpleDateFormat(granul_days);
        quantity=quantity*7;
        
        try {
            if (reference.equalsIgnoreCase("REFTIME")) {
                cal = timex_object.reftime.getCalendar();
            }
            //System.out.println(reference+weekday+quantity+timex_object+"---");
            //System.out.println(reference+weekday+quantity+timex_object+"---"+Java_Weekdays);
            formatter = new SimpleDateFormat(granul_days);
            cal.set(GregorianCalendar.DAY_OF_WEEK, Java_Weekdays.get(weekday.toLowerCase(locale)));
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
            result = timek.phraselists.get("time_of_day").getMap().get(tod);
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
            cal.set(GregorianCalendar.DAY_OF_WEEK, Java_Weekdays.get(weekday.toLowerCase(locale)));
            Date result = cal.getTime();
            if (!timex_object.getTense().startsWith("omit")) {
                if (result.before(refdate)) {
                    if (!timex_object.getTense().startsWith("past")) {
                        cal.add(GregorianCalendar.WEEK_OF_YEAR, 1);
                    }
                } else {
                    if (result.equals(refdate)) {
                        if (timex_object.getTense().equals("past")) {
                            // in English Newspapers they talk about the writing day as past
                            // because newspapers are published the day after
                            if (locale.getLanguage().equalsIgnoreCase("es")) {
                                cal.add(GregorianCalendar.WEEK_OF_YEAR, -1);
                            }
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
            cal.set(GregorianCalendar.MONTH, Java_Yearmonths.get(month.toLowerCase(locale)));
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
            cal.set(GregorianCalendar.MONTH, Java_Yearmonths.get(month.toLowerCase(locale)));
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

    public String date_weeknum_weekday_month(String reference, String num, String weekday, String month, TIMEX_Instance timex_object) {
        Calendar cal = new GregorianCalendar();
        Date refdate = timex_object.dct.getCalendar().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat(granul_days);
        try {
            if (reference.equalsIgnoreCase("REFTIME")) {
                refdate = timex_object.reftime.getCalendar().getTime();
            }
            cal.setTime(refdate);
            cal.set(GregorianCalendar.MONTH, Java_Yearmonths.get(month.toLowerCase(locale)));
            cal.set(GregorianCalendar.DAY_OF_MONTH, 0);
            int dayofweekday1 = cal.get(GregorianCalendar.DAY_OF_WEEK);
            cal.set(GregorianCalendar.DAY_OF_WEEK, Java_Weekdays.get(weekday.toLowerCase(locale)));
            // if first weekday of month is lower or equal than the given weekday, then substract one week (first (1) Monday will add already 1 week)
            if (dayofweekday1 <= Java_Weekdays.get(weekday.toLowerCase(locale))) {
                cal.add(GregorianCalendar.WEEK_OF_YEAR, -1);
            }
            cal.add(GregorianCalendar.WEEK_OF_YEAR, Integer.parseInt(num));
        } catch (Exception e) {
            System.err.println("Errors found (TIMEN):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }

        return formatter.format(cal.getTime());
    }

    public String date_last_weekday_month(String reference, String weekday, String month, TIMEX_Instance timex_object) {
        Calendar cal = new GregorianCalendar();
        Date refdate = timex_object.dct.getCalendar().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat(granul_days);
        try {
            if (reference.equalsIgnoreCase("REFTIME")) {
                refdate = timex_object.reftime.getCalendar().getTime();
            }
            cal.setTime(refdate);
            cal.set(GregorianCalendar.MONTH, Java_Yearmonths.get(month.toLowerCase(locale)) + 1);
            cal.set(GregorianCalendar.DAY_OF_MONTH, -1);
            Date bug = cal.getTime(); // BUG: Three consecutive sets without a get make the 2nd set useless
            cal.set(GregorianCalendar.DAY_OF_WEEK, Java_Weekdays.get(weekday.toLowerCase(locale)));
            int rmonth = cal.get(GregorianCalendar.MONTH);
            //System.out.println(cal.getTime());
            // if month is different than the provided (not greater because could be december-january), then substract one week
            if (rmonth != Java_Yearmonths.get(month.toLowerCase(locale))) {
                cal.add(GregorianCalendar.WEEK_OF_YEAR, -1);
            }
            //System.out.println(cal.getTime());

        } catch (Exception e) {
            System.err.println("Errors found (TIMEN):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }

        return formatter.format(cal.getTime());
    }


    //////////////////////////////////77
    // DEPRECATED
    /**
     * Returns an ISO8601 without abbreviations such as WI, Q1, SU, etc. then it can be represented as an exact GregorianCaledar reference
     * @param date
     * @return String (ISO 8601 without TimeML abbrev like WE, SU, etc.)
     */
    public static String ISOclean(String date) {
        if (date.matches("(?i)[0-9]{4}-(WI|SP|SU|AU|FA|Q(1|2|3|4)|H(1|2))")) {
            if (date.matches("(?i).*-(WI|Q1|H1)")) {
                date = date.substring(0, 4) + "-01";
            }
            if (date.matches("(?i).*-(SP|Q2)")) {
                date = date.substring(0, 4) + "-03";
            }
            if (date.matches("(?i).*-(SU|Q3|H2)")) {
                date = date.substring(0, 4) + "-06";
            }
            if (date.matches("(?i).*-(AU|FA|Q4)")) {
                date = date.substring(0, 4) + "-09";
            }
        }

        if (date.matches("(?i)[0-9]{4}-[0-9]{2}-[0-9]{2}T(MO|AF|EV|NI)")) {
            // MORNING 5-12
            if (date.matches("(?i).*TMO")) {
                date = date.substring(0, 10) + "T05:00";
            }
            // NOON 12-13
            if (date.matches("(?i).*TAF")) {
                date = date.substring(0, 10) + "T13:00";
            }
            // DEPEND ON WORK BREAKS
            if (date.matches("(?i).*TEV")) {
                date = date.substring(0, 10) + "T18:00";
            }
            // AFTER WORK... GOING BACK HOME...
            if (date.matches("(?i).*TNI")) {
                date = date.substring(0, 10) + "T21:00";
            }
        }

        // TODO: IN THE FUTURE TREAT BETTER THIS DATES
        // GET THE DATE WITHOUT WE AND THEN SET DAY TO SATURDAY...
        // GET BACK THE DATE IN STRING FORMAT WITH DAY GRANULARITY
        if (date.matches("(?i).*-WE")) {
            date = date.substring(0, date.length() - 3);
        }

        // JODA TIME RARE ERROR
        if (date.equals("1901")) {
            date = "1901-01-02";
        }

        return date;
    }

    /**
     * DON'T DO THIS: is unnatural if I say Monday present tense is a better default ("future").
     * It was a good fake to win evaluations or to guess tense but it is not something consistent.
     * Compare 2 dates to a reference and return the closest one
     * @param key
     * @param a
     * @param b
     * @return closest date
     */
    public static Date getClosestDate(Date key, Date a, Date b) {
        Date ret = a;
        return a;
    }
    
    
    
}
