package org.timen.timen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;
import org.timen.timen.knowledge.time.Timek;
import org.timen.timen.utils.CognitionisFileUtils;

/**
 * Default entry point for basic functionality testing
 *
 * @author hector
 */
public class Main {


    public static enum Action {
        GET_PATTERN, NORMALIZE, FIND_RESOURCE
    };

    public static void main(String[] args) {
        try {
            String lang = "en";
            String country = "US";
            String action = "none";
            String action_parameters = null;
            String input_files[];
            String input_text = null;

            // Probably UIMA does this Even Pipelines
            // UIMA: Extract some text from some XML tag, process this and that, output it in format X...

            Options opt = new Options();
            //addOption(String opt, boolean hasArg, String description)
            opt.addOption("h", "help", false, "Print this help");
            opt.addOption("l", "lang", true, "Language locale (default \"en_US\" [English])");
            opt.addOption("a", "action", true, "Action/s to be done (tokenize, tag, parse, ...)");
            opt.addOption("ap", "action_parameters", true, "Optionally actions can have parameters (-a NORMALIZE -ap dct=1999-09-09,tense={past,present,future,omit})");
            opt.addOption("t", "text", true, "To use text instead of a file (for short texts)");
            opt.addOption("d", "debug", false, "Debug mode: Output errors stack trace (default: disabled)");
            PosixParser parser = new PosixParser();
            CommandLine cl_options = parser.parse(opt, args);
            input_files = cl_options.getArgs();
            HelpFormatter hf = new HelpFormatter();
            if (cl_options.hasOption('h')) {
                hf.printHelp("Help", opt);
                System.exit(0);
            } else {
                if (cl_options.hasOption('d')) {
                    System.setProperty("DEBUG", "true");
                }
                if (cl_options.hasOption('l')) {
                    String l = cl_options.getOptionValue('l').toLowerCase();
                    if (l.length() != 5) {
                        hf.printHelp("Help", opt);
                        throw new Exception("Error: incorrect locale " + l + " -- must be 5 chars (e.g., en-US)");
                    } else {
                        lang = l.substring(0, 2).toLowerCase();
                        country = l.substring(3).toUpperCase();
                    }
                }
                if (cl_options.hasOption('a')) {
                    action = cl_options.getOptionValue("a");
                    try {
                        Action.valueOf(action.toUpperCase());
                    } catch (Exception e) {
                        String errortext = "\nValid acctions are:\n";
                        for (Action c : Action.values()) {
                            errortext += "\t" + c.name() + "\n";
                        }
                        throw new RuntimeException("\tIlegal action: " + action.toUpperCase() + "\n" + errortext);
                    }
                    if (cl_options.hasOption("ap")) {
                        action_parameters = cl_options.getOptionValue("ap");
                    }
                    if (cl_options.hasOption("t")) {
                        input_text = cl_options.getOptionValue("t");
                    }
                } else {
                    hf.printHelp("Help", opt);
                    String errortext = "\nValid acctions are:\n";
                    for (Action c : Action.values()) {
                        errortext += "\t" + c.name() + "\n";
                    }
                    throw new IOException("\nError: No action specified." + errortext);
                }
            }

            if ((input_text == null || input_text.length() == 0) && input_files.length == 0) {
                throw new Exception("No input files or input text found");
            }
            if (input_text != null && input_files.length != 0) {
                throw new Exception("Only one input type allowed: input text or input file/s");
            }

            for (int i = 0; i < input_files.length; i++) {
                File f = new File(input_files[i]);
                if (!f.exists()) {
                    throw new FileNotFoundException("File does not exist: " + f);
                }
                if (!f.isFile()) {
                    throw new IllegalArgumentException("Should not be a directory: " + f);
                }
                String file_encoding = CognitionisFileUtils.getEncoding(f);
                if (!CognitionisFileUtils.checkEncoding(file_encoding, "(ASCII|UTF-8)")) {
                    throw new Exception("Error: " + f + " has an unsupported encoding " + file_encoding + " (must be (ASCII|UTF-8))");
                }
            }
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                System.err.println("ExecPath: " + CognitionisFileUtils.getExecutionPath());
                System.err.println("ApplicationPath: " + CognitionisFileUtils.getApplicationPath());
                System.err.println("\n\nDoing action: " + action.toUpperCase() + "\n------------");
                System.err.println("\n\n");
            }

            if(input_files.length!=0)
                doAction(action, input_files, action_parameters, lang, country);
            if(input_text!=null)
                doAction(action, input_text, action_parameters, lang, country);

        } catch (Exception e) {
            System.err.println("\nErrors found:\n\t" + e.getMessage() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
            }
            System.exit(1);
        }
    }


    /**
     * Obtain the value of one parameter of ap parameters
     * @param params    the params string
     * @param param     the parameter we need the value from
     * @return          the value of the parameter param
     */
    public static String getParameter(String params, String param) {
        String paramValue = null;
        if (params != null && params.contains(param)) {
            if (params.matches(".*" + param + "=[^,]*,.*")) {
                paramValue = params.substring(params.lastIndexOf(param + "=") + param.length() + 1, params.indexOf(',', params.lastIndexOf(param + "=")));
            } else {
                if (params.matches(".*" + param + "=[^,]*")) {
                    paramValue = params.substring(params.lastIndexOf(param + "=") + param.length() + 1);
                }
            }
        }
        return paramValue;
    }
    
    public static void doAction(String action, String[] input_files, String action_parameters, String lang, String country) {
        try {
            switch (Action.valueOf(action.toUpperCase())) {
                case FIND_RESOURCE: {
                    System.out.println("find resource with file. Under construction.\n\n");
                }
                break;

                default:{
                    System.out.println(action.toUpperCase()+" with input_file not supported yet.\n\n");
                }                    
                break;
            }

        } catch (Exception e) {
            System.err.println("\nErrors found:\n\t" + e.toString() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }
    }

    public static void doAction(String action, String input_text, String action_parameters, String lang, String country) {
        try {
            switch (Action.valueOf(action.toUpperCase())) {
                case GET_PATTERN: {
                    Timek tiki = new Timek(new Locale(lang, country),"knowledge-bases");
                    System.out.println(tiki.getNormTextandPattern(input_text));
                }
                break;
                case NORMALIZE: {
                    /* Set DCT */
                    String dctvalue = getParameter(action_parameters, "dct");
                    if (dctvalue == null) {
                        dctvalue = TIMEN.dct_format.format(new Date());
                    }
                    /* Set tense parameter */
                    String tense = getParameter(action_parameters, "tense");
                    if (tense == null) {
                        tense = "omit";
                    }
                    String ref_datevalue = getParameter(action_parameters, "ref_date");
                    if (ref_datevalue == null) {
                        ref_datevalue = dctvalue;
                    }
                    TIMEN timen = new TIMEN(new Locale(lang, country));
                    System.out.println(timen.normalize(input_text,dctvalue, tense, ref_datevalue));
                }
                break;
                case FIND_RESOURCE: {
                    System.out.println("Silly with text (e.g., jar:file:/home/hector/timen/TIMEN/target/timen-1.0.16-SNAPSHOT.jar!/knowledge-bases/time/)");
                    
                    //RULEBASES
                    URL url=CognitionisFileUtils.class.getClassLoader().getResource("rule-bases");
                    if(url!=null){
                        System.out.println(url.toString()+" - URI: "+url.toURI().toString()+"  - file:  "+url.getFile());                  
                        if(CognitionisFileUtils.URL_exists(url.toString())){
                            System.out.println("EXISTS");
                        }else{
                            System.out.println("does not exist");
                        }
                    }
                    
                    // RANDOM INPUT TEXT
                    System.out.println("Finding resource with text (testing: "+input_text);
                    input_text=CognitionisFileUtils.ensureURL(input_text);
                    if(CognitionisFileUtils.URL_exists(input_text)){
                        url=new URL(input_text);
                        System.out.println(url.toString()+" - URI: "+url.toURI().toString()+"  - file:  "+url.getFile());                  
                        System.out.println("EXISTS");
                        // intentar leer contenido
                    }else{
                        System.out.println("does not exist "+input_text);
                    }
                }
                break;                  
                default:{
                    System.out.println(action.toUpperCase()+" with text input not supported yet.\n\n");
                }                    
                break;
            }

        } catch (Exception e) {
            System.err.println("\nErrors found:\n\t" + e.toString() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }
    }
}