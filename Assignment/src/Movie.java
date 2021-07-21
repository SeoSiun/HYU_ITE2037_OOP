import java.util.ArrayList;
import java.util.Date;

public class Movie {
	private String title;
	private int startTime;
	private int endTime;
	private int seats[][];
	private int cntSeat;
	private ArrayList<Member> waiting;

	public Movie(String title, int startTime, int endTime) {
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		seats = new int[6][6];
		for(int i=0; i<seats.length; i++) {
			for(int j=0; j<seats[0].length; j++) {
				seats[i][j] = 0;
			}
		}
		cntSeat = 0;
		waiting = new ArrayList<Member>();
	}

	public int getCntSeat() {
		return cntSeat;
	}

	public String getTitle() {
		return this.title;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public boolean isReserved(char c, int j) {
		int i = (int)c - 65;
		if(seats[i][j-1] == 1) {
			return true;
		}
		else {
			return false;
		}	
	}

	public void reserveTicket(char c, int j){
		int i = (int)c - 65;
		seats[i][j-1] = 1;
		cntSeat++;	
	}
	
	public synchronized String reserveTicket(int time, Member member) throws InterruptedException {	
		String seat = null;
		int t = time * 60000;
		Character c;
		int cnt =0;
		
		if(cntSeat==36) {
			Date oldTime = new Date();
			while(true) {
				wait(t);
				t = time*60000 -(int)((new Date()).getTime()-oldTime.getTime());
				if(t <= 0) break;
				if(cntSeat!=36) {
					cnt =0;
					for(int i=0; i<waiting.indexOf(member); i++) {
						if(waiting.get(i).isAlive())
							cnt++;
					}
					if(cnt ==0) break;
				}
			}
		}
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if(seats[i][j]==0) {
					seats[i][j]=1;
					cntSeat++;
					c = (char)(i+65);
					seat = c.toString() + (j+1);
					break;
				}
			}
		}
		return seat;
	}

	public synchronized void cancelTicket(char c, int j) {
		int i = (int)c - 65;
		seats[i][j-1] = 0;
		cntSeat--;
		notifyAll();
	}
	
	public String toString() {
		return "제목: " + this.title + " / 상영 시간: " + this.startTime + ":00 - " + this.endTime + ":00";
	}

	public void showSeats() {
		System.out.println("******좌 석******");
		System.out.println("  1 2 3 4 5 6");
		for(int i=0; i<seats.length; i++) {
			System.out.print((char)(i+65));
			for(int j=0; j<seats[0].length; j++) {
				if(seats[i][j] == 0) {
					System.out.print(" O");
				}
				else {
					System.out.print(" X");
				}
			}
			System.out.println();
		}
		System.out.println("******************");
	}
	
	public void addMember(Member member) {
		waiting.add(member);
		member.start();
	}
	
	public boolean isAlive(int i) {
		return waiting.get(i).isAlive();
	}
	
	public Member getMember(int i) {
		return waiting.get(i);
	}
	
	public int getWaitingSize() {
		return waiting.size();
	}
	
	public void removeMember(int i) {
		waiting.remove(i);
	}
}
