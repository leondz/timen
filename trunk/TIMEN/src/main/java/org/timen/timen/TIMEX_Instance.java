package org.timen.timen;

import org.timen.timen.TIMEXCalendarRef;

/**
 *
 * @author Hector Llorens
 */
public class TIMEX_Instance {

    private String normText;
    private String [] normTextArr;
    private String tense;
    public TIMEXCalendarRef dct;
    public TIMEXCalendarRef reftime;
    private static final String validTenses="(?:omit|present|past|future|present-perfect|present-continuos|past-perfect|past-continuous|conditional)";
    private static final String defaultTense="past";

    public TIMEX_Instance(String nt, String t, String d, String r){
        try{
        //System.out.println(nt+t+d+r);
        normText=nt.replaceAll("\\s+", " ");
        normTextArr=normText.split(" ");
        tense=t;
        if(!tense.matches(validTenses)){
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                throw new Exception("Invalid tense: "+tense);
            }else{
                System.err.println("Invalid tense: "+tense+". Set as "+defaultTense+" by default.");
                tense=defaultTense; // by default
            }

        }
        dct= new TIMEXCalendarRef(d);
        reftime= new TIMEXCalendarRef(r);


        } catch (Exception e) {
            System.err.println("Errors found (TIMEN_Instance):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }
    }

    public String getNormText(){
        return normText;
    }

    public String [] getNormTextArr(){
        return normTextArr;
    }
    
    public String getSubPat(int arrindex, String delimiter, int subindex){
        return normTextArr[arrindex].split(delimiter)[subindex];
    }

    public String getTense(){
        return tense;
    }



}
