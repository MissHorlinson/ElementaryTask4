package service;
import com.sun.istack.internal.Nullable;
import util.*;
import java.io.*;
import java.lang.Exception;

public class ParserService {

    private Validator   validator = new Validator();
    private MyException exception = new MyException();

    public int countString(File file, String findString) throws IOException {
        String[] fileContent = validator.fileContent(readFromFile(file));
        int count = 0;
        for (int i = 0; i < fileContent.length; i++) {
            if (fileContent[i].equals(findString)) {
                count++;
            }
        }
        return count;
    }

    public boolean replaceString(File file, String findString, String replaceString) throws IOException {
        if (countString(file, findString) > 0) {
            if (!dataToFile(file, readFromFile(file).replaceAll(findString, replaceString))) {
                return false;
            } else {
                return true;
            }
        } else {
            exception.noSuchString();
            return false;
        }
    }

    public String readFromFile(File file) throws IOException {
        BufferedReader bufferedReader = fileReader(file);
        String content = "";
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content += line + " ";
        }
        return content;
    }

    @Nullable
    public BufferedReader fileReader(File file) throws IOException {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            return bufferedReader;
        } catch (Exception e) {
            exception.fileReadError();
            return null;
        }
    }

    public boolean dataToFile(File file, String string) {
        BufferedWriter writer = writeToFile(file);
        try {
            writer.write(string);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            exception.fileWriteError();
            return false;
        }
        return true;
    }

    @Nullable
    public BufferedWriter writeToFile(File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            return bufferedWriter;
        } catch (Exception e) {
            exception.fileWriteError();
            return null;
        }
    }
}
