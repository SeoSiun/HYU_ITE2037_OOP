import java.util.Scanner;

public class Lab02_2 {
	
	private static String makeOrdinalNumber(int num) {
		switch(num%10) {
			case 1:
				return num+"st";
			case 2:
				return num+"nd";
			case 3:
				return num+"rd";
		}
		return num+"th";
	}
	
	private static int convertScore(String score) {
		switch(score) {
			case "A":
				return 100;
			case "B":
				return 90;
			case "C":
				return 80;
			case "D":
				return 70;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		String score=scanner.nextLine();
		score=score.toUpperCase();
		
		String[] score_arr=score.split(" ");
		
		int student_num=score_arr.length;
		float total_score=0.0f;
		
		for(int i=0;i<student_num;i++) {
			System.out.println(makeOrdinalNumber(i+1)+" student's score is "+convertScore(score_arr[i]));
			total_score+=convertScore(score_arr[i]);
		}
		
		String result=String.format("%.2f",total_score/student_num);
		System.out.println("This class's average = "+result);
	}

}