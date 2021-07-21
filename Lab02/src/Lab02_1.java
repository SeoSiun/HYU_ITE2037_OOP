import java.util.Scanner;

public class Lab02_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		String input = scanner.nextLine();
//		
//		String[] input_arr=input.split(",");
//		
//		String[] name_arr=input_arr[0].split(" ");
//		int name_length=name_arr.length;
//		
//		String name_result="";
//		
//		for(int i=1;i<name_length;i++) {
//			name_result+=name_arr[i].substring(0,1).toUpperCase()+".";
//		}
//		name_result+=name_arr[0].replace("s", "S");
//		
//		input_arr[1]=input_arr[1].replace("h", "H");
//		input_arr[1]=input_arr[1].replace("ppt","pdf");
//		
//		System.out.println("Name Length(Korean) : "+name_length);
//		System.out.println(name_result+" submitted"+input_arr[1]);
//		
//		String tmp = "a";
//		System.out.println(tmp.compareTo("A"));
		
		System.out.println("Input: ");
		String line = scanner.nextLine();
		Scanner sc = new Scanner(line).useDelimiter("m");
		int a=0;
		while(sc.hasNextInt()) {
			a += sc.nextInt();
		}
		System.out.println(a);
	}

}
