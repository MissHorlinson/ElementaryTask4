package model;

import java.io.File;

public class ParserModel {
    private File file;

    public ParserModel() { }

    public ParserModel(File file) {
        this.file = file;
    }

    public File getFile() { return file; }

    public void setFile(File file) { this.file = file; }
}
