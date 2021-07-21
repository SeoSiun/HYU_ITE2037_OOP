package lab10;

public class Tiger extends Animal implements Barkable {

	public Tiger() {
		super("È£¶ûÀÌ");
	}

	@Override
	public String bark() {
		return "¾îÈï";
	}

}
