package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Validator {
    private Output output = new Output();

    public boolean fileExist(File file) {
        if(file.exists() && file.isFile())
            return true;
        else
            output.fileError();
            return false;
    }

    public String[] fileContent(String string) {
            String[] content = string.split(" ");
            return content;
    }

    public boolean emptyFile(File file) {
        if(file.length() == 0) {
            output.emptyFile();
            return false;
        } else {
            return true;
        }
    }
}
