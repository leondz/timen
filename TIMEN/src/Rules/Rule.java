
package Rules;

/**
 *
 * @author hector
 */
public class Rule {
    private int id;
    private String pattern;
    private String rule_type;
    private String rule_condition;
    private String rule;

    public static enum NormTaxonomy {
        explicit, implicit_deictic,implicit_anaphoric,durative,set,vague;
    }

    // constructor
    public Rule(int i, String p, String rt, String r, String rc){
        try{
        id=i;
        pattern=p; // TODO check syntax
        rule_type=rt;
        rule=r;
        rule_condition=rc;

        } catch (Exception e) {
            System.err.println("Errors found (" + this.getClass().getSimpleName() + "):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
            }
            System.exit(1);
        }


    }


    public int get_id(){
        return id;
    }

    public String get_pattern(){
        return pattern;
    }

    public String get_rule(){
        return rule;
    }

    public String get_rule_type(){
        return rule_type;
    }

    public String get_rule_condition(){
        return rule_condition;
    }

    public boolean is_well_formed(){
        try{
            if(rule_type==null || rule==null || rule.length()<1){
                throw new Exception("Null pattern, rule_type, or rule.");
            }
            NormTaxonomy.valueOf(rule_type);
            // Check syntax and correspondence between patern, rule, conditions
            return true;
        } catch (Exception e) {
            System.err.println("Malformed rule (" + this.getClass().getSimpleName() + "):\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
            }
            return false;
        }
    }

}
