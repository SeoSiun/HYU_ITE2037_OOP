package lab11;

import java.util.ArrayList;

public class Management {
	public static <T extends Employee> T moveDepartment(T t, String department) {
		t.setDepartment(department);
		return t;
	}
	
	public static <T extends Employee> T raiseSalary(T t, double rate) {
		t.setSalary(t.getSalary() * rate);
		return t;
	}
	
	public static <T extends Employee> int findIndexByEmpNum(ArrayList<T> tList, int employeeNum) {
		for(T t:tList) {
			if(t.getEmployeeNum() == employeeNum) {
				return tList.indexOf(t);
			}
		}
		return -1;
	}
	
	public static <T extends Employee> ArrayList<T> raiseAllSalary(ArrayList<T> tList, double rate) {
		for(T t:tList) {
			t.setSalary(t.getSalary() * rate);
		}
		return tList;
	}
}
