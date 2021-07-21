package lab08;

public class Engineer extends Employee{

	private double rate;
	
	Engineer(String name, int employeeNum){
		super(name,employeeNum);
		rate = 4.0;
		setDepartment("Engineering");
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Engineer)) {
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
		return getWorkHrs() * rate;
	}
}
