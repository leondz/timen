// $ANTLR 3.4 TIMENruleGrammar.g 2013-09-22 20:09:47

    package org.timen.timen.grammar;
    import org.timen.timen.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TIMENruleGrammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "GRANULARITY", "INT", "REFERENCE", "SEPARATOR", "STRING", "WHITESPACE", "'('", "')'", "','", "'ADD'", "'ADD_WEEKDAY'", "'DATE_LAST_WEEKDAY_MONTH'", "'DATE_MONTH'", "'DATE_MONTH_DAY'", "'DATE_WEEKDAY'", "'DATE_WEEKNUM_WEEKDAY_MONTH'", "'DCTDAY'", "'DCTMONTH'", "'DCTYEAR'", "'FILL_ZEROS'", "'GET_TOD'", "'INT('", "'NEGATIVEINT('", "'PAT'", "'SUBPAT'", "'TO_CENTURY'", "'TO_DAY'", "'TO_DECADE'", "'TO_ISO'", "'TO_MONTH'", "'TO_PERIOD'", "'TO_TIME'", "'TO_YEAR'"
    };

    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int COMMENT=4;
    public static final int GRANULARITY=5;
    public static final int INT=6;
    public static final int REFERENCE=7;
    public static final int SEPARATOR=8;
    public static final int STRING=9;
    public static final int WHITESPACE=10;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public TIMENruleGrammarParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public TIMENruleGrammarParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return TIMENruleGrammarParser.tokenNames; }
    public String getGrammarFileName() { return "TIMENruleGrammar.g"; }



    // $ANTLR start "run"
    // TIMENruleGrammar.g:13:1: run[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : rules[$timen, $timex_object] ( SEPARATOR )? EOF ;
    public final String run(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String rules1 =null;


        try {
            // TIMENruleGrammar.g:13:69: ( rules[$timen, $timex_object] ( SEPARATOR )? EOF )
            // TIMENruleGrammar.g:14:2: rules[$timen, $timex_object] ( SEPARATOR )? EOF
            {
            pushFollow(FOLLOW_rules_in_run33);
            rules1=rules(timen, timex_object);

            state._fsp--;


            // TIMENruleGrammar.g:14:31: ( SEPARATOR )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==SEPARATOR) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // TIMENruleGrammar.g:14:32: SEPARATOR
                    {
                    match(input,SEPARATOR,FOLLOW_SEPARATOR_in_run37); 

                    }
                    break;

            }


            match(input,EOF,FOLLOW_EOF_in_run41); 

            value =rules1;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "run"



    // $ANTLR start "rules"
    // TIMENruleGrammar.g:16:1: rules[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : e= rule[$timen, $timex_object] ( SEPARATOR e= rule[$timen, $timex_object] )* ;
    public final String rules(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:16:72: (e= rule[$timen, $timex_object] ( SEPARATOR e= rule[$timen, $timex_object] )* )
            // TIMENruleGrammar.g:17:2: e= rule[$timen, $timex_object] ( SEPARATOR e= rule[$timen, $timex_object] )*
            {
            pushFollow(FOLLOW_rule_in_rules59);
            e=rule(timen, timex_object);

            state._fsp--;


            value =e;

            // TIMENruleGrammar.g:17:51: ( SEPARATOR e= rule[$timen, $timex_object] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==SEPARATOR) ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1==STRING||(LA2_1 >= 14 && LA2_1 <= 25)||LA2_1==28||(LA2_1 >= 30 && LA2_1 <= 37)) ) {
                        alt2=1;
                    }


                }


                switch (alt2) {
            	case 1 :
            	    // TIMENruleGrammar.g:17:52: SEPARATOR e= rule[$timen, $timex_object]
            	    {
            	    match(input,SEPARATOR,FOLLOW_SEPARATOR_in_rules65); 

            	    pushFollow(FOLLOW_rule_in_rules69);
            	    e=rule(timen, timex_object);

            	    state._fsp--;


            	    value+=e;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "rules"



    // $ANTLR start "rule"
    // TIMENruleGrammar.g:19:1: rule[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= to_month[$timen,$timex_object] |e= to_day[$timen,$timex_object] |e= to_iso[$timen,$timex_object] |e= to_decade[$timen,$timex_object] |e= to_century[$timen,$timex_object] |e= to_time[$timen,$timex_object] |e= add[$timen, $timex_object] |e= date_weekday[$timen, $timex_object] |e= date_month[$timen, $timex_object] |e= date_month_day[$timen, $timex_object] |e= date_weeknum_weekday_month[$timen, $timex_object] |e= date_last_weekday_month[$timen, $timex_object] |e= to_period[$timen, $timex_object] |e= get_tod[$timen, timex_object] |e= fill_zeros[$timex_object] ) ;
    public final String rule(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:19:71: ( (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= to_month[$timen,$timex_object] |e= to_day[$timen,$timex_object] |e= to_iso[$timen,$timex_object] |e= to_decade[$timen,$timex_object] |e= to_century[$timen,$timex_object] |e= to_time[$timen,$timex_object] |e= add[$timen, $timex_object] |e= date_weekday[$timen, $timex_object] |e= date_month[$timen, $timex_object] |e= date_month_day[$timen, $timex_object] |e= date_weeknum_weekday_month[$timen, $timex_object] |e= date_last_weekday_month[$timen, $timex_object] |e= to_period[$timen, $timex_object] |e= get_tod[$timen, timex_object] |e= fill_zeros[$timex_object] ) )
            // TIMENruleGrammar.g:20:2: (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= to_month[$timen,$timex_object] |e= to_day[$timen,$timex_object] |e= to_iso[$timen,$timex_object] |e= to_decade[$timen,$timex_object] |e= to_century[$timen,$timex_object] |e= to_time[$timen,$timex_object] |e= add[$timen, $timex_object] |e= date_weekday[$timen, $timex_object] |e= date_month[$timen, $timex_object] |e= date_month_day[$timen, $timex_object] |e= date_weeknum_weekday_month[$timen, $timex_object] |e= date_last_weekday_month[$timen, $timex_object] |e= to_period[$timen, $timex_object] |e= get_tod[$timen, timex_object] |e= fill_zeros[$timex_object] )
            {
            // TIMENruleGrammar.g:20:2: (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= to_month[$timen,$timex_object] |e= to_day[$timen,$timex_object] |e= to_iso[$timen,$timex_object] |e= to_decade[$timen,$timex_object] |e= to_century[$timen,$timex_object] |e= to_time[$timen,$timex_object] |e= add[$timen, $timex_object] |e= date_weekday[$timen, $timex_object] |e= date_month[$timen, $timex_object] |e= date_month_day[$timen, $timex_object] |e= date_weeknum_weekday_month[$timen, $timex_object] |e= date_last_weekday_month[$timen, $timex_object] |e= to_period[$timen, $timex_object] |e= get_tod[$timen, timex_object] |e= fill_zeros[$timex_object] )
            int alt3=21;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt3=1;
                }
                break;
            case 28:
                {
                alt3=2;
                }
                break;
            case 23:
                {
                alt3=3;
                }
                break;
            case 22:
                {
                alt3=4;
                }
                break;
            case 21:
                {
                alt3=5;
                }
                break;
            case 37:
                {
                alt3=6;
                }
                break;
            case 34:
                {
                alt3=7;
                }
                break;
            case 31:
                {
                alt3=8;
                }
                break;
            case 33:
                {
                alt3=9;
                }
                break;
            case 32:
                {
                alt3=10;
                }
                break;
            case 30:
                {
                alt3=11;
                }
                break;
            case 36:
                {
                alt3=12;
                }
                break;
            case 14:
            case 15:
                {
                alt3=13;
                }
                break;
            case 19:
                {
                alt3=14;
                }
                break;
            case 17:
                {
                alt3=15;
                }
                break;
            case 18:
                {
                alt3=16;
                }
                break;
            case 20:
                {
                alt3=17;
                }
                break;
            case 16:
                {
                alt3=18;
                }
                break;
            case 35:
                {
                alt3=19;
                }
                break;
            case 25:
                {
                alt3=20;
                }
                break;
            case 24:
                {
                alt3=21;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // TIMENruleGrammar.g:20:3: e= print
                    {
                    pushFollow(FOLLOW_print_in_rule94);
                    e=print();

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 2 :
                    // TIMENruleGrammar.g:21:3: e= pat[$timex_object]
                    {
                    pushFollow(FOLLOW_pat_in_rule102);
                    e=pat(timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 3 :
                    // TIMENruleGrammar.g:22:3: e= dct_year[$timex_object]
                    {
                    pushFollow(FOLLOW_dct_year_in_rule111);
                    e=dct_year(timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 4 :
                    // TIMENruleGrammar.g:23:3: e= dct_month[$timex_object]
                    {
                    pushFollow(FOLLOW_dct_month_in_rule120);
                    e=dct_month(timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 5 :
                    // TIMENruleGrammar.g:24:3: e= dct_day[$timex_object]
                    {
                    pushFollow(FOLLOW_dct_day_in_rule129);
                    e=dct_day(timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 6 :
                    // TIMENruleGrammar.g:25:3: e= to_year[$timex_object]
                    {
                    pushFollow(FOLLOW_to_year_in_rule138);
                    e=to_year(timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 7 :
                    // TIMENruleGrammar.g:26:3: e= to_month[$timen,$timex_object]
                    {
                    pushFollow(FOLLOW_to_month_in_rule147);
                    e=to_month(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 8 :
                    // TIMENruleGrammar.g:27:3: e= to_day[$timen,$timex_object]
                    {
                    pushFollow(FOLLOW_to_day_in_rule156);
                    e=to_day(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 9 :
                    // TIMENruleGrammar.g:28:3: e= to_iso[$timen,$timex_object]
                    {
                    pushFollow(FOLLOW_to_iso_in_rule165);
                    e=to_iso(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 10 :
                    // TIMENruleGrammar.g:29:3: e= to_decade[$timen,$timex_object]
                    {
                    pushFollow(FOLLOW_to_decade_in_rule174);
                    e=to_decade(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 11 :
                    // TIMENruleGrammar.g:30:3: e= to_century[$timen,$timex_object]
                    {
                    pushFollow(FOLLOW_to_century_in_rule183);
                    e=to_century(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 12 :
                    // TIMENruleGrammar.g:31:3: e= to_time[$timen,$timex_object]
                    {
                    pushFollow(FOLLOW_to_time_in_rule192);
                    e=to_time(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 13 :
                    // TIMENruleGrammar.g:32:3: e= add[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_add_in_rule201);
                    e=add(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 14 :
                    // TIMENruleGrammar.g:33:3: e= date_weekday[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_date_weekday_in_rule210);
                    e=date_weekday(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 15 :
                    // TIMENruleGrammar.g:34:3: e= date_month[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_date_month_in_rule219);
                    e=date_month(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 16 :
                    // TIMENruleGrammar.g:35:3: e= date_month_day[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_date_month_day_in_rule228);
                    e=date_month_day(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 17 :
                    // TIMENruleGrammar.g:36:3: e= date_weeknum_weekday_month[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_date_weeknum_weekday_month_in_rule237);
                    e=date_weeknum_weekday_month(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 18 :
                    // TIMENruleGrammar.g:37:3: e= date_last_weekday_month[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_date_last_weekday_month_in_rule246);
                    e=date_last_weekday_month(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 19 :
                    // TIMENruleGrammar.g:38:3: e= to_period[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_to_period_in_rule255);
                    e=to_period(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 20 :
                    // TIMENruleGrammar.g:39:3: e= get_tod[$timen, timex_object]
                    {
                    pushFollow(FOLLOW_get_tod_in_rule264);
                    e=get_tod(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 21 :
                    // TIMENruleGrammar.g:40:3: e= fill_zeros[$timex_object]
                    {
                    pushFollow(FOLLOW_fill_zeros_in_rule273);
                    e=fill_zeros(timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "rule"



    // $ANTLR start "to_period"
    // TIMENruleGrammar.g:43:1: to_period[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : ( 'TO_PERIOD' '(' num= pat[$timex_object] ',' tunit= pat[$timex_object] ')' | 'TO_PERIOD' '(' INT ',' tunit= pat[$timex_object] ')' | 'TO_PERIOD' '(' STRING ',' tunit= pat[$timex_object] ')' );
    public final String to_period(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token INT2=null;
        Token STRING3=null;
        String num =null;

        String tunit =null;


        try {
            // TIMENruleGrammar.g:43:75: ( 'TO_PERIOD' '(' num= pat[$timex_object] ',' tunit= pat[$timex_object] ')' | 'TO_PERIOD' '(' INT ',' tunit= pat[$timex_object] ')' | 'TO_PERIOD' '(' STRING ',' tunit= pat[$timex_object] ')' )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==35) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==11) ) {
                    switch ( input.LA(3) ) {
                    case INT:
                        {
                        alt4=2;
                        }
                        break;
                    case STRING:
                        {
                        alt4=3;
                        }
                        break;
                    case 28:
                        {
                        alt4=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 2, input);

                        throw nvae;

                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // TIMENruleGrammar.g:44:2: 'TO_PERIOD' '(' num= pat[$timex_object] ',' tunit= pat[$timex_object] ')'
                    {
                    match(input,35,FOLLOW_35_in_to_period292); 

                    match(input,11,FOLLOW_11_in_to_period294); 

                    pushFollow(FOLLOW_pat_in_to_period298);
                    num=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_to_period301); 

                    pushFollow(FOLLOW_pat_in_to_period305);
                    tunit=pat(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_to_period308); 

                    value = timen.to_period(num,tunit);

                    }
                    break;
                case 2 :
                    // TIMENruleGrammar.g:45:11: 'TO_PERIOD' '(' INT ',' tunit= pat[$timex_object] ')'
                    {
                    match(input,35,FOLLOW_35_in_to_period322); 

                    match(input,11,FOLLOW_11_in_to_period324); 

                    INT2=(Token)match(input,INT,FOLLOW_INT_in_to_period326); 

                    match(input,13,FOLLOW_13_in_to_period328); 

                    pushFollow(FOLLOW_pat_in_to_period332);
                    tunit=pat(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_to_period335); 

                    value = timen.to_period((INT2!=null?INT2.getText():null),tunit);

                    }
                    break;
                case 3 :
                    // TIMENruleGrammar.g:46:11: 'TO_PERIOD' '(' STRING ',' tunit= pat[$timex_object] ')'
                    {
                    match(input,35,FOLLOW_35_in_to_period349); 

                    match(input,11,FOLLOW_11_in_to_period351); 

                    STRING3=(Token)match(input,STRING,FOLLOW_STRING_in_to_period353); 

                    match(input,13,FOLLOW_13_in_to_period355); 

                    pushFollow(FOLLOW_pat_in_to_period359);
                    tunit=pat(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_to_period362); 

                    value = timen.to_period((STRING3!=null?STRING3.getText():null),tunit);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "to_period"



    // $ANTLR start "get_tod"
    // TIMENruleGrammar.g:50:1: get_tod[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'GET_TOD' '(' e= pat[$timex_object] ')' ;
    public final String get_tod(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:50:73: ( 'GET_TOD' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:51:2: 'GET_TOD' '(' e= pat[$timex_object] ')'
            {
            match(input,25,FOLLOW_25_in_get_tod387); 

            match(input,11,FOLLOW_11_in_get_tod389); 

            pushFollow(FOLLOW_pat_in_get_tod393);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_get_tod396); 

            value = timen.getTOD(e);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "get_tod"



    // $ANTLR start "dct_year"
    // TIMENruleGrammar.g:54:1: dct_year[TIMEX_Instance timex_object] returns [String value] : 'DCTYEAR' ;
    public final String dct_year(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        try {
            // TIMENruleGrammar.g:54:61: ( 'DCTYEAR' )
            // TIMENruleGrammar.g:55:2: 'DCTYEAR'
            {
            match(input,23,FOLLOW_23_in_dct_year412); 

            value = timex_object.dct.getYear();

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "dct_year"



    // $ANTLR start "dct_month"
    // TIMENruleGrammar.g:57:1: dct_month[TIMEX_Instance timex_object] returns [String value] : 'DCTMONTH' ;
    public final String dct_month(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        try {
            // TIMENruleGrammar.g:57:62: ( 'DCTMONTH' )
            // TIMENruleGrammar.g:58:2: 'DCTMONTH'
            {
            match(input,22,FOLLOW_22_in_dct_month428); 

            value = timex_object.dct.getMonth();

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "dct_month"



    // $ANTLR start "dct_day"
    // TIMENruleGrammar.g:60:1: dct_day[TIMEX_Instance timex_object] returns [String value] : 'DCTDAY' ;
    public final String dct_day(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        try {
            // TIMENruleGrammar.g:60:60: ( 'DCTDAY' )
            // TIMENruleGrammar.g:61:2: 'DCTDAY'
            {
            match(input,21,FOLLOW_21_in_dct_day444); 

            value = timex_object.dct.getDay();

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "dct_day"



    // $ANTLR start "to_year"
    // TIMENruleGrammar.g:63:1: to_year[TIMEX_Instance timex_object] returns [String value] : 'TO_YEAR' '(' e= pat[$timex_object] ')' ;
    public final String to_year(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:63:60: ( 'TO_YEAR' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:64:2: 'TO_YEAR' '(' e= pat[$timex_object] ')'
            {
            match(input,37,FOLLOW_37_in_to_year460); 

            match(input,11,FOLLOW_11_in_to_year462); 

            pushFollow(FOLLOW_pat_in_to_year466);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_year469); 

            value = TIMEN.to_year(e,timex_object);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "to_year"



    // $ANTLR start "to_month"
    // TIMENruleGrammar.g:66:1: to_month[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'TO_MONTH' '(' e= pat[$timex_object] ')' ;
    public final String to_month(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:66:74: ( 'TO_MONTH' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:67:2: 'TO_MONTH' '(' e= pat[$timex_object] ')'
            {
            match(input,34,FOLLOW_34_in_to_month484); 

            match(input,11,FOLLOW_11_in_to_month486); 

            pushFollow(FOLLOW_pat_in_to_month490);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_month493); 

            value = timen.to_month(e);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "to_month"



    // $ANTLR start "to_day"
    // TIMENruleGrammar.g:69:1: to_day[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'TO_DAY' '(' e= pat[$timex_object] ')' ;
    public final String to_day(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:69:72: ( 'TO_DAY' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:70:2: 'TO_DAY' '(' e= pat[$timex_object] ')'
            {
            match(input,31,FOLLOW_31_in_to_day508); 

            match(input,11,FOLLOW_11_in_to_day510); 

            pushFollow(FOLLOW_pat_in_to_day514);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_day517); 

            value = timen.to_day(e);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "to_day"



    // $ANTLR start "to_iso"
    // TIMENruleGrammar.g:72:1: to_iso[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'TO_ISO' '(' e= pat[$timex_object] ')' ;
    public final String to_iso(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:72:72: ( 'TO_ISO' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:73:2: 'TO_ISO' '(' e= pat[$timex_object] ')'
            {
            match(input,33,FOLLOW_33_in_to_iso532); 

            match(input,11,FOLLOW_11_in_to_iso534); 

            pushFollow(FOLLOW_pat_in_to_iso538);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_iso541); 

            value = timen.to_iso(e,timex_object);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "to_iso"



    // $ANTLR start "to_decade"
    // TIMENruleGrammar.g:75:1: to_decade[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'TO_DECADE' '(' e= pat[$timex_object] ')' ;
    public final String to_decade(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:75:75: ( 'TO_DECADE' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:76:2: 'TO_DECADE' '(' e= pat[$timex_object] ')'
            {
            match(input,32,FOLLOW_32_in_to_decade556); 

            match(input,11,FOLLOW_11_in_to_decade558); 

            pushFollow(FOLLOW_pat_in_to_decade562);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_decade565); 

            value = timen.to_decade(e,timex_object);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "to_decade"



    // $ANTLR start "to_century"
    // TIMENruleGrammar.g:78:1: to_century[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'TO_CENTURY' '(' e= pat[$timex_object] ')' ;
    public final String to_century(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:78:76: ( 'TO_CENTURY' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:79:2: 'TO_CENTURY' '(' e= pat[$timex_object] ')'
            {
            match(input,30,FOLLOW_30_in_to_century580); 

            match(input,11,FOLLOW_11_in_to_century582); 

            pushFollow(FOLLOW_pat_in_to_century586);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_century589); 

            value = timen.to_century(e,timex_object);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "to_century"



    // $ANTLR start "to_time"
    // TIMENruleGrammar.g:81:1: to_time[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'TO_TIME' '(' e= pat[$timex_object] ')' ;
    public final String to_time(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:81:73: ( 'TO_TIME' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:82:2: 'TO_TIME' '(' e= pat[$timex_object] ')'
            {
            match(input,36,FOLLOW_36_in_to_time604); 

            match(input,11,FOLLOW_11_in_to_time606); 

            pushFollow(FOLLOW_pat_in_to_time610);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_time613); 

            value = timen.to_time(e);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "to_time"



    // $ANTLR start "fill_zeros"
    // TIMENruleGrammar.g:84:1: fill_zeros[TIMEX_Instance timex_object] returns [String value] : 'FILL_ZEROS' '(' e= pat[$timex_object] ',' i= intnumber ')' ;
    public final String fill_zeros(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;

        int i =0;


        try {
            // TIMENruleGrammar.g:84:63: ( 'FILL_ZEROS' '(' e= pat[$timex_object] ',' i= intnumber ')' )
            // TIMENruleGrammar.g:85:2: 'FILL_ZEROS' '(' e= pat[$timex_object] ',' i= intnumber ')'
            {
            match(input,24,FOLLOW_24_in_fill_zeros628); 

            match(input,11,FOLLOW_11_in_fill_zeros630); 

            pushFollow(FOLLOW_pat_in_fill_zeros634);
            e=pat(timex_object);

            state._fsp--;


            match(input,13,FOLLOW_13_in_fill_zeros637); 

            pushFollow(FOLLOW_intnumber_in_fill_zeros641);
            i=intnumber();

            state._fsp--;


            match(input,12,FOLLOW_12_in_fill_zeros643); 

            value = TIMEN.fill_zeros(e,i);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "fill_zeros"



    // $ANTLR start "add"
    // TIMENruleGrammar.g:87:1: add[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : ( 'ADD' '(' r= REFERENCE ',' GRANULARITY ',' i= intnumber ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= toint[$timex_object] ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= tonegativeint[$timex_object] ')' | 'ADD' '(' r= REFERENCE ',' e= subpat[$timex_object] ',' i= intsubpat[$timex_object] ')' | 'ADD' '(' a= subpat[$timex_object] ',' e= pat[$timex_object] ',' i= intsubpat[$timex_object] ')' | 'ADD' '(' a= subpat[$timex_object] ',' e= subpat[$timex_object] ',' i= intsubpat[$timex_object] ')' | 'ADD_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')' | 'ADD_WEEKDAY' '(' a= subpat[$timex_object] ',' e= pat[$timex_object] ',' i= intnumber ')' | 'ADD_WEEKDAY' '(' a= subpat[$timex_object] ',' e= pat[$timex_object] ',' i= intsubpat[$timex_object] ')' );
    public final String add(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        Token GRANULARITY4=null;
        int i =0;

        String e =null;

        String a =null;


        try {
            // TIMENruleGrammar.g:87:69: ( 'ADD' '(' r= REFERENCE ',' GRANULARITY ',' i= intnumber ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= toint[$timex_object] ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= tonegativeint[$timex_object] ')' | 'ADD' '(' r= REFERENCE ',' e= subpat[$timex_object] ',' i= intsubpat[$timex_object] ')' | 'ADD' '(' a= subpat[$timex_object] ',' e= pat[$timex_object] ',' i= intsubpat[$timex_object] ')' | 'ADD' '(' a= subpat[$timex_object] ',' e= subpat[$timex_object] ',' i= intsubpat[$timex_object] ')' | 'ADD_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')' | 'ADD_WEEKDAY' '(' a= subpat[$timex_object] ',' e= pat[$timex_object] ',' i= intnumber ')' | 'ADD_WEEKDAY' '(' a= subpat[$timex_object] ',' e= pat[$timex_object] ',' i= intsubpat[$timex_object] ')' )
            int alt5=10;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==11) ) {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==REFERENCE) ) {
                        int LA5_5 = input.LA(4);

                        if ( (LA5_5==13) ) {
                            switch ( input.LA(5) ) {
                            case GRANULARITY:
                                {
                                alt5=1;
                                }
                                break;
                            case 28:
                                {
                                int LA5_13 = input.LA(6);

                                if ( (LA5_13==11) ) {
                                    int LA5_17 = input.LA(7);

                                    if ( (LA5_17==INT) ) {
                                        int LA5_20 = input.LA(8);

                                        if ( (LA5_20==12) ) {
                                            int LA5_23 = input.LA(9);

                                            if ( (LA5_23==13) ) {
                                                switch ( input.LA(10) ) {
                                                case INT:
                                                    {
                                                    alt5=2;
                                                    }
                                                    break;
                                                case 26:
                                                    {
                                                    alt5=3;
                                                    }
                                                    break;
                                                case 27:
                                                    {
                                                    alt5=4;
                                                    }
                                                    break;
                                                default:
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("", 5, 26, input);

                                                    throw nvae;

                                                }

                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 5, 23, input);

                                                throw nvae;

                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 5, 20, input);

                                            throw nvae;

                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 5, 17, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 5, 13, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case 29:
                                {
                                alt5=5;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 9, input);

                                throw nvae;

                            }

                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 5, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA5_3==29) ) {
                        int LA5_6 = input.LA(4);

                        if ( (LA5_6==11) ) {
                            int LA5_10 = input.LA(5);

                            if ( (LA5_10==INT) ) {
                                int LA5_15 = input.LA(6);

                                if ( (LA5_15==13) ) {
                                    int LA5_18 = input.LA(7);

                                    if ( (LA5_18==STRING) ) {
                                        int LA5_21 = input.LA(8);

                                        if ( (LA5_21==13) ) {
                                            int LA5_24 = input.LA(9);

                                            if ( (LA5_24==INT) ) {
                                                int LA5_27 = input.LA(10);

                                                if ( (LA5_27==12) ) {
                                                    int LA5_32 = input.LA(11);

                                                    if ( (LA5_32==13) ) {
                                                        int LA5_34 = input.LA(12);

                                                        if ( (LA5_34==28) ) {
                                                            alt5=6;
                                                        }
                                                        else if ( (LA5_34==29) ) {
                                                            alt5=7;
                                                        }
                                                        else {
                                                            NoViableAltException nvae =
                                                                new NoViableAltException("", 5, 34, input);

                                                            throw nvae;

                                                        }
                                                    }
                                                    else {
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("", 5, 32, input);

                                                        throw nvae;

                                                    }
                                                }
                                                else {
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("", 5, 27, input);

                                                    throw nvae;

                                                }
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 5, 24, input);

                                                throw nvae;

                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 5, 21, input);

                                            throw nvae;

                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 5, 18, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 5, 15, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 10, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 6, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 3, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA5_0==15) ) {
                int LA5_2 = input.LA(2);

                if ( (LA5_2==11) ) {
                    int LA5_4 = input.LA(3);

                    if ( (LA5_4==REFERENCE) ) {
                        alt5=8;
                    }
                    else if ( (LA5_4==29) ) {
                        int LA5_8 = input.LA(4);

                        if ( (LA5_8==11) ) {
                            int LA5_11 = input.LA(5);

                            if ( (LA5_11==INT) ) {
                                int LA5_16 = input.LA(6);

                                if ( (LA5_16==13) ) {
                                    int LA5_19 = input.LA(7);

                                    if ( (LA5_19==STRING) ) {
                                        int LA5_22 = input.LA(8);

                                        if ( (LA5_22==13) ) {
                                            int LA5_25 = input.LA(9);

                                            if ( (LA5_25==INT) ) {
                                                int LA5_28 = input.LA(10);

                                                if ( (LA5_28==12) ) {
                                                    int LA5_33 = input.LA(11);

                                                    if ( (LA5_33==13) ) {
                                                        int LA5_35 = input.LA(12);

                                                        if ( (LA5_35==28) ) {
                                                            int LA5_38 = input.LA(13);

                                                            if ( (LA5_38==11) ) {
                                                                int LA5_39 = input.LA(14);

                                                                if ( (LA5_39==INT) ) {
                                                                    int LA5_40 = input.LA(15);

                                                                    if ( (LA5_40==12) ) {
                                                                        int LA5_41 = input.LA(16);

                                                                        if ( (LA5_41==13) ) {
                                                                            int LA5_42 = input.LA(17);

                                                                            if ( (LA5_42==INT) ) {
                                                                                alt5=9;
                                                                            }
                                                                            else if ( (LA5_42==29) ) {
                                                                                alt5=10;
                                                                            }
                                                                            else {
                                                                                NoViableAltException nvae =
                                                                                    new NoViableAltException("", 5, 42, input);

                                                                                throw nvae;

                                                                            }
                                                                        }
                                                                        else {
                                                                            NoViableAltException nvae =
                                                                                new NoViableAltException("", 5, 41, input);

                                                                            throw nvae;

                                                                        }
                                                                    }
                                                                    else {
                                                                        NoViableAltException nvae =
                                                                            new NoViableAltException("", 5, 40, input);

                                                                        throw nvae;

                                                                    }
                                                                }
                                                                else {
                                                                    NoViableAltException nvae =
                                                                        new NoViableAltException("", 5, 39, input);

                                                                    throw nvae;

                                                                }
                                                            }
                                                            else {
                                                                NoViableAltException nvae =
                                                                    new NoViableAltException("", 5, 38, input);

                                                                throw nvae;

                                                            }
                                                        }
                                                        else {
                                                            NoViableAltException nvae =
                                                                new NoViableAltException("", 5, 35, input);

                                                            throw nvae;

                                                        }
                                                    }
                                                    else {
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("", 5, 33, input);

                                                        throw nvae;

                                                    }
                                                }
                                                else {
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("", 5, 28, input);

                                                    throw nvae;

                                                }
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 5, 25, input);

                                                throw nvae;

                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 5, 22, input);

                                            throw nvae;

                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 5, 19, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 5, 16, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 11, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 8, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 4, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // TIMENruleGrammar.g:88:10: 'ADD' '(' r= REFERENCE ',' GRANULARITY ',' i= intnumber ')'
                    {
                    match(input,14,FOLLOW_14_in_add667); 

                    match(input,11,FOLLOW_11_in_add669); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add673); 

                    match(input,13,FOLLOW_13_in_add681); 

                    GRANULARITY4=(Token)match(input,GRANULARITY,FOLLOW_GRANULARITY_in_add683); 

                    match(input,13,FOLLOW_13_in_add695); 

                    pushFollow(FOLLOW_intnumber_in_add699);
                    i=intnumber();

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add701); 

                    value = timen.add((r!=null?r.getText():null),(GRANULARITY4!=null?GRANULARITY4.getText():null),i, timex_object);

                    }
                    break;
                case 2 :
                    // TIMENruleGrammar.g:89:11: 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')'
                    {
                    match(input,14,FOLLOW_14_in_add715); 

                    match(input,11,FOLLOW_11_in_add717); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add721); 

                    match(input,13,FOLLOW_13_in_add729); 

                    pushFollow(FOLLOW_pat_in_add733);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add736); 

                    pushFollow(FOLLOW_intnumber_in_add740);
                    i=intnumber();

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add742); 

                    value = timen.add((r!=null?r.getText():null),e,i, timex_object);

                    }
                    break;
                case 3 :
                    // TIMENruleGrammar.g:90:11: 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= toint[$timex_object] ')'
                    {
                    match(input,14,FOLLOW_14_in_add756); 

                    match(input,11,FOLLOW_11_in_add758); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add762); 

                    match(input,13,FOLLOW_13_in_add770); 

                    pushFollow(FOLLOW_pat_in_add774);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add777); 

                    pushFollow(FOLLOW_toint_in_add781);
                    i=toint(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add784); 

                    value = timen.add((r!=null?r.getText():null),e,i, timex_object);

                    }
                    break;
                case 4 :
                    // TIMENruleGrammar.g:91:11: 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= tonegativeint[$timex_object] ')'
                    {
                    match(input,14,FOLLOW_14_in_add798); 

                    match(input,11,FOLLOW_11_in_add800); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add804); 

                    match(input,13,FOLLOW_13_in_add812); 

                    pushFollow(FOLLOW_pat_in_add816);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add819); 

                    pushFollow(FOLLOW_tonegativeint_in_add823);
                    i=tonegativeint(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add826); 

                    value = timen.add((r!=null?r.getText():null),e,i, timex_object);

                    }
                    break;
                case 5 :
                    // TIMENruleGrammar.g:92:11: 'ADD' '(' r= REFERENCE ',' e= subpat[$timex_object] ',' i= intsubpat[$timex_object] ')'
                    {
                    match(input,14,FOLLOW_14_in_add840); 

                    match(input,11,FOLLOW_11_in_add842); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add846); 

                    match(input,13,FOLLOW_13_in_add854); 

                    pushFollow(FOLLOW_subpat_in_add858);
                    e=subpat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add861); 

                    pushFollow(FOLLOW_intsubpat_in_add865);
                    i=intsubpat(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add868); 

                    value = timen.add((r!=null?r.getText():null),e,i, timex_object);

                    }
                    break;
                case 6 :
                    // TIMENruleGrammar.g:93:11: 'ADD' '(' a= subpat[$timex_object] ',' e= pat[$timex_object] ',' i= intsubpat[$timex_object] ')'
                    {
                    match(input,14,FOLLOW_14_in_add882); 

                    match(input,11,FOLLOW_11_in_add884); 

                    pushFollow(FOLLOW_subpat_in_add888);
                    a=subpat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add897); 

                    pushFollow(FOLLOW_pat_in_add901);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add904); 

                    pushFollow(FOLLOW_intsubpat_in_add908);
                    i=intsubpat(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add911); 

                    value = timen.add(a,e,i, timex_object);

                    }
                    break;
                case 7 :
                    // TIMENruleGrammar.g:94:11: 'ADD' '(' a= subpat[$timex_object] ',' e= subpat[$timex_object] ',' i= intsubpat[$timex_object] ')'
                    {
                    match(input,14,FOLLOW_14_in_add925); 

                    match(input,11,FOLLOW_11_in_add927); 

                    pushFollow(FOLLOW_subpat_in_add931);
                    a=subpat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add940); 

                    pushFollow(FOLLOW_subpat_in_add944);
                    e=subpat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add947); 

                    pushFollow(FOLLOW_intsubpat_in_add951);
                    i=intsubpat(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add954); 

                    value = timen.add(a,e,i, timex_object);

                    }
                    break;
                case 8 :
                    // TIMENruleGrammar.g:95:11: 'ADD_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')'
                    {
                    match(input,15,FOLLOW_15_in_add968); 

                    match(input,11,FOLLOW_11_in_add970); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add974); 

                    match(input,13,FOLLOW_13_in_add982); 

                    pushFollow(FOLLOW_pat_in_add986);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add989); 

                    pushFollow(FOLLOW_intnumber_in_add993);
                    i=intnumber();

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add995); 

                    value = timen.add_weekday((r!=null?r.getText():null),e,i, timex_object);

                    }
                    break;
                case 9 :
                    // TIMENruleGrammar.g:96:11: 'ADD_WEEKDAY' '(' a= subpat[$timex_object] ',' e= pat[$timex_object] ',' i= intnumber ')'
                    {
                    match(input,15,FOLLOW_15_in_add1009); 

                    match(input,11,FOLLOW_11_in_add1011); 

                    pushFollow(FOLLOW_subpat_in_add1015);
                    a=subpat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add1024); 

                    pushFollow(FOLLOW_pat_in_add1028);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add1031); 

                    pushFollow(FOLLOW_intnumber_in_add1035);
                    i=intnumber();

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add1037); 

                    value = timen.add_weekday(a,e,i, timex_object);

                    }
                    break;
                case 10 :
                    // TIMENruleGrammar.g:97:11: 'ADD_WEEKDAY' '(' a= subpat[$timex_object] ',' e= pat[$timex_object] ',' i= intsubpat[$timex_object] ')'
                    {
                    match(input,15,FOLLOW_15_in_add1051); 

                    match(input,11,FOLLOW_11_in_add1053); 

                    pushFollow(FOLLOW_subpat_in_add1057);
                    a=subpat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add1066); 

                    pushFollow(FOLLOW_pat_in_add1070);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add1073); 

                    pushFollow(FOLLOW_intsubpat_in_add1077);
                    i=intsubpat(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add1080); 

                    value = timen.add_weekday(a,e,i, timex_object);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "add"



    // $ANTLR start "date_weekday"
    // TIMENruleGrammar.g:103:1: date_weekday[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'DATE_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ')' ;
    public final String date_weekday(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        String e =null;


        try {
            // TIMENruleGrammar.g:103:78: ( 'DATE_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:104:10: 'DATE_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ')'
            {
            match(input,19,FOLLOW_19_in_date_weekday1115); 

            match(input,11,FOLLOW_11_in_date_weekday1117); 

            r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_date_weekday1121); 

            match(input,13,FOLLOW_13_in_date_weekday1129); 

            pushFollow(FOLLOW_pat_in_date_weekday1133);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_date_weekday1136); 

            value = timen.date_weekday((r!=null?r.getText():null),e, timex_object);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "date_weekday"



    // $ANTLR start "date_month"
    // TIMENruleGrammar.g:107:1: date_month[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'DATE_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ')' ;
    public final String date_month(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        String e =null;


        try {
            // TIMENruleGrammar.g:107:76: ( 'DATE_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:108:10: 'DATE_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ')'
            {
            match(input,17,FOLLOW_17_in_date_month1160); 

            match(input,11,FOLLOW_11_in_date_month1162); 

            r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_date_month1166); 

            match(input,13,FOLLOW_13_in_date_month1174); 

            pushFollow(FOLLOW_pat_in_date_month1178);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_date_month1181); 

            value = timen.date_month((r!=null?r.getText():null),e, timex_object);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "date_month"



    // $ANTLR start "date_month_day"
    // TIMENruleGrammar.g:110:1: date_month_day[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'DATE_MONTH_DAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ')' ;
    public final String date_month_day(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        String e =null;

        String d =null;


        try {
            // TIMENruleGrammar.g:110:80: ( 'DATE_MONTH_DAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:111:10: 'DATE_MONTH_DAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ')'
            {
            match(input,18,FOLLOW_18_in_date_month_day1204); 

            match(input,11,FOLLOW_11_in_date_month_day1206); 

            r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_date_month_day1210); 

            match(input,13,FOLLOW_13_in_date_month_day1218); 

            pushFollow(FOLLOW_pat_in_date_month_day1222);
            e=pat(timex_object);

            state._fsp--;


            match(input,13,FOLLOW_13_in_date_month_day1225); 

            pushFollow(FOLLOW_pat_in_date_month_day1229);
            d=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_date_month_day1232); 

            value = timen.date_month_day((r!=null?r.getText():null),e,d, timex_object);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "date_month_day"



    // $ANTLR start "date_weeknum_weekday_month"
    // TIMENruleGrammar.g:113:1: date_weeknum_weekday_month[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'DATE_WEEKNUM_WEEKDAY_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ',' f= pat[$timex_object] ')' ;
    public final String date_weeknum_weekday_month(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        String e =null;

        String d =null;

        String f =null;


        try {
            // TIMENruleGrammar.g:113:92: ( 'DATE_WEEKNUM_WEEKDAY_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ',' f= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:114:10: 'DATE_WEEKNUM_WEEKDAY_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ',' f= pat[$timex_object] ')'
            {
            match(input,20,FOLLOW_20_in_date_weeknum_weekday_month1255); 

            match(input,11,FOLLOW_11_in_date_weeknum_weekday_month1257); 

            r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_date_weeknum_weekday_month1261); 

            match(input,13,FOLLOW_13_in_date_weeknum_weekday_month1269); 

            pushFollow(FOLLOW_pat_in_date_weeknum_weekday_month1273);
            e=pat(timex_object);

            state._fsp--;


            match(input,13,FOLLOW_13_in_date_weeknum_weekday_month1276); 

            pushFollow(FOLLOW_pat_in_date_weeknum_weekday_month1280);
            d=pat(timex_object);

            state._fsp--;


            match(input,13,FOLLOW_13_in_date_weeknum_weekday_month1283); 

            pushFollow(FOLLOW_pat_in_date_weeknum_weekday_month1287);
            f=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_date_weeknum_weekday_month1290); 

            value = timen.date_weeknum_weekday_month((r!=null?r.getText():null),e,d,f, timex_object);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "date_weeknum_weekday_month"



    // $ANTLR start "date_last_weekday_month"
    // TIMENruleGrammar.g:116:1: date_last_weekday_month[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'DATE_LAST_WEEKDAY_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ')' ;
    public final String date_last_weekday_month(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        String e =null;

        String d =null;


        try {
            // TIMENruleGrammar.g:116:89: ( 'DATE_LAST_WEEKDAY_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:117:10: 'DATE_LAST_WEEKDAY_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ')'
            {
            match(input,16,FOLLOW_16_in_date_last_weekday_month1313); 

            match(input,11,FOLLOW_11_in_date_last_weekday_month1315); 

            r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_date_last_weekday_month1319); 

            match(input,13,FOLLOW_13_in_date_last_weekday_month1327); 

            pushFollow(FOLLOW_pat_in_date_last_weekday_month1331);
            e=pat(timex_object);

            state._fsp--;


            match(input,13,FOLLOW_13_in_date_last_weekday_month1334); 

            pushFollow(FOLLOW_pat_in_date_last_weekday_month1338);
            d=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_date_last_weekday_month1342); 

            value = timen.date_last_weekday_month((r!=null?r.getText():null),e,d, timex_object);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "date_last_weekday_month"



    // $ANTLR start "pat"
    // TIMENruleGrammar.g:120:1: pat[TIMEX_Instance timex_object] returns [String value] : 'PAT' '(' e= intnumber ')' ;
    public final String pat(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        int e =0;


        try {
            // TIMENruleGrammar.g:120:56: ( 'PAT' '(' e= intnumber ')' )
            // TIMENruleGrammar.g:121:2: 'PAT' '(' e= intnumber ')'
            {
            match(input,28,FOLLOW_28_in_pat1358); 

            match(input,11,FOLLOW_11_in_pat1360); 

            pushFollow(FOLLOW_intnumber_in_pat1364);
            e=intnumber();

            state._fsp--;


            match(input,12,FOLLOW_12_in_pat1366); 

            value = timex_object.getNormTextArr()[e];

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "pat"



    // $ANTLR start "subpat"
    // TIMENruleGrammar.g:123:1: subpat[TIMEX_Instance timex_object] returns [String value] : 'SUBPAT' '(' e= intnumber ',' d= STRING ',' c= intnumber ')' ;
    public final String subpat(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token d=null;
        int e =0;

        int c =0;


        try {
            // TIMENruleGrammar.g:123:59: ( 'SUBPAT' '(' e= intnumber ',' d= STRING ',' c= intnumber ')' )
            // TIMENruleGrammar.g:124:2: 'SUBPAT' '(' e= intnumber ',' d= STRING ',' c= intnumber ')'
            {
            match(input,29,FOLLOW_29_in_subpat1381); 

            match(input,11,FOLLOW_11_in_subpat1383); 

            pushFollow(FOLLOW_intnumber_in_subpat1387);
            e=intnumber();

            state._fsp--;


            match(input,13,FOLLOW_13_in_subpat1389); 

            d=(Token)match(input,STRING,FOLLOW_STRING_in_subpat1393); 

            match(input,13,FOLLOW_13_in_subpat1395); 

            pushFollow(FOLLOW_intnumber_in_subpat1399);
            c=intnumber();

            state._fsp--;


            match(input,12,FOLLOW_12_in_subpat1401); 

            value = timex_object.getSubPat(e,(d!=null?d.getText():null),c);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "subpat"



    // $ANTLR start "intsubpat"
    // TIMENruleGrammar.g:126:1: intsubpat[TIMEX_Instance timex_object] returns [int value] : 'SUBPAT' '(' e= intnumber ',' d= STRING ',' c= intnumber ')' ;
    public final int intsubpat(TIMEX_Instance timex_object) throws RecognitionException {
        int value = 0;


        Token d=null;
        int e =0;

        int c =0;


        try {
            // TIMENruleGrammar.g:126:59: ( 'SUBPAT' '(' e= intnumber ',' d= STRING ',' c= intnumber ')' )
            // TIMENruleGrammar.g:127:2: 'SUBPAT' '(' e= intnumber ',' d= STRING ',' c= intnumber ')'
            {
            match(input,29,FOLLOW_29_in_intsubpat1416); 

            match(input,11,FOLLOW_11_in_intsubpat1418); 

            pushFollow(FOLLOW_intnumber_in_intsubpat1422);
            e=intnumber();

            state._fsp--;


            match(input,13,FOLLOW_13_in_intsubpat1424); 

            d=(Token)match(input,STRING,FOLLOW_STRING_in_intsubpat1428); 

            match(input,13,FOLLOW_13_in_intsubpat1430); 

            pushFollow(FOLLOW_intnumber_in_intsubpat1434);
            c=intnumber();

            state._fsp--;


            match(input,12,FOLLOW_12_in_intsubpat1436); 

            value = Integer.parseInt(timex_object.getSubPat(e,(d!=null?d.getText():null),c));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "intsubpat"



    // $ANTLR start "tonegativeint"
    // TIMENruleGrammar.g:130:1: tonegativeint[TIMEX_Instance timex_object] returns [int value] : 'NEGATIVEINT(' e= pat[$timex_object] ')' ;
    public final int tonegativeint(TIMEX_Instance timex_object) throws RecognitionException {
        int value = 0;


        String e =null;


        try {
            // TIMENruleGrammar.g:130:63: ( 'NEGATIVEINT(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:131:5: 'NEGATIVEINT(' e= pat[$timex_object] ')'
            {
            match(input,27,FOLLOW_27_in_tonegativeint1455); 

            pushFollow(FOLLOW_pat_in_tonegativeint1459);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_tonegativeint1462); 

            value = Integer.parseInt("-"+e);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "tonegativeint"



    // $ANTLR start "toint"
    // TIMENruleGrammar.g:133:1: toint[TIMEX_Instance timex_object] returns [int value] : 'INT(' e= pat[$timex_object] ')' ;
    public final int toint(TIMEX_Instance timex_object) throws RecognitionException {
        int value = 0;


        String e =null;


        try {
            // TIMENruleGrammar.g:133:55: ( 'INT(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:134:5: 'INT(' e= pat[$timex_object] ')'
            {
            match(input,26,FOLLOW_26_in_toint1480); 

            pushFollow(FOLLOW_pat_in_toint1484);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_toint1487); 

            value = Integer.parseInt(e);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "toint"



    // $ANTLR start "print"
    // TIMENruleGrammar.g:137:1: print returns [String value] : STRING ;
    public final String print() throws RecognitionException {
        String value = null;


        Token STRING5=null;

        try {
            // TIMENruleGrammar.g:137:29: ( STRING )
            // TIMENruleGrammar.g:138:5: STRING
            {
            STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_print1505); 

            value = (STRING5!=null?STRING5.getText():null);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "print"



    // $ANTLR start "intnumber"
    // TIMENruleGrammar.g:141:1: intnumber returns [int value] : INT ;
    public final int intnumber() throws RecognitionException {
        int value = 0;


        Token INT6=null;

        try {
            // TIMENruleGrammar.g:141:30: ( INT )
            // TIMENruleGrammar.g:142:2: INT
            {
            INT6=(Token)match(input,INT,FOLLOW_INT_in_intnumber1525); 

            value = Integer.parseInt((INT6!=null?INT6.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "intnumber"

    // Delegated rules


 

    public static final BitSet FOLLOW_rules_in_run33 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEPARATOR_in_run37 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_run41 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule_in_rules59 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_SEPARATOR_in_rules65 = new BitSet(new long[]{0x0000003FD3FFC200L});
    public static final BitSet FOLLOW_rule_in_rules69 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_print_in_rule94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pat_in_rule102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dct_year_in_rule111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dct_month_in_rule120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dct_day_in_rule129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_year_in_rule138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_month_in_rule147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_day_in_rule156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_iso_in_rule165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_decade_in_rule174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_century_in_rule183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_time_in_rule192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_add_in_rule201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_weekday_in_rule210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_month_in_rule219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_month_day_in_rule228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_weeknum_weekday_month_in_rule237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_last_weekday_month_in_rule246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_period_in_rule255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_get_tod_in_rule264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fill_zeros_in_rule273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_to_period292 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_period294 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_period298 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_to_period301 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_period305 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_period308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_to_period322 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_period324 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_to_period326 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_to_period328 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_period332 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_period335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_to_period349 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_period351 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_to_period353 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_to_period355 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_period359 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_period362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_get_tod387 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_get_tod389 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_get_tod393 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_get_tod396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_dct_year412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_dct_month428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_dct_day444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_to_year460 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_year462 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_year466 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_year469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_to_month484 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_month486 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_month490 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_month493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_to_day508 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_day510 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_day514 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_day517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_to_iso532 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_iso534 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_iso538 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_iso541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_to_decade556 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_decade558 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_decade562 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_decade565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_to_century580 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_century582 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_century586 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_century589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_to_time604 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_time606 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_time610 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_time613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_fill_zeros628 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_fill_zeros630 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_fill_zeros634 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_fill_zeros637 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_fill_zeros641 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_fill_zeros643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add667 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add669 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add673 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add681 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_GRANULARITY_in_add683 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add695 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_add699 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add715 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add717 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add721 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add729 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_add733 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add736 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_add740 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add756 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add758 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add762 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add770 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_add774 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add777 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_toint_in_add781 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add798 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add800 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add804 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add812 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_add816 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add819 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_tonegativeint_in_add823 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add840 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add842 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add846 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add854 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_subpat_in_add858 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add861 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_intsubpat_in_add865 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add882 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add884 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_subpat_in_add888 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add897 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_add901 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add904 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_intsubpat_in_add908 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add925 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add927 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_subpat_in_add931 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add940 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_subpat_in_add944 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add947 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_intsubpat_in_add951 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_add968 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add970 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add974 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add982 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_add986 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add989 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_add993 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_add1009 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add1011 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_subpat_in_add1015 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add1024 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_add1028 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add1031 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_add1035 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add1037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_add1051 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add1053 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_subpat_in_add1057 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add1066 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_add1070 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add1073 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_intsubpat_in_add1077 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add1080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_date_weekday1115 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_date_weekday1117 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_date_weekday1121 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_weekday1129 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_date_weekday1133 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_date_weekday1136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_date_month1160 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_date_month1162 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_date_month1166 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_month1174 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_date_month1178 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_date_month1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_date_month_day1204 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_date_month_day1206 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_date_month_day1210 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_month_day1218 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_date_month_day1222 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_month_day1225 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_date_month_day1229 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_date_month_day1232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_date_weeknum_weekday_month1255 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_date_weeknum_weekday_month1257 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_date_weeknum_weekday_month1261 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_weeknum_weekday_month1269 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_date_weeknum_weekday_month1273 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_weeknum_weekday_month1276 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_date_weeknum_weekday_month1280 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_weeknum_weekday_month1283 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_date_weeknum_weekday_month1287 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_date_weeknum_weekday_month1290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_date_last_weekday_month1313 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_date_last_weekday_month1315 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_date_last_weekday_month1319 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_last_weekday_month1327 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_date_last_weekday_month1331 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_last_weekday_month1334 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_date_last_weekday_month1338 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_date_last_weekday_month1342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_pat1358 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_pat1360 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_pat1364 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_pat1366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_subpat1381 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_subpat1383 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_subpat1387 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_subpat1389 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_subpat1393 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_subpat1395 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_subpat1399 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_subpat1401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_intsubpat1416 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_intsubpat1418 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_intsubpat1422 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_intsubpat1424 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_intsubpat1428 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_intsubpat1430 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_intsubpat1434 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_intsubpat1436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_tonegativeint1455 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_tonegativeint1459 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_tonegativeint1462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_toint1480 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_toint1484 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_toint1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_print1505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_intnumber1525 = new BitSet(new long[]{0x0000000000000002L});

}