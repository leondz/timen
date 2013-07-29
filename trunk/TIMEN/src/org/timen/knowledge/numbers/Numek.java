package org.timen.knowledge.numbers;

import org.timen.nlp_files.PhraselistFile;
import org.timen.utils.CognitionisFileUtils;
import java.io.File;
import java.util.*;

public class Numek {

    // this could probably be an abstract class
    public Locale locale;
    public HashSet<String> all_keys;
    public HashSet<String> repeated_keys;    
    public PhraselistFile ambiguous;

    // this could probably be a Map of phraselists (dynamic)
    public PhraselistFile delimiters;
    public PhraselistFile units;
    public PhraselistFile tens;
    public PhraselistFile irregular_tens;
    public PhraselistFile magnitudes;
    public PhraselistFile special_groups;
    public PhraselistFile restrictions;
    public PhraselistFile ordinals;
    public PhraselistFile decimal_point_separator;
    public PhraselistFile group_separators;

    //Number class is needed to store values objects by reference
    private class Number {

        public Double value;

        public Number() {
            value = 0.0;
        }

        public Number(Double v) {
            value = v;
        }
    }
    // Magnitude is whatever can have numbers or lower order magnitudes on the left
    // A number is whatever distinct to magnitude that cannot be operated with magnitudes on the left
    public final static Integer MAX_NUMBERS_ORDER = 99;  // Explicit numbers (one token) MAX order of magnitude
    // Roman numbers are static since they are not going to change
    public static String romans = "IVXLCDM";
    public static String romans5 = "VLD";
    public final static HashMap<String, Integer> romansMap = new HashMap<>();

    static {
        romansMap.put("I", 1);
        romansMap.put("V", 5);
        romansMap.put("X", 10);
        romansMap.put("L", 50);
        romansMap.put("C", 100);
        romansMap.put("D", 500);
        romansMap.put("M", 1000);
    }

    public Numek() {
        this(new Locale("en", "US"));
    }

    public Numek(Locale l) {
        locale = l;
        String lang = l.toString().replace('_', '-');
        all_keys=new HashSet<>();
        repeated_keys=new HashSet<>();
        try {
            // For our beloved Windows
            String extra = "";
            if (File.separator.equals("\\")) {
                extra = "\\";
            }
            String app_path = CognitionisFileUtils.getApplicationPath(); //.replaceAll(extra + File.separator + "classes", "");
            String res_path = app_path + File.separator + "knowledge-bases"  + File.separator + "numbers" + File.separator + lang + File.separator;
            if (!(new File(res_path)).exists()) {
                throw new Exception("Not-supported locale: " + lang);
            } else {
                // this can be done dynamically given .conf json file (requiring specific files...)
                // I understand more why VLINGO is how it is
                // This then could be a FOR loop
                delimiters = new PhraselistFile(res_path + "delimiters.phraselist");
                all_keys.addAll(delimiters.keySet());
                units = new PhraselistFile(res_path + "units.phraselist");
                repeated_keys.addAll(units.intersectPhraselist(all_keys));
                all_keys.addAll(units.keySet());              
                tens = new PhraselistFile(res_path + "tens.phraselist");
                repeated_keys.addAll(tens.intersectPhraselist(all_keys));                
                all_keys.addAll(tens.keySet());
                magnitudes = new PhraselistFile(res_path + "magnitudes.phraselist");
                repeated_keys.addAll(magnitudes.intersectPhraselist(all_keys));
                all_keys.addAll(magnitudes.keySet());
                decimal_point_separator = new PhraselistFile(res_path + "decimal_point_separator.phraselist");
                repeated_keys.addAll(decimal_point_separator.intersectPhraselist(all_keys));                
                all_keys.addAll(decimal_point_separator.keySet());
                ordinals = new PhraselistFile(res_path + "ordinals.phraselist");
                repeated_keys.addAll(ordinals.intersectPhraselist(all_keys));                
                all_keys.addAll(ordinals.keySet());
                if (new File(res_path + "irregular_tens.phraselist").exists()) {
                    irregular_tens = new PhraselistFile(res_path + "irregular_tens.phraselist");
                    repeated_keys.addAll(irregular_tens.intersectPhraselist(all_keys));                
                    all_keys.addAll(irregular_tens.keySet());
                }
                if (new File(res_path + "special_groups.phraselist").exists()) {
                    special_groups = new PhraselistFile(res_path + "special_groups.phraselist");
                    repeated_keys.addAll(special_groups.intersectPhraselist(all_keys));                
                    all_keys.addAll(special_groups.keySet());
                }
                if (new File(res_path + "group_separators.phraselist").exists()) {
                    group_separators = new PhraselistFile(res_path + "group_separators.phraselist");
                    repeated_keys.addAll(group_separators.intersectPhraselist(all_keys));                
                    all_keys.addAll(group_separators.keySet());
                }
                if (new File(res_path + "restrictions.phraselist").exists()) {
                    restrictions = new PhraselistFile(res_path + "restrictions.phraselist"); // do not count for ambiguity
                }

                if(!repeated_keys.isEmpty()){
                    // there should be a way to check if there is an ambiguity variable (all must have a config.json file)
                    throw new Exception("This knowledge element has unhandled ambiguity: "+repeated_keys);
                }
                // part modifiers are not used yet because more resarch is needed... can be language dependent
               // all_keys.contains(l);
                
            }
        } catch (Exception e) {
            System.err.println("Errors found in " + this.getClass().getName() + ":\n\t" + e.toString());
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
            }
        }
    }

    /**
     * Returns value of a fraction (e.g., 1/2 --> 0.5) or the sum of a number
     * and a fraction (e.g., 2 1/2 --> 2.5).
     *
     * @param snumber string number (separator is whitespace " ")
     *
     * @return result
     */
    public static Double calc_and_sum_frac(String snumber) {
        if (snumber.matches("([0-9]+ )?[0-9]+/[0-9]+")) {
            String[] temp;
            if (snumber.contains(" ")) {
                temp = snumber.split(" ");
                return Double.parseDouble(temp[0]) + Double.parseDouble(temp[1].substring(0, temp[1].indexOf('/'))) / Double.parseDouble(temp[1].substring(temp[1].indexOf('/') + 1));
            } else {
                return Double.parseDouble(snumber.substring(0, snumber.indexOf('/'))) / Double.parseDouble(snumber.substring(snumber.indexOf('/') + 1));
            }
        } else {
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                System.err.println("Warining: error normalizing fraction (" + snumber + ") it has been set to 0.0 by default.");
            }
            return 0.0;
        }
    }

    /**
     * Converts a spelled number to numeric (twenty -> 20) If the input is
     * numeric it is normalized. (010.0540 -> 10.054)
     * If the input is not normalizable: eight eight, then the same text is returned
     *
     * @param snumber
     * @return
     */
    public String text2number(String snumber) {
        // UK  "and" hundreds/thousands/tens/units separator "five hundred and six"
        // UK/US  "-" is tens and units separator
        // UK magnitudes are singular. Plural (milions) is informal/indefinite (e.g., there were millions of people)
        // eleven hundred == 1100 (correct in "informal" English)
        Number number = new Number(); // We cannot use Double because objects are not saved by reference
        try {

            // BASIC CLEANUP
            snumber = snumber.trim().toLowerCase(locale); //.replaceAll("\\s+(st|nd|rd|th|o|a)$", "").replaceAll("ord__", "");
            //snumber = snumber.replaceAll("^(?:a|an)\\s+((?:" + units.getRE() + "|" + tens.getRE() + "|" + irregular_tens.getRE() + ").*)$", "$1");

            Integer magnitude = 0; // order of magnitude
            Integer max_magn = MAX_NUMBERS_ORDER;
            String[] elements = snumber.split("(\\s*-\\s*|\\s+" + delimiters.getRE() + "\\s+|\\s+)"); // we need to add - because we cannot ensure space separation
            //System.out.println(snumber + " - numelems: "+elements.length);

            //remove group separator
            if (group_separators != null) {
                snumber = snumber.replaceAll(group_separators.getRE(), "");
            }
            //replace decimal separators by . (standardize to en-US)
            if (decimal_point_separator != null) {
                snumber = snumber.replaceAll(decimal_point_separator.getRE(), ".");
            }

            // NORMALIZE NUMERIC INPUTS
            if (snumber.matches("(-)?[0-9]+(\\.[0-9]+)?")) {
                return prettyFormat(Double.parseDouble(snumber));
            }
            if (snumber.matches("(-)?[0-9]+%")) {
                return "" + (Double.parseDouble(snumber.substring(0, snumber.length() - 1)) / 100);
            }

            if (snumber.matches("([0-9]+ )?[0-9]+/[0-9]+")) {
                return "" + calc_and_sum_frac(snumber);
            }

            // CHECK IF WE KNOW ALL THE ELEMENTS OF THE INPUT STRING
            for (int i = 0; i < elements.length; i++) {
                if (i == 0 && !elements[i].matches("[0-9]+") && !units.getMap().containsKey(elements[i]) && !tens.getMap().containsKey(elements[i]) && !irregular_tens.getMap().containsKey(elements[i]) && !magnitudes.getMap().containsKey(elements[i]) && !ordinals.getMap().containsKey(elements[i]) && !special_groups.getMap().containsKey(elements[i])) {
                    throw new Exception("Unknown element (0): " + elements[i] + " in " + snumber);
                }
                if (i != 0 && !units.getMap().containsKey(elements[i]) && !tens.getMap().containsKey(elements[i]) && !irregular_tens.getMap().containsKey(elements[i]) && !magnitudes.getMap().containsKey(elements[i]) && !special_groups.getMap().containsKey(elements[i])) {
                    throw new Exception("Unknown element (" + i + "): " + elements[i] + " in " + snumber);
                }
            }

            // ordinals
            if (elements.length == 1 && ordinals.getMap().containsKey(elements[0])) {
                return "" + ordinals.getMapValue(elements[0]);
            }

            // num grup expression
            if(snumber.matches(".*"+special_groups.getRE()+".*")){
                if (elements.length == 1 && special_groups.getMap().containsKey(elements[0])) {
                    return "" + special_groups.getMapValue(elements[0]);
                }
                if (elements.length == 2 && units.getMap().containsKey(elements[0]) && special_groups.getMap().containsKey(elements[1])) {
                    return "" + (Integer.parseInt(units.getMapValue(elements[0])) * Integer.parseInt(special_groups.getMapValue(elements[1])));
                }
                if (elements.length == 2 && irregular_tens.getMap().containsKey(elements[0]) && special_groups.getMap().containsKey(elements[1])) {
                    return "" + (Integer.parseInt(irregular_tens.getMapValue(elements[0])) * Integer.parseInt(special_groups.getMapValue(elements[1])));
                }
                if (elements.length == 2 && tens.getMap().containsKey(elements[0]) && special_groups.getMap().containsKey(elements[1])) {
                    return "" + (Integer.parseInt(tens.getMapValue(elements[0])) * Integer.parseInt(special_groups.getMapValue(elements[1])));
                }
                if (elements.length == 2 && special_groups.getMap().containsKey(elements[0]) && magnitudes.getMap().containsKey(elements[1])) {
                    return "" + (Integer.parseInt(special_groups.getMapValue(elements[0])) * Integer.parseInt(magnitudes.getMapValue(elements[1])));
                }
                if (elements.length == 3 && units.getMap().containsKey(elements[0]) && special_groups.getMap().containsKey(elements[1]) && magnitudes.getMap().containsKey(elements[2])) {
                    return "" + (Integer.parseInt(units.getMapValue(elements[0])) * Integer.parseInt(special_groups.getMapValue(elements[1])) * Integer.parseInt(magnitudes.getMapValue(elements[2])) );
                }
            }

            
            
            // date spelled number (nineteen eighty == 1980, 2010, 1919,2081,1981). Specific to English?
            /*if (locale.getLanguage().equals("en") && (elements.length == 2 || elements.length == 3) && (irregular_tens.getMap().containsKey(elements[0]) || tens.getMap().containsKey(elements[0])) && !magnitudes.getMap().containsKey(elements[1]) && (tens.getMap().containsKey(elements[1]) || irregular_tens.getMap().containsKey(elements[1]))) {
                Integer value = 0;
                if (irregular_tens.getMap().containsKey(elements[0])) {
                    value = Integer.parseInt(irregular_tens.getMapValue(elements[0])) * 100;
                } else {
                    value = Integer.parseInt(tens.getMapValue(elements[0])) * 100;
                }
                if (irregular_tens.getMap().containsKey(elements[1])) {
                    value += Integer.parseInt(irregular_tens.getMapValue(elements[1]));
                } else {
                    value += Integer.parseInt(tens.getMapValue(elements[1]));
                }
                if (elements.length == 3 && units.getMap().containsKey(elements[2])) {
                    value += Integer.parseInt(units.getMapValue(elements[2]));
                }
                return "" + value;
            }*/

            // number + magnitude: 20 million
            if (elements[0].matches("([0-9]+|([0-9]*.[0-9]+))")) {
                if (elements.length != 2) {
                    if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                        System.err.println("(UNDER CONSTRUCTION) Only the number and the first magnitude will be normalized: " + snumber);
                    }
                }
                Integer magn = Integer.parseInt(magnitudes.getMapValue(elements[1]));
                if (magn == null) {
                    if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                        System.err.println("In [0-9]+ magnitude numbers the second component must be a valid magnitude. Found: " + elements[1] + "   from: " + snumber);
                    }
                    magn = 1;
                }
                // TODO provar a ver si va .5
                return prettyFormat((Double.parseDouble(elements[0]) * magn));


            } else { // regular spelled number
                // the number (Number) object increases while i increases from units to the highest magnitude-unit pair
                Integer i = elements.length - 1; // i means the analyzed position from units to the highest magnitude-unit pair
                while (i >= 0) {
                    String element = elements[i].trim();
                    magnitude = null;
                    if (magnitudes.getMapValue(element) != null) {
                        magnitude = Integer.parseInt(magnitudes.getMapValue(element));
                    }
                    //System.err.println("i=" + i + " - " + element);
                    if (magnitude != null) {
                        //operate magnitude
                        if (magnitude <= (((int) Math.pow(10, number.value.toString().substring(0, number.value.toString().lastIndexOf('.')).length()) - 1))) {
                            throw new Exception("Greater magnitude expected in " + element + " (" + snumber + ")");
                        }
                        i = operateMagnitude(elements, i, number);
                    } else {
                        // operate number (only at rightest position)
                        if (i != (elements.length - 1)) {
                            // TODO no exception but warning..., 
                            throw new Exception("Unexpected number when looking for a magnitude. Found: " + element + " (" + snumber + ")");
                        }
                        i = getNumber(elements, i, number, max_magn);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Errors found (NUMEK):\n\t" + e.toString());
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                //System.exit(1);
            }
            //return snumber.replaceAll(" ", "-"); // not null nor textual string because it breaks the application
            /*if (number.value != null && number.value > 0) {
                return prettyFormat(number.value);
            } else {*/  // we should not return partial values
                return snumber;
            //}
        }

        // remove useless decimals
        return prettyFormat(number.value);
    }

    
    
    
    
    
    
    
    
    
    
    private String prettyFormat(Double numeknum) {
        //This is the correct use but will break for very big/small numbers, we can loose precision, but is shorter than the alternative
        return cleanNumberFormat(String.format(Locale.ENGLISH, "%1$.7f", numeknum));
        /*if (numeknum < 0) {
         return "-" + prettyFormat(-numeknum);
         }
         String snumeknum = String.valueOf(numeknum);
         int indexOfE = snumeknum.indexOf("E");
         if (indexOfE == -1) {
         return snumeknum;
         }
         StringBuilder sb = new StringBuilder();
         if (numeknum > 1) {//big number
         int exp = Integer.parseInt(snumeknum.substring(indexOfE + 1));
         String sciDecimal = snumeknum.substring(2, indexOfE);
         int sciDecimalLength = sciDecimal.length();
         if (exp == sciDecimalLength) {
         sb.append(snumeknum.charAt(0));
         sb.append(sciDecimal);
         } else if (exp > sciDecimalLength) {
         sb.append(snumeknum.charAt(0));
         sb.append(sciDecimal);
         for (int i = 0; i < exp - sciDecimalLength; i++) {
         sb.append('0');
         }
         } else if (exp < sciDecimalLength) {
         sb.append(snumeknum.charAt(0));
         sb.append(sciDecimal.substring(0, exp));
         sb.append('.');
         for (int i = exp; i < sciDecimalLength; i++) {
         sb.append(sciDecimal.charAt(i));
         }
         }
         return sb.toString();
         } else { //for little numbers use the default or you will loose accuracy
         return snumeknum;
         }*/
    }

    private String cleanNumberFormat(String numeknum) {
        //numeknum=numeknum.replace(",", ""); // not needed since we specify it in string format
        // The pure would be use DecimalFormat in pretty format but...
        //if (numeknum.matches(".*\\.(0)+")) { numeknum = numeknum.substring(0, numeknum.lastIndexOf('.'));  }
        numeknum = numeknum.indexOf(".") < 0 ? numeknum : numeknum.replaceAll("0*$", "").replaceAll("\\.$", ""); // 2 replace all are needed
        return numeknum;
    }

    private Integer getNumber(String[] elements, Integer i, Number number, Integer maxorder) {
        Integer ret = i;
        try {
            if (maxorder > MAX_NUMBERS_ORDER) {
                maxorder = MAX_NUMBERS_ORDER;
            }
            if (maxorder <= 0) {
                throw new Exception("Order not in correct range : " + maxorder);
            }
            if (maxorder <= 10) {
                ret = ret - look4units(elements[i], number);
            }
            if (maxorder > 10) {
                ret = i - look4irregular_tens(elements[i], number);
                if (ret == i) {
                    ret = i - look4tens(elements[i], number);
                    if (ret == i) {
                        ret = ret - look4units(elements[i], number);
                        if (ret == i) {
                            throw new Exception("Malformed number: " + elements[i]);
                        }
                        if (i > 0) {
                            ret = ret - look4tens(elements[i - 1], number);
                        }
                    }
                }
            }
            if (ret == i) {
                throw new Exception("Malformed number, unexected (max order " + maxorder + "): " + elements[i]);
            }

        } catch (Exception e) {
            System.err.println("Errors found (NUMEK):\n\t" + e.toString());
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                //System.exit(1);
            }
            return -1;
        }
        return ret;
    }

    private Integer operateMagnitude(String[] elements, Integer i, Number number) {
        try {
            Number magnumber = new Number();
            //Double magnumber = 0.0;
            String magnitude = elements[i].trim();
            Integer magnvalue = Integer.parseInt(magnitudes.getMapValue(magnitude));
            if (!magnitudes.getMap().containsKey(magnitude)) {
                throw new Exception("Expected magnitude, found " + magnitude);
            }
            //System.err.println("Magnitude: " + magnitude);
            Integer maxmagn = magnvalue - 1;

            if (restrictions.getMap().containsKey(magnitude)) {
                maxmagn = Integer.parseInt(restrictions.getMapValue(magnitude));
            }

            i--;

            if (i >= 0) {
                Integer currentmagn = 0;
                while (i >= 0) {
                    // if there is a number and it can be operated it then operate it
                    if (!magnitudes.getMap().containsKey(elements[i])) {
                        if (currentmagn > MAX_NUMBERS_ORDER) {
                            throw new Exception("Expected magnitude, found " + elements[i]); //instead of this, normalize in n-parts six six six --> 6 6 6
                        }
                        i = getNumber(elements, i, magnumber, maxmagn);
                        currentmagn = ((int) Math.pow(10, number.value.toString().substring(0, number.value.toString().lastIndexOf('.')).length()));
                    } else {
                        // If magnitudes can be eelements[i]xpected for the current magnitude
                        if (Integer.parseInt(magnitudes.getMapValue(elements[i])) < maxmagn) {
                            i = operateMagnitude(elements, i, magnumber);
                        } else {  // resolver magnitud present y subir arriba para seguir operando
                            //if no value for magnitude go by
                            if (magnumber.value == 0L) {
                                magnumber.value = 1.0;
                            }
                            // finally operate whatever and break
                            number.value += magnumber.value * magnvalue;
                            magnumber.value = 0.0;
                            break;
                        }
                    }
                }
                if (magnumber.value != 0L) {
                    number.value += magnumber.value * magnvalue;
                }
            } else {
                magnumber.value = 1.0;
                number.value += magnumber.value * magnvalue;
                i--;
            }
        } catch (Exception e) {
            System.err.println("Errors found (NUMEK):\n\t" + e.toString());
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                //System.exit(1);
            }
            return -1;
        }
        return i;

    }

    private Integer look4units(String element, Number number) {
        if (units.getMapValue(element) != null) {
            number.value += Integer.parseInt(units.getMapValue(element));
            return 1;
        }
        return 0;
    }

    private Integer look4irregular_tens(String element, Number number) {
        if (irregular_tens.getMapValue(element) != null) {
            number.value += Integer.parseInt(irregular_tens.getMapValue(element));
            return 1;
        }
        return 0;
    }

    private Integer look4tens(String element, Number number) {
        if (tens.getMapValue(element) != null) {
            number.value += Integer.parseInt(tens.getMapValue(element));
            return 1;
        }
        return 0;
    }

    /**
     * Counts how many times a char (pattern) appears in a string (source)
     *
     * @param source
     * @param pattern
     * @return
     */
    public static int countOccurrencesOf(String source, char pattern) {
        int count = 0;
        if (source != null) {
            int found = -1;
            int start = 0;
            while ((found = source.indexOf(pattern, start)) != -1) {
                start = found + 1;
                count++;
            }
            return count;
        } else {
            return 0;
        }
    }

    /**
     * Returns the decimal representation of a Roman number This function only
     * works until 3999 since greater numbers use non-ASCII chars (See
     * Wikipedia) Rules: Only 3 consecutive chars, 5-like can not be repeated,
     * only multiples of 10 can be used to subtract (and must subtract only the
     * next two greater values) ...
     *
     * @param roman
     * @return
     */
    public static String Roman2Decimal(String roman) {
        try {
            int dec = 0;
            int ant = 0;
            char ant_letter = '\0';
            if (roman == null || roman.trim().length() == 0) {
                return "0";
            }
            roman = roman.trim().replaceAll("\\s+", "").toUpperCase();
            if (!roman.matches("[" + romans + "]+") || roman.matches(".*(.)\\1{3,}.*") || roman.matches(".*([" + romans5 + "]).*\\1.*")) {
                throw new Exception("Invalid roman number: " + roman + ". Must only contain " + romans + " and not more than 3 consecutive equal chars are allowed, non-10 power numbers (" + romans5 + ") can only appear once. " + roman);
            }
            for (int i = 0; i < roman.length(); i++) {
                char letter = roman.charAt(i);
                int value = romansMap.get("" + letter);
                dec = dec + value;
                if (i > 0 && roman.length() > 2 && i < roman.length() - 1 && (ant <= value && value < romansMap.get("" + roman.charAt(i + 1)))) {
                    throw new Exception("Two consecutive subtractions or more than one equal symbols used to subtract " + roman);
                }
                if (i > 0 && roman.length() > 2 && i < roman.length() - 1 && (ant < value && ant <= romansMap.get("" + roman.charAt(i + 1)))) {
                    throw new Exception("Substracting and adding the same symbol or greater " + roman);
                }

                if (i != 0 && ant < value) { // no need to check if ant is 0 because it means substract nothing
                    double check5 = Math.log10(ant);
                    if (i != 0 && check5 != (int) check5) {
                        throw new Exception("Symbols powers of 5 cannot be used to substract: " + ant);
                    }
                    if (romans.indexOf(letter) - 2 > romans.indexOf(ant_letter)) {
                        throw new Exception("With " + ant_letter + " you can only substract " + romans.substring(romans.indexOf(ant_letter) + 1, romans.indexOf(ant_letter) + 3) + ". Incorrect: " + roman);
                    }
                    dec = dec - ant * 2;
                }
                ant = value;
                ant_letter = letter;
            }
            return "" + dec;
        } catch (Exception e) {
            System.err.println("Errors found (NUMEK):\n\t" + e.toString());
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
            }
            return null;
        }

    }
}
