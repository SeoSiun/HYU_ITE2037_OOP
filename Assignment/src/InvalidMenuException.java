public class InvalidMenuException extends Exception {
    public InvalidMenuException(int command) {
        super(command+" is an invalid menu number.");
    }

    public InvalidMenuException() {
        super("Invalid Access.");
    }
}