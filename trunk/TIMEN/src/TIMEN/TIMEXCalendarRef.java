/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TIMEN;

import java.text.*;
import java.util.*;

/**
 *
 * @author hector
 */
public class TIMEXCalendarRef {
    // in the future manage Time Zone
    // TimeZone tz = TimeZone.getTimeZone("GMT:00");
    // Manage granularity

    private static final String emptydate="0000-01-01T12:00:00";

    private Calendar cal;
    private String granularity;
    private String iso_year;
    private String iso_month;
    private String iso_day;
    private String iso_hour;
    private String iso_minute;
    private String iso_second;

    public TIMEXCalendarRef(){
        cal = Calendar.getInstance();
        granularity = "seconds";
    }

    public TIMEXCalendarRef(String dct){
        try{
        cal = Calendar.getInstance();
        if(dct.length()>=19){
            dct=dct.substring(0, 19);
            granularity="seconds";
        }else{
            dct+=emptydate.substring(dct.length());
            // granularity xxx
        }
        SimpleDateFormat isoformat=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        cal.setTime(isoformat.parse(dct));

        iso_year=dct.substring(0, 4);
        iso_month=dct.substring(5, 7);
        iso_day=dct.substring(8, 10);
        iso_hour=dct.substring(11, 13);
        iso_minute=dct.substring(14, 16);
        iso_second=dct.substring(17, 19);


        } catch (Exception e) {
            System.err.println("Errors found (TimenCalendarRef):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }
    }

    public Calendar getCalendar(){
        return cal;
    }

    public String getISO8601(){
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-ddTHH:mm:ss");
        return formatter.format(cal.getTime());
    }

    public String getYear(){
        return iso_year;
    }

    public String getMonth(){
        return iso_month;
    }

    public String getDay(){
        return iso_day;
    }

    public String getHour(){
        return iso_hour;
    }

    public String getMinute(){
        return iso_minute;
    }

    public String getSecond(){
        return iso_second;
    }


    public int getJavaYear(){
        return cal.get(Calendar.YEAR);
    }

    public int getJavaMonth(){
        return cal.get(Calendar.MONTH);
    }

    public int getJavaDay(){
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public int getJavaHour(){
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public int getJavaMinute(){
        return cal.get(Calendar.MINUTE);
    }

    public int getJavaSecond(){
        return cal.get(Calendar.SECOND);
    }



}
