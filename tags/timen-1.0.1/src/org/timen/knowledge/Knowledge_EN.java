/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.timen.knowledge;

import java.util.*;

/**
 *
 * @author hector
 */
public class Knowledge_EN extends Knowledge {

    public Knowledge_EN(Locale l) {
        super(l);
        TUnit_re = "(?i)(?:seconds|minute|hour|day|week|month|semester|year|decade|centur(y|ies)|millennium)s?"; // quarter ambiguous
        // hack "seconds" because the ambiguity with ordinal
        // abbreviations? h min sec
        TMonths_re = "(?i)(?:(?:January|February|March|April|May|June|July|August|September|October|November|December)|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Sept|Oct|Nov|Dec)(?:\\.)?)";
        TWeekdays_re = "(?i)(?:Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday|(Mon|Tue|Wed|Thu|Fri|Sat|Sun)(?:\\.)?)";
        Decades_re = "(?i)(?:twenties|thirties|forties|fifties|sixties|seventies|eighties|nineties)";
        TOD_re = "(?i)(?:morning|afternoon|noon|midday|evening|night|midnight|overnight)";
        Seasons_re = "(?i)(?:spring|summer|(autumn|fall)|winter)";
        SET_re = "(?i)(?:each(\\s|_)+.*|every(?:\\s|_)+.*|.*" + TWeekdays_re + "s.*|(?:hour|day|week|month|quarter|year)ly)";
        TIMEgranul_re = "(?i)(?:seconds|minute(?:s)?|hour(?:s)?|" + TOD_re + ")";

        ambiguous_re = "(?i)_quarter(s)?_";

        TUnits = new HashMap<String, String>();
        TUnits.put("millennium", "millennium");
        TUnits.put("century", "century");
        TUnits.put("decade", "decade");
        TUnits.put("year", "year");
        TUnits.put("semester", "semester");
        TUnits.put("quarter", "quarter"); // ambiguous
        TUnits.put("month", "month");
        TUnits.put("week", "week");
        TUnits.put("day", "day");
        TUnits.put("hour", "hour");
        TUnits.put("minute", "minute");
        TUnits.put("second","second");

        decades = new HashMap<String, Integer>();
        decades.put("twenties", 192);
        decades.put("thirties", 193);
        decades.put("forties", 194);
        decades.put("fifties", 195);
        decades.put("sixties", 196);
        decades.put("seventies", 197);
        decades.put("eighties", 198);
        decades.put("nineties", 199);
        decades.put("ougthies", 200);
        decades.put("teens", 201);
        
        TODs = new HashMap<String, String>();
        TODs.put("morning","TMO");
        TODs.put("noon","T12:00");
        TODs.put("midday","T12:00");
        TODs.put("afternoon","TAF");
        TODs.put("evening","TEV");
        TODs.put("night","TNI");
        TODs.put("overnight","TNI");
        TODs.put("midnight","T00:00");
    }

    public final String normalizeTUnit(String text) {
        if (text.matches("centuries")) {
            text = "century";    // hack for plural removal
        }
        if (text.matches("millennia")) {
            text = "millennium";    // hack for plural removal
        }
        return text.replaceAll("s$", "");
    }

    public final String disambiguate(String text) {
        // there are not ambiguities
        if (!text.matches("_(this|current|1st|2nd|3rd|4th|first|second|third|forth|latest)_quarter(s)?_")) {
            text = text.replaceAll("_([^_]+)_quarter(s)?_", "_$1_TUnit_");
        }
        return text;
    }
}
