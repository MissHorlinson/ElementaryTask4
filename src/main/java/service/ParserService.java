package service;

import com.sun.istack.internal.Nullable;
import util.*;
import java.io.*;

public class ParserService {
    private Validator  validator = new Validator();

    @Nullable
    public String readFromFile(File file) throws IOException {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            return bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public BufferedWriter writeToFile(File file) throws IOException {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            return bufferedWriter;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean dataToFile(File file, String string) throws IOException {
        BufferedWriter writer = writeToFile(file);
        try {
            writer.write(string);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

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
        if (!dataToFile(file, readFromFile(file).replaceAll(findString, replaceString))) {
           return false;
        } else {
            return true;
        }
    }
}
