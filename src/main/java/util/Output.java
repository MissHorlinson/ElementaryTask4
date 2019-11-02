package util;

public class Output {

    public void description() {
        System.out.println("Please choice  mode:\n 1 Find string in the file and count them\n 2 Find string in the file and replace it\n --------------------------------------------");
    }

    public void wrongMode() {
        System.out.println("You select nonexistent mode. Please enter y - yes, if you want to try again");
    }

    public void fileName() {
        System.out.println("Enter the file name");
    }

    public void fileError() {
        System.out.println("Such file doesn`t exist");
    }

    public void emptyFile() {
        System.out.println("File is empty");
    }

    public void countString() {
        System.out.println("Enter string for search");
    }

    public void stringInFile(int number) {
        System.out.println("File has " + number + " search string");
    }

    public void replaceString() {
        System.out.println("Enter string for search and replace");
    }

    public void noString() { System.out.println("No such string in the file"); }

    public void replaceError() {
        System.out.println("Record failed");
    }

    public void replaceSuccess() {
        System.out.println("Record was successful");
    }

    public void fileReadError() {
        System.out.println("Error with reading from file");
    }

    public void fileWriteError() {
        System.out.println("Error with writing to file");
    }
}
