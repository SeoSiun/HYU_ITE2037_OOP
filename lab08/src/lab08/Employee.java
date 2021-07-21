package lab08;

public abstract class Employee {

	private String name;
	private int employeeNum;
	private String department;
	private int workHrs;
	private double salary;
	
	Employee(String name, int employeeNum){
		this.name = name;
		this.employeeNum = employeeNum;
		workHrs = 0;
		salary = 0;
	}


	public String getDepartment() {
		return this.department;
	}
	
	public void setDepartment(String department) {
		this.department  = department;
	}
	
	public int getWorkHrs() {
		return this.workHrs;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Employee)) {
			return false;
		}
		else {
			Employee employee = (Employee)obj;
			return this.name.equals(employee.name) && this.employeeNum == employee.employeeNum;
		}
	}
	
	public String toString() {
		return "Name : " + this.name + "\nEmp# : " + this.employeeNum + "\n";
	}
	
	public void doWork(int hrs) {
		this.workHrs += hrs;
		salary = getPaid();
	}
	
	public abstract double getPaid();
	
	public boolean equalPay(Employee emp) {
		return this.salary == emp.salary;
	}
}
