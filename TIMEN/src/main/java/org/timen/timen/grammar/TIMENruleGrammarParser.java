// $ANTLR 3.4 TIMENruleGrammar.g 2013-08-25 05:03:11

    package org.timen.timen.grammar;
    import org.timen.timen.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TIMENruleGrammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "GRANULARITY", "INT", "REFERENCE", "SEPARATOR", "STRING", "WHITESPACE", "'('", "')'", "','", "'ADD'", "'ADD_WEEKDAY'", "'DATE_LAST_WEEKDAY_MONTH'", "'DATE_MONTH'", "'DATE_MONTH_DAY'", "'DATE_WEEKDAY'", "'DATE_WEEKNUM_WEEKDAY_MONTH'", "'DCTDAY'", "'DCTMONTH'", "'DCTYEAR'", "'FILL_ZEROS'", "'GET_TOD'", "'INT('", "'NEGATIVEINT('", "'PAT'", "'SUBPAT'", "'TO_DAY'", "'TO_DECADE'", "'TO_ISO'", "'TO_MONTH'", "'TO_PERIOD'", "'TO_TIME'", "'TO_YEAR'"
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

                    if ( (LA2_1==STRING||(LA2_1 >= 14 && LA2_1 <= 25)||LA2_1==28||(LA2_1 >= 30 && LA2_1 <= 36)) ) {
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
    // TIMENruleGrammar.g:19:1: rule[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= to_month[$timen,$timex_object] |e= to_day[$timen,$timex_object] |e= to_iso[$timen,$timex_object] |e= to_decade[$timen,$timex_object] |e= to_time[$timen,$timex_object] |e= add[$timen, $timex_object] |e= date_weekday[$timen, $timex_object] |e= date_month[$timen, $timex_object] |e= date_month_day[$timen, $timex_object] |e= date_weeknum_weekday_month[$timen, $timex_object] |e= date_last_weekday_month[$timen, $timex_object] |e= to_period[$timen, $timex_object] |e= get_tod[$timen, timex_object] |e= fill_zeros[$timex_object] ) ;
    public final String rule(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:19:71: ( (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= to_month[$timen,$timex_object] |e= to_day[$timen,$timex_object] |e= to_iso[$timen,$timex_object] |e= to_decade[$timen,$timex_object] |e= to_time[$timen,$timex_object] |e= add[$timen, $timex_object] |e= date_weekday[$timen, $timex_object] |e= date_month[$timen, $timex_object] |e= date_month_day[$timen, $timex_object] |e= date_weeknum_weekday_month[$timen, $timex_object] |e= date_last_weekday_month[$timen, $timex_object] |e= to_period[$timen, $timex_object] |e= get_tod[$timen, timex_object] |e= fill_zeros[$timex_object] ) )
            // TIMENruleGrammar.g:20:2: (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= to_month[$timen,$timex_object] |e= to_day[$timen,$timex_object] |e= to_iso[$timen,$timex_object] |e= to_decade[$timen,$timex_object] |e= to_time[$timen,$timex_object] |e= add[$timen, $timex_object] |e= date_weekday[$timen, $timex_object] |e= date_month[$timen, $timex_object] |e= date_month_day[$timen, $timex_object] |e= date_weeknum_weekday_month[$timen, $timex_object] |e= date_last_weekday_month[$timen, $timex_object] |e= to_period[$timen, $timex_object] |e= get_tod[$timen, timex_object] |e= fill_zeros[$timex_object] )
            {
            // TIMENruleGrammar.g:20:2: (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= to_month[$timen,$timex_object] |e= to_day[$timen,$timex_object] |e= to_iso[$timen,$timex_object] |e= to_decade[$timen,$timex_object] |e= to_time[$timen,$timex_object] |e= add[$timen, $timex_object] |e= date_weekday[$timen, $timex_object] |e= date_month[$timen, $timex_object] |e= date_month_day[$timen, $timex_object] |e= date_weeknum_weekday_month[$timen, $timex_object] |e= date_last_weekday_month[$timen, $timex_object] |e= to_period[$timen, $timex_object] |e= get_tod[$timen, timex_object] |e= fill_zeros[$timex_object] )
            int alt3=20;
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
            case 36:
                {
                alt3=6;
                }
                break;
            case 33:
                {
                alt3=7;
                }
                break;
            case 30:
                {
                alt3=8;
                }
                break;
            case 32:
                {
                alt3=9;
                }
                break;
            case 31:
                {
                alt3=10;
                }
                break;
            case 35:
                {
                alt3=11;
                }
                break;
            case 14:
            case 15:
                {
                alt3=12;
                }
                break;
            case 19:
                {
                alt3=13;
                }
                break;
            case 17:
                {
                alt3=14;
                }
                break;
            case 18:
                {
                alt3=15;
                }
                break;
            case 20:
                {
                alt3=16;
                }
                break;
            case 16:
                {
                alt3=17;
                }
                break;
            case 34:
                {
                alt3=18;
                }
                break;
            case 25:
                {
                alt3=19;
                }
                break;
            case 24:
                {
                alt3=20;
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
                    // TIMENruleGrammar.g:30:3: e= to_time[$timen,$timex_object]
                    {
                    pushFollow(FOLLOW_to_time_in_rule183);
                    e=to_time(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 12 :
                    // TIMENruleGrammar.g:31:3: e= add[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_add_in_rule192);
                    e=add(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 13 :
                    // TIMENruleGrammar.g:32:3: e= date_weekday[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_date_weekday_in_rule201);
                    e=date_weekday(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 14 :
                    // TIMENruleGrammar.g:33:3: e= date_month[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_date_month_in_rule210);
                    e=date_month(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 15 :
                    // TIMENruleGrammar.g:34:3: e= date_month_day[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_date_month_day_in_rule219);
                    e=date_month_day(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 16 :
                    // TIMENruleGrammar.g:35:3: e= date_weeknum_weekday_month[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_date_weeknum_weekday_month_in_rule228);
                    e=date_weeknum_weekday_month(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 17 :
                    // TIMENruleGrammar.g:36:3: e= date_last_weekday_month[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_date_last_weekday_month_in_rule237);
                    e=date_last_weekday_month(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 18 :
                    // TIMENruleGrammar.g:37:3: e= to_period[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_to_period_in_rule246);
                    e=to_period(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 19 :
                    // TIMENruleGrammar.g:38:3: e= get_tod[$timen, timex_object]
                    {
                    pushFollow(FOLLOW_get_tod_in_rule255);
                    e=get_tod(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 20 :
                    // TIMENruleGrammar.g:39:3: e= fill_zeros[$timex_object]
                    {
                    pushFollow(FOLLOW_fill_zeros_in_rule264);
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
    // TIMENruleGrammar.g:42:1: to_period[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : ( 'TO_PERIOD' '(' num= pat[$timex_object] ',' tunit= pat[$timex_object] ')' | 'TO_PERIOD' '(' INT ',' tunit= pat[$timex_object] ')' | 'TO_PERIOD' '(' STRING ',' tunit= pat[$timex_object] ')' );
    public final String to_period(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token INT2=null;
        Token STRING3=null;
        String num =null;

        String tunit =null;


        try {
            // TIMENruleGrammar.g:42:75: ( 'TO_PERIOD' '(' num= pat[$timex_object] ',' tunit= pat[$timex_object] ')' | 'TO_PERIOD' '(' INT ',' tunit= pat[$timex_object] ')' | 'TO_PERIOD' '(' STRING ',' tunit= pat[$timex_object] ')' )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==34) ) {
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
                    // TIMENruleGrammar.g:43:2: 'TO_PERIOD' '(' num= pat[$timex_object] ',' tunit= pat[$timex_object] ')'
                    {
                    match(input,34,FOLLOW_34_in_to_period283); 

                    match(input,11,FOLLOW_11_in_to_period285); 

                    pushFollow(FOLLOW_pat_in_to_period289);
                    num=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_to_period292); 

                    pushFollow(FOLLOW_pat_in_to_period296);
                    tunit=pat(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_to_period299); 

                    value = timen.to_period(num,tunit);

                    }
                    break;
                case 2 :
                    // TIMENruleGrammar.g:44:11: 'TO_PERIOD' '(' INT ',' tunit= pat[$timex_object] ')'
                    {
                    match(input,34,FOLLOW_34_in_to_period313); 

                    match(input,11,FOLLOW_11_in_to_period315); 

                    INT2=(Token)match(input,INT,FOLLOW_INT_in_to_period317); 

                    match(input,13,FOLLOW_13_in_to_period319); 

                    pushFollow(FOLLOW_pat_in_to_period323);
                    tunit=pat(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_to_period326); 

                    value = timen.to_period((INT2!=null?INT2.getText():null),tunit);

                    }
                    break;
                case 3 :
                    // TIMENruleGrammar.g:45:11: 'TO_PERIOD' '(' STRING ',' tunit= pat[$timex_object] ')'
                    {
                    match(input,34,FOLLOW_34_in_to_period340); 

                    match(input,11,FOLLOW_11_in_to_period342); 

                    STRING3=(Token)match(input,STRING,FOLLOW_STRING_in_to_period344); 

                    match(input,13,FOLLOW_13_in_to_period346); 

                    pushFollow(FOLLOW_pat_in_to_period350);
                    tunit=pat(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_to_period353); 

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
    // TIMENruleGrammar.g:49:1: get_tod[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'GET_TOD' '(' e= pat[$timex_object] ')' ;
    public final String get_tod(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:49:73: ( 'GET_TOD' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:50:2: 'GET_TOD' '(' e= pat[$timex_object] ')'
            {
            match(input,25,FOLLOW_25_in_get_tod378); 

            match(input,11,FOLLOW_11_in_get_tod380); 

            pushFollow(FOLLOW_pat_in_get_tod384);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_get_tod387); 

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
    // TIMENruleGrammar.g:53:1: dct_year[TIMEX_Instance timex_object] returns [String value] : 'DCTYEAR' ;
    public final String dct_year(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        try {
            // TIMENruleGrammar.g:53:61: ( 'DCTYEAR' )
            // TIMENruleGrammar.g:54:2: 'DCTYEAR'
            {
            match(input,23,FOLLOW_23_in_dct_year403); 

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
    // TIMENruleGrammar.g:56:1: dct_month[TIMEX_Instance timex_object] returns [String value] : 'DCTMONTH' ;
    public final String dct_month(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        try {
            // TIMENruleGrammar.g:56:62: ( 'DCTMONTH' )
            // TIMENruleGrammar.g:57:2: 'DCTMONTH'
            {
            match(input,22,FOLLOW_22_in_dct_month419); 

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
    // TIMENruleGrammar.g:59:1: dct_day[TIMEX_Instance timex_object] returns [String value] : 'DCTDAY' ;
    public final String dct_day(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        try {
            // TIMENruleGrammar.g:59:60: ( 'DCTDAY' )
            // TIMENruleGrammar.g:60:2: 'DCTDAY'
            {
            match(input,21,FOLLOW_21_in_dct_day435); 

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
    // TIMENruleGrammar.g:62:1: to_year[TIMEX_Instance timex_object] returns [String value] : 'TO_YEAR' '(' e= pat[$timex_object] ')' ;
    public final String to_year(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:62:60: ( 'TO_YEAR' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:63:2: 'TO_YEAR' '(' e= pat[$timex_object] ')'
            {
            match(input,36,FOLLOW_36_in_to_year451); 

            match(input,11,FOLLOW_11_in_to_year453); 

            pushFollow(FOLLOW_pat_in_to_year457);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_year460); 

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
    // TIMENruleGrammar.g:65:1: to_month[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'TO_MONTH' '(' e= pat[$timex_object] ')' ;
    public final String to_month(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:65:74: ( 'TO_MONTH' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:66:2: 'TO_MONTH' '(' e= pat[$timex_object] ')'
            {
            match(input,33,FOLLOW_33_in_to_month475); 

            match(input,11,FOLLOW_11_in_to_month477); 

            pushFollow(FOLLOW_pat_in_to_month481);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_month484); 

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
    // TIMENruleGrammar.g:68:1: to_day[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'TO_DAY' '(' e= pat[$timex_object] ')' ;
    public final String to_day(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:68:72: ( 'TO_DAY' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:69:2: 'TO_DAY' '(' e= pat[$timex_object] ')'
            {
            match(input,30,FOLLOW_30_in_to_day499); 

            match(input,11,FOLLOW_11_in_to_day501); 

            pushFollow(FOLLOW_pat_in_to_day505);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_day508); 

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
    // TIMENruleGrammar.g:71:1: to_iso[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'TO_ISO' '(' e= pat[$timex_object] ')' ;
    public final String to_iso(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:71:72: ( 'TO_ISO' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:72:2: 'TO_ISO' '(' e= pat[$timex_object] ')'
            {
            match(input,32,FOLLOW_32_in_to_iso523); 

            match(input,11,FOLLOW_11_in_to_iso525); 

            pushFollow(FOLLOW_pat_in_to_iso529);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_iso532); 

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
    // TIMENruleGrammar.g:74:1: to_decade[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'TO_DECADE' '(' e= pat[$timex_object] ')' ;
    public final String to_decade(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:74:75: ( 'TO_DECADE' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:75:2: 'TO_DECADE' '(' e= pat[$timex_object] ')'
            {
            match(input,31,FOLLOW_31_in_to_decade547); 

            match(input,11,FOLLOW_11_in_to_decade549); 

            pushFollow(FOLLOW_pat_in_to_decade553);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_decade556); 

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



    // $ANTLR start "to_time"
    // TIMENruleGrammar.g:77:1: to_time[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'TO_TIME' '(' e= pat[$timex_object] ')' ;
    public final String to_time(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:77:73: ( 'TO_TIME' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:78:2: 'TO_TIME' '(' e= pat[$timex_object] ')'
            {
            match(input,35,FOLLOW_35_in_to_time571); 

            match(input,11,FOLLOW_11_in_to_time573); 

            pushFollow(FOLLOW_pat_in_to_time577);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_time580); 

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
    // TIMENruleGrammar.g:80:1: fill_zeros[TIMEX_Instance timex_object] returns [String value] : 'FILL_ZEROS' '(' e= pat[$timex_object] ',' i= intnumber ')' ;
    public final String fill_zeros(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;

        int i =0;


        try {
            // TIMENruleGrammar.g:80:63: ( 'FILL_ZEROS' '(' e= pat[$timex_object] ',' i= intnumber ')' )
            // TIMENruleGrammar.g:81:2: 'FILL_ZEROS' '(' e= pat[$timex_object] ',' i= intnumber ')'
            {
            match(input,24,FOLLOW_24_in_fill_zeros595); 

            match(input,11,FOLLOW_11_in_fill_zeros597); 

            pushFollow(FOLLOW_pat_in_fill_zeros601);
            e=pat(timex_object);

            state._fsp--;


            match(input,13,FOLLOW_13_in_fill_zeros604); 

            pushFollow(FOLLOW_intnumber_in_fill_zeros608);
            i=intnumber();

            state._fsp--;


            match(input,12,FOLLOW_12_in_fill_zeros610); 

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
    // TIMENruleGrammar.g:83:1: add[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : ( 'ADD' '(' r= REFERENCE ',' GRANULARITY ',' i= intnumber ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= toint[$timex_object] ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= tonegativeint[$timex_object] ')' | 'ADD' '(' r= REFERENCE ',' e= subpat[$timex_object] ',' i= intsubpat[$timex_object] ')' | 'ADD_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')' );
    public final String add(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        Token GRANULARITY4=null;
        int i =0;

        String e =null;


        try {
            // TIMENruleGrammar.g:83:69: ( 'ADD' '(' r= REFERENCE ',' GRANULARITY ',' i= intnumber ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= toint[$timex_object] ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= tonegativeint[$timex_object] ')' | 'ADD' '(' r= REFERENCE ',' e= subpat[$timex_object] ',' i= intsubpat[$timex_object] ')' | 'ADD_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')' )
            int alt5=6;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==11) ) {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==REFERENCE) ) {
                        int LA5_4 = input.LA(4);

                        if ( (LA5_4==13) ) {
                            switch ( input.LA(5) ) {
                            case GRANULARITY:
                                {
                                alt5=1;
                                }
                                break;
                            case 28:
                                {
                                int LA5_7 = input.LA(6);

                                if ( (LA5_7==11) ) {
                                    int LA5_9 = input.LA(7);

                                    if ( (LA5_9==INT) ) {
                                        int LA5_10 = input.LA(8);

                                        if ( (LA5_10==12) ) {
                                            int LA5_11 = input.LA(9);

                                            if ( (LA5_11==13) ) {
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
                                                        new NoViableAltException("", 5, 12, input);

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
                                                new NoViableAltException("", 5, 10, input);

                                            throw nvae;

                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 5, 9, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 5, 7, input);

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
                                    new NoViableAltException("", 5, 5, input);

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
                alt5=6;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // TIMENruleGrammar.g:84:10: 'ADD' '(' r= REFERENCE ',' GRANULARITY ',' i= intnumber ')'
                    {
                    match(input,14,FOLLOW_14_in_add634); 

                    match(input,11,FOLLOW_11_in_add636); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add640); 

                    match(input,13,FOLLOW_13_in_add648); 

                    GRANULARITY4=(Token)match(input,GRANULARITY,FOLLOW_GRANULARITY_in_add650); 

                    match(input,13,FOLLOW_13_in_add662); 

                    pushFollow(FOLLOW_intnumber_in_add666);
                    i=intnumber();

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add668); 

                    value = timen.add((r!=null?r.getText():null),(GRANULARITY4!=null?GRANULARITY4.getText():null),i, timex_object);

                    }
                    break;
                case 2 :
                    // TIMENruleGrammar.g:85:11: 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')'
                    {
                    match(input,14,FOLLOW_14_in_add682); 

                    match(input,11,FOLLOW_11_in_add684); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add688); 

                    match(input,13,FOLLOW_13_in_add696); 

                    pushFollow(FOLLOW_pat_in_add700);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add703); 

                    pushFollow(FOLLOW_intnumber_in_add707);
                    i=intnumber();

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add709); 

                    value = timen.add((r!=null?r.getText():null),e,i, timex_object);

                    }
                    break;
                case 3 :
                    // TIMENruleGrammar.g:86:11: 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= toint[$timex_object] ')'
                    {
                    match(input,14,FOLLOW_14_in_add723); 

                    match(input,11,FOLLOW_11_in_add725); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add729); 

                    match(input,13,FOLLOW_13_in_add737); 

                    pushFollow(FOLLOW_pat_in_add741);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add744); 

                    pushFollow(FOLLOW_toint_in_add748);
                    i=toint(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add751); 

                    value = timen.add((r!=null?r.getText():null),e,i, timex_object);

                    }
                    break;
                case 4 :
                    // TIMENruleGrammar.g:87:11: 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= tonegativeint[$timex_object] ')'
                    {
                    match(input,14,FOLLOW_14_in_add765); 

                    match(input,11,FOLLOW_11_in_add767); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add771); 

                    match(input,13,FOLLOW_13_in_add779); 

                    pushFollow(FOLLOW_pat_in_add783);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add786); 

                    pushFollow(FOLLOW_tonegativeint_in_add790);
                    i=tonegativeint(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add793); 

                    value = timen.add((r!=null?r.getText():null),e,i, timex_object);

                    }
                    break;
                case 5 :
                    // TIMENruleGrammar.g:88:11: 'ADD' '(' r= REFERENCE ',' e= subpat[$timex_object] ',' i= intsubpat[$timex_object] ')'
                    {
                    match(input,14,FOLLOW_14_in_add807); 

                    match(input,11,FOLLOW_11_in_add809); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add813); 

                    match(input,13,FOLLOW_13_in_add821); 

                    pushFollow(FOLLOW_subpat_in_add825);
                    e=subpat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add828); 

                    pushFollow(FOLLOW_intsubpat_in_add832);
                    i=intsubpat(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add835); 

                    value = timen.add((r!=null?r.getText():null),e,i, timex_object);

                    }
                    break;
                case 6 :
                    // TIMENruleGrammar.g:89:11: 'ADD_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')'
                    {
                    match(input,15,FOLLOW_15_in_add849); 

                    match(input,11,FOLLOW_11_in_add851); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add855); 

                    match(input,13,FOLLOW_13_in_add863); 

                    pushFollow(FOLLOW_pat_in_add867);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add870); 

                    pushFollow(FOLLOW_intnumber_in_add874);
                    i=intnumber();

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add876); 

                    value = timen.add_weekday((r!=null?r.getText():null),e,i, timex_object);

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
    // TIMENruleGrammar.g:95:1: date_weekday[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'DATE_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ')' ;
    public final String date_weekday(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        String e =null;


        try {
            // TIMENruleGrammar.g:95:78: ( 'DATE_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:96:10: 'DATE_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ')'
            {
            match(input,19,FOLLOW_19_in_date_weekday911); 

            match(input,11,FOLLOW_11_in_date_weekday913); 

            r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_date_weekday917); 

            match(input,13,FOLLOW_13_in_date_weekday925); 

            pushFollow(FOLLOW_pat_in_date_weekday929);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_date_weekday932); 

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
    // TIMENruleGrammar.g:99:1: date_month[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'DATE_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ')' ;
    public final String date_month(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        String e =null;


        try {
            // TIMENruleGrammar.g:99:76: ( 'DATE_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:100:10: 'DATE_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ')'
            {
            match(input,17,FOLLOW_17_in_date_month956); 

            match(input,11,FOLLOW_11_in_date_month958); 

            r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_date_month962); 

            match(input,13,FOLLOW_13_in_date_month970); 

            pushFollow(FOLLOW_pat_in_date_month974);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_date_month977); 

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
    // TIMENruleGrammar.g:102:1: date_month_day[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'DATE_MONTH_DAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ')' ;
    public final String date_month_day(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        String e =null;

        String d =null;


        try {
            // TIMENruleGrammar.g:102:80: ( 'DATE_MONTH_DAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:103:10: 'DATE_MONTH_DAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ')'
            {
            match(input,18,FOLLOW_18_in_date_month_day1000); 

            match(input,11,FOLLOW_11_in_date_month_day1002); 

            r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_date_month_day1006); 

            match(input,13,FOLLOW_13_in_date_month_day1014); 

            pushFollow(FOLLOW_pat_in_date_month_day1018);
            e=pat(timex_object);

            state._fsp--;


            match(input,13,FOLLOW_13_in_date_month_day1021); 

            pushFollow(FOLLOW_pat_in_date_month_day1025);
            d=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_date_month_day1028); 

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
    // TIMENruleGrammar.g:105:1: date_weeknum_weekday_month[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'DATE_WEEKNUM_WEEKDAY_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ',' f= pat[$timex_object] ')' ;
    public final String date_weeknum_weekday_month(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        String e =null;

        String d =null;

        String f =null;


        try {
            // TIMENruleGrammar.g:105:92: ( 'DATE_WEEKNUM_WEEKDAY_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ',' f= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:106:10: 'DATE_WEEKNUM_WEEKDAY_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ',' f= pat[$timex_object] ')'
            {
            match(input,20,FOLLOW_20_in_date_weeknum_weekday_month1051); 

            match(input,11,FOLLOW_11_in_date_weeknum_weekday_month1053); 

            r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_date_weeknum_weekday_month1057); 

            match(input,13,FOLLOW_13_in_date_weeknum_weekday_month1065); 

            pushFollow(FOLLOW_pat_in_date_weeknum_weekday_month1069);
            e=pat(timex_object);

            state._fsp--;


            match(input,13,FOLLOW_13_in_date_weeknum_weekday_month1072); 

            pushFollow(FOLLOW_pat_in_date_weeknum_weekday_month1076);
            d=pat(timex_object);

            state._fsp--;


            match(input,13,FOLLOW_13_in_date_weeknum_weekday_month1079); 

            pushFollow(FOLLOW_pat_in_date_weeknum_weekday_month1083);
            f=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_date_weeknum_weekday_month1086); 

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
    // TIMENruleGrammar.g:108:1: date_last_weekday_month[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'DATE_LAST_WEEKDAY_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ')' ;
    public final String date_last_weekday_month(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        String e =null;

        String d =null;


        try {
            // TIMENruleGrammar.g:108:89: ( 'DATE_LAST_WEEKDAY_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:109:10: 'DATE_LAST_WEEKDAY_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ')'
            {
            match(input,16,FOLLOW_16_in_date_last_weekday_month1109); 

            match(input,11,FOLLOW_11_in_date_last_weekday_month1111); 

            r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_date_last_weekday_month1115); 

            match(input,13,FOLLOW_13_in_date_last_weekday_month1123); 

            pushFollow(FOLLOW_pat_in_date_last_weekday_month1127);
            e=pat(timex_object);

            state._fsp--;


            match(input,13,FOLLOW_13_in_date_last_weekday_month1130); 

            pushFollow(FOLLOW_pat_in_date_last_weekday_month1134);
            d=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_date_last_weekday_month1138); 

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
    // TIMENruleGrammar.g:112:1: pat[TIMEX_Instance timex_object] returns [String value] : 'PAT' '(' e= intnumber ')' ;
    public final String pat(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        int e =0;


        try {
            // TIMENruleGrammar.g:112:56: ( 'PAT' '(' e= intnumber ')' )
            // TIMENruleGrammar.g:113:2: 'PAT' '(' e= intnumber ')'
            {
            match(input,28,FOLLOW_28_in_pat1154); 

            match(input,11,FOLLOW_11_in_pat1156); 

            pushFollow(FOLLOW_intnumber_in_pat1160);
            e=intnumber();

            state._fsp--;


            match(input,12,FOLLOW_12_in_pat1162); 

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
    // TIMENruleGrammar.g:115:1: subpat[TIMEX_Instance timex_object] returns [String value] : 'SUBPAT' '(' e= intnumber ',' d= STRING ',' c= intnumber ')' ;
    public final String subpat(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token d=null;
        int e =0;

        int c =0;


        try {
            // TIMENruleGrammar.g:115:59: ( 'SUBPAT' '(' e= intnumber ',' d= STRING ',' c= intnumber ')' )
            // TIMENruleGrammar.g:116:2: 'SUBPAT' '(' e= intnumber ',' d= STRING ',' c= intnumber ')'
            {
            match(input,29,FOLLOW_29_in_subpat1177); 

            match(input,11,FOLLOW_11_in_subpat1179); 

            pushFollow(FOLLOW_intnumber_in_subpat1183);
            e=intnumber();

            state._fsp--;


            match(input,13,FOLLOW_13_in_subpat1185); 

            d=(Token)match(input,STRING,FOLLOW_STRING_in_subpat1189); 

            match(input,13,FOLLOW_13_in_subpat1191); 

            pushFollow(FOLLOW_intnumber_in_subpat1195);
            c=intnumber();

            state._fsp--;


            match(input,12,FOLLOW_12_in_subpat1197); 

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
    // TIMENruleGrammar.g:118:1: intsubpat[TIMEX_Instance timex_object] returns [int value] : 'SUBPAT' '(' e= intnumber ',' d= STRING ',' c= intnumber ')' ;
    public final int intsubpat(TIMEX_Instance timex_object) throws RecognitionException {
        int value = 0;


        Token d=null;
        int e =0;

        int c =0;


        try {
            // TIMENruleGrammar.g:118:59: ( 'SUBPAT' '(' e= intnumber ',' d= STRING ',' c= intnumber ')' )
            // TIMENruleGrammar.g:119:2: 'SUBPAT' '(' e= intnumber ',' d= STRING ',' c= intnumber ')'
            {
            match(input,29,FOLLOW_29_in_intsubpat1212); 

            match(input,11,FOLLOW_11_in_intsubpat1214); 

            pushFollow(FOLLOW_intnumber_in_intsubpat1218);
            e=intnumber();

            state._fsp--;


            match(input,13,FOLLOW_13_in_intsubpat1220); 

            d=(Token)match(input,STRING,FOLLOW_STRING_in_intsubpat1224); 

            match(input,13,FOLLOW_13_in_intsubpat1226); 

            pushFollow(FOLLOW_intnumber_in_intsubpat1230);
            c=intnumber();

            state._fsp--;


            match(input,12,FOLLOW_12_in_intsubpat1232); 

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
    // TIMENruleGrammar.g:122:1: tonegativeint[TIMEX_Instance timex_object] returns [int value] : 'NEGATIVEINT(' e= pat[$timex_object] ')' ;
    public final int tonegativeint(TIMEX_Instance timex_object) throws RecognitionException {
        int value = 0;


        String e =null;


        try {
            // TIMENruleGrammar.g:122:63: ( 'NEGATIVEINT(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:123:5: 'NEGATIVEINT(' e= pat[$timex_object] ')'
            {
            match(input,27,FOLLOW_27_in_tonegativeint1251); 

            pushFollow(FOLLOW_pat_in_tonegativeint1255);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_tonegativeint1258); 

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
    // TIMENruleGrammar.g:125:1: toint[TIMEX_Instance timex_object] returns [int value] : 'INT(' e= pat[$timex_object] ')' ;
    public final int toint(TIMEX_Instance timex_object) throws RecognitionException {
        int value = 0;


        String e =null;


        try {
            // TIMENruleGrammar.g:125:55: ( 'INT(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:126:5: 'INT(' e= pat[$timex_object] ')'
            {
            match(input,26,FOLLOW_26_in_toint1276); 

            pushFollow(FOLLOW_pat_in_toint1280);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_toint1283); 

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
    // TIMENruleGrammar.g:129:1: print returns [String value] : STRING ;
    public final String print() throws RecognitionException {
        String value = null;


        Token STRING5=null;

        try {
            // TIMENruleGrammar.g:129:29: ( STRING )
            // TIMENruleGrammar.g:130:5: STRING
            {
            STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_print1301); 

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
    // TIMENruleGrammar.g:133:1: intnumber returns [int value] : INT ;
    public final int intnumber() throws RecognitionException {
        int value = 0;


        Token INT6=null;

        try {
            // TIMENruleGrammar.g:133:30: ( INT )
            // TIMENruleGrammar.g:134:2: INT
            {
            INT6=(Token)match(input,INT,FOLLOW_INT_in_intnumber1321); 

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
    public static final BitSet FOLLOW_SEPARATOR_in_rules65 = new BitSet(new long[]{0x0000001FD3FFC200L});
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
    public static final BitSet FOLLOW_to_time_in_rule183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_add_in_rule192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_weekday_in_rule201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_month_in_rule210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_month_day_in_rule219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_weeknum_weekday_month_in_rule228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_last_weekday_month_in_rule237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_period_in_rule246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_get_tod_in_rule255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fill_zeros_in_rule264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_to_period283 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_period285 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_period289 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_to_period292 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_period296 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_period299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_to_period313 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_period315 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_to_period317 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_to_period319 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_period323 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_period326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_to_period340 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_period342 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_to_period344 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_to_period346 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_period350 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_period353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_get_tod378 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_get_tod380 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_get_tod384 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_get_tod387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_dct_year403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_dct_month419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_dct_day435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_to_year451 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_year453 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_year457 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_year460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_to_month475 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_month477 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_month481 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_month484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_to_day499 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_day501 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_day505 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_day508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_to_iso523 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_iso525 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_iso529 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_iso532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_to_decade547 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_decade549 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_decade553 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_decade556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_to_time571 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_time573 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_to_time577 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_time580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_fill_zeros595 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_fill_zeros597 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_fill_zeros601 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_fill_zeros604 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_fill_zeros608 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_fill_zeros610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add634 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add636 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add640 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add648 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_GRANULARITY_in_add650 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add662 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_add666 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add682 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add684 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add688 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add696 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_add700 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add703 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_add707 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add723 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add725 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add729 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add737 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_add741 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add744 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_toint_in_add748 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add765 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add767 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add771 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add779 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_add783 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add786 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_tonegativeint_in_add790 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add807 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add809 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add813 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add821 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_subpat_in_add825 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add828 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_intsubpat_in_add832 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_add849 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add851 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add855 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add863 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_add867 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add870 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_add874 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_date_weekday911 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_date_weekday913 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_date_weekday917 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_weekday925 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_date_weekday929 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_date_weekday932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_date_month956 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_date_month958 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_date_month962 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_month970 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_date_month974 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_date_month977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_date_month_day1000 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_date_month_day1002 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_date_month_day1006 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_month_day1014 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_date_month_day1018 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_month_day1021 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_date_month_day1025 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_date_month_day1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_date_weeknum_weekday_month1051 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_date_weeknum_weekday_month1053 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_date_weeknum_weekday_month1057 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_weeknum_weekday_month1065 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_date_weeknum_weekday_month1069 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_weeknum_weekday_month1072 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_date_weeknum_weekday_month1076 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_weeknum_weekday_month1079 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_date_weeknum_weekday_month1083 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_date_weeknum_weekday_month1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_date_last_weekday_month1109 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_date_last_weekday_month1111 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_date_last_weekday_month1115 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_last_weekday_month1123 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_date_last_weekday_month1127 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_last_weekday_month1130 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_date_last_weekday_month1134 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_date_last_weekday_month1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_pat1154 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_pat1156 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_pat1160 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_pat1162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_subpat1177 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_subpat1179 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_subpat1183 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_subpat1185 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_subpat1189 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_subpat1191 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_subpat1195 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_subpat1197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_intsubpat1212 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_intsubpat1214 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_intsubpat1218 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_intsubpat1220 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_intsubpat1224 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_intsubpat1226 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_intsubpat1230 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_intsubpat1232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_tonegativeint1251 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_tonegativeint1255 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_tonegativeint1258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_toint1276 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_pat_in_toint1280 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_toint1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_print1301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_intnumber1321 = new BitSet(new long[]{0x0000000000000002L});

}