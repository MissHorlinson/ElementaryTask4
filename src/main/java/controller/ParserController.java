package controller;
import util.*;
import model.*;
import java.io.*;

public class ParserController {
    private Input input = new Input();
    private Output output = new Output();
    private Validator validator = new Validator();
    private ParserModel model;

    public void choiceMode() throws IOException {
        output.description();
        if(input.getString().equals("1")) {
            runCounting();
        } else if(input.getString().equals("2")) {
            runReplace();
        }
    }

    public File getFile() {
        //  C://Users//Maria//Downloads//test.txt
        File file = new File(input.getString());
        return file;
    }


    public BufferedReader readFromFile(File file) throws IOException {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            return bufferedReader;
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

    public String fileToString(File file) throws IOException {
        StringBuilder builder = new StringBuilder();
        return builder.append(readFromFile(file).readLine()).toString();
    }

    public boolean stringToFile(File file, String string) throws IOException {
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

    public void runCounting() throws IOException {
        output.countString();
        model = new ParserModel(getFile(), input.getString());
        if (validator.fileExist(model.getFile())) {
            if(validator.emptyFile(model.getFile())) {
                countString(model);
            }
        }
    }

    public void countString(ParserModel model) throws IOException {
        String[] fileContent = validator.fileContent(fileToString(model.getFile()));
        int count = 0;
        for (int i = 0; i < fileContent.length; i++) {
            if (fileContent[i].equals(model.getFindString())) {
                count++;
            }
        }
        output.stringInFile(count);
    }

    public void runReplace() throws IOException {
        output.replaceString();
        model = new ParserModel(getFile(), input.getString(), input.getString());
        if (validator.fileExist(model.getFile())) {
            if(validator.emptyFile(model.getFile())) {
                replaceString(model);
            }
        }
    }

    public void replaceString(ParserModel model) throws IOException {
       if (!stringToFile(model.getFile(), fileToString(model.getFile()).replaceAll(model.getFindString(), model.getReplaceString()))) {
           output.replaceError();
       } else {
           output.replaceSuccess();
       }
    }
}
