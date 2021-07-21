package lab08;

public class Manager extends Employee{

	private double overtimeRate;
	private double rate;
	int regularHrs;
	
	Manager(String name, int employeeNum){
		super(name, employeeNum);
		this.rate = 5.0;
		this.overtimeRate = 8.0;
		this.regularHrs =  40;
		setDepartment("Management");
	}
	

	public boolean equals(Object obj) {
		if(!(obj instanceof Manager)) {
			return false;
		}
		else {
			return super.equals(obj);
		}
	}
	
	public String toString() {
		return super.toString() + "Dept : " + getDepartment() +"\n";
	}
	
	public double getPaid() {
		int overtimeHrs = getWorkHrs() - regularHrs;
		if(getWorkHrs() < 40) {
			return getWorkHrs() * rate;
		}
		else {
			return (regularHrs * rate) + (overtimeHrs * overtimeRate);
		}
	}
}
