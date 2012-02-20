package Knowledge;

import java.text.*;
import java.util.*;

/**
 *
 * @author Hector Llorens
 */
public abstract class Knowledge {

    public String TUnit_re;
    // hack "seconds" because the ambiguity with ordinal
    // abbreviations? h min sec
    public String TMonths_re;
    public String TWeekdays_re;
    public String Decades_re;
    public String TOD_re;
    public String Seasons_re;
    public String SET_re;
    public String TIMEgranul_re;
    public HashMap<String, Integer> Weekdays;
    public HashMap<String, Integer> Yearmonths;
    public  HashMap<String, String> TUnits;
    public  HashMap<String, Integer> decades;



    /**
     * Returns a normalized TUnit (no plural, no abbrev)
     * @param text TUnit text
     *
     * @return  String: normalized text
     */
    public abstract String normalizeTUnit(String text);


    public Knowledge() {
        this(Locale.getDefault());
    }

    // constructor
    public Knowledge(Locale l) {
            loadJavaTemporalKnowledge(l);
    }
     /**
     * Loads the localized java GregorianCalendar temporal knowledge (i.e., DOW, MOY) for the indicated locale l
     *
     * @param l language locale
     *
     */
    public void loadJavaTemporalKnowledge(Locale l) {
        // load DOW
        Weekdays = null;
        Weekdays = new HashMap<String, Integer>();
        String[] temp = new DateFormatSymbols(l).getWeekdays();
        for (int i = 1; i < temp.length; i++) {
            Weekdays.put(temp[i].toLowerCase(l), i);
        }
        temp = new DateFormatSymbols(l).getShortWeekdays();
        for (int i = 1; i < temp.length; i++) {
            Weekdays.put(temp[i].toLowerCase(l), i);
        }
        //System.out.println(Weekdays.toString());

        // load MOY
        temp = null;
        Yearmonths = null;
        Yearmonths = new HashMap<String, Integer>();
        temp = new DateFormatSymbols(l).getMonths();
        for (int i = 0; i < temp.length - 1; i++) {
            //System.out.println(i+temp[i]);
            Yearmonths.put(temp[i].toLowerCase(l), i);
        }
        temp = new DateFormatSymbols(l).getShortMonths();
        for (int i = 0; i < temp.length - 1; i++) {
            //System.out.println(i+temp[i]);
            Yearmonths.put(temp[i].toLowerCase(l), i);
        }
        //System.out.println(Yearmonths.toString());
    }

    
}
