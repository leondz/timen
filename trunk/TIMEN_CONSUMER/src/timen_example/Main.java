/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package timen_example;

import org.apache.commons.cli.*;

/**
 *
 * @author hector
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

                try {
            String lang = "en";
            String action = "normalize"; //default action
            String action_parameters = null;
            String input_files[];
            //Date ExecTime = new Date();


            Options opt = new Options();
            //addOption(String opt, boolean hasArg, String description)
            opt.addOption("h", "help", false, "Print this help");
            opt.addOption("l", "lang", true, "Language code (default \"EN\" [English])");
            opt.addOption("a", "action", true, "Action/s to be done (normalize, obtain knowledge-java from db)");
            //opt.addOption("ap", "action_parameters", true, "Optionally actions can have parameters (-a annotate -ap model=TIPSemB)");
            opt.addOption("d", "debug", false, "Debug mode: Output errors stack trace (default: disabled)");

            PosixParser parser = new PosixParser();
            CommandLine cl_options = parser.parse(opt, args);
            input_files = cl_options.getArgs();
            HelpFormatter hf = new HelpFormatter();
            if (cl_options.hasOption('h')) {
                hf.printHelp("TIMEN", opt);
                System.exit(0);
            } else {
                if (cl_options.hasOption('d')) {
                    System.setProperty("DEBUG", "true");
                }
                if (cl_options.hasOption('l')) {
                    lang = cl_options.getOptionValue('l').toLowerCase();
                    if (lang.length() != 2) {
                        hf.printHelp(Class.class.getName(), opt);
                        throw new Exception("Error: incorrect language " + lang+ " -- must be 2 chars");
                    }
                }
                if (cl_options.hasOption('a')) {
                    action = cl_options.getOptionValue("a");
                    try {
                        OptionHandler.Action.valueOf(action.toUpperCase());
                    } catch (Exception e) {
                        String errortext = "\nValid acctions are:\n";
                        for (OptionHandler.Action c : OptionHandler.Action.values()) {
                            errortext += "\t" + c.name() + "\n";
                        }
                        throw new RuntimeException("\tIlegal action: " + action.toUpperCase() + "\n" + errortext);
                    }
                }
            }


            if (input_files == null){
                hf.printHelp("TIMEN", opt);
                throw new Exception("Input file/s not found.");
            }

            //System.err.println("TIMEN Will normalize these files after checking correct format.");
            // Default action: get pattern/normval
            // Other function --> directly normalize (TIPSem pat/nom already built)
            // Other action --> from knowledge_lang.db to knowledge_lang.java
            OptionHandler.doAction(action, input_files, action_parameters, lang);

            // TEST DB TODO DELETE
            //TIMEN.showDBcontents(lang);


        } catch (Exception e) {
            System.err.println("Errors found:\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
            }
            System.exit(1);
        }

    }

}
