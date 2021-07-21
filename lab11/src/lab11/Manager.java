package lab11;

public class Manager extends Employee {
	public static int initial_manager_number = 1000;
	public static String initial_manager_dept = "Sales Management";
	public static int initial_manager_salary = 3000;
	
	public Manager(String name) {
		super(name, ++initial_manager_number, initial_manager_dept, initial_manager_salary);
	}
}
