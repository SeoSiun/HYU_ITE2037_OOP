package lab10;

public class Dog extends Animal implements Barkable{

	public Dog() {
		super("°³");
	}

	@Override
	public String bark() {
		return "¸Û¸Û";
	}
	
}
