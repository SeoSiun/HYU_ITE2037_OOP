package lab11;

public class Engineer extends Employee {
	public static int initial_engineer_number = 2000;
	public static String initial_engineer_dept = "Conputational Management";
	public static int initial_engineer_salary = 3300;
	
	public Engineer(String name) {
		super(name, ++initial_engineer_number, initial_engineer_dept, initial_engineer_salary);
	}
}
