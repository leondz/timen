/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Knowledge;

import java.util.*;

/**
 *
 * @author hector
 */
public class Knowledge_ES extends Knowledge {

    public Knowledge_ES(Locale l) {
        super(l);
        TUnit_re = "(?i)(?:segundos|minuto|hora|día|semana|mes(?:es)?|trimestre|semestre|año|década|siglo|milenio)s?";
        // hack "segundos" because the ambiguity with ordinal
        TMonths_re = "(?:(?:enero|febrero|marzo|abril|mayo|junio|julio|agosto|septiembre|octubre|noviembre|diciembre)|(?:ene|feb|mar|abr|may|jun|jul|ago|sep|oct|nov|dic)(?:\\.)?)";
        TWeekdays_re = "(?:lunes|martes|miércoles|jueves|viernes|sábado|domingo)";
        Decades_re = "años_(?:veinte|treinta|cuarente|cincuenta|sesenta|setenta|ochenta|noventa|[2-9]0)";
        TOD_re = "(?:madrugada|mediodía|tarde|noche|medianoche)"; // mañana is ambiguous
        Seasons_re = "(?:primavera|verano|otoño|invierno)";
        SET_re = "(?i)(?:cada(?:\\s|_)+.*|todos(?:\\s|_)+los.*|.*" + TWeekdays_re + "s.*|(?:diari|diaria|semanal|mensual|trimestral|anual|bienal)(?:mente|(?:a|e|o)(?:s)?))";
        TIMEgranul_re = "(?i)(?:segundos|minuto(?:s)?|hora(?:s)?|" + TOD_re + ")";

        ambiguous_re = "(?i)_mañana_";
        
        TUnits = new HashMap<String, String>();
        TUnits.put("milenio", "millennium");
        TUnits.put("siglo", "century");
        TUnits.put("década", "decade");
        TUnits.put("año", "year");
        TUnits.put("semestre", "semester");
        TUnits.put("trimestre", "quarter"); // ambiguous...
        TUnits.put("mes", "month");
        TUnits.put("semana", "week");
        TUnits.put("día", "day");
        TUnits.put("hora", "hour");
        TUnits.put("minuto", "minute");
        TUnits.put("segundo","second");


        decades = new HashMap<String, Integer>();
        decades.put("años_veinte", 192);
        decades.put("años_20", 192);
        decades.put("años_treinta", 193);
        decades.put("años_30", 193);
        decades.put("años_cuarenta", 194);
        decades.put("años_40", 194);
        decades.put("años_cincuenta", 195);
        decades.put("años_50", 195);
        decades.put("años_sesenta", 196);
        decades.put("años_60", 196);
        decades.put("años_setenta", 197);
        decades.put("años_70", 197);
        decades.put("años_ochenta", 198);
        decades.put("años_80", 198);
        decades.put("años_noventa", 199);
        decades.put("años_90", 199);

        TODs = new HashMap<String, String>();
        TODs.put("madrugada","TMO");
        TODs.put("mañana","TMO");
        TODs.put("mediodía","TAF");
        TODs.put("tarde","TAF");
        TODs.put("noche","TNI");
        TODs.put("medianoche","T00:00");
    }

    public final String normalizeTUnit(String text) {
        if (text.matches("mes(es)?")) {
            text = "mess";    // hack for plural removal
        }
        return text.replaceAll("s$", "");
    }

    public final String disambiguate(String text) {
        if (text.matches("_(la|esta|de)_mañana_")) {
            text = text.replaceAll("_(la|esta|de)_mañana_", "_$1_TOD_");
        }

        // "tarde" can be also treated but the ambiguous alternative cannot be normalized...
        // llegó tarde

        return text;
    }
}
