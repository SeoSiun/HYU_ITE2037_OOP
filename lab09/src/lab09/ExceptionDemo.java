package lab09;

import java.util.Scanner;

public class ExceptionDemo {

	public static void main(String[] args) {
		Employee employee = new Employee("Seo");
		int hours;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print(employee.getWorkDay() + "일차 근무 시간을 입력하세요: ");
			hours = sc.nextInt();
			
			try {
				if(hours < 0) {
					throw new NegativeException();
				}
				else if(hours == 0) {
					throw new Exception("Program Exit");
				}
				else if(hours > 24) {
					throw new TooMuchStuffException(hours);
				}
				else {
					employee.addWorkHours(hours);
					employee.addWorkDay();
					System.out.println("이름: " + employee.getName());
					System.out.println("누적 근무 시간: " + employee.getWorkHours());
					System.out.println("No Exception has been occured");
				}
			}
			catch(NegativeException e){
				System.out.println(e.getMessage());
			}
			catch(TooMuchStuffException e) {
				System.out.println(e.getInputNum() + ", " + e.getMessage());
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
			finally {
				System.out.println("End of try-catch statement");
			}
			
		}

	}

}
