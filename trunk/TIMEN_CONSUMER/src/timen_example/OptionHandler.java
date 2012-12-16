package timen_example;

import FeatureBuilder.*;
import TIMEN.TIMEN;
import TimeML_BasicKit.TML_file_utils;
import java.io.*;
import java.text.*;
import java.util.*;
import nlp_files.*;
import utils_bk.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * @author Hector Llorens
 * @since 2012
 */
public class OptionHandler {

    public static enum Action {

        NORMALIZE_EXPR,
        NORMALIZE_TML,
        CREATE_KNOWLEDGE_FILE;
    }
    private static TIMEN timen;
    private static SimpleDateFormat dct_format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

    /**
     * Obtain the value of one parameter of ap paramenters
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

    public static void doAction(String action, String[] input, String action_parameters, String lang) {

        try {
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                System.err.println("\n\nDoing action: " + action.toUpperCase() + "\n------------");
            }
            switch (Action.valueOf(action.toUpperCase())) {



                /* This is a non-NLP baseline, the only context info is dct */
                case NORMALIZE_EXPR: {
                    /* Set DCT */
                    String dctvalue = getParameter(action_parameters, "dct");
                    if (dctvalue == null) {
                        dctvalue = dct_format.format(new Date());
                    }
                    /* Create a timen object */
                    timen = new TIMEN(new Locale(lang));

                    /* Process expression/s */
                    for (int i = 0; i < input.length; i++) {
                        System.out.println(timen.normalize(input[i].replaceAll("\\s+", "_"), dctvalue));
                    }
                    // limit to one expression, but it could be useful allowing a list for efficiency
                    /*if (input.length == 1) {
                    System.out.println(timen.normalize(input[0], dctvalue));
                    } else {
                    System.err.println("Expecting one expression, found " + input.length);
                    }*/
                }
                break;

                case NORMALIZE_TML: {
                    /* Disable DCT, it is obtained from the tml file */
                    if (getParameter(action_parameters, "dct") != null) {
                        throw new Exception("DCT must be specified in each tml file, not as a parameter.");
                    }

                    /* Set use_nlp parameter */
                    String use_nlp = getParameter(action_parameters, "use_nlp");
                    if (use_nlp != null && !use_nlp.equalsIgnoreCase("true")) {
                        use_nlp = null;
                    }

                    /* Set tense parameter */
                    String tense = getParameter(action_parameters, "tense");
                    if (tense != null && !tense.equalsIgnoreCase("closest")) {
                        tense = null;
                    }

                    /* Create an output folder */
                    String output_folder_string = getParameter(action_parameters, "output_folder");
                    if (output_folder_string == null) {
                        output_folder_string = "TIMEN-output";
                        String parent_folder = new File(input[0]).getParent();
                        if (parent_folder != null) {
                            output_folder_string = parent_folder + File.separator + output_folder_string;
                        }
                    }


                    File output_folder = new File(output_folder_string);
                    if (output_folder.exists()) {
                        System.err.println("Output directory already exists: " + output_folder.getCanonicalPath() + ".");
                        if (System.getProperty("DEBUG") == null || System.getProperty("DEBUG").equalsIgnoreCase("false")) {
                            Console c = System.console();
                            String overwrite = c.readLine("Do you want to overwrite it (Y/n): ");
                            if (!(overwrite.equalsIgnoreCase("y") || overwrite.equals(""))) {
                                throw new Exception("You must specify a valid output folder or leave it empty to use default (TIMEN-output)");
                            }
                            c = null;
                        }
                    } else {
                        if (!output_folder.mkdirs()) {  // mkdirs creates many parent dirs if needed
                            throw new Exception("Error creating output folder: " + output_folder);
                        }
                    }



                    /* Create a timen object */
                    timen = new TIMEN(new Locale(lang));

                    /* Process files */
                    for (int i = 0; i < input.length; i++) {
                        File input_file = new File(input[i]);
                        if (!input_file.exists()) {
                            throw new FileNotFoundException("File does not exist: " + input_file);
                        }
                        if (!input_file.isFile()) {
                            throw new IllegalArgumentException("File must be a regular file: " + input_file);
                        }

                        File outputfile;

                        if (use_nlp != null) {
                            outputfile = getNLPfeatures(input_file, lang);
                        } else {
                            if(tense!=null){
                                outputfile = getFeatures(input_file,tense);
                            }else{
                                outputfile = getFeatures(input_file,"omit");
                            }
                        }
                        /* get normalized values -- ids need to be specified*/
                        HashMap<String, String> normalization = contextaware_normalization(outputfile);
                        if (System.getProperty("DEBUG") == null || !System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                            outputfile.delete();
                        }

                        /* save normalization in a tml file in output_folder */
                        create_updated_tml_with_normalization(input_file, normalization, output_folder);

                    }

                }
                break;

                case CREATE_KNOWLEDGE_FILE: {
                    /*
                     * This creates a knowledge_XX.java file from SQLite knowledge dbs where XX is the language code
                     */
                    System.err.println("Under development");
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

    public static File getFeatures(File input_file, String tense) {
        File outputfile = null;
        String dct = null;
        try {
            XMLFile xmlfile = new XMLFile();
            xmlfile.loadFile(input_file);
            if (!xmlfile.getExtension().equalsIgnoreCase("tml")) {
                throw new Exception("TimeML (.tml) XML file is required as input.");
            }
            if (!xmlfile.isWellFormed()) {
                throw new Exception("File: " + xmlfile.getFile() + " is not a valid TimeML (.tml) XML file.");
            }



            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(input_file);
            doc.getDocumentElement().normalize();

            Element dcte = ((Element) ((NodeList) ((Element) doc.getElementsByTagName("TIMEX3").item(0))));

            if (dcte != null) {
                dct = dcte.getAttribute("value");
            }

            if (dct == null || dct.length() == 0) {
                throw new Exception("DCT not found in TimeML file.");
            }

            NodeList text = doc.getElementsByTagName("TEXT");
            if (text.getLength() > 1) {
                throw new Exception("More than one TEXT tag found.");
            }
            Element TextElmnt = (Element) text.item(0); // If not ELEMENT NODE will throw exception

            // normalize timexes
            NodeList current_node = TextElmnt.getElementsByTagName("TIMEX3");

            // Write outputfile
            outputfile = new File(FileUtils.getFolder(input_file.getCanonicalPath()) + File.separator + input_file.getName() + ".TIMEN_complete");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile));
            try {

                for (int s = 0; s < current_node.getLength(); s++) {
                    Element element = (Element) current_node.item(s);
                    // write line to file
                    writer.write(element.getAttribute("tid") + "|" + element.getTextContent().replaceAll("\\s+", "_") + "|"+tense+"|" + dct + "\n");
                }
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
            doc = null;
            db = null;
            dbf = null;
        } catch (Exception e) {
            System.err.println("\nErrors found (ActionHandler):\n\t" + e.toString() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }
        return outputfile;
    }

    /*
     * Get all the NLP features required and asociate them to the id. We aim to minimize these.
     *
     * Currently these are limited to TENSE-ASPECT
     *
     */
    public static File getNLPfeatures(File input_file, String lang) {
        File outputfile = null;
        try {
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
            File dir = new File(input_file.getCanonicalPath() + "-TIPSemB-dataset");
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
            output = TempEvalFiles.merge_extents(dir.getCanonicalPath() + File.separator + input_file.getName() + ".plain.TempEval2-features", dir + File.separator + "timex-extents.tab", "timex");
            features = TempEvalFiles.merge_attribs(output, dir + File.separator + "timex-attributes.tab", "timex");
            output = Timen.get_timen(features, lang);

            outputfile = new File(FileUtils.getFolder(input_file.getCanonicalPath()) + File.separator + input_file.getName() + ".TIMEN_complete");
            FileUtils.copyFileUtil(new File(output), outputfile);
            if (System.getProperty("DEBUG") == null || !System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                FileUtils.deleteRecursively(dir);
            }
        } catch (Exception e) {
            System.err.println("\nErrors found (ActionHandler):\n\t" + e.toString() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }
        return outputfile;
    }

    /**
     *
     * Get a normalized values for each timex with the ISO8601 value in a Hash id -> normalized value
     *
     * De entrada tb podria ser un hash...
     * text|tense|DCT|ref-val
     *
     *
     * text:		timex tokens separated by "_"
     * tense:           timex governing-verb tense
     * DCT:		Document Creation Time in ISO8601 format
     * DEPRECATED - ref-val:  Previous date/time-timex focus (temporal reference) (i.e., reference point time-location)
     *                          NOW IS HANDLED BY THE CONSUMER
     *
     * @param input_file
     *
     */
    public static HashMap<String, String> contextaware_normalization(File input_file) {
        HashMap<String, String> normalization = null;
        try {
            normalization = new HashMap<String, String>();
            int linen = 0;
            BufferedReader pipesreader = new BufferedReader(new FileReader(input_file));
            String pipesline = null;
            String[] pipesarr = null;
            String ref_val = "0000-00-00";
            try {
                while ((pipesline = pipesreader.readLine()) != null) {
                    pipesarr = pipesline.split("\\|");
                    linen++;
                    if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                        System.err.println(pipesline);
                    }

                    if (pipesarr.length >= 2) {
                        String id = pipesarr[0];
                        String text = pipesarr[1];
                        String tense = pipesarr[2];
                        String dct = pipesarr[3];
                        //String ref_val=pipesarr[9];
                        if (ref_val.equals("0000-00-00")) {
                            ref_val = dct;
                        }
                        String norm_value = timen.normalize(text, dct, tense, ref_val);
                        //outfile.write(pipesline + "|" + norm_value + "\n");
                        normalization.put(id, norm_value);
                        if (norm_value.matches("[0-9]{4}(-[0-1][0-9](-[0-3][0-9])?)?")) {
                            ref_val = norm_value;
                            // check if ISO valid if not... DCT
                            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                                System.err.println("Ref_time updated: "+ref_val);
                            }
                        }
                    }
                }
            } finally {
                if (pipesreader != null) {
                    pipesreader.close();
                }
            }

        } catch (Exception e) {
            System.err.println("\nErrors found (ActionHandler):\n\t" + e.toString() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }
        return normalization;
    }

    public static void create_updated_tml_with_normalization(File file, HashMap<String, String> normalization, File output_folder) {
        try {
            String tmp = FileUtils.readFileAsString(file.getCanonicalPath(), "UTF-8");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList text = doc.getElementsByTagName("TEXT");
            if (text.getLength() > 1) {
                throw new Exception("More than one TEXT tag found.");
            }
            Element TextElmnt = (Element) text.item(0); // If not ELEMENT NODE will throw exception

            // normalize timexes
            NodeList current_node = TextElmnt.getElementsByTagName("TIMEX3");
            for (int s = 0; s < current_node.getLength(); s++) {
                Element element = (Element) current_node.item(s);
                if (normalization.get(element.getAttribute("tid")) != null) {
                    // remove value if found
                    tmp = tmp.replaceAll("(<TIMEX3[^>]*) value=\"[^\"]*\"([^>]*tid=\"" + element.getAttribute("tid") + "\"[^>]*>)", "$1" + "$2");
                    tmp = tmp.replaceAll("(<TIMEX3[^>]*tid=\"" + element.getAttribute("tid") + "\"[^>]*) value=\"[^\"]*\"([^>]*>)", "$1" + "$2");
                    // add new normalized value
                    tmp = tmp.replaceAll("(<TIMEX3[^>]*tid=\"" + element.getAttribute("tid") + "\"[^>]*)>", "$1 value=\"" + normalization.get(element.getAttribute("tid")) + "\">");
                }
            }
            doc = null;
            db = null;
            dbf = null;
            FileUtils.writeFileFromString(tmp, output_folder.getCanonicalPath() + File.separator + file.getName());
        } catch (Exception e) {
            System.err.println("\nErrors found (ActionHandler):\n\t" + e.toString() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }
    }
}


