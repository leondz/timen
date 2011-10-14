/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timen_example;

import FeatureBuilder.*;
import TIMEN.TIMEN;
import TimeML_BasicKit.TML_file_utils;
import java.io.*;
import java.util.*;
import nlp_files.*;
import utils_bk.*;

/** @author Hector Llorens */
public class OptionHandler {

    public static enum Action {

        NORMALIZE, NORMALIZE_WNORMTEXTPAT,
        CREATE_KNOWLEDGE_FILE,
        OBTAIN_INPUT_FROM_TML;
    }
    private static TIMEN timen;

    /**
     * Obtain the value of one parameter of ap paramenters
     * @param params    the params string
     * @param param     the parameter we need the value from
     * @return          the value of the parameter param
     */
    /*
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
     */
    public static void doAction(String action, String[] input_files, String action_parameters, String lang) {

        try {
            System.err.println("\n\nDoing action: " + action.toUpperCase() + "\n------------");
            switch (Action.valueOf(action.toUpperCase())) {


                case NORMALIZE: {
                    /*String include_test = getParameter(action_parameters, "include_test");
                    boolean itest = true;
                    if (include_test == null || include_test.equalsIgnoreCase("false")) {
                    itest = false;
                    }*/
                    timen = new TIMEN(new Locale(lang));
                    for (int i = 0; i < input_files.length; i++) {
                        File input_file = new File(input_files[i]);
                        if (!input_file.exists()) {
                            throw new FileNotFoundException("File does not exist: " + input_file);
                        }

                        if (!input_file.isFile()) {
                            throw new IllegalArgumentException("File must be a regular file: " + input_file);
                        }

                        normalize(input_file, input_file.getCanonicalPath() + ".normalized");

                    }
                }
                break;

                /*                case NORMALIZE_WNORMTEXTPAT: {
                timen = new TIMEN(new Locale(lang));
                for (int i = 0; i < input_files.length; i++) {
                File input_file = new File(input_files[i]);
                if (!input_file.exists()) {
                throw new FileNotFoundException("File does not exist: " + input_file);
                }

                if (!input_file.isFile()) {
                throw new IllegalArgumentException("File must be a regular file: " + input_file);
                }

                normalize_file_with_normtextpat(input_file, input_file.getCanonicalPath() + ".normalized");

                }
                }
                break;*/

                case CREATE_KNOWLEDGE_FILE: {
                    /*
                     * This creates a knowledge_XX.java file from SQLite knowledge dbs where XX is the language code
                     */
                }
                break;


                case OBTAIN_INPUT_FROM_TML: {
                    for (int i = 0; i < input_files.length; i++) {
                        File input_file = new File(input_files[i]);
                        if (!input_file.exists()) {
                            throw new FileNotFoundException("File does not exist: " + input_file);
                        }

                        if (!input_file.isFile()) {
                            throw new IllegalArgumentException("File must be a regular file: " + input_file);
                        }

                        XMLFile xmlfile = new XMLFile();
                        xmlfile.loadFile(input_file);
                        xmlfile.setLanguage(lang);
                        if (!xmlfile.getExtension().equalsIgnoreCase("tml")) {
                            throw new Exception("TimeML (.tml) XML file is required as input.");
                        }
                        if (!xmlfile.isWellFormed()) {
                            throw new Exception("File: " + xmlfile.getFile() + " is not a valid TimeML (.tml) XML file.");
                        }


                        // Create a working directory
                        File dir = new File(input_file.getCanonicalPath() + "-TIPSemB-dataset/");
                        if (!dir.exists() || !dir.isDirectory()) {
                            dir.mkdir();
                        }

                        // Copy the valid TML-XML file
                        String output = dir + "/" + input_file.getName();
                        FileUtils.copyFileUtil(input_file, new File(output));
                        xmlfile.loadFile(new File(output));


                        // get plain
                        String plainfile = xmlfile.toPlain();

                        String features = null;
                        features = BaseTokenFeatures.getFeatures4Plain(lang, plainfile, 1, false, "TempEval2-features", "TIPSemB");
                        TML_file_utils.tml2dataset4model(xmlfile, features);


                        // add TempEval2 features
                        output = TempEvalFiles.merge_extents(dir.getCanonicalPath() + "/" + input_file.getName() + ".plain.TempEval2-features", dir + "/timex-extents.tab", "timex");
                        features = TempEvalFiles.merge_attribs(output, dir + "/timex-attributes.tab", "timex");
                        output = Classification.get_classik(features, lang);
                        output = TimexNormalization.getTIMEN(features, output, lang);
                        output = TimexNormalization.get_key_normalized_values(output);

                        String outputfile = FileUtils.getFolder(input_file.getCanonicalPath()) + "/" + input_file.getName() + ".TIMEN_complete";
                        FileUtils.copyFileUtil(new File(output), new File(outputfile));


                        String[] command = {"/bin/sh", "-c", "cut -f 1,4,5,6,9,10,12,13,22,23 -d \"|\" \"" + outputfile + "\""};
                        Process p = Runtime.getRuntime().exec(command);
                        String line;
                        BufferedWriter outputf = new BufferedWriter(new FileWriter(new File(outputfile + ".tnf")));
                        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        try {
                            while ((line = stdInput.readLine()) != null) {
                                outputf.write(line + "\n");
                            }
                        } finally {
                            if (stdInput != null) {
                                stdInput.close();
                            }
                            if (output != null) {
                                outputf.close();
                            }
                            
                            if (p != null) {
                                p.getInputStream().close();
                                p.getOutputStream().close();
                                p.getErrorStream().close();
                                p.destroy();
                            }
                        }

                        String[] command2 = {"/bin/sh", "-c", "cut -f 1,4,5,6,9,10,12,13,22,23,27 -d \"|\" \"" + outputfile + "\""};
                        Process p2 = Runtime.getRuntime().exec(command2);
                        outputf = new BufferedWriter(new FileWriter(new File(outputfile + ".tnf_key")));
                        stdInput = new BufferedReader(new InputStreamReader(p2.getInputStream()));
                        try {
                            while ((line = stdInput.readLine()) != null) {
                                outputf.write(line + "\n");
                            }
                        } finally {
                            p2.waitFor();
                            if (stdInput != null) {
                                stdInput.close();
                            }
                            if (output != null) {
                                outputf.close();
                            }
                            if (p2 != null) {
                                p2.getInputStream().close();
                                p2.getOutputStream().close();
                                p2.getErrorStream().close();
                                p2.destroy();
                            }
                        }


                        FileUtils.deleteRecursively(dir);

                    }

                }
                break;
            }

        } catch (Exception e) {
            System.err.println("\nErrors found (ActionHandler):\n\t" + e.toString() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
            //throw new RuntimeException("\tAction: " + action.toUpperCase());
        }

    }

    /**
     *
     * Normalize each line of a .tnf file (timex normalization file) with the following format adding a new piped column
     * with the ISO8601 value in a file called outfile
     *
     * word|pos|lemma|depverb|tense|mainphrase|PPdetail|te-type|DCT|ref-val|value
     *
     *
     * word:		timex tokens separated by "_"
     * pos:		timex POSs separated by "_"
     * lemma:		timex lemmas separated by "_"
     * depverb:         timex governing-verb
     * tense:           timex governing-verb tense
     * mainphrase:	timex governing main-phrase (NP-PP-ADVP-ADJP)
     * PPdetail:	timex prepositional modiviers (in PP phrases: in, on, for, during...)
     * te-type:         timex TimeML type (optional: leave as "ukwn" if unknown)
     * DCT:		Document Creation Time in ISO8601 format
     * DEPRECATED - ref-val:  Previous date/time-timex focus (temporal reference) (i.e., reference point time-location)
     *                          NOW IS HANDLED BY THE CONSUMER
     * value:		Normalization ISO8601 value for evaluation purposes (optional: leave as "ukwnl" if unknown)
     *                      CURRENTLY UNUSED
     *
     * @param input_file
     * @param output_file
     *
     */
    public static void normalize(File input_file, String output_file) {
        try {
            int linen = 0;
            BufferedWriter outfile = new BufferedWriter(new FileWriter(output_file));
            BufferedReader pipesreader = new BufferedReader(new FileReader(input_file));
            String pipesline = null;
            String[] pipesarr = null;
            String ref_val = "0000-00-00";
            String fileid = "currently-unkonwn-id";
            try {
                while ((pipesline = pipesreader.readLine()) != null) {
                    pipesarr = pipesline.split("\\|");
                    linen++;
                    if (pipesarr.length >= 10) {
                        if (!fileid.equals(pipesarr[0])) {
                            ref_val = "0000-00-00";
                        }
                        fileid = pipesarr[0];
                        String word = pipesarr[1];
                        String pos = pipesarr[2];
                        String lemma = pipesarr[3];
                        String depverb = pipesarr[4];
                        String tense = pipesarr[5];
                        String mainphrase = pipesarr[6];
                        String ppdetail = pipesarr[7];
                        String timex_type = pipesarr[8];
                        String dct = pipesarr[9];
                        //String ref_val=pipesarr[9];
                        if (ref_val.equals("0000-00-00")) {
                            ref_val = dct;
                        }

                        String normTextandPattern = timen.getNormTextandPattern(word);
                        if (normTextandPattern == null) {
                            throw new Exception("Problem obtaining NormText and Pattern from: " + word);
                        }
                        String[] normTextandPattern_arr = normTextandPattern.split("\\|");
                        String norm_value = timen.normalize(word, pos, lemma, depverb, tense, mainphrase, ppdetail, timex_type, normTextandPattern_arr[0], normTextandPattern_arr[1], dct, ref_val);
                        outfile.write(pipesline + "|" + norm_value + "\n");
                    }
                }
            } finally {
                if (pipesreader != null) {
                    pipesreader.close();
                }
                if (outfile != null) {
                    outfile.close();
                }
            }

        } catch (Exception e) {
            System.err.println("\nErrors found (ActionHandler):\n\t" + e.toString() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }
    }
    /**
     *
     * Normalize each line of a .tnf file (timex normalization file) with the following format adding a new piped column
     * with the ISO8601 value in a file called outfile
     *
     * word|pos|lemma|depverb|tense|mainphrase|PPdetail|te-numval|te-pattern|te-type|DCT|ref-val|value
     *
     * word:		timex tokens separated by "_"
     * pos:		timex POSs separated by "_"
     * lemma:		timex lemmas separated by "_"
     * depverb:         timex governing-verb
     * tense:           timex governing-verb tense
     * mainphrase:	timex governing main-phrase (NP-PP-ADVP-ADJP)
     * PPdetail:	timex prepositional modiviers (in PP phrases: in, on, for, during...)
     * te-numval:	timex TIMEN standard format (spelled numbers to numbers, token separation...)
     * te-pattern:	timex TIMEN pattern
     * te-type:         timex TimeML type (optional: leave as "ukwn" if unknown)
     * DCT:		Document Creation Time in ISO8601 format
     * DEPRECATED - ref-val:  Previous date/time-timex focus (temporal reference) (i.e., reference point time-location)
     *                          NOW IS HANDLED BY THE CONSUMER
     * value:		Normalization ISO8601 value for evaluation purposes (optional: leave as "ukwnl" if unknown)
     *                          CURRENTLY UNUSED
     * @param input_file
     * @param output_file
     *
     */
    /*    public static void normalize_file_with_normtextpat(File input_file, String output_file) {
    try {
    int linen = 0;
    BufferedWriter outfile = new BufferedWriter(new FileWriter(output_file));
    BufferedReader pipesreader = new BufferedReader(new FileReader(input_file));
    String pipesline = null;
    String[] pipesarr = null;
    String ref_val = "0000-00-00";
    String fileid = "currently-unkonwn-id";
    try {
    while ((pipesline = pipesreader.readLine()) != null) {
    pipesarr = pipesline.split("\\|");
    linen++;
    if (pipesarr.length >= 12) {
    if (!fileid.equals(pipesarr[0])) {
    ref_val = "0000-00-00";
    }
    fileid = pipesarr[0];
    String word = pipesarr[1];
    String pos = pipesarr[2];
    String lemma = pipesarr[3];
    String depverb = pipesarr[4];
    String tense = pipesarr[5];
    String mainphrase = pipesarr[6];
    String ppdetail = pipesarr[7];
    String normText = pipesarr[8];
    String pattern = pipesarr[9];
    String timex_type = pipesarr[10];
    String dct = pipesarr[11];
    //String ref_val=pipesarr[11];
    if (ref_val.equals("0000-00-00")) {
    ref_val = dct;
    }
    String norm_value = timen.normalize(word, pos, lemma, depverb, tense, mainphrase, ppdetail, timex_type, normText, pattern, dct, ref_val);
    outfile.write(pipesline + "|" + norm_value + "\n");
    }
    }
    } finally {
    if (pipesreader != null) {
    pipesreader.close();
    }
    if (outfile != null) {
    outfile.close();
    }
    }

    } catch (Exception e) {
    System.err.println("\nErrors found (ActionHandler):\n\t" + e.toString() + "\n");
    if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
    e.printStackTrace(System.err);
    System.exit(1);
    }
    }

    }*/
}


