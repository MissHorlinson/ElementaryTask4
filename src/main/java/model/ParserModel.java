package model;

import java.io.File;

public class ParserModel {
    private File file;
    private String findString;
    private String replaceString;

    public ParserModel() { }

    public ParserModel(File file, String findString) {
        this.file = file;
        this.findString = findString;
    }

    public ParserModel(File file, String findString, String replaceString) {
        this.file = file;
        this.findString = findString;
        this.replaceString = replaceString;
    }

    public File getFile() { return file; }

    public String getFindString() { return findString; }

    public String getReplaceString() { return replaceString; }

    public void setFile(File file) { this.file = file; }

    public void setFindString(String findString) { this.findString = findString; }

    public void setReplaceString(String replaceString) { this.replaceString = replaceString; }

}
