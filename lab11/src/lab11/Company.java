package lab11;
import java.util.ArrayList;
import java.util.Scanner;

public class Company {

	public static void main(String[] args) {
		String[] new_manager_names = {"Sally", "Tammy", "John", "Jessi", "Ariana"};
		String[] new_engineer_names = {"Jenny", "Mason", "Kevin", "Jolly", "Jack", "Ash"};
		ArrayList<Manager> mList = new ArrayList<>();
		ArrayList<Engineer> eList = new ArrayList<>();
		
		Scanner scan = new Scanner(System.in);
		
		hireEmployees(eList, new_engineer_names, "engineer");
		hireEmployees(mList, new_manager_names, "manager");
		
		System.out.println("All employees' salaries were raised by 4%");
		Management.raiseAllSalary(mList, 1.04);
		Management.raiseAllSalary(eList, 1.04);
		
		System.out.print("enter the number of ENGINEER who will additionally raise his salary : ");
		int selectedEmployee = scan.nextInt();
		
		int index = Management.findIndexByEmpNum(eList, selectedEmployee);
		if(index != -1) {
			Management.raiseSalary(eList.get(index), 1.20);
			System.out.println(eList.get(index).getName() + "'s salary is raised.\n");
		}
		else
			System.out.println("No one gets chance of raising salary.\n");
		
		System.out.print("enter the number of MANAGER who will move his department to Section of Personnel : ");
		selectedEmployee = scan.nextInt();
		
		index = Management.findIndexByEmpNum(mList, selectedEmployee);
		if(index != -1) {
			Management.moveDepartment(mList.get(index),  "Section of Personnel").toString();
			Management.raiseSalary(mList.get(index), 1.05);
			String selectedName = mList.get(index).getName();
			System.out.println(selectedName + " moves department.\nAnd " + selectedName + "'s salary is raised by 5%.\n");
		}
		else
			System.out.println("No one moves to Section of Personnel");
		
		for(Manager m : mList)
			System.out.println(m + "\n");
		
		for(Engineer e : eList)
			System.out.println(e+ "\n");
		
	}
	
	public static <T extends Employee> ArrayList<T> hireEmployees(ArrayList<T> tList, String[] names, String dept) {
		// 1. dept 매개변수를 통해 Manager인지 Engineer인지 판단한다.
		// 2. 이름들이 들어있는 String 배열들을 가지고 ArrayList<Base_Type>에 차례로 add한다.
		// 3. add시 type이 맞지않을 때는 type casting을 이용한다.
		// ex) tList.add((T) new Employee());
		
		if(dept.equals("manager")) {
			for(int i=0; i<names.length; i++) {
				tList.add((T) new Manager(names[i]));
			}
		}else {
			for(int i=0; i<names.length; i++) {
				tList.add((T) new Engineer(names[i]));
			}
		}
		return tList;
	}

}
