package Rules;

import TIMEN.*;
import com.almworks.sqlite4java.*;
import grammar.*;
import java.io.*;
import org.antlr.runtime.*;

/**
 *
 * @author hector
 */
public class Rule_Engine {

    public static boolean check_rule_db(SQLiteConnection db) {
        // bucle loop load each rule and run rule.is_well_formed
        return false;
    }

    /**
     * Appy a valid rule:
     *
     * The language has different variables and keywords to read
     *
     * @param rule
     * @param normText
     * @param tense
     * @param dct
     * @param ref_val
     * @return
     */
    public static String apply(Rule rule, TIMEN timen_object, TIMEX_Instance timex_object) {
        String result = "";

        try {

        ANTLRInputStream rule_input = new ANTLRInputStream(new ByteArrayInputStream((rule.get_rule()).getBytes("UTF-8")));
        TIMENruleGrammarLexer rule_lexer = new TIMENruleGrammarLexer(rule_input);
        CommonTokenStream rule_tokens = new CommonTokenStream(rule_lexer);
        TIMENruleGrammarParser rule_parser = new TIMENruleGrammarParser(rule_tokens);

            switch (Rule.NormTaxonomy.valueOf(rule.get_rule_type())) {
                case explicit: {
                    result=rule_parser.run(timen_object, timex_object);
                }
                break;

                case implicit_deictic: {
                    result=rule_parser.run(timen_object, timex_object);
                }
                break;

                case implicit_anaphoric: {
                }
                break;

                case durative: {
                    result=rule_parser.run(timen_object, timex_object);
                }
                break;

                case set: {
                }
                break;

                case vague: {
                }
                break;

            }
        } catch (Exception e) {
            System.err.println("Errors found (Rule_Engine):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
            }
            System.exit(1);
        }
        return result;
    }

    /*
    public static String parse_explicit(String rule, String[] normtextarr) {
        String result = "";
        try {
            // variable or function
            if (rule.matches("PAT\\([0-9]+\\)")) {
                return normtextarr[Integer.parseInt(rule.substring(4, rule.length()-1))];
            }else{
                int splitpos=rule.indexOf('(');
                String func=rule.substring(0, splitpos);
                String params = rule.substring(splitpos+1, rule.length()-1);
                System.out.println(func+" ---> "+params);
                if(params.length()>0){
                    //Let's use ANTRL3
                }
            }
        } catch (Exception e) {
            System.err.println("Errors found (Rule_Engine):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
            }
            System.exit(1);
        }


        return result;
    }
*/
    
    public static String to_year(String Num) {
        return null;
    }
}