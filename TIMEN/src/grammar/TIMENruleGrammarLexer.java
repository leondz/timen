// $ANTLR 3.4 TIMENruleGrammar.g 2011-10-04 01:43:23
package grammar;

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
            // TIMENruleGrammar.g:4:7: ( '\"' )
            // TIMENruleGrammar.g:4:9: '\"'
            {
            match('\"'); 

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
            // TIMENruleGrammar.g:5:7: ( '(' )
            // TIMENruleGrammar.g:5:9: '('
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
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:6:7: ( ')' )
            // TIMENruleGrammar.g:6:9: ')'
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:7:7: ( ',' )
            // TIMENruleGrammar.g:7:9: ','
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:8:7: ( 'ADD' )
            // TIMENruleGrammar.g:8:9: 'ADD'
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:9:7: ( 'DATE_TENSE_WEEKDAY' )
            // TIMENruleGrammar.g:9:9: 'DATE_TENSE_WEEKDAY'
            {
            match("DATE_TENSE_WEEKDAY"); 



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
            // TIMENruleGrammar.g:10:7: ( 'DCTDAY' )
            // TIMENruleGrammar.g:10:9: 'DCTDAY'
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:11:7: ( 'DCTMONTH' )
            // TIMENruleGrammar.g:11:9: 'DCTMONTH'
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:12:7: ( 'DCTYEAR' )
            // TIMENruleGrammar.g:12:9: 'DCTYEAR'
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:13:7: ( 'INT(' )
            // TIMENruleGrammar.g:13:9: 'INT('
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:14:7: ( 'NEGATIVEINT(' )
            // TIMENruleGrammar.g:14:9: 'NEGATIVEINT('
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
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:15:7: ( 'PAT' )
            // TIMENruleGrammar.g:15:9: 'PAT'
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:16:7: ( 'TO_PERIOD' )
            // TIMENruleGrammar.g:16:9: 'TO_PERIOD'
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
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:17:7: ( 'TO_YEAR' )
            // TIMENruleGrammar.g:17:9: 'TO_YEAR'
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
    // $ANTLR end "T__24"

    // $ANTLR start "REFERENCE"
    public final void mREFERENCE() throws RecognitionException {
        try {
            int _type = REFERENCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TIMENruleGrammar.g:80:10: ( ( 'DCT' | 'REFTIME' ) )
            // TIMENruleGrammar.g:80:12: ( 'DCT' | 'REFTIME' )
            {
            // TIMENruleGrammar.g:80:12: ( 'DCT' | 'REFTIME' )
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
                    // TIMENruleGrammar.g:80:13: 'DCT'
                    {
                    match("DCT"); 



                    }
                    break;
                case 2 :
                    // TIMENruleGrammar.g:80:19: 'REFTIME'
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
            // TIMENruleGrammar.g:82:12: ( ( 'millennium' | 'century' | 'decade' | 'year' | 'semester' | 'quarter' | 'month' | 'week' | 'day' | 'hour' | 'minute' | 'second' ) )
            // TIMENruleGrammar.g:82:14: ( 'millennium' | 'century' | 'decade' | 'year' | 'semester' | 'quarter' | 'month' | 'week' | 'day' | 'hour' | 'minute' | 'second' )
            {
            // TIMENruleGrammar.g:82:14: ( 'millennium' | 'century' | 'decade' | 'year' | 'semester' | 'quarter' | 'month' | 'week' | 'day' | 'hour' | 'minute' | 'second' )
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
                    // TIMENruleGrammar.g:82:15: 'millennium'
                    {
                    match("millennium"); 



                    }
                    break;
                case 2 :
                    // TIMENruleGrammar.g:82:28: 'century'
                    {
                    match("century"); 



                    }
                    break;
                case 3 :
                    // TIMENruleGrammar.g:82:38: 'decade'
                    {
                    match("decade"); 



                    }
                    break;
                case 4 :
                    // TIMENruleGrammar.g:82:47: 'year'
                    {
                    match("year"); 



                    }
                    break;
                case 5 :
                    // TIMENruleGrammar.g:82:54: 'semester'
                    {
                    match("semester"); 



                    }
                    break;
                case 6 :
                    // TIMENruleGrammar.g:82:65: 'quarter'
                    {
                    match("quarter"); 



                    }
                    break;
                case 7 :
                    // TIMENruleGrammar.g:82:75: 'month'
                    {
                    match("month"); 



                    }
                    break;
                case 8 :
                    // TIMENruleGrammar.g:82:83: 'week'
                    {
                    match("week"); 



                    }
                    break;
                case 9 :
                    // TIMENruleGrammar.g:82:90: 'day'
                    {
                    match("day"); 



                    }
                    break;
                case 10 :
                    // TIMENruleGrammar.g:82:96: 'hour'
                    {
                    match("hour"); 



                    }
                    break;
                case 11 :
                    // TIMENruleGrammar.g:82:103: 'minute'
                    {
                    match("minute"); 



                    }
                    break;
                case 12 :
                    // TIMENruleGrammar.g:82:112: 'second'
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
            // TIMENruleGrammar.g:84:7: ( ( '-' | 'P' ) )
            // TIMENruleGrammar.g:
            {
            if ( input.LA(1)=='-'||input.LA(1)=='P' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


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
            // TIMENruleGrammar.g:86:6: ( ( '+' | '-' )? ( '0' .. '9' )+ )
            // TIMENruleGrammar.g:86:8: ( '+' | '-' )? ( '0' .. '9' )+
            {
            // TIMENruleGrammar.g:86:8: ( '+' | '-' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='+'||LA3_0=='-') ) {
                alt3=1;
            }
            switch (alt3) {
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


            // TIMENruleGrammar.g:86:19: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                    alt4=1;
                }


                switch (alt4) {
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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
            // TIMENruleGrammar.g:88:11: ( ';' )
            // TIMENruleGrammar.g:88:14: ';'
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
            // TIMENruleGrammar.g:90:8: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='/') ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1=='/') ) {
                    alt8=1;
                }
                else if ( (LA8_1=='*') ) {
                    alt8=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // TIMENruleGrammar.g:90:13: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 



                    // TIMENruleGrammar.g:90:18: (~ ( '\\n' | '\\r' ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0 >= '\u0000' && LA5_0 <= '\t')||(LA5_0 >= '\u000B' && LA5_0 <= '\f')||(LA5_0 >= '\u000E' && LA5_0 <= '\uFFFF')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
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
                    	    break loop5;
                        }
                    } while (true);


                    // TIMENruleGrammar.g:90:32: ( '\\r' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='\r') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // TIMENruleGrammar.g:90:32: '\\r'
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
                    // TIMENruleGrammar.g:90:63: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 



                    // TIMENruleGrammar.g:90:68: ( options {greedy=false; } : . )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='*') ) {
                            int LA7_1 = input.LA(2);

                            if ( (LA7_1=='/') ) {
                                alt7=2;
                            }
                            else if ( ((LA7_1 >= '\u0000' && LA7_1 <= '.')||(LA7_1 >= '0' && LA7_1 <= '\uFFFF')) ) {
                                alt7=1;
                            }


                        }
                        else if ( ((LA7_0 >= '\u0000' && LA7_0 <= ')')||(LA7_0 >= '+' && LA7_0 <= '\uFFFF')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // TIMENruleGrammar.g:90:96: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
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
            // TIMENruleGrammar.g:92:12: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // TIMENruleGrammar.g:92:15: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // TIMENruleGrammar.g:92:15: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= '\t' && LA9_0 <= '\n')||(LA9_0 >= '\f' && LA9_0 <= '\r')||LA9_0==' ') ) {
                    alt9=1;
                }


                switch (alt9) {
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
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
        // TIMENruleGrammar.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | REFERENCE | GRANULARITY | STRING | INT | SEPARATOR | COMMENT | WHITESPACE )
        int alt10=21;
        switch ( input.LA(1) ) {
        case '\"':
            {
            alt10=1;
            }
            break;
        case '(':
            {
            alt10=2;
            }
            break;
        case ')':
            {
            alt10=3;
            }
            break;
        case ',':
            {
            alt10=4;
            }
            break;
        case 'A':
            {
            alt10=5;
            }
            break;
        case 'D':
            {
            int LA10_6 = input.LA(2);

            if ( (LA10_6=='A') ) {
                alt10=6;
            }
            else if ( (LA10_6=='C') ) {
                int LA10_19 = input.LA(3);

                if ( (LA10_19=='T') ) {
                    switch ( input.LA(4) ) {
                    case 'D':
                        {
                        alt10=7;
                        }
                        break;
                    case 'M':
                        {
                        alt10=8;
                        }
                        break;
                    case 'Y':
                        {
                        alt10=9;
                        }
                        break;
                    default:
                        alt10=15;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 19, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 6, input);

                throw nvae;

            }
            }
            break;
        case 'I':
            {
            alt10=10;
            }
            break;
        case 'N':
            {
            alt10=11;
            }
            break;
        case 'P':
            {
            int LA10_9 = input.LA(2);

            if ( (LA10_9=='A') ) {
                alt10=12;
            }
            else {
                alt10=17;
            }
            }
            break;
        case 'T':
            {
            int LA10_10 = input.LA(2);

            if ( (LA10_10=='O') ) {
                int LA10_22 = input.LA(3);

                if ( (LA10_22=='_') ) {
                    int LA10_24 = input.LA(4);

                    if ( (LA10_24=='P') ) {
                        alt10=13;
                    }
                    else if ( (LA10_24=='Y') ) {
                        alt10=14;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 24, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 22, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 10, input);

                throw nvae;

            }
            }
            break;
        case 'R':
            {
            alt10=15;
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
            alt10=16;
            }
            break;
        case '-':
            {
            int LA10_13 = input.LA(2);

            if ( ((LA10_13 >= '0' && LA10_13 <= '9')) ) {
                alt10=18;
            }
            else {
                alt10=17;
            }
            }
            break;
        case '+':
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
            alt10=18;
            }
            break;
        case ';':
            {
            alt10=19;
            }
            break;
        case '/':
            {
            alt10=20;
            }
            break;
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
            {
            alt10=21;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 10, 0, input);

            throw nvae;

        }

        switch (alt10) {
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
                // TIMENruleGrammar.g:1:94: REFERENCE
                {
                mREFERENCE(); 


                }
                break;
            case 16 :
                // TIMENruleGrammar.g:1:104: GRANULARITY
                {
                mGRANULARITY(); 


                }
                break;
            case 17 :
                // TIMENruleGrammar.g:1:116: STRING
                {
                mSTRING(); 


                }
                break;
            case 18 :
                // TIMENruleGrammar.g:1:123: INT
                {
                mINT(); 


                }
                break;
            case 19 :
                // TIMENruleGrammar.g:1:127: SEPARATOR
                {
                mSEPARATOR(); 


                }
                break;
            case 20 :
                // TIMENruleGrammar.g:1:137: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 21 :
                // TIMENruleGrammar.g:1:145: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;

        }

    }


 

}