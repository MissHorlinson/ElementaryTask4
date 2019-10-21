package controller;
import service.ParserService;
import util.*;
import model.*;
import java.io.*;

public class ParserController {
    private Input         input = new Input();
    private Output        output = new Output();
    private Validator     validator = new Validator();
    private ParserService service = new ParserService();
    private ParserModel   model;

    public void choiceMode() throws IOException {
        while (true) {
        output.description();
            if (input.getString().equals("1")) {
                runCounting();
            } else if (input.getString().equals("2")) {
                runReplace();
            } else {
                output.wrongMode();
                if(!continueRequest(input.getString()))
                    break;
            }
        }
    }

    public File getFile() {
        //  C://Users//Maria//Downloads//test.txt
        File file = new File(input.getString());
        return file;
    }


    public void runCounting() throws IOException {
        output.fileName();
        model = new ParserModel(getFile());
        if (validator.fileExist(model.getFile())) {
            if(validator.emptyFile(model.getFile())) {
                service.countString(model.getFile());
            }
        }
    }

    public void runReplace() throws IOException {
        output.fileName();
        model = new ParserModel(getFile());
        if (validator.fileExist(model.getFile())) {
            if(validator.emptyFile(model.getFile())) {
                service.replaceString(model.getFile());
            }
        }
    }

    public boolean continueRequest(String answer) {
        answer = answer.toUpperCase();
        if(answer.equals("Y") || answer.equals("YES"))
            return true;
        else
            return false;
    }


}
