package lab09;

public class TooMuchStuffException extends Exception {
	
	private int inputNum;
	
	public TooMuchStuffException() {
		super("Too much stuff!");
	}
	
	public TooMuchStuffException(String message) {
		super(message);
	}
	
	public TooMuchStuffException(int inputNum) {
		super("Too much stuff!");
		this.inputNum = inputNum;
	}

	public int getInputNum() {
		return inputNum;
	}
}
