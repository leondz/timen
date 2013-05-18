// $ANTLR 3.4 TIMENruleGrammar.g 2013-05-18 17:16:51
package org.timen.grammar;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TIMENruleGrammarLexer extends Lexer {
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
    public static final int COMMENT=4;
    public static final int GRANULARITY=5;
    public static final int INT=6;
    public static final int REFERENCE=7;
    public static final int SEPARATOR=8;
    public static final int STRING=9;
    public static final int WHITESPACE=10;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public TIMENruleGrammarLexer() {} 
    public TIMENruleGrammarLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public TIMENruleGrammarLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "TIMENruleGrammar.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:4:7: ( '(' )
            // TIMENruleGrammar.g:4:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:5:7: ( ')' )
            // TIMENruleGrammar.g:5:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:6:7: ( ',' )
            // TIMENruleGrammar.g:6:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:7:7: ( 'ADD' )
            // TIMENruleGrammar.g:7:9: 'ADD'
            {
            match("ADD"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:8:7: ( 'ADD_WEEKDAY' )
            // TIMENruleGrammar.g:8:9: 'ADD_WEEKDAY'
            {
            match("ADD_WEEKDAY"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:9:7: ( 'DATE_LAST_WEEKDAY_MONTH' )
            // TIMENruleGrammar.g:9:9: 'DATE_LAST_WEEKDAY_MONTH'
            {
            match("DATE_LAST_WEEKDAY_MONTH"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:10:7: ( 'DATE_MONTH' )
            // TIMENruleGrammar.g:10:9: 'DATE_MONTH'
            {
            match("DATE_MONTH"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:11:7: ( 'DATE_MONTH_DAY' )
            // TIMENruleGrammar.g:11:9: 'DATE_MONTH_DAY'
            {
            match("DATE_MONTH_DAY"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:12:7: ( 'DATE_WEEKDAY' )
            // TIMENruleGrammar.g:12:9: 'DATE_WEEKDAY'
            {
            match("DATE_WEEKDAY"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:13:7: ( 'DATE_WEEKNUM_WEEKDAY_MONTH' )
            // TIMENruleGrammar.g:13:9: 'DATE_WEEKNUM_WEEKDAY_MONTH'
            {
            match("DATE_WEEKNUM_WEEKDAY_MONTH"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:14:7: ( 'DCTDAY' )
            // TIMENruleGrammar.g:14:9: 'DCTDAY'
            {
            match("DCTDAY"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:15:7: ( 'DCTMONTH' )
            // TIMENruleGrammar.g:15:9: 'DCTMONTH'
            {
            match("DCTMONTH"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:16:7: ( 'DCTYEAR' )
            // TIMENruleGrammar.g:16:9: 'DCTYEAR'
            {
            match("DCTYEAR"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:17:7: ( 'FILL_ZEROS' )
            // TIMENruleGrammar.g:17:9: 'FILL_ZEROS'
            {
            match("FILL_ZEROS"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:18:7: ( 'GET_TOD' )
            // TIMENruleGrammar.g:18:9: 'GET_TOD'
            {
            match("GET_TOD"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:19:7: ( 'INT(' )
            // TIMENruleGrammar.g:19:9: 'INT('
            {
            match("INT("); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:20:7: ( 'NEGATIVEINT(' )
            // TIMENruleGrammar.g:20:9: 'NEGATIVEINT('
            {
            match("NEGATIVEINT("); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:21:7: ( 'PAT' )
            // TIMENruleGrammar.g:21:9: 'PAT'
            {
            match("PAT"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:22:7: ( 'TO_DAY' )
            // TIMENruleGrammar.g:22:9: 'TO_DAY'
            {
            match("TO_DAY"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:23:7: ( 'TO_DECADE' )
            // TIMENruleGrammar.g:23:9: 'TO_DECADE'
            {
            match("TO_DECADE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:24:7: ( 'TO_ISO' )
            // TIMENruleGrammar.g:24:9: 'TO_ISO'
            {
            match("TO_ISO"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:25:7: ( 'TO_MONTH' )
            // TIMENruleGrammar.g:25:9: 'TO_MONTH'
            {
            match("TO_MONTH"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:26:7: ( 'TO_PERIOD' )
            // TIMENruleGrammar.g:26:9: 'TO_PERIOD'
            {
            match("TO_PERIOD"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:27:7: ( 'TO_TIME' )
            // TIMENruleGrammar.g:27:9: 'TO_TIME'
            {
            match("TO_TIME"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:28:7: ( 'TO_YEAR' )
            // TIMENruleGrammar.g:28:9: 'TO_YEAR'
            {
            match("TO_YEAR"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "REFERENCE"
    public final void mREFERENCE() throws RecognitionException {
        try {
            int _type = REFERENCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:135:10: ( ( 'DCT' | 'REFTIME' ) )
            // TIMENruleGrammar.g:135:12: ( 'DCT' | 'REFTIME' )
            {
            // TIMENruleGrammar.g:135:12: ( 'DCT' | 'REFTIME' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='D') ) {
                alt1=1;
            }
            else if ( (LA1_0=='R') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // TIMENruleGrammar.g:135:13: 'DCT'
                    {
                    match("DCT"); 



                    }
                    break;
                case 2 :
                    // TIMENruleGrammar.g:135:19: 'REFTIME'
                    {
                    match("REFTIME"); 



                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "REFERENCE"

    // $ANTLR start "GRANULARITY"
    public final void mGRANULARITY() throws RecognitionException {
        try {
            int _type = GRANULARITY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:137:12: ( ( 'millennium' | 'century' | 'decade' | 'year' | 'semester' | 'quarter' | 'month' | 'week' | 'day' | 'hour' | 'minute' | 'second' ) )
            // TIMENruleGrammar.g:137:14: ( 'millennium' | 'century' | 'decade' | 'year' | 'semester' | 'quarter' | 'month' | 'week' | 'day' | 'hour' | 'minute' | 'second' )
            {
            // TIMENruleGrammar.g:137:14: ( 'millennium' | 'century' | 'decade' | 'year' | 'semester' | 'quarter' | 'month' | 'week' | 'day' | 'hour' | 'minute' | 'second' )
            int alt2=12;
            switch ( input.LA(1) ) {
            case 'm':
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='i') ) {
                    int LA2_9 = input.LA(3);

                    if ( (LA2_9=='l') ) {
                        alt2=1;
                    }
                    else if ( (LA2_9=='n') ) {
                        alt2=11;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 9, input);

                        throw nvae;

                    }
                }
                else if ( (LA2_1=='o') ) {
                    alt2=7;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
                }
                break;
            case 'c':
                {
                alt2=2;
                }
                break;
            case 'd':
                {
                int LA2_3 = input.LA(2);

                if ( (LA2_3=='e') ) {
                    alt2=3;
                }
                else if ( (LA2_3=='a') ) {
                    alt2=9;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 3, input);

                    throw nvae;

                }
                }
                break;
            case 'y':
                {
                alt2=4;
                }
                break;
            case 's':
                {
                int LA2_5 = input.LA(2);

                if ( (LA2_5=='e') ) {
                    int LA2_13 = input.LA(3);

                    if ( (LA2_13=='m') ) {
                        alt2=5;
                    }
                    else if ( (LA2_13=='c') ) {
                        alt2=12;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 13, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 5, input);

                    throw nvae;

                }
                }
                break;
            case 'q':
                {
                alt2=6;
                }
                break;
            case 'w':
                {
                alt2=8;
                }
                break;
            case 'h':
                {
                alt2=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // TIMENruleGrammar.g:137:15: 'millennium'
                    {
                    match("millennium"); 



                    }
                    break;
                case 2 :
                    // TIMENruleGrammar.g:137:28: 'century'
                    {
                    match("century"); 



                    }
                    break;
                case 3 :
                    // TIMENruleGrammar.g:137:38: 'decade'
                    {
                    match("decade"); 



                    }
                    break;
                case 4 :
                    // TIMENruleGrammar.g:137:47: 'year'
                    {
                    match("year"); 



                    }
                    break;
                case 5 :
                    // TIMENruleGrammar.g:137:54: 'semester'
                    {
                    match("semester"); 



                    }
                    break;
                case 6 :
                    // TIMENruleGrammar.g:137:65: 'quarter'
                    {
                    match("quarter"); 



                    }
                    break;
                case 7 :
                    // TIMENruleGrammar.g:137:75: 'month'
                    {
                    match("month"); 



                    }
                    break;
                case 8 :
                    // TIMENruleGrammar.g:137:83: 'week'
                    {
                    match("week"); 



                    }
                    break;
                case 9 :
                    // TIMENruleGrammar.g:137:90: 'day'
                    {
                    match("day"); 



                    }
                    break;
                case 10 :
                    // TIMENruleGrammar.g:137:96: 'hour'
                    {
                    match("hour"); 



                    }
                    break;
                case 11 :
                    // TIMENruleGrammar.g:137:103: 'minute'
                    {
                    match("minute"); 



                    }
                    break;
                case 12 :
                    // TIMENruleGrammar.g:137:112: 'second'
                    {
                    match("second"); 



                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GRANULARITY"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:142:7: ( '\"' (~ '\"' )+ '\"' )
            // TIMENruleGrammar.g:142:9: '\"' (~ '\"' )+ '\"'
            {
            match('\"'); 

            // TIMENruleGrammar.g:142:13: (~ '\"' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '\u0000' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // TIMENruleGrammar.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            match('\"'); 

            state.text = getText().substring(1, getText().length()-1);

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:144:6: ( ( '+' | '-' )? ( '0' .. '9' )+ )
            // TIMENruleGrammar.g:144:8: ( '+' | '-' )? ( '0' .. '9' )+
            {
            // TIMENruleGrammar.g:144:8: ( '+' | '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='+'||LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // TIMENruleGrammar.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // TIMENruleGrammar.g:144:19: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // TIMENruleGrammar.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "SEPARATOR"
    public final void mSEPARATOR() throws RecognitionException {
        try {
            int _type = SEPARATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:146:11: ( ';' )
            // TIMENruleGrammar.g:146:14: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEPARATOR"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:148:8: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='/') ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1=='/') ) {
                    alt9=1;
                }
                else if ( (LA9_1=='*') ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // TIMENruleGrammar.g:148:13: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 



                    // TIMENruleGrammar.g:148:18: (~ ( '\\n' | '\\r' ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\t')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '\uFFFF')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // TIMENruleGrammar.g:
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    // TIMENruleGrammar.g:148:32: ( '\\r' )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='\r') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // TIMENruleGrammar.g:148:32: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // TIMENruleGrammar.g:148:63: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 



                    // TIMENruleGrammar.g:148:68: ( options {greedy=false; } : . )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='*') ) {
                            int LA8_1 = input.LA(2);

                            if ( (LA8_1=='/') ) {
                                alt8=2;
                            }
                            else if ( ((LA8_1 >= '\u0000' && LA8_1 <= '.')||(LA8_1 >= '0' && LA8_1 <= '\uFFFF')) ) {
                                alt8=1;
                            }


                        }
                        else if ( ((LA8_0 >= '\u0000' && LA8_0 <= ')')||(LA8_0 >= '+' && LA8_0 <= '\uFFFF')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // TIMENruleGrammar.g:148:96: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    match("*/"); 



                    _channel=HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:150:12: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // TIMENruleGrammar.g:150:15: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // TIMENruleGrammar.g:150:15: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= '\t' && LA10_0 <= '\n')||(LA10_0 >= '\f' && LA10_0 <= '\r')||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // TIMENruleGrammar.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    public void mTokens() throws RecognitionException {
        // TIMENruleGrammar.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | REFERENCE | GRANULARITY | STRING | INT | SEPARATOR | COMMENT | WHITESPACE )
        int alt11=32;
        switch ( input.LA(1) ) {
        case '(':
            {
            alt11=1;
            }
            break;
        case ')':
            {
            alt11=2;
            }
            break;
        case ',':
            {
            alt11=3;
            }
            break;
        case 'A':
            {
            int LA11_4 = input.LA(2);

            if ( (LA11_4=='D') ) {
                int LA11_19 = input.LA(3);

                if ( (LA11_19=='D') ) {
                    int LA11_23 = input.LA(4);

                    if ( (LA11_23=='_') ) {
                        alt11=5;
                    }
                    else {
                        alt11=4;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 19, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 4, input);

                throw nvae;

            }
            }
            break;
        case 'D':
            {
            int LA11_5 = input.LA(2);

            if ( (LA11_5=='A') ) {
                int LA11_20 = input.LA(3);

                if ( (LA11_20=='T') ) {
                    int LA11_24 = input.LA(4);

                    if ( (LA11_24=='E') ) {
                        int LA11_29 = input.LA(5);

                        if ( (LA11_29=='_') ) {
                            switch ( input.LA(6) ) {
                            case 'L':
                                {
                                alt11=6;
                                }
                                break;
                            case 'M':
                                {
                                int LA11_43 = input.LA(7);

                                if ( (LA11_43=='O') ) {
                                    int LA11_45 = input.LA(8);

                                    if ( (LA11_45=='N') ) {
                                        int LA11_47 = input.LA(9);

                                        if ( (LA11_47=='T') ) {
                                            int LA11_49 = input.LA(10);

                                            if ( (LA11_49=='H') ) {
                                                int LA11_51 = input.LA(11);

                                                if ( (LA11_51=='_') ) {
                                                    alt11=8;
                                                }
                                                else {
                                                    alt11=7;
                                                }
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 11, 49, input);

                                                throw nvae;

                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 11, 47, input);

                                            throw nvae;

                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 11, 45, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 11, 43, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case 'W':
                                {
                                int LA11_44 = input.LA(7);

                                if ( (LA11_44=='E') ) {
                                    int LA11_46 = input.LA(8);

                                    if ( (LA11_46=='E') ) {
                                        int LA11_48 = input.LA(9);

                                        if ( (LA11_48=='K') ) {
                                            int LA11_50 = input.LA(10);

                                            if ( (LA11_50=='D') ) {
                                                alt11=9;
                                            }
                                            else if ( (LA11_50=='N') ) {
                                                alt11=10;
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 11, 50, input);

                                                throw nvae;

                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 11, 48, input);

                                            throw nvae;

                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 11, 46, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 11, 44, input);

                                    throw nvae;

                                }
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 11, 39, input);

                                throw nvae;

                            }

                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 11, 29, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 24, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 20, input);

                    throw nvae;

                }
            }
            else if ( (LA11_5=='C') ) {
                int LA11_21 = input.LA(3);

                if ( (LA11_21=='T') ) {
                    switch ( input.LA(4) ) {
                    case 'D':
                        {
                        alt11=11;
                        }
                        break;
                    case 'M':
                        {
                        alt11=12;
                        }
                        break;
                    case 'Y':
                        {
                        alt11=13;
                        }
                        break;
                    default:
                        alt11=26;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 21, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 5, input);

                throw nvae;

            }
            }
            break;
        case 'F':
            {
            alt11=14;
            }
            break;
        case 'G':
            {
            alt11=15;
            }
            break;
        case 'I':
            {
            alt11=16;
            }
            break;
        case 'N':
            {
            alt11=17;
            }
            break;
        case 'P':
            {
            alt11=18;
            }
            break;
        case 'T':
            {
            int LA11_11 = input.LA(2);

            if ( (LA11_11=='O') ) {
                int LA11_22 = input.LA(3);

                if ( (LA11_22=='_') ) {
                    switch ( input.LA(4) ) {
                    case 'D':
                        {
                        int LA11_33 = input.LA(5);

                        if ( (LA11_33=='A') ) {
                            alt11=19;
                        }
                        else if ( (LA11_33=='E') ) {
                            alt11=20;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 11, 33, input);

                            throw nvae;

                        }
                        }
                        break;
                    case 'I':
                        {
                        alt11=21;
                        }
                        break;
                    case 'M':
                        {
                        alt11=22;
                        }
                        break;
                    case 'P':
                        {
                        alt11=23;
                        }
                        break;
                    case 'T':
                        {
                        alt11=24;
                        }
                        break;
                    case 'Y':
                        {
                        alt11=25;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 26, input);

                        throw nvae;

                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 22, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 11, input);

                throw nvae;

            }
            }
            break;
        case 'R':
            {
            alt11=26;
            }
            break;
        case 'c':
        case 'd':
        case 'h':
        case 'm':
        case 'q':
        case 's':
        case 'w':
        case 'y':
            {
            alt11=27;
            }
            break;
        case '\"':
            {
            alt11=28;
            }
            break;
        case '+':
        case '-':
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt11=29;
            }
            break;
        case ';':
            {
            alt11=30;
            }
            break;
        case '/':
            {
            alt11=31;
            }
            break;
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
            {
            alt11=32;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 11, 0, input);

            throw nvae;

        }

        switch (alt11) {
            case 1 :
                // TIMENruleGrammar.g:1:10: T__11
                {
                mT__11(); 


                }
                break;
            case 2 :
                // TIMENruleGrammar.g:1:16: T__12
                {
                mT__12(); 


                }
                break;
            case 3 :
                // TIMENruleGrammar.g:1:22: T__13
                {
                mT__13(); 


                }
                break;
            case 4 :
                // TIMENruleGrammar.g:1:28: T__14
                {
                mT__14(); 


                }
                break;
            case 5 :
                // TIMENruleGrammar.g:1:34: T__15
                {
                mT__15(); 


                }
                break;
            case 6 :
                // TIMENruleGrammar.g:1:40: T__16
                {
                mT__16(); 


                }
                break;
            case 7 :
                // TIMENruleGrammar.g:1:46: T__17
                {
                mT__17(); 


                }
                break;
            case 8 :
                // TIMENruleGrammar.g:1:52: T__18
                {
                mT__18(); 


                }
                break;
            case 9 :
                // TIMENruleGrammar.g:1:58: T__19
                {
                mT__19(); 


                }
                break;
            case 10 :
                // TIMENruleGrammar.g:1:64: T__20
                {
                mT__20(); 


                }
                break;
            case 11 :
                // TIMENruleGrammar.g:1:70: T__21
                {
                mT__21(); 


                }
                break;
            case 12 :
                // TIMENruleGrammar.g:1:76: T__22
                {
                mT__22(); 


                }
                break;
            case 13 :
                // TIMENruleGrammar.g:1:82: T__23
                {
                mT__23(); 


                }
                break;
            case 14 :
                // TIMENruleGrammar.g:1:88: T__24
                {
                mT__24(); 


                }
                break;
            case 15 :
                // TIMENruleGrammar.g:1:94: T__25
                {
                mT__25(); 


                }
                break;
            case 16 :
                // TIMENruleGrammar.g:1:100: T__26
                {
                mT__26(); 


                }
                break;
            case 17 :
                // TIMENruleGrammar.g:1:106: T__27
                {
                mT__27(); 


                }
                break;
            case 18 :
                // TIMENruleGrammar.g:1:112: T__28
                {
                mT__28(); 


                }
                break;
            case 19 :
                // TIMENruleGrammar.g:1:118: T__29
                {
                mT__29(); 


                }
                break;
            case 20 :
                // TIMENruleGrammar.g:1:124: T__30
                {
                mT__30(); 


                }
                break;
            case 21 :
                // TIMENruleGrammar.g:1:130: T__31
                {
                mT__31(); 


                }
                break;
            case 22 :
                // TIMENruleGrammar.g:1:136: T__32
                {
                mT__32(); 


                }
                break;
            case 23 :
                // TIMENruleGrammar.g:1:142: T__33
                {
                mT__33(); 


                }
                break;
            case 24 :
                // TIMENruleGrammar.g:1:148: T__34
                {
                mT__34(); 


                }
                break;
            case 25 :
                // TIMENruleGrammar.g:1:154: T__35
                {
                mT__35(); 


                }
                break;
            case 26 :
                // TIMENruleGrammar.g:1:160: REFERENCE
                {
                mREFERENCE(); 


                }
                break;
            case 27 :
                // TIMENruleGrammar.g:1:170: GRANULARITY
                {
                mGRANULARITY(); 


                }
                break;
            case 28 :
                // TIMENruleGrammar.g:1:182: STRING
                {
                mSTRING(); 


                }
                break;
            case 29 :
                // TIMENruleGrammar.g:1:189: INT
                {
                mINT(); 


                }
                break;
            case 30 :
                // TIMENruleGrammar.g:1:193: SEPARATOR
                {
                mSEPARATOR(); 


                }
                break;
            case 31 :
                // TIMENruleGrammar.g:1:203: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 32 :
                // TIMENruleGrammar.g:1:211: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;

        }

    }


 

}