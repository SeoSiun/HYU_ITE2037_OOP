package kr.co.lab05.employee;

public class Employee {

	private String name;
	private double yearly_salary;
	private double monthly_salary;
	private double balance;
	
	public Employee(String name, double yearly_salary) {
		this.name = name;
		this.yearly_salary = yearly_salary;
		this.monthly_salary = yearly_salary/12;
		this.balance = 0;
	}
	public double getBalance() {
		return balance;
	}
	public void increaseYearlySalary(int byPercent) {
		this.yearly_salary += this.yearly_salary * (byPercent) / 100;
		this.monthly_salary = this.yearly_salary/12;
	}
	public void receiveSalary() {
		this.balance += this.monthly_salary;
	}
	public String toString() {
		return "이름 : " + name + " 연봉 : " + this.yearly_salary + " 월급 : " + this.monthly_salary + " 재산 : " + this.balance;
	}
}
