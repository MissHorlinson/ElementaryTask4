package service;

import util.*;
import java.io.*;

public class ParserService {
    private Input      input = new Input();
    private Output     output = new Output();
    private Validator  validator = new Validator();


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

    public void countString(File file) throws IOException {
        String[] fileContent = validator.fileContent(readFromFile(file));
        output.countString();
        String findString = input.getString();
        int count = 0;
        for (int i = 0; i < fileContent.length; i++) {
            if (fileContent[i].equals(findString)) {
                count++;
            }
        }
        output.stringInFile(count);
    }

    public void replaceString(File file) throws IOException {
        output.replaceString();
        String findString = input.getString();
        String replaceString = input.getString();
        if (!dataToFile(file, readFromFile(file).replaceAll(findString, replaceString))) {
            output.replaceError();
        } else {
            output.replaceSuccess();
        }
    }

    public boolean isAlpha(String string) {
        return string.matches("[a-zA-Z]");
    }
}
