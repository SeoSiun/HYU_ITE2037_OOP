package lab09;

public class Employee {

	private String name;
	private int workDay;
	private int workHours;
	
	public Employee(String name) {
		this.name = name;
		this.workDay = 1;
		this.workHours = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getWorkDay() {
		return this.workDay;
	}

	public int getWorkHours() {
		return this.workHours;
	}
	
	public void addWorkDay() {
		this.workDay++;
	}
	
	public void addWorkHours(int hours) {
		this.workHours += hours;
	}
}
