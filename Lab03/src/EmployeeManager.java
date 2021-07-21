
public class EmployeeManager {

	public static void main(String[] args) {
		Employee e_james = new Employee("James Wright",42,"Manager",20000);
		System.out.println(e_james.toString());
		
		Employee e_amy = new Employee("Amy Smith",27,"Design Coordinator",8000,15);
		System.out.println(e_amy.toString());

		Employee e_peter = new Employee("Peter Coolidge",32,"Assistant Manager",12000,7);
		System.out.println(e_peter.toString());

		Employee e_john = new Employee("John Doe",22,"Engineer",10000,10);
		System.out.println(e_john.toString());

		Employee new_e1 = new Employee("Amy Smith",27,"Design Coordinator",8000);
		System.out.println(new_e1.toString());

		if(e_amy.equals(new_e1)) 
			System.out.println("같은 사람입니다.");
		else 
			System.out.println("다른 사람입니다.");

		Employee new_e2 = new Employee("Siun Seo",21);
		System.out.println(new_e2.toString());

		if(e_amy.equals(new_e2)) 
			System.out.println("같은 사람입니다.");
		else 
			System.out.println("다른 사람입니다.");
		
		e_james.vacation(10);
		e_peter.vacation(10);
		
		System.out.println(e_james.toString());
		System.out.println(e_amy.toString());
		System.out.println(e_peter.toString());
		System.out.println(e_john.toString());
		System.out.println(new_e1.toString());
		System.out.println(new_e2.toString());
	}
}
