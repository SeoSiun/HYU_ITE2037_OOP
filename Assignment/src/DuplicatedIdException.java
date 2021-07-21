public class DuplicatedIdException extends Exception {
    public DuplicatedIdException(String id) {
        super(id+" already exists.");
    }
}