// $ANTLR 3.4 TIMENruleGrammar.g 2012-03-09 16:33:47

    package org.timen.grammar;
    import org.timen.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TIMENruleGrammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "GRANULARITY", "INT", "REFERENCE", "SEPARATOR", "STRING", "WHITESPACE", "'('", "')'", "','", "'ADD'", "'ADD_WEEKDAY'", "'DATE_MONTH'", "'DATE_MONTH_DAY'", "'DATE_WEEKDAY'", "'DCTDAY'", "'DCTMONTH'", "'DCTYEAR'", "'FILL_ZEROS'", "'GET_TOD'", "'INT('", "'NEGATIVEINT('", "'PAT'", "'TO_DAY'", "'TO_ISO'", "'TO_MONTH'", "'TO_PERIOD'", "'TO_TIME'", "'TO_YEAR'"
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

                    if ( (LA2_1==STRING||(LA2_1 >= 14 && LA2_1 <= 23)||(LA2_1 >= 26 && LA2_1 <= 32)) ) {
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
    // TIMENruleGrammar.g:19:1: rule[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= to_month[$timen,$timex_object] |e= to_day[$timen,$timex_object] |e= to_iso[$timen,$timex_object] |e= to_time[$timen,$timex_object] |e= add[$timen, $timex_object] |e= date_weekday[$timen, $timex_object] |e= date_month[$timen, $timex_object] |e= date_month_day[$timen, $timex_object] |e= to_period[$timen, $timex_object] |e= get_tod[$timen, timex_object] |e= fill_zeros[$timex_object] ) ;
    public final String rule(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:19:71: ( (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= to_month[$timen,$timex_object] |e= to_day[$timen,$timex_object] |e= to_iso[$timen,$timex_object] |e= to_time[$timen,$timex_object] |e= add[$timen, $timex_object] |e= date_weekday[$timen, $timex_object] |e= date_month[$timen, $timex_object] |e= date_month_day[$timen, $timex_object] |e= to_period[$timen, $timex_object] |e= get_tod[$timen, timex_object] |e= fill_zeros[$timex_object] ) )
            // TIMENruleGrammar.g:20:2: (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= to_month[$timen,$timex_object] |e= to_day[$timen,$timex_object] |e= to_iso[$timen,$timex_object] |e= to_time[$timen,$timex_object] |e= add[$timen, $timex_object] |e= date_weekday[$timen, $timex_object] |e= date_month[$timen, $timex_object] |e= date_month_day[$timen, $timex_object] |e= to_period[$timen, $timex_object] |e= get_tod[$timen, timex_object] |e= fill_zeros[$timex_object] )
            {
            // TIMENruleGrammar.g:20:2: (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= to_month[$timen,$timex_object] |e= to_day[$timen,$timex_object] |e= to_iso[$timen,$timex_object] |e= to_time[$timen,$timex_object] |e= add[$timen, $timex_object] |e= date_weekday[$timen, $timex_object] |e= date_month[$timen, $timex_object] |e= date_month_day[$timen, $timex_object] |e= to_period[$timen, $timex_object] |e= get_tod[$timen, timex_object] |e= fill_zeros[$timex_object] )
            int alt3=17;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt3=1;
                }
                break;
            case 26:
                {
                alt3=2;
                }
                break;
            case 21:
                {
                alt3=3;
                }
                break;
            case 20:
                {
                alt3=4;
                }
                break;
            case 19:
                {
                alt3=5;
                }
                break;
            case 32:
                {
                alt3=6;
                }
                break;
            case 29:
                {
                alt3=7;
                }
                break;
            case 27:
                {
                alt3=8;
                }
                break;
            case 28:
                {
                alt3=9;
                }
                break;
            case 31:
                {
                alt3=10;
                }
                break;
            case 14:
            case 15:
                {
                alt3=11;
                }
                break;
            case 18:
                {
                alt3=12;
                }
                break;
            case 16:
                {
                alt3=13;
                }
                break;
            case 17:
                {
                alt3=14;
                }
                break;
            case 30:
                {
                alt3=15;
                }
                break;
            case 23:
                {
                alt3=16;
                }
                break;
            case 22:
                {
                alt3=17;
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
                    // TIMENruleGrammar.g:29:3: e= to_time[$timen,$timex_object]
                    {
                    pushFollow(FOLLOW_to_time_in_rule174);
                    e=to_time(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 11 :
                    // TIMENruleGrammar.g:30:3: e= add[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_add_in_rule183);
                    e=add(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 12 :
                    // TIMENruleGrammar.g:31:3: e= date_weekday[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_date_weekday_in_rule192);
                    e=date_weekday(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 13 :
                    // TIMENruleGrammar.g:32:3: e= date_month[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_date_month_in_rule201);
                    e=date_month(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 14 :
                    // TIMENruleGrammar.g:33:3: e= date_month_day[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_date_month_day_in_rule210);
                    e=date_month_day(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 15 :
                    // TIMENruleGrammar.g:34:3: e= to_period[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_to_period_in_rule219);
                    e=to_period(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 16 :
                    // TIMENruleGrammar.g:35:3: e= get_tod[$timen, timex_object]
                    {
                    pushFollow(FOLLOW_get_tod_in_rule228);
                    e=get_tod(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 17 :
                    // TIMENruleGrammar.g:36:3: e= fill_zeros[$timex_object]
                    {
                    pushFollow(FOLLOW_fill_zeros_in_rule237);
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
    // TIMENruleGrammar.g:39:1: to_period[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : ( 'TO_PERIOD' '(' num= pat[$timex_object] ',' tunit= pat[$timex_object] ')' | 'TO_PERIOD' '(' INT ',' tunit= pat[$timex_object] ')' | 'TO_PERIOD' '(' STRING ',' tunit= pat[$timex_object] ')' );
    public final String to_period(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token INT2=null;
        Token STRING3=null;
        String num =null;

        String tunit =null;


        try {
            // TIMENruleGrammar.g:39:75: ( 'TO_PERIOD' '(' num= pat[$timex_object] ',' tunit= pat[$timex_object] ')' | 'TO_PERIOD' '(' INT ',' tunit= pat[$timex_object] ')' | 'TO_PERIOD' '(' STRING ',' tunit= pat[$timex_object] ')' )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==30) ) {
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
                    case 26:
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
                    // TIMENruleGrammar.g:40:2: 'TO_PERIOD' '(' num= pat[$timex_object] ',' tunit= pat[$timex_object] ')'
                    {
                    match(input,30,FOLLOW_30_in_to_period256); 

                    match(input,11,FOLLOW_11_in_to_period258); 

                    pushFollow(FOLLOW_pat_in_to_period262);
                    num=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_to_period265); 

                    pushFollow(FOLLOW_pat_in_to_period269);
                    tunit=pat(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_to_period272); 

                    value = timen.to_period(num,tunit);

                    }
                    break;
                case 2 :
                    // TIMENruleGrammar.g:41:11: 'TO_PERIOD' '(' INT ',' tunit= pat[$timex_object] ')'
                    {
                    match(input,30,FOLLOW_30_in_to_period286); 

                    match(input,11,FOLLOW_11_in_to_period288); 

                    INT2=(Token)match(input,INT,FOLLOW_INT_in_to_period290); 

                    match(input,13,FOLLOW_13_in_to_period292); 

                    pushFollow(FOLLOW_pat_in_to_period296);
                    tunit=pat(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_to_period299); 

                    value = timen.to_period((INT2!=null?INT2.getText():null),tunit);

                    }
                    break;
                case 3 :
                    // TIMENruleGrammar.g:42:11: 'TO_PERIOD' '(' STRING ',' tunit= pat[$timex_object] ')'
                    {
                    match(input,30,FOLLOW_30_in_to_period313); 

                    match(input,11,FOLLOW_11_in_to_period315); 

                    STRING3=(Token)match(input,STRING,FOLLOW_STRING_in_to_period317); 

                    match(input,13,FOLLOW_13_in_to_period319); 

                    pushFollow(FOLLOW_pat_in_to_period323);
                    tunit=pat(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_to_period326); 

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
    // TIMENruleGrammar.g:46:1: get_tod[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'GET_TOD' '(' e= pat[$timex_object] ')' ;
    public final String get_tod(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:46:73: ( 'GET_TOD' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:47:2: 'GET_TOD' '(' e= pat[$timex_object] ')'
            {
            match(input,23,FOLLOW_23_in_get_tod351); 

            match(input,11,FOLLOW_11_in_get_tod353); 

            pushFollow(FOLLOW_pat_in_get_tod357);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_get_tod360); 

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
    // TIMENruleGrammar.g:50:1: dct_year[TIMEX_Instance timex_object] returns [String value] : 'DCTYEAR' ;
    public final String dct_year(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        try {
            // TIMENruleGrammar.g:50:61: ( 'DCTYEAR' )
            // TIMENruleGrammar.g:51:2: 'DCTYEAR'
            {
            match(input,21,FOLLOW_21_in_dct_year376); 

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
    // TIMENruleGrammar.g:53:1: dct_month[TIMEX_Instance timex_object] returns [String value] : 'DCTMONTH' ;
    public final String dct_month(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        try {
            // TIMENruleGrammar.g:53:62: ( 'DCTMONTH' )
            // TIMENruleGrammar.g:54:2: 'DCTMONTH'
            {
            match(input,20,FOLLOW_20_in_dct_month392); 

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
    // TIMENruleGrammar.g:56:1: dct_day[TIMEX_Instance timex_object] returns [String value] : 'DCTDAY' ;
    public final String dct_day(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        try {
            // TIMENruleGrammar.g:56:60: ( 'DCTDAY' )
            // TIMENruleGrammar.g:57:2: 'DCTDAY'
            {
            match(input,19,FOLLOW_19_in_dct_day408); 

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
    // TIMENruleGrammar.g:59:1: to_year[TIMEX_Instance timex_object] returns [String value] : 'TO_YEAR' '(' e= pat[$timex_object] ')' ;
    public final String to_year(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:59:60: ( 'TO_YEAR' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:60:2: 'TO_YEAR' '(' e= pat[$timex_object] ')'
            {
            match(input,32,FOLLOW_32_in_to_year424); 

            match(input,11,FOLLOW_11_in_to_year426); 

            pushFollow(FOLLOW_pat_in_to_year430);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_year433); 

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
    // TIMENruleGrammar.g:62:1: to_month[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'TO_MONTH' '(' e= pat[$timex_object] ')' ;
    public final String to_month(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:62:74: ( 'TO_MONTH' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:63:2: 'TO_MONTH' '(' e= pat[$timex_object] ')'
            {
            match(input,29,FOLLOW_29_in_to_month448); 

            match(input,11,FOLLOW_11_in_to_month450); 

            pushFollow(FOLLOW_pat_in_to_month454);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_month457); 

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
    // TIMENruleGrammar.g:65:1: to_day[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'TO_DAY' '(' e= pat[$timex_object] ')' ;
    public final String to_day(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:65:72: ( 'TO_DAY' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:66:2: 'TO_DAY' '(' e= pat[$timex_object] ')'
            {
            match(input,27,FOLLOW_27_in_to_day472); 

            match(input,11,FOLLOW_11_in_to_day474); 

            pushFollow(FOLLOW_pat_in_to_day478);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_day481); 

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
    // TIMENruleGrammar.g:68:1: to_iso[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'TO_ISO' '(' e= pat[$timex_object] ')' ;
    public final String to_iso(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:68:72: ( 'TO_ISO' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:69:2: 'TO_ISO' '(' e= pat[$timex_object] ')'
            {
            match(input,28,FOLLOW_28_in_to_iso496); 

            match(input,11,FOLLOW_11_in_to_iso498); 

            pushFollow(FOLLOW_pat_in_to_iso502);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_iso505); 

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



    // $ANTLR start "to_time"
    // TIMENruleGrammar.g:71:1: to_time[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'TO_TIME' '(' e= pat[$timex_object] ')' ;
    public final String to_time(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:71:73: ( 'TO_TIME' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:72:2: 'TO_TIME' '(' e= pat[$timex_object] ')'
            {
            match(input,31,FOLLOW_31_in_to_time520); 

            match(input,11,FOLLOW_11_in_to_time522); 

            pushFollow(FOLLOW_pat_in_to_time526);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_time529); 

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
    // TIMENruleGrammar.g:74:1: fill_zeros[TIMEX_Instance timex_object] returns [String value] : 'FILL_ZEROS' '(' e= pat[$timex_object] ',' i= intnumber ')' ;
    public final String fill_zeros(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;

        int i =0;


        try {
            // TIMENruleGrammar.g:74:63: ( 'FILL_ZEROS' '(' e= pat[$timex_object] ',' i= intnumber ')' )
            // TIMENruleGrammar.g:75:2: 'FILL_ZEROS' '(' e= pat[$timex_object] ',' i= intnumber ')'
            {
            match(input,22,FOLLOW_22_in_fill_zeros544); 

            match(input,11,FOLLOW_11_in_fill_zeros546); 

            pushFollow(FOLLOW_pat_in_fill_zeros550);
            e=pat(timex_object);

            state._fsp--;


            match(input,13,FOLLOW_13_in_fill_zeros553); 

            pushFollow(FOLLOW_intnumber_in_fill_zeros557);
            i=intnumber();

            state._fsp--;


            match(input,12,FOLLOW_12_in_fill_zeros559); 

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
    // TIMENruleGrammar.g:77:1: add[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : ( 'ADD' '(' r= REFERENCE ',' GRANULARITY ',' i= intnumber ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= toint[$timex_object] ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= tonegativeint[$timex_object] ')' | 'ADD_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')' );
    public final String add(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        Token GRANULARITY4=null;
        int i =0;

        String e =null;


        try {
            // TIMENruleGrammar.g:77:69: ( 'ADD' '(' r= REFERENCE ',' GRANULARITY ',' i= intnumber ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= toint[$timex_object] ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= tonegativeint[$timex_object] ')' | 'ADD_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')' )
            int alt5=5;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==11) ) {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==REFERENCE) ) {
                        int LA5_4 = input.LA(4);

                        if ( (LA5_4==13) ) {
                            int LA5_5 = input.LA(5);

                            if ( (LA5_5==GRANULARITY) ) {
                                alt5=1;
                            }
                            else if ( (LA5_5==26) ) {
                                int LA5_7 = input.LA(6);

                                if ( (LA5_7==11) ) {
                                    int LA5_8 = input.LA(7);

                                    if ( (LA5_8==INT) ) {
                                        int LA5_9 = input.LA(8);

                                        if ( (LA5_9==12) ) {
                                            int LA5_10 = input.LA(9);

                                            if ( (LA5_10==13) ) {
                                                switch ( input.LA(10) ) {
                                                case INT:
                                                    {
                                                    alt5=2;
                                                    }
                                                    break;
                                                case 24:
                                                    {
                                                    alt5=3;
                                                    }
                                                    break;
                                                case 25:
                                                    {
                                                    alt5=4;
                                                    }
                                                    break;
                                                default:
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
                                            new NoViableAltException("", 5, 8, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 5, 7, input);

                                    throw nvae;

                                }
                            }
                            else {
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
                alt5=5;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // TIMENruleGrammar.g:78:10: 'ADD' '(' r= REFERENCE ',' GRANULARITY ',' i= intnumber ')'
                    {
                    match(input,14,FOLLOW_14_in_add583); 

                    match(input,11,FOLLOW_11_in_add585); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add589); 

                    match(input,13,FOLLOW_13_in_add597); 

                    GRANULARITY4=(Token)match(input,GRANULARITY,FOLLOW_GRANULARITY_in_add599); 

                    match(input,13,FOLLOW_13_in_add611); 

                    pushFollow(FOLLOW_intnumber_in_add615);
                    i=intnumber();

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add617); 

                    value = timen.add((r!=null?r.getText():null),(GRANULARITY4!=null?GRANULARITY4.getText():null),i, timex_object);

                    }
                    break;
                case 2 :
                    // TIMENruleGrammar.g:79:11: 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')'
                    {
                    match(input,14,FOLLOW_14_in_add631); 

                    match(input,11,FOLLOW_11_in_add633); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add637); 

                    match(input,13,FOLLOW_13_in_add645); 

                    pushFollow(FOLLOW_pat_in_add649);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add652); 

                    pushFollow(FOLLOW_intnumber_in_add656);
                    i=intnumber();

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add658); 

                    value = timen.add((r!=null?r.getText():null),e,i, timex_object);

                    }
                    break;
                case 3 :
                    // TIMENruleGrammar.g:80:11: 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= toint[$timex_object] ')'
                    {
                    match(input,14,FOLLOW_14_in_add672); 

                    match(input,11,FOLLOW_11_in_add674); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add678); 

                    match(input,13,FOLLOW_13_in_add686); 

                    pushFollow(FOLLOW_pat_in_add690);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add693); 

                    pushFollow(FOLLOW_toint_in_add697);
                    i=toint(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add700); 

                    value = timen.add((r!=null?r.getText():null),e,i, timex_object);

                    }
                    break;
                case 4 :
                    // TIMENruleGrammar.g:81:11: 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= tonegativeint[$timex_object] ')'
                    {
                    match(input,14,FOLLOW_14_in_add714); 

                    match(input,11,FOLLOW_11_in_add716); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add720); 

                    match(input,13,FOLLOW_13_in_add728); 

                    pushFollow(FOLLOW_pat_in_add732);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add735); 

                    pushFollow(FOLLOW_tonegativeint_in_add739);
                    i=tonegativeint(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add742); 

                    value = timen.add((r!=null?r.getText():null),e,i, timex_object);

                    }
                    break;
                case 5 :
                    // TIMENruleGrammar.g:82:11: 'ADD_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')'
                    {
                    match(input,15,FOLLOW_15_in_add756); 

                    match(input,11,FOLLOW_11_in_add758); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add762); 

                    match(input,13,FOLLOW_13_in_add770); 

                    pushFollow(FOLLOW_pat_in_add774);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add777); 

                    pushFollow(FOLLOW_intnumber_in_add781);
                    i=intnumber();

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add783); 

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
    // TIMENruleGrammar.g:88:1: date_weekday[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'DATE_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ')' ;
    public final String date_weekday(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        String e =null;


        try {
            // TIMENruleGrammar.g:88:78: ( 'DATE_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:89:10: 'DATE_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ')'
            {
            match(input,18,FOLLOW_18_in_date_weekday818); 

            match(input,11,FOLLOW_11_in_date_weekday820); 

            r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_date_weekday824); 

            match(input,13,FOLLOW_13_in_date_weekday832); 

            pushFollow(FOLLOW_pat_in_date_weekday836);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_date_weekday839); 

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
    // TIMENruleGrammar.g:92:1: date_month[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'DATE_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ')' ;
    public final String date_month(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        String e =null;


        try {
            // TIMENruleGrammar.g:92:76: ( 'DATE_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:93:10: 'DATE_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ')'
            {
            match(input,16,FOLLOW_16_in_date_month863); 

            match(input,11,FOLLOW_11_in_date_month865); 

            r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_date_month869); 

            match(input,13,FOLLOW_13_in_date_month877); 

            pushFollow(FOLLOW_pat_in_date_month881);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_date_month884); 

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
    // TIMENruleGrammar.g:95:1: date_month_day[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'DATE_MONTH_DAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ')' ;
    public final String date_month_day(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        String e =null;

        String d =null;


        try {
            // TIMENruleGrammar.g:95:80: ( 'DATE_MONTH_DAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:96:10: 'DATE_MONTH_DAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ')'
            {
            match(input,17,FOLLOW_17_in_date_month_day907); 

            match(input,11,FOLLOW_11_in_date_month_day909); 

            r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_date_month_day913); 

            match(input,13,FOLLOW_13_in_date_month_day921); 

            pushFollow(FOLLOW_pat_in_date_month_day925);
            e=pat(timex_object);

            state._fsp--;


            match(input,13,FOLLOW_13_in_date_month_day928); 

            pushFollow(FOLLOW_pat_in_date_month_day932);
            d=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_date_month_day935); 

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



    // $ANTLR start "pat"
    // TIMENruleGrammar.g:99:1: pat[TIMEX_Instance timex_object] returns [String value] : 'PAT' '(' e= intnumber ')' ;
    public final String pat(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        int e =0;


        try {
            // TIMENruleGrammar.g:99:56: ( 'PAT' '(' e= intnumber ')' )
            // TIMENruleGrammar.g:100:2: 'PAT' '(' e= intnumber ')'
            {
            match(input,26,FOLLOW_26_in_pat951); 

            match(input,11,FOLLOW_11_in_pat953); 

            pushFollow(FOLLOW_intnumber_in_pat957);
            e=intnumber();

            state._fsp--;


            match(input,12,FOLLOW_12_in_pat959); 

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



    // $ANTLR start "tonegativeint"
    // TIMENruleGrammar.g:102:1: tonegativeint[TIMEX_Instance timex_object] returns [int value] : 'NEGATIVEINT(' e= pat[$timex_object] ')' ;
    public final int tonegativeint(TIMEX_Instance timex_object) throws RecognitionException {
        int value = 0;


        String e =null;


        try {
            // TIMENruleGrammar.g:102:63: ( 'NEGATIVEINT(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:103:5: 'NEGATIVEINT(' e= pat[$timex_object] ')'
            {
            match(input,25,FOLLOW_25_in_tonegativeint977); 

            pushFollow(FOLLOW_pat_in_tonegativeint981);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_tonegativeint984); 

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
    // TIMENruleGrammar.g:105:1: toint[TIMEX_Instance timex_object] returns [int value] : 'INT(' e= pat[$timex_object] ')' ;
    public final int toint(TIMEX_Instance timex_object) throws RecognitionException {
        int value = 0;


        String e =null;


        try {
            // TIMENruleGrammar.g:105:55: ( 'INT(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:106:5: 'INT(' e= pat[$timex_object] ')'
            {
            match(input,24,FOLLOW_24_in_toint1002); 

            pushFollow(FOLLOW_pat_in_toint1006);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_toint1009); 

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
    // TIMENruleGrammar.g:109:1: print returns [String value] : STRING ;
    public final String print() throws RecognitionException {
        String value = null;


        Token STRING5=null;

        try {
            // TIMENruleGrammar.g:109:29: ( STRING )
            // TIMENruleGrammar.g:110:5: STRING
            {
            STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_print1027); 

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
    // TIMENruleGrammar.g:113:1: intnumber returns [int value] : INT ;
    public final int intnumber() throws RecognitionException {
        int value = 0;


        Token INT6=null;

        try {
            // TIMENruleGrammar.g:113:30: ( INT )
            // TIMENruleGrammar.g:114:2: INT
            {
            INT6=(Token)match(input,INT,FOLLOW_INT_in_intnumber1047); 

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
    public static final BitSet FOLLOW_SEPARATOR_in_rules65 = new BitSet(new long[]{0x00000001FCFFC200L});
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
    public static final BitSet FOLLOW_to_time_in_rule174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_add_in_rule183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_weekday_in_rule192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_month_in_rule201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_month_day_in_rule210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_period_in_rule219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_get_tod_in_rule228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fill_zeros_in_rule237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_to_period256 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_period258 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_to_period262 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_to_period265 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_to_period269 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_period272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_to_period286 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_period288 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_to_period290 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_to_period292 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_to_period296 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_period299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_to_period313 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_period315 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_to_period317 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_to_period319 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_to_period323 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_period326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_get_tod351 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_get_tod353 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_get_tod357 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_get_tod360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_dct_year376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_dct_month392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_dct_day408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_to_year424 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_year426 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_to_year430 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_year433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_to_month448 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_month450 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_to_month454 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_month457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_to_day472 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_day474 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_to_day478 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_day481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_to_iso496 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_iso498 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_to_iso502 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_iso505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_to_time520 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_time522 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_to_time526 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_time529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_fill_zeros544 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_fill_zeros546 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_fill_zeros550 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_fill_zeros553 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_fill_zeros557 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_fill_zeros559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add583 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add585 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add589 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add597 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_GRANULARITY_in_add599 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add611 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_add615 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add631 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add633 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add637 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add645 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_add649 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add652 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_add656 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add672 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add674 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add678 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add686 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_add690 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add693 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_toint_in_add697 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add714 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add716 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add720 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add728 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_add732 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add735 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_tonegativeint_in_add739 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_add756 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add758 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add762 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add770 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_add774 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add777 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_add781 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_date_weekday818 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_date_weekday820 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_date_weekday824 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_weekday832 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_date_weekday836 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_date_weekday839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_date_month863 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_date_month865 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_date_month869 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_month877 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_date_month881 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_date_month884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_date_month_day907 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_date_month_day909 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_date_month_day913 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_month_day921 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_date_month_day925 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_month_day928 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_date_month_day932 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_date_month_day935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_pat951 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_pat953 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_pat957 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_pat959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_tonegativeint977 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_tonegativeint981 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_tonegativeint984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_toint1002 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pat_in_toint1006 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_toint1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_print1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_intnumber1047 = new BitSet(new long[]{0x0000000000000002L});

}