package util;
import java.io.File;

public class Validator {

    public boolean isFileExist(File file) {
        if(file.exists() && file.isFile())
            return true;
        else
            return false;
    }

    public String[] fileContent(String string) {
            String[] content = string.split("\\s+");
            return content;
    }

    public boolean isFileEmpty(File file) {
        if(file.length() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
