package lab07;

public class Manager extends Employee {
	private int officeNum;
	private String team;

	Manager(String name, int employeeNum, int officeNum, String team){
		super(name, employeeNum, "Management");
		this.officeNum = officeNum;
		this.team = team;
	}
	
	public String toString() {
		return super.toString() + "\nlocation : [" + super.getDepartment() + "], office : [" + this.officeNum + "]";
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Manager)) {
			return false;
		}
		else {
			Manager manager = (Manager)obj;
			return super.equals(obj) && manager.officeNum == this.officeNum;		
		}
	}
}
