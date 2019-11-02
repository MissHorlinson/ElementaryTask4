package util;

public class MyException {

    private Output output = new Output();

    public void noSuchString() {
        output.noString();
    }

    public void fileReadError() {
        output.fileReadError();
    }

    public void fileWriteError() {
        output.fileWriteError();
    }
}
