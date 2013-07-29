package org.timen.knowledge.time;

import org.timen.nlp_files.PhraselistFile;
import org.timen.knowledge.numbers.Numek;
import org.timen.utils.CognitionisFileUtils;
import java.io.File;
import java.text.DateFormatSymbols;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Timek {
    // this could probably be loaded from json confing
    public static final String [] phraselists_names= {"weekday","month","tunit","decade", "time_of_day","season"};
    
    public HashMap<String,PhraselistFile> phraselists=new HashMap<>();
    // this can probably be an array of dependent knowledges
    public Numek numek;
    // this could probably be an abstract class
    public Locale locale;
    public HashSet<String> all_keys;
    public HashSet<String> repeated_keys;
    public PhraselistFile ambiguous;
    public PhraselistFile useless_symbols;

    public HashMap<String, Integer> Java_Weekdays;
    public HashMap<String, Integer> Java_Yearmonths;

    
/*
    // set TODO develop the phraselist... or somethign else
    // todo TIMEgranul_re = "(?i)(?:seconds|minute(?:s)?|hour(?:s)?|" + TOD_re + ")";
    * */
    
    // DEPRECATED could be guessed from phraselists
    // DEPRECATED ALL START WITH C_ public static final String pattern_symbols = "(Card|Ord|C_Tunit|C_Month|C_Weekday|C_Time_of_day|C_Decade|C_Deictic|C_Season|ISOTime|ISODate|.*-Ambiguous)"; // use TIgnore to force decoding in desambiguation

    public Timek() {
        this(new Locale("en", "US"));
    }
    
    public Timek(Locale l) {
        try {
            locale = l;
            numek = new Numek(l);
            String lang = l.toString().replace('_', '-');
            all_keys = new HashSet<>();
            repeated_keys = new HashSet<>();
            phraselists=new HashMap<>();
            
            all_keys = numek.all_keys;
            // Load from resource knowledge files (all string, string)            
            // For our beloved Windows
            String extra = "";
            if (File.separator.equals("\\")) {
                extra = "\\";
            }
            String app_path = CognitionisFileUtils.getApplicationPath(); //.replaceAll(extra + File.separator + "classes", "");
            String res_path = app_path + File.separator + "knowledge-bases" + File.separator + "time" + File.separator + lang + File.separator;
            ambiguous = new PhraselistFile(res_path + "ambiguous.phraselist");
            useless_symbols = new PhraselistFile(res_path + "useless_symbol.phraselist");
            //weekdays=new PhraselistFile(this.getClass().getResource("/time/"+lang+"/weekdays.phraselist").toURI().getPath()); // does not work if Phraselist requires a File as input

            for(String phra:phraselists_names){
                phraselists.put(phra, new PhraselistFile(res_path + phra+".phraselist"));
                repeated_keys.addAll(phraselists.get(phra).intersectPhraselist(all_keys));
                all_keys.addAll(phraselists.get(phra).keySet());
            }
            // set TODO develop the phraselist... or somethign else
            // todo TIMEgranul_re = "(?i)(?:seconds|minute(?:s)?|hour(?:s)?|" + TOD_re + ")";
            
            for (String akey : ambiguous.keySet()) {
                HashSet<String> temp_keys = new HashSet<>(repeated_keys);
                for (String key : repeated_keys) {
                    if (akey.contains(key)) {
                        temp_keys.remove(key);
                    }
                }
                repeated_keys.clear();
                repeated_keys.addAll(temp_keys);
            }
            if (!repeated_keys.isEmpty()) {
                throw new Exception("This knowledge element has unhandled ambiguity: " + repeated_keys);
            }
            
            // old stuff consider removing
            loadJavaTemporalKnowledge(l);
            
        } catch (Exception e) {
            System.err.println("Errors found in " + this.getClass().getName() + ":\n\t" + e.toString());
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
            }
        }
    }

    /**
     * Returns an unambiguous semi-text|semi-pattern
     * NOTE: Ambiguous RE must not contain multi-word replacements
     * 
     * @param text
     *
     * @return String: unambiguous text
     */
    public final String disambiguate(String text) {
        // open the ambiguities file, iterate, if matches replace...
        String pat=text;
        for (String key : ambiguous.getMap().keySet()) {
            // NOTE: negative patterns cannot be used unless se use another paramter (match-negative-replacement), otherwise everything matches
            /* Boolean positive=true;
             String negkey="";
             if(key.contains("-") && key.split("-")[0].equalsIgnoreCase("!negative")){
             positive=false;
             negkey=key.split("-")[1];
             }
             if (positive && text.matches(key)) {*/
            Pattern ambig = Pattern.compile(key, Pattern.CASE_INSENSITIVE);
            Matcher m = ambig.matcher(text);
            if (m.find()) {
                pat=text.replaceAll(key, ambiguous.getMapValue(key)); // in the file use TIgnore to force decoding in a subsequent step
                String [] normarr=text.trim().split(" ");
                String [] patarr=pat.trim().split(" ");
                text="";
                for(int i=0;i<patarr.length;i++){
                    if(patarr[i].matches("^C_.*")){// pero açò es un poc merda...                        
                        normarr[i]="V__"+phraselists.get(patarr[i].substring(2).toLowerCase()).getMapValue(normarr[i]);
                    }
                    text+=" "+normarr[i];
                }
                text+=" ";
            }
            /*}
             if (!positive && !text.matches(key)) {
             return text.replaceAll(key,ambiguous.getMapValue(key));
             }*/
        }
        return text+"|"+pat;
    }

    /**
     * Removes all useless symbols from an input text
     *
     * @param text expects space-separated symbols including leading and
     * training spaces
     * @return clean text
     */
    public final String removeUselessSymbols(String text) {
        if (useless_symbols.getRE() != null) {
            return text.replaceAll(" " + useless_symbols.getRE() + " ", " ");
        } else {
            return text;
        }
    }
    
    
    
    // OLD STUFF MAYBE WE CAN REMOVE THIS IN THE FUTURE
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
    
}
