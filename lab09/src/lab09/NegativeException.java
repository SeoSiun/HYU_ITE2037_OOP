package lab09;

public class NegativeException extends Exception {
	
	public NegativeException() {
		super("work time must be positive");
	}
	
	public NegativeException(String message) {
		super(message);
	}
}
