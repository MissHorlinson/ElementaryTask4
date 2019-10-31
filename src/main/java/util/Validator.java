package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Validator {
    public boolean fileExist(File file) {
        if(file.exists() && file.isFile())
            return true;
        else
            return false;
    }

    public String[] fileContent(String string) {
            String[] content = string.split("\\s+");
            return content;
    }

    public boolean emptyFile(File file) {
        if(file.length() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
