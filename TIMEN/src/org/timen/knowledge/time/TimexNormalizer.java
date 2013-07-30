package org.timen.knowledge.time;

import org.timen.knowledge.numbers.Numek;
import java.util.*;
import java.util.regex.*;


/**
 * Timex Normalization: There is two main options to do this using external
 * knowledge files (entities) plus rules (grammars) 1) Do it as a grammar
 * parsing in one step: 2) Do it as pre-processing+rule-matching in 2 steps:
 * This is the strategy chosen in this class.
 *
 * @author Hector_Llorens
 */
public class TimexNormalizer {

    private Locale locale;
    private Timek timek;

    public TimexNormalizer() {
        this(Locale.getDefault());
    }

    public TimexNormalizer(Locale l) {
        locale = l;
        timek = new Timek(l);
    }


    /**
     * *****************************************************************
     * NORMALIZING TEXT INPUT
     * ****************************************************************
     */
    
    /**
     * Obtains the normalized text (NormText) and Patter from a given timex
     * textual expression
     *
     * @param timex the timex textual expression (by default it is case insensitive)
     * @return the feature-values for NormText and Pattern (i.e., normtext|pattern)
     */
    public String getNormTextandPattern(String timex_text) {
        return getNormTextandPattern(timex_text, Boolean.TRUE);
    }

    
    /**
     * Obtains the normalized text (NormText) and Patter from a given timex
     * textual expression
     *
     * @param timex the timex textual expression
     * @param case_sensitive boolean selector (by default it is false == case insensitive)
     * 
     * @return the feature-values for NormText and Pattern (i.e., normtext|pattern)
     */
    public String getNormTextandPattern(String timex_text, Boolean case_sensitive) {
        String timex_normtext = "";
        String timex_pattern = "";
        String modifiers = ""; // mid,late,early,almost,approx... 
        try {
            // BASIC CLEAN-UP  -----------------------------------------------------------------------------------
            timex_text = " " + timex_text.replaceAll("\\s+", " ") + " "; // Ensure correct tokenization 
            if(!case_sensitive){
                timex_text=timex_text.toLowerCase(); //make it all-lowercase
            }
            timex_text = timex_text.replaceAll(" ,", "").replaceAll(", ", " "); // remove tokenized commas untokenized commas
            // REMOVE USELESS SYMBOLS: only if they are completely useless
            // YES: "of" is useless in English dates
            // NO: "los" in Spanish is useful to disambiguate between DATE and SET
            timex_text = timek.removeUselessSymbols(timex_text);
            // Unify ISO dates
            timex_text = timex_text.replaceAll("([0-9]+) ([-/:]) ([0-9]+|" + timek.phraselists.get("month").getRE() + ") ([-/:]) ([0-9]+)", "$1$2$3$4$5");
            timex_text = timex_text.replaceAll("([0-9]+[-/:]) ((?:[0-9]+|" + timek.phraselists.get("month").getRE() + ")[-/:]) ([0-9]+)", "$1$2$3");
            timex_text = timex_text.replaceAll("([0-9]+) ([-/:](?:[0-9]+|" + timek.phraselists.get("month").getRE() + ")) ([-/:][0-9]+)", "$1$2$3");
            timex_text = timex_text.replaceAll("([0-9]+|" + timek.phraselists.get("month").getRE() + ") ([-/:]) ([0-9]+)", "$1$2$3");
            timex_text = timex_text.replaceAll("((?:[0-9]+|" + timek.phraselists.get("month").getRE() + ")[-/:]) ([0-9]+)", "$1$2");
            timex_text = timex_text.replaceAll("([0-9]+|" + timek.phraselists.get("month").getRE() + ") ([-/:][0-9]+)", "$1$2");
            timex_text = timex_text.replaceAll("([0-9]0) s", "$1s");
            // Special for modifiers (SHOULD be loaded from a phraselist)
            timex_text = timex_text.replaceAll("mid(?:-)?([0-9]+)", "mid $1").replaceAll("mid-(.+)", "mid $1");
            // Separate adjective periods num-TUnit
            timex_text = timex_text.replaceAll("([^ ]+)-" + timek.phraselists.get("tunit").getRE(), "$1 $2");
            // Special for fractions (only one is normalized because there should be no more than one per timex)
            if (timex_text.matches("(?:.* )?(?:[0-9]* )?[1-9][0-9]*/[1-9][0-9]* " + timek.phraselists.get("tunit").getRE() + ".*")) {
                String nums2norm = timex_text.replaceFirst("(.* )?((?:[0-9]* )?[1-9][0-9]*/[1-9][0-9]*)( " + timek.phraselists.get("tunit").getRE() + ".*)", "$2");
                String normalizedfrac = "" + Numek.calc_and_sum_frac(nums2norm);
                timex_text = timex_text.replaceFirst("(.* )?((?:[0-9]* )?[1-9][0-9]*/[1-9][0-9]*)( " + timek.phraselists.get("tunit").getRE() + ".*)", "$1" + normalizedfrac + "$3");
            }

            // DISAMBIGUATE TO PATTERN IF NEEDED  ----------------------------------------------------------------------------
            // ambiguity (replace also text V_ except C_Card, C_Ord) 
            Pattern p = Pattern.compile(timek.ambiguous.getRE(), Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(timex_text);
            if (timek.ambiguous.getRE() != null && m.find()) {
                String norm_and_pat = timek.disambiguate(timex_text);
                timex_text = norm_and_pat.split("\\|")[0];
                timex_pattern = norm_and_pat.split("\\|")[1];
            } else {
                timex_pattern = timex_text;
            }



            timex_text = timex_text.trim();
            timex_pattern = timex_pattern.trim();
            String[] textarr = timex_text.split(" ");
            String[] patternarr = timex_pattern.split(" ");
            timex_pattern = ""; // reset to build


            //numbers and ISO (Replace both in text V__ and in Pattern C_)            
            // check Nums and ISO (e.g., one million or 25 hundred), if after [0-9] there is no spell leave as it is.
            String spelledNum = "";
            String currentPat;
            for (int i = 0; i < textarr.length; i++) {
                if (patternarr[i].matches("C_.*")) {
                    currentPat = patternarr[i];
                } else {
                    if (textarr[i].matches("(?:[0-2])?[0-9][.:][0-5][0-9](?:[.:][0-5][0-9])?(?:(?:p|a)(?:\\.)?m(?:\\.)?|h)?") || textarr[i].matches("(?:[0-2])?[0-9](?:(?:p|a)(?:\\.)?m(?:\\.)?)")) {
                        currentPat = "C_isotime";
                    } else {
                        if (textarr[i].matches("(?:[0-3])?[0-9][./-](?:(?:[0-3])?[0-9]|" + timek.phraselists.get("month").getRE() + ")[./-][0-9]+") // dd-mm-yyyy
                                || textarr[i].matches(timek.phraselists.get("month").getRE() + "[/-][0-9]+") // MM-yyyy
                                || textarr[i].matches("(?:1[0-2]|(?:0)?[1-9])[/-][1-2][0-9]{3}") // mm-yyyy
                                || textarr[i].matches("[0-9]{4}[./-](?:1[0-2]|(?:0)?[1-9])[./-](?:[0-3])?[0-9](?:(T| )[0-2][0-9][.:][0-5][0-9](?:[.:][0-5][0-9])?)?(?:Z)?") // ISO
                                ) {
                            currentPat = "C_isodate";
                        } else {
                            if (textarr[i].matches("[0-9]+(?:\\.[0-9]+)?") || textarr[i].matches("(" + timek.numek.units.getRE() + "|" + timek.numek.tens.getRE() + "|" + timek.numek.irregular_tens.getRE() + "|" + timek.numek.magnitudes.getRE() + "|" + timek.numek.special_groups.getRE() + "|" + timek.numek.ordinals.getRE() + "|" + timek.numek.units.getRE() + "|" + timek.numek.tens.getRE() + "-" + timek.numek.units.getRE() + ")") || (!spelledNum.equals("") && !spelledNum.matches(".*([0-9]|" + timek.numek.ordinals.getRE() + ").*") && textarr[i].matches(timek.numek.delimiters.getRE()))) {
                                currentPat = "C_card";
                            } else {
                                currentPat = textarr[i];
                            }
                        }
                    }
                }



                // check if a spellednum ends, if the current is C_card but cannot be combined then resolve
                //(spellednumarr[spellednumarr.length - 1].matches(timek.numek.magnitudes.getRE()) && textarr[i].matches(timek.numek.magnitudes.getRE())) || 
                //(!spellednumarr[spellednumarr.length - 1].matches(timek.numek.magnitudes.getRE()) && !textarr[i].matches(timek.numek.magnitudes.getRE())) 
                if (!spelledNum.equals("") && 
                        ((!currentPat.equals("C_card") || textarr[i].matches("[0-9]+(?:\\.[0-9]+)?") || spelledNum.matches(timek.numek.ordinals.getRE()) || textarr[i].trim().matches(timek.numek.ordinals.getRE()))
                        || 
                        (currentPat.equals("C_card") && (timek.numek.text2number(spelledNum + " " + textarr[i])).equals(spelledNum.trim() + " " + textarr[i])  ))) {
                    timex_normtext += " V__" + timek.numek.text2number(spelledNum.trim());
                    timex_pattern += " C_card";
                    spelledNum = ""; // initialize
                }
                // add to normTE or to spelled num
                if (currentPat.equalsIgnoreCase("C_card")) {
                    spelledNum += " " + textarr[i];
                } else { // Month/Week could be replaced by a number BUT SINCE THERE ARE DIFFERENT INTERPRETATIONS it is better to leave them as string
                    timex_normtext += " " + textarr[i];
                    timex_pattern += " " + currentPat;
                }
            }

            // add last spellednum if exists
            if (!spelledNum.equals("")) {
                //if (!spelledNum.trim().matches(numek.ordinals_re)) {
                timex_normtext += " V__" + timek.numek.text2number(spelledNum.trim());
                //} else {
                //    normText += " " + spelledNum.trim();
                //}
                timex_pattern += " C_card";
            }


            //                  3. replace all (for each RE) in both text and pattern (don't worry... there wont be strange matches because V__)
            //         if (text matches ^( V__[^\s])+ $ )) break (completely paternized)
            timex_normtext = " " + timex_normtext + " ";
            timex_pattern = " " + timex_pattern + " ";
            for (String phraselist : timek.phraselists.keySet()) {
                //System.err.println(timex_normtext+"   "+timex_pattern+"   "+timek.phraselists.get(phraselist).getName()+" " + timek.phraselists.get(phraselist).getRE());
                p = Pattern.compile(" " + timek.phraselists.get(phraselist).getRE() + " "); //, Pattern.CASE_INSENSITIVE this must be handled with a parameter (default insensitive, all lowercap)
                m = p.matcher(timex_normtext);
                while (m.find()) {
                    timex_normtext = timex_normtext.replaceAll("(?i)" +m.group(), " V__" + timek.phraselists.get(phraselist).getMapValue(m.group().trim()) + " ");
                    timex_pattern = timex_pattern.replaceAll("(?i)" +m.group(), " " + timek.phraselists.get(phraselist).getName() + " ");
                }
            }
        } catch (Exception e) {
            System.err.println("Errors found:\n\t" + e.toString() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
            return null;
        }

        return (timex_normtext.trim().replaceAll("V__", "") + "|" + timex_pattern.trim());

    }
}
