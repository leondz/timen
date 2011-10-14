// $ANTLR 3.4 TIMENruleGrammar.g 2011-10-04 01:43:22

    package grammar;
    import TIMEN.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TIMENruleGrammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "GRANULARITY", "INT", "REFERENCE", "SEPARATOR", "STRING", "WHITESPACE", "'\"'", "'('", "')'", "','", "'ADD'", "'DATE_TENSE_WEEKDAY'", "'DCTDAY'", "'DCTMONTH'", "'DCTYEAR'", "'INT('", "'NEGATIVEINT('", "'PAT'", "'TO_PERIOD'", "'TO_YEAR'"
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

                    if ( (LA2_1==11||(LA2_1 >= 15 && LA2_1 <= 19)||(LA2_1 >= 22 && LA2_1 <= 24)) ) {
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
    // TIMENruleGrammar.g:19:1: rule[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= add[$timen, $timex_object] |e= date_tense_weekday[$timen, $timex_object] |e= to_period[$timen, $timex_object] ) ;
    public final String rule(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:19:71: ( (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= add[$timen, $timex_object] |e= date_tense_weekday[$timen, $timex_object] |e= to_period[$timen, $timex_object] ) )
            // TIMENruleGrammar.g:20:2: (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= add[$timen, $timex_object] |e= date_tense_weekday[$timen, $timex_object] |e= to_period[$timen, $timex_object] )
            {
            // TIMENruleGrammar.g:20:2: (e= print |e= pat[$timex_object] |e= dct_year[$timex_object] |e= dct_month[$timex_object] |e= dct_day[$timex_object] |e= to_year[$timex_object] |e= add[$timen, $timex_object] |e= date_tense_weekday[$timen, $timex_object] |e= to_period[$timen, $timex_object] )
            int alt3=9;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt3=1;
                }
                break;
            case 22:
                {
                alt3=2;
                }
                break;
            case 19:
                {
                alt3=3;
                }
                break;
            case 18:
                {
                alt3=4;
                }
                break;
            case 17:
                {
                alt3=5;
                }
                break;
            case 24:
                {
                alt3=6;
                }
                break;
            case 15:
                {
                alt3=7;
                }
                break;
            case 16:
                {
                alt3=8;
                }
                break;
            case 23:
                {
                alt3=9;
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
                    // TIMENruleGrammar.g:26:3: e= add[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_add_in_rule147);
                    e=add(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 8 :
                    // TIMENruleGrammar.g:27:3: e= date_tense_weekday[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_date_tense_weekday_in_rule156);
                    e=date_tense_weekday(timen, timex_object);

                    state._fsp--;


                    value = e;

                    }
                    break;
                case 9 :
                    // TIMENruleGrammar.g:28:3: e= to_period[$timen, $timex_object]
                    {
                    pushFollow(FOLLOW_to_period_in_rule165);
                    e=to_period(timen, timex_object);

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
    // TIMENruleGrammar.g:31:1: to_period[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'TO_PERIOD' '(' num= pat[$timex_object] ',' tunit= pat[$timex_object] ')' ;
    public final String to_period(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String num =null;

        String tunit =null;


        try {
            // TIMENruleGrammar.g:31:75: ( 'TO_PERIOD' '(' num= pat[$timex_object] ',' tunit= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:32:2: 'TO_PERIOD' '(' num= pat[$timex_object] ',' tunit= pat[$timex_object] ')'
            {
            match(input,23,FOLLOW_23_in_to_period184); 

            match(input,12,FOLLOW_12_in_to_period186); 

            pushFollow(FOLLOW_pat_in_to_period190);
            num=pat(timex_object);

            state._fsp--;


            match(input,14,FOLLOW_14_in_to_period193); 

            pushFollow(FOLLOW_pat_in_to_period197);
            tunit=pat(timex_object);

            state._fsp--;


            match(input,13,FOLLOW_13_in_to_period200); 

            value = timen.to_period(num,tunit);

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



    // $ANTLR start "dct_year"
    // TIMENruleGrammar.g:35:1: dct_year[TIMEX_Instance timex_object] returns [String value] : 'DCTYEAR' ;
    public final String dct_year(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        try {
            // TIMENruleGrammar.g:35:61: ( 'DCTYEAR' )
            // TIMENruleGrammar.g:36:2: 'DCTYEAR'
            {
            match(input,19,FOLLOW_19_in_dct_year216); 

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
    // TIMENruleGrammar.g:38:1: dct_month[TIMEX_Instance timex_object] returns [String value] : 'DCTMONTH' ;
    public final String dct_month(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        try {
            // TIMENruleGrammar.g:38:62: ( 'DCTMONTH' )
            // TIMENruleGrammar.g:39:2: 'DCTMONTH'
            {
            match(input,18,FOLLOW_18_in_dct_month232); 

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
    // TIMENruleGrammar.g:41:1: dct_day[TIMEX_Instance timex_object] returns [String value] : 'DCTDAY' ;
    public final String dct_day(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        try {
            // TIMENruleGrammar.g:41:60: ( 'DCTDAY' )
            // TIMENruleGrammar.g:42:2: 'DCTDAY'
            {
            match(input,17,FOLLOW_17_in_dct_day248); 

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
    // TIMENruleGrammar.g:44:1: to_year[TIMEX_Instance timex_object] returns [String value] : 'TO_YEAR' '(' e= pat[$timex_object] ')' ;
    public final String to_year(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        String e =null;


        try {
            // TIMENruleGrammar.g:44:60: ( 'TO_YEAR' '(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:45:2: 'TO_YEAR' '(' e= pat[$timex_object] ')'
            {
            match(input,24,FOLLOW_24_in_to_year264); 

            match(input,12,FOLLOW_12_in_to_year266); 

            pushFollow(FOLLOW_pat_in_to_year270);
            e=pat(timex_object);

            state._fsp--;


            match(input,13,FOLLOW_13_in_to_year273); 

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



    // $ANTLR start "add"
    // TIMENruleGrammar.g:47:1: add[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : ( 'ADD' '(' r= REFERENCE ',' GRANULARITY ',' i= intnumber ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= toint[$timex_object] ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= tonegativeint[$timex_object] ')' );
    public final String add(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        Token GRANULARITY2=null;
        int i =0;

        String e =null;


        try {
            // TIMENruleGrammar.g:47:69: ( 'ADD' '(' r= REFERENCE ',' GRANULARITY ',' i= intnumber ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= toint[$timex_object] ')' | 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= tonegativeint[$timex_object] ')' )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==12) ) {
                    int LA4_2 = input.LA(3);

                    if ( (LA4_2==REFERENCE) ) {
                        int LA4_3 = input.LA(4);

                        if ( (LA4_3==14) ) {
                            int LA4_4 = input.LA(5);

                            if ( (LA4_4==GRANULARITY) ) {
                                alt4=1;
                            }
                            else if ( (LA4_4==22) ) {
                                int LA4_6 = input.LA(6);

                                if ( (LA4_6==12) ) {
                                    int LA4_7 = input.LA(7);

                                    if ( (LA4_7==INT) ) {
                                        int LA4_8 = input.LA(8);

                                        if ( (LA4_8==13) ) {
                                            int LA4_9 = input.LA(9);

                                            if ( (LA4_9==14) ) {
                                                int LA4_10 = input.LA(10);

                                                if ( (LA4_10==20) ) {
                                                    alt4=2;
                                                }
                                                else if ( (LA4_10==21) ) {
                                                    alt4=3;
                                                }
                                                else {
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("", 4, 10, input);

                                                    throw nvae;

                                                }
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 4, 9, input);

                                                throw nvae;

                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 4, 8, input);

                                            throw nvae;

                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 4, 7, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 4, 6, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 4, 4, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 3, input);

                            throw nvae;

                        }
                    }
                    else {
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
                    // TIMENruleGrammar.g:48:10: 'ADD' '(' r= REFERENCE ',' GRANULARITY ',' i= intnumber ')'
                    {
                    match(input,15,FOLLOW_15_in_add297); 

                    match(input,12,FOLLOW_12_in_add299); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add303); 

                    match(input,14,FOLLOW_14_in_add311); 

                    GRANULARITY2=(Token)match(input,GRANULARITY,FOLLOW_GRANULARITY_in_add313); 

                    match(input,14,FOLLOW_14_in_add325); 

                    pushFollow(FOLLOW_intnumber_in_add329);
                    i=intnumber();

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add331); 

                    value = timen.add((r!=null?r.getText():null),(GRANULARITY2!=null?GRANULARITY2.getText():null),i, timex_object);

                    }
                    break;
                case 2 :
                    // TIMENruleGrammar.g:49:11: 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= toint[$timex_object] ')'
                    {
                    match(input,15,FOLLOW_15_in_add345); 

                    match(input,12,FOLLOW_12_in_add347); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add351); 

                    match(input,14,FOLLOW_14_in_add359); 

                    pushFollow(FOLLOW_pat_in_add363);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,14,FOLLOW_14_in_add366); 

                    pushFollow(FOLLOW_toint_in_add370);
                    i=toint(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add373); 

                    value = timen.add((r!=null?r.getText():null),e,i, timex_object);

                    }
                    break;
                case 3 :
                    // TIMENruleGrammar.g:50:11: 'ADD' '(' r= REFERENCE ',' e= pat[$timex_object] ',' i= tonegativeint[$timex_object] ')'
                    {
                    match(input,15,FOLLOW_15_in_add387); 

                    match(input,12,FOLLOW_12_in_add389); 

                    r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_add393); 

                    match(input,14,FOLLOW_14_in_add401); 

                    pushFollow(FOLLOW_pat_in_add405);
                    e=pat(timex_object);

                    state._fsp--;


                    match(input,14,FOLLOW_14_in_add408); 

                    pushFollow(FOLLOW_tonegativeint_in_add412);
                    i=tonegativeint(timex_object);

                    state._fsp--;


                    match(input,13,FOLLOW_13_in_add415); 

                    value = timen.add((r!=null?r.getText():null),e,i, timex_object);

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



    // $ANTLR start "date_tense_weekday"
    // TIMENruleGrammar.g:53:1: date_tense_weekday[TIMEN timen, TIMEX_Instance timex_object] returns [String value] : 'DATE_TENSE_WEEKDAY' '(' r= REFERENCE ',' GRANULARITY ',' e= pat[$timex_object] ')' ;
    public final String date_tense_weekday(TIMEN timen, TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        Token r=null;
        Token GRANULARITY3=null;
        String e =null;


        try {
            // TIMENruleGrammar.g:53:84: ( 'DATE_TENSE_WEEKDAY' '(' r= REFERENCE ',' GRANULARITY ',' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:54:10: 'DATE_TENSE_WEEKDAY' '(' r= REFERENCE ',' GRANULARITY ',' e= pat[$timex_object] ')'
            {
            match(input,16,FOLLOW_16_in_date_tense_weekday447); 

            match(input,12,FOLLOW_12_in_date_tense_weekday449); 

            r=(Token)match(input,REFERENCE,FOLLOW_REFERENCE_in_date_tense_weekday453); 

            match(input,14,FOLLOW_14_in_date_tense_weekday461); 

            GRANULARITY3=(Token)match(input,GRANULARITY,FOLLOW_GRANULARITY_in_date_tense_weekday463); 

            match(input,14,FOLLOW_14_in_date_tense_weekday475); 

            pushFollow(FOLLOW_pat_in_date_tense_weekday479);
            e=pat(timex_object);

            state._fsp--;


            match(input,13,FOLLOW_13_in_date_tense_weekday482); 

            value = timen.date_tense_weekday((r!=null?r.getText():null),(GRANULARITY3!=null?GRANULARITY3.getText():null),e, timex_object);

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
    // $ANTLR end "date_tense_weekday"



    // $ANTLR start "pat"
    // TIMENruleGrammar.g:57:1: pat[TIMEX_Instance timex_object] returns [String value] : 'PAT' '(' e= intnumber ')' ;
    public final String pat(TIMEX_Instance timex_object) throws RecognitionException {
        String value = null;


        int e =0;


        try {
            // TIMENruleGrammar.g:57:56: ( 'PAT' '(' e= intnumber ')' )
            // TIMENruleGrammar.g:58:2: 'PAT' '(' e= intnumber ')'
            {
            match(input,22,FOLLOW_22_in_pat498); 

            match(input,12,FOLLOW_12_in_pat500); 

            pushFollow(FOLLOW_intnumber_in_pat504);
            e=intnumber();

            state._fsp--;


            match(input,13,FOLLOW_13_in_pat506); 

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
    // TIMENruleGrammar.g:60:1: tonegativeint[TIMEX_Instance timex_object] returns [int value] : 'NEGATIVEINT(' e= pat[$timex_object] ')' ;
    public final int tonegativeint(TIMEX_Instance timex_object) throws RecognitionException {
        int value = 0;


        String e =null;


        try {
            // TIMENruleGrammar.g:60:63: ( 'NEGATIVEINT(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:61:5: 'NEGATIVEINT(' e= pat[$timex_object] ')'
            {
            match(input,21,FOLLOW_21_in_tonegativeint524); 

            pushFollow(FOLLOW_pat_in_tonegativeint528);
            e=pat(timex_object);

            state._fsp--;


            match(input,13,FOLLOW_13_in_tonegativeint531); 

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
    // TIMENruleGrammar.g:63:1: toint[TIMEX_Instance timex_object] returns [int value] : 'INT(' e= pat[$timex_object] ')' ;
    public final int toint(TIMEX_Instance timex_object) throws RecognitionException {
        int value = 0;


        String e =null;


        try {
            // TIMENruleGrammar.g:63:55: ( 'INT(' e= pat[$timex_object] ')' )
            // TIMENruleGrammar.g:64:5: 'INT(' e= pat[$timex_object] ')'
            {
            match(input,20,FOLLOW_20_in_toint549); 

            pushFollow(FOLLOW_pat_in_toint553);
            e=pat(timex_object);

            state._fsp--;


            match(input,13,FOLLOW_13_in_toint556); 

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
    // TIMENruleGrammar.g:67:1: print returns [String value] : '\"' STRING '\"' ;
    public final String print() throws RecognitionException {
        String value = null;


        Token STRING4=null;

        try {
            // TIMENruleGrammar.g:67:29: ( '\"' STRING '\"' )
            // TIMENruleGrammar.g:68:2: '\"' STRING '\"'
            {
            match(input,11,FOLLOW_11_in_print571); 

            STRING4=(Token)match(input,STRING,FOLLOW_STRING_in_print573); 

            match(input,11,FOLLOW_11_in_print575); 

            value = (STRING4!=null?STRING4.getText():null);

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
    // TIMENruleGrammar.g:70:1: intnumber returns [int value] : INT ;
    public final int intnumber() throws RecognitionException {
        int value = 0;


        Token INT5=null;

        try {
            // TIMENruleGrammar.g:70:30: ( INT )
            // TIMENruleGrammar.g:71:2: INT
            {
            INT5=(Token)match(input,INT,FOLLOW_INT_in_intnumber589); 

            value = Integer.parseInt((INT5!=null?INT5.getText():null));

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
    public static final BitSet FOLLOW_SEPARATOR_in_rules65 = new BitSet(new long[]{0x0000000001CF8800L});
    public static final BitSet FOLLOW_rule_in_rules69 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_print_in_rule94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pat_in_rule102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dct_year_in_rule111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dct_month_in_rule120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dct_day_in_rule129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_year_in_rule138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_add_in_rule147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_tense_weekday_in_rule156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_to_period_in_rule165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_to_period184 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_period186 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_pat_in_to_period190 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_to_period193 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_pat_in_to_period197 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_to_period200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_dct_year216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_dct_month232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_dct_day248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_to_year264 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_to_year266 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_pat_in_to_year270 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_to_year273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_add297 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add299 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add303 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_add311 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_GRANULARITY_in_add313 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_add325 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_add329 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_add345 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add347 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add351 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_add359 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_pat_in_add363 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_add366 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_toint_in_add370 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_add387 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_add389 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_add393 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_add401 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_pat_in_add405 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_add408 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_tonegativeint_in_add412 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_add415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_date_tense_weekday447 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_date_tense_weekday449 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_REFERENCE_in_date_tense_weekday453 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_date_tense_weekday461 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_GRANULARITY_in_date_tense_weekday463 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_date_tense_weekday475 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_pat_in_date_tense_weekday479 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_date_tense_weekday482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_pat498 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_pat500 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_intnumber_in_pat504 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_pat506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_tonegativeint524 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_pat_in_tonegativeint528 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_tonegativeint531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_toint549 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_pat_in_toint553 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_toint556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_print571 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_print573 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_print575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_intnumber589 = new BitSet(new long[]{0x0000000000000002L});

}