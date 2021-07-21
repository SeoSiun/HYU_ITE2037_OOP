package lab07;

public class Employee {
	private String name;
	private int employeeNum;
	private String department;
	
	Employee(String name, int employeeNum, String department){
		this.name = name;
		this.employeeNum = employeeNum;
		this.department = department;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getEmployeeNum() {
		return this.employeeNum;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmployeeNum(int employeeNum) {
		this.employeeNum = employeeNum;
	}
	
	public void setDepartment(String department) {
		this.department = department;
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
		return "Name : [" + this.name + "]\nEmp# : [" + this.employeeNum + "]";
	}
}
