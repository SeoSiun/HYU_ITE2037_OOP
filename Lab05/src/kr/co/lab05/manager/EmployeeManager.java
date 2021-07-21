package kr.co.lab05.manager;
import kr.co.lab05.employee.*;
import java.time.LocalDate;
import java.util.Random;

public class EmployeeManager {

	public static void main(String args[]) {
		Employee employee = new Employee("Seo", 4500);
		LocalDate date = LocalDate.of(2020, 4, 16);
		
		System.out.println("계약일 : " + date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth());
		System.out.println(employee.toString());
		
		Random r = new Random();
		int random_month= r.nextInt(12) + 1;
		
		int cnt_month = 0;
		int random_num =0;
		while(employee.getBalance()<20000) {
			if(date.getMonthValue()==12) {
				date= LocalDate.of(date.getYear()+1, 1, 16);
			}
			else {
				date = LocalDate.of(date.getYear(), date.getMonthValue() + 1, 16);
			}
			cnt_month++;
			
			employee.receiveSalary();
			
			if(date.getMonthValue()==random_month) {
				employee.receiveSalary();
				System.out.println((cnt_month/12 + 1) + "년차 " + date.getMonthValue() + "월에 인센티브를 받았습니다.");
			}
			
			if(cnt_month % 12 == 0) {
				random_num = r.nextInt(11);
				employee.increaseYearlySalary(random_num);
				System.out.println((cnt_month/12 + 1) + "년차 연봉이 " + random_num + "% 인상되었습니다.");
				random_month= r.nextInt(12) + 1;
			}
		}
		
		System.out.println("날짜 : "  + date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth());
		System.out.println(employee.toString());

	}
}
