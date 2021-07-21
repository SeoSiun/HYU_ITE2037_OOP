
public class Employee {

	private String name;
	private int age;
	private String position;
	private int salary;
	private int vacationDays;
	
	
	Employee(String name, int age){
		this.name = name;
		this.age = age;
		this.position = "Employee";
		this.salary = 5000;
		this.vacationDays = 20;
	}
	Employee(String name, int age, String position, int salary){
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.vacationDays = 20;
	}
	Employee(String name, int age, String position, int salary, int vacationDays){
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.vacationDays = vacationDays;
	}
	
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getPosition() {
		return position;
	}
	public int getSalary() {
		return salary;
	}	
	public int getVacationDays() {
		return vacationDays;
	}	
	public void setName(String name) {
		this.name = name;
	}	
	public void setAge(int age) {
		this.age = age;
	}	
	public void setPosition(String position) {
		this.position = position;
	}	
	public void setSalary(int salary) {
		this.salary = salary;
	}	
	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}
	
	
	public boolean equals(Employee employee) {
		if(this.name == employee.name && this.age == employee.age && this.position == employee.position)
			return true;
		return false;
	}
	
	public String toString() {
		return "Name : " + this.name + ", Age : " + this.age + ", Position : " + this.position + ", Salary : " + this.salary + ", VacationDays : "+this.vacationDays;
	}

	
	public boolean vacation(int days) {
		if(this.vacationDays < days) {
			System.out.println("남은 휴가 일수가 부족합니다.");
			return false;
		}
		else {
			this.vacationDays -= days;
			System.out.printf("휴가를 사용하였습니다. 남은 휴가 일 수 %d\n",this.vacationDays);
			return true;
		}
	}	
}
