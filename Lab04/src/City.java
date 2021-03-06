import java.util.Random;

public class City {
	private String name;
	private int location_x;
	private int location_y;
	
	City(String name, int location_x, int location_y){
		this.name = name;
		this.location_x = location_x;
		this.location_y = location_y;
	}
	
	City(String name){
		this.name = name;
		Random r = new Random();
		this.location_x = r.nextInt(361);
		this.location_y = r.nextInt(361);
	}
	
	public String getName() {
		return name;
	}
	public int getLocation_x() {
		return location_x;
	}
	public int getLocation_y() {
		return location_y;
	}
	
	public String toString() {
		return this.name + "," + this.location_x + "," + this.location_y;
	}
	
	public static double distance(City c1, City c2) {
		return Math.sqrt(Math.pow((c1.location_x-c2.location_x),2) + Math.pow((c1.location_y-c2.location_y),2));
	}
}
