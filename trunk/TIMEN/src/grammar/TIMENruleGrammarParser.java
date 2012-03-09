// $ANTLR 3.4 TIMENruleGrammar.g 2012-02-29 18:12:10

    package grammar;
    import TIMEN.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TIMENruleGrammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "GRANULARITY", "INT", "REFERENCE", "SEPARATOR", "STRING", "WHITESPACE", "'('", "')'", "','", "'ADD'", "'ADD_WEEKDAY'", "'DATE_MONTH'", "'DATE_MONTH_DAY'", "'DATE_WEEKDAY'", "'DCTDAY'", "'DCTMONTH'", "'DCTYEAR'", "'GET_TOD'", "'INT('", "'NEGATIVEINT('", "'PAT'", "'TO_DAY'", "'TO_MONTH'", "'TO_PERIOD'", "'TO_YEAR'"
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

                    if ( (LA2_1==STRING||(LA2_1 >= 14 && LA2_1 <= 22)||(LA2_1 >= 25 && LA2_1 <= 29)) ) {
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
    // TIMENruleGrammar.g:19:1: rule[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= to_month[$timen,$timex_object] |e= to_day[$timen,$timex_object] |e= add[$timen, $timex_object] |e= date_weekday[$timen, $timex_object] |e= date_month[$timen, $timex_object] |e= date_month_day[$timen, $timex_object] |e= to_period[$timen, $timex_object] |e= get_tod[$timen, timex_object] ) ;
    public final String rule(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:19:71: ( (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= to_month[$timen,$timex_object] |e= to_day[$timen,$timex_object] |e= add[$timen, $timex_object] |e= date_weekday[$timen, $timex_object] |e= date_month[$timen, $timex_object] |e= date_month_day[$timen, $timex_object] |e= to_period[$timen, $timex_object] |e= get_tod[$timen, timex_object] ) )
            // TIMENruleGrammar.g:20:2: (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= to_month[$timen,$timex_object] |e= to_day[$timen,$timex_object] |e= add[$timen, $timex_object] |e= date_weekday[$timen, $timex_object] |e= date_month[$timen, $timex_object] |e= date_month_day[$timen, $timex_object] |e= to_period[$timen, $timex_object] |e= get_tod[$timen, timex_object] )
            {
            // TIMENruleGrammar.g:20:2: (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= to_month[$timen,$timex_object] |e= to_day[$timen,$timex_object] |e= add[$timen, $timex_object] |e= date_weekday[$timen, $timex_object] |e= date_month[$timen, $timex_object] |e= date_month_day[$timen, $timex_object] |e= to_period[$timen, $timex_object] |e= get_tod[$timen, timex_object] )
            int alt3=14;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt3=1;
                }
                break;
            case 25:
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
            case 29:
                {
                alt3=6;
                }
                break;
            case 27:
                {
                alt3=7;
                }
                break;
            case 26:
                {
                alt3=8;
                }
                break;
            case 14:
            case 15:
                {
                alt3=9;
                }
                break;
            case 18:
                {
                alt3=10;
                }
                break;
            case 16:
                {
                alt3=11;
                }
                break;
            case 17:
                {
                alt3=12;
                }
                break;
            case 28:
                {
                alt3=13;
                }
                break;
            case 22:
                {
                alt3=14;
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
                    // TIMENruleGrammar.g:28:3: e= add[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_add_in_rule165);
                    e=add(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 10 :
                    // TIMENruleGrammar.g:29:3: e= date_weekday[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_date_weekday_in_rule174);
                    e=date_weekday(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 11 :
                    // TIMENruleGrammar.g:30:3: e= date_month[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_date_month_in_rule183);
                    e=date_month(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 12 :
                    // TIMENruleGrammar.g:31:3: e= date_month_day[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_date_month_day_in_rule192);
                    e=date_month_day(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 13 :
                    // TIMENruleGrammar.g:32:3: e= to_period[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_to_period_in_rule201);
                    e=to_period(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 14 :
                    // TIMENruleGrammar.g:33:3: e= get_tod[$timen, timex_object]
                    {
                    pushFollow(FOLLOW_get_tod_in_rule210);
                    e=get_tod(timen, timex_object);

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
    // TIMENruleGrammar.g:36:1: to_period[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : ( 'TO_PERIOD' '(' num= pat[$timex_object] ',' tunit= pat[$timex_object] ')' | 'TO_PERIOD' '(' INT ',' tunit= pat[$timex_object] ')' | 'TO_PERIOD' '(' STRING ',' tunit= pat[$timex_object] ')' );
    public final String to_period(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token INT2=null;
        Token STRING3=null;
        String num =null;

        String tunit =null;


        try {
            // TIMENruleGrammar.g:36:75: ( 'TO_PERIOD' '(' num= pat[$timex_object] ',' tunit= pat[$timex_object] ')' | 'TO_PERIOD' '(' INT ',' tunit= pat[$timex_object] ')' | 'TO_PERIOD' '(' STRING ',' tunit= pat[$timex_object] ')' )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==28) ) {
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
                    case 25:
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
                    // TIMENruleGrammar.g:37:2: 'TO_PERIOD' '(' num= pat[$timex_object] ',' tunit= pat[$timex_object] ')'
                    {
                    match(input,28,FOLLOW_28_in_to_period229); 

                    match(input,11,FOLLOW_11_in_to_period231); 

                    pushFollow(FOLLOW_pat_in_to_period235);
                    num=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_to_period238); 

                    pushFollow(FOLLOW_pat_in_to_period242);
                    tunit=pat(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_to_period245); 

                    value = timen.to_period(num,tunit);

                    }
                    break;
                case 2 :
                    // TIMENruleGrammar.g:38:11: 'TO_PERIOD' '(' INT ',' tunit= pat[$timex_object] ')'
                    {
                    match(input,28,FOLLOW_28_in_to_period259); 

                    match(input,11,FOLLOW_11_in_to_period261); 

                    INT2=(Token)match(input,INT,FOLLOW_INT_in_to_period263); 

                    match(input,13,FOLLOW_13_in_to_period265); 

                    pushFollow(FOLLOW_pat_in_to_period269);
                    tunit=pat(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_to_period272); 

                    value = timen.to_period((INT2!=null?INT2.getText():null),tunit);

                    }
                    break;
                case 3 :
                    // TIMENruleGrammar.g:39:11: 'TO_PERIOD' '(' STRING ',' tunit= pat[$timex_object] ')'
                    {
                    match(input,28,FOLLOW_28_in_to_period286); 

                    match(input,11,FOLLOW_11_in_to_period288); 

                    STRING3=(Token)match(input,STRING,FOLLOW_STRING_in_to_period290); 

                    match(input,13,FOLLOW_13_in_to_period292); 

                    pushFollow(FOLLOW_pat_in_to_period296);
                    tunit=pat(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_to_period299); 

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
    // TIMENruleGrammar.g:43:1: get_tod[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'GET_TOD' '(' e= pat[$timex_object] ')' ;
    public final String get_tod(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:43:73: ( 'GET_TOD' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:44:2: 'GET_TOD' '(' e= pat[$timex_object] ')'
            {
            match(input,22,FOLLOW_22_in_get_tod324); 

            match(input,11,FOLLOW_11_in_get_tod326); 

            pushFollow(FOLLOW_pat_in_get_tod330);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_get_tod333); 

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
    // TIMENruleGrammar.g:47:1: dct_year[TIMEX_Instance timex_object] returns [String value] : 'DCTYEAR' ;
    public final String dct_year(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        try {
            // TIMENruleGrammar.g:47:61: ( 'DCTYEAR' )
            // TIMENruleGrammar.g:48:2: 'DCTYEAR'
            {
            match(input,21,FOLLOW_21_in_dct_year349); 

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
    // TIMENruleGrammar.g:50:1: dct_month[TIMEX_Instance timex_object] returns [String value] : 'DCTMONTH' ;
    public final String dct_month(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        try {
            // TIMENruleGrammar.g:50:62: ( 'DCTMONTH' )
            // TIMENruleGrammar.g:51:2: 'DCTMONTH'
            {
            match(input,20,FOLLOW_20_in_dct_month365); 

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
    // TIMENruleGrammar.g:53:1: dct_day[TIMEX_Instance timex_object] returns [String value] : 'DCTDAY' ;
    public final String dct_day(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        try {
            // TIMENruleGrammar.g:53:60: ( 'DCTDAY' )
            // TIMENruleGrammar.g:54:2: 'DCTDAY'
            {
            match(input,19,FOLLOW_19_in_dct_day381); 

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
    // TIMENruleGrammar.g:56:1: to_year[TIMEX_Instance timex_object] returns [String value] : 'TO_YEAR' '(' e= pat[$timex_object] ')' ;
    public final String to_year(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:56:60: ( 'TO_YEAR' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:57:2: 'TO_YEAR' '(' e= pat[$timex_object] ')'
            {
            match(input,29,FOLLOW_29_in_to_year397); 

            match(input,11,FOLLOW_11_in_to_year399); 

            pushFollow(FOLLOW_pat_in_to_year403);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_year406); 

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
    // TIMENruleGrammar.g:59:1: to_month[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'TO_MONTH' '(' e= pat[$timex_object] ')' ;
    public final String to_month(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:59:74: ( 'TO_MONTH' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:60:2: 'TO_MONTH' '(' e= pat[$timex_object] ')'
            {
            match(input,27,FOLLOW_27_in_to_month421); 

            match(input,11,FOLLOW_11_in_to_month423); 

            pushFollow(FOLLOW_pat_in_to_month427);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_month430); 

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
    // TIMENruleGrammar.g:62:1: to_day[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'TO_DAY' '(' e= pat[$timex_object] ')' ;
    public final String to_day(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:62:72: ( 'TO_DAY' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:63:2: 'TO_DAY' '(' e= pat[$timex_object] ')'
            {
            match(input,26,FOLLOW_26_in_to_day445); 

            match(input,11,FOLLOW_11_in_to_day447); 

            pushFollow(FOLLOW_pat_in_to_day451);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_to_day454); 

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



    // $ANTLR start "add"
    // TIMENruleGrammar.g:66:1: add[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : ( 'ADD' '(' r= REFERENCE ',' GRANULARITY ',' i= intnumber ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= toint[$timex_object] ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= tonegativeint[$timex_object] ')' | 'ADD_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')' );
    public final String add(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        Token GRANULARITY4=null;
        int i =0;

        String e =null;


        try {
            // TIMENruleGrammar.g:66:69: ( 'ADD' '(' r= REFERENCE ',' GRANULARITY ',' i= intnumber ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= toint[$timex_object] ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= tonegativeint[$timex_object] ')' | 'ADD_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')' )
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
                            else if ( (LA5_5==25) ) {
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
                                                case 23:
                                                    {
                                                    alt5=3;
                                                    }
                                                    break;
                                                case 24:
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
                    // TIMENruleGrammar.g:67:10: 'ADD' '(' r= REFERENCE ',' GRANULARITY ',' i= intnumber ')'
                    {
                    match(input,14,FOLLOW_14_in_add479); 

                    match(input,11,FOLLOW_11_in_add481); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add485); 

                    match(input,13,FOLLOW_13_in_add493); 

                    GRANULARITY4=(Token)match(input,GRANULARITY,FOLLOW_GRANULARITY_in_add495); 

                    match(input,13,FOLLOW_13_in_add507); 

                    pushFollow(FOLLOW_intnumber_in_add511);
                    i=intnumber();

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add513); 

                    value = timen.add((r!=null?r.getText():null),(GRANULARITY4!=null?GRANULARITY4.getText():null),i, timex_object);

                    }
                    break;
                case 2 :
                    // TIMENruleGrammar.g:68:11: 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')'
                    {
                    match(input,14,FOLLOW_14_in_add527); 

                    match(input,11,FOLLOW_11_in_add529); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add533); 

                    match(input,13,FOLLOW_13_in_add541); 

                    pushFollow(FOLLOW_pat_in_add545);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add548); 

                    pushFollow(FOLLOW_intnumber_in_add552);
                    i=intnumber();

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add554); 

                    value = timen.add((r!=null?r.getText():null),e,i, timex_object);

                    }
                    break;
                case 3 :
                    // TIMENruleGrammar.g:69:11: 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= toint[$timex_object] ')'
                    {
                    match(input,14,FOLLOW_14_in_add568); 

                    match(input,11,FOLLOW_11_in_add570); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add574); 

                    match(input,13,FOLLOW_13_in_add582); 

                    pushFollow(FOLLOW_pat_in_add586);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add589); 

                    pushFollow(FOLLOW_toint_in_add593);
                    i=toint(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add596); 

                    value = timen.add((r!=null?r.getText():null),e,i, timex_object);

                    }
                    break;
                case 4 :
                    // TIMENruleGrammar.g:70:11: 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= tonegativeint[$timex_object] ')'
                    {
                    match(input,14,FOLLOW_14_in_add610); 

                    match(input,11,FOLLOW_11_in_add612); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add616); 

                    match(input,13,FOLLOW_13_in_add624); 

                    pushFollow(FOLLOW_pat_in_add628);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add631); 

                    pushFollow(FOLLOW_tonegativeint_in_add635);
                    i=tonegativeint(timex_object);

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add638); 

                    value = timen.add((r!=null?r.getText():null),e,i, timex_object);

                    }
                    break;
                case 5 :
                    // TIMENruleGrammar.g:71:11: 'ADD_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= intnumber ')'
                    {
                    match(input,15,FOLLOW_15_in_add652); 

                    match(input,11,FOLLOW_11_in_add654); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add658); 

                    match(input,13,FOLLOW_13_in_add666); 

                    pushFollow(FOLLOW_pat_in_add670);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add673); 

                    pushFollow(FOLLOW_intnumber_in_add677);
                    i=intnumber();

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_add679); 

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
    // TIMENruleGrammar.g:77:1: date_weekday[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'DATE_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ')' ;
    public final String date_weekday(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        String e =null;


        try {
            // TIMENruleGrammar.g:77:78: ( 'DATE_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:78:10: 'DATE_WEEKDAY' '(' r= REFERENCE ',' e= pat[$timex_object] ')'
            {
            match(input,18,FOLLOW_18_in_date_weekday714); 

            match(input,11,FOLLOW_11_in_date_weekday716); 

            r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_date_weekday720); 

            match(input,13,FOLLOW_13_in_date_weekday728); 

            pushFollow(FOLLOW_pat_in_date_weekday732);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_date_weekday735); 

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
    // TIMENruleGrammar.g:80:1: date_month[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'DATE_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ')' ;
    public final String date_month(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        String e =null;


        try {
            // TIMENruleGrammar.g:80:76: ( 'DATE_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:81:10: 'DATE_MONTH' '(' r= REFERENCE ',' e= pat[$timex_object] ')'
            {
            match(input,16,FOLLOW_16_in_date_month758); 

            match(input,11,FOLLOW_11_in_date_month760); 

            r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_date_month764); 

            match(input,13,FOLLOW_13_in_date_month772); 

            pushFollow(FOLLOW_pat_in_date_month776);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_date_month779); 

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
    // TIMENruleGrammar.g:83:1: date_month_day[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'DATE_MONTH_DAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ')' ;
    public final String date_month_day(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        String e =null;

        String d =null;


        try {
            // TIMENruleGrammar.g:83:80: ( 'DATE_MONTH_DAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:84:10: 'DATE_MONTH_DAY' '(' r= REFERENCE ',' e= pat[$timex_object] ',' d= pat[$timex_object] ')'
            {
            match(input,17,FOLLOW_17_in_date_month_day802); 

            match(input,11,FOLLOW_11_in_date_month_day804); 

            r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_date_month_day808); 

            match(input,13,FOLLOW_13_in_date_month_day816); 

            pushFollow(FOLLOW_pat_in_date_month_day820);
            e=pat(timex_object);

            state._fsp--;


            match(input,13,FOLLOW_13_in_date_month_day823); 

            pushFollow(FOLLOW_pat_in_date_month_day827);
            d=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_date_month_day830); 

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
    // TIMENruleGrammar.g:87:1: pat[TIMEX_Instance timex_object] returns [String value] : 'PAT' '(' e= intnumber ')' ;
    public final String pat(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        int e =0;


        try {
            // TIMENruleGrammar.g:87:56: ( 'PAT' '(' e= intnumber ')' )
            // TIMENruleGrammar.g:88:2: 'PAT' '(' e= intnumber ')'
            {
            match(input,25,FOLLOW_25_in_pat846); 

            match(input,11,FOLLOW_11_in_pat848); 

            pushFollow(FOLLOW_intnumber_in_pat852);
            e=intnumber();

            state._fsp--;


            match(input,12,FOLLOW_12_in_pat854); 

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
    // TIMENruleGrammar.g:90:1: tonegativeint[TIMEX_Instance timex_object] returns [int value] : 'NEGATIVEINT(' e= pat[$timex_object] ')' ;
    public final int tonegativeint(TIMEX_Instance timex_object) throws RecognitionException {
        int value = 0;


        String e =null;


        try {
            // TIMENruleGrammar.g:90:63: ( 'NEGATIVEINT(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:91:5: 'NEGATIVEINT(' e= pat[$timex_object] ')'
            {
            match(input,24,FOLLOW_24_in_tonegativeint872); 

            pushFollow(FOLLOW_pat_in_tonegativeint876);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_tonegativeint879); 

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
    // TIMENruleGrammar.g:93:1: toint[TIMEX_Instance timex_object] returns [int value] : 'INT(' e= pat[$timex_object] ')' ;
    public final int toint(TIMEX_Instance timex_object) throws RecognitionException {
        int value = 0;


        String e =null;


        try {
            // TIMENruleGrammar.g:93:55: ( 'INT(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:94:5: 'INT(' e= pat[$timex_object] ')'
            {
            match(input,23,FOLLOW_23_in_toint897); 

            pushFollow(FOLLOW_pat_in_toint901);
            e=pat(timex_object);

            state._fsp--;


            match(input,12,FOLLOW_12_in_toint904); 

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
    // TIMENruleGrammar.g:97:1: print returns [String value] : STRING ;
    public final String print() throws RecognitionException {
        String value = null;


        Token STRING5=null;

        try {
            // TIMENruleGrammar.g:97:29: ( STRING )
            // TIMENruleGrammar.g:98:5: STRING
            {
            STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_print922); 

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
    // TIMENruleGrammar.g:101:1: intnumber returns [int value] : INT ;
    public final int intnumber() throws RecognitionException {
        int value = 0;


        Token INT6=null;

        try {
            // TIMENruleGrammar.g:101:30: ( INT )
            // TIMENruleGrammar.g:102:2: INT
            {
            INT6=(Token)match(input,INT,FOLLOW_INT_in_intnumber942); 

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
    public static final BitSet FOLLOW_SEPARATOR_in_rules65 = new BitSet(new long[]{0x000000003E7FC200L});
    public static final BitSet FOLLOW_rule_in_rules69 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_print_in_rule94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pat_in_rule102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dct_year_in_rule111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dct_month_in_rule120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dct_day_in_rule129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_year_in_rule138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_month_in_rule147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_day_in_rule156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_add_in_rule165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_weekday_in_rule174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_month_in_rule183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_month_day_in_rule192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_period_in_rule201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_get_tod_in_rule210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_to_period229 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_period231 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_pat_in_to_period235 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_to_period238 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_pat_in_to_period242 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_period245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_to_period259 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_period261 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_to_period263 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_to_period265 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_pat_in_to_period269 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_period272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_to_period286 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_period288 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_to_period290 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_to_period292 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_pat_in_to_period296 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_period299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_get_tod324 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_get_tod326 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_pat_in_get_tod330 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_get_tod333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_dct_year349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_dct_month365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_dct_day381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_to_year397 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_year399 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_pat_in_to_year403 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_year406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_to_month421 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_month423 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_pat_in_to_month427 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_month430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_to_day445 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_to_day447 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_pat_in_to_day451 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_day454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add479 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add481 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add485 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add493 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_GRANULARITY_in_add495 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add507 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_add511 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add527 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add529 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add533 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add541 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_pat_in_add545 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add548 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_add552 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add568 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add570 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add574 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add582 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_pat_in_add586 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add589 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_toint_in_add593 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_add610 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add612 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add616 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add624 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_pat_in_add628 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add631 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_tonegativeint_in_add635 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_add652 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_add654 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add658 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add666 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_pat_in_add670 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add673 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_add677 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_date_weekday714 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_date_weekday716 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_date_weekday720 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_weekday728 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_pat_in_date_weekday732 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_date_weekday735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_date_month758 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_date_month760 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_date_month764 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_month772 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_pat_in_date_month776 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_date_month779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_date_month_day802 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_date_month_day804 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_date_month_day808 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_month_day816 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_pat_in_date_month_day820 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_month_day823 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_pat_in_date_month_day827 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_date_month_day830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_pat846 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_pat848 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_pat852 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_pat854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_tonegativeint872 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_pat_in_tonegativeint876 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_tonegativeint879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_toint897 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_pat_in_toint901 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_toint904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_print922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_intnumber942 = new BitSet(new long[]{0x0000000000000002L});

}