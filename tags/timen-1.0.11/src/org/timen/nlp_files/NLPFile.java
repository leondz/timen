package org.timen.nlp_files;

import org.timen.utils.CognitionisFileUtils;
import java.io.*;

/**
 * @author Héctor Llorens
 * @since 2011
 */
public abstract class NLPFile {

    public static enum Subclasses {        PipesFile, PlainFile, TreebankFile, XMLFile;    }
    protected File f;
    protected String language;
    protected String encoding;
    protected String extension;
    protected Boolean isWellFormatted;

    /**
     * Creates the object and loads a file into it
     * @param filename
     */
    public NLPFile(String filename){
        File file=new File(filename);
        try {
            if (!file.exists()) 
                throw new FileNotFoundException("File does not exist: " + file);
            if (!file.isFile()) 
                throw new IllegalArgumentException("Should be a file (not directory, etc): " + file);
            this.f = file;
            this.extension=CognitionisFileUtils.getExtension(this.f.getName());
            this.encoding = CognitionisFileUtils.getEncoding(this.f);
        } catch (FileNotFoundException | IllegalArgumentException e) {
            System.err.println("Errors found (" + this.getClass().getSimpleName() + "):\n\t" + e.toString() + "\n");
            if (System.getProperty("DEBUG") != null && System.getProperty("DEBUG").equalsIgnoreCase("true")) {
                e.printStackTrace(System.err);
            }
            this.f = null;
        }        
    }
    
    /**
     * Basic format check
     * @return  String: the canonical path to the created file
     */
    public abstract Boolean isWellFormatted();

    /**
     * Creates a plain file from any type of NLPFile.
     * @return  String: the canonical path to the created file
     */
    public abstract String toPlain(String filename);


    public File getFile() {
        return this.f;
    }

    public void setEncoding(String e) {
        this.encoding = e;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setLanguage(String lang) {
        this.language = lang;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getExtension() {
        return this.extension;
    }

    public void overrideExtension(String newext){
        this.extension=newext;
    }

}
