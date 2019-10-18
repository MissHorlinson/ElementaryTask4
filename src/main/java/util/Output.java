package util;

public class Output {
    public void description() {
        System.out.println("Please choice  mode:\n 1 Find string in the file and count them\n 2 Find string in the file and replace them");
    }

    public void fileError() {
        System.out.println("Such file doesn`t exist");
    }

    public void emptyFile() {
        System.out.println("File is empty");
    }

    public void countString() {
        System.out.println("Enter file name and string for search");
    }

    public void stringInFile(int number) {
        System.out.println("File has " + number + " search string");
    }
    public void replaceString() {
        System.out.println("Enter file name string for search and replace");
    }

    public void replaceError() {
        System.out.println("Record failed");
    }

    public void replaceSuccess() {
        System.out.println("Record was successful");
    }
}
