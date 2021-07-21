
public class Lab04 {

	public static void main(String[] args) {
		City seoul = new City("Seoul",23,45);
		System.out.println(seoul.toString());
		
		City paris = new City("Paris",123,41);
		System.out.println(paris.toString());
		
		City racoon = new City("Racoon City");
		System.out.println(racoon.toString());
		
		City mega = new City("Mega City");
		System.out.println(mega.toString());
		
		System.out.println("Seoul-Paris : "+City.distance(seoul, paris));
		System.out.println("Seoul-Racoon City : "+City.distance(seoul, racoon));
		System.out.println("Paris-Mega City : "+City.distance(paris, mega));
	}

}
