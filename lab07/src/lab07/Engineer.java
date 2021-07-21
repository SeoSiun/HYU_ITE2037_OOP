package lab07;

public class Engineer extends Employee{
	private String workZone;
	private String project;
	
	Engineer(String name, int employeeNum, String workZone, String project){
		super(name, employeeNum, "Engineering");
		this.workZone = workZone;
		this.project = project;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Engineer)) {
			return false;
		}
		else {
			Engineer engineer = (Engineer)obj;
			return super.equals(obj) && engineer.workZone.equals(this.workZone);
		}
	}
	
	public String toString() {
		return super.toString() +  "\nlocation : [" + super.getDepartment() + "], zone : [" + this.workZone + "]";
	}
}