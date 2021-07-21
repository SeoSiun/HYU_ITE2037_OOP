import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Member extends Thread{
    private String id;
    private String password;
    private ArrayList<Ticket> ticket;
    private Movie[] movies;
    private String title;
    private int time;

    public Member(String id, String password, Movie[] movies) {
        this.id = id;
        this.password = password;
        ticket = new ArrayList<Ticket>();
        this.movies = movies;
    }
    
    public Member(Member member) {
		this.id = member.id;
		this.password = member.password;
		this.ticket = member.ticket;
		this.movies = member.movies;
	}

	public int getCntTicket() {
        return ticket.size();
    }
    
    public String getId_() {
    	return this.id;
    }
    
    public void run() {
    	try {
			reserveTicket();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    public void reserveTicket() throws InterruptedException {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd.HH:mm");
    	int i;
    	String seat = null;
    	
    	for(i=0; i<movies.length; i++) {
    		if(this.title.equals(this.movies[i].getTitle())) {
    			seat = this.movies[i].reserveTicket(this.time,this);
    			break;
    		}
    	}
    	if(seat != null) {
			Theater.setTicketNumber((Theater.getTicketNumber())+1);
			ticket.add(new Ticket(movies[i].getTitle(), movies[i].getStartTime(), movies[i].getEndTime(), seat, Theater.getTicketNumber()));
			ticket.get(ticket.size()-1).setDate(format.format(new Date()));
		}
    }
    

    public void reserveTicket(int index, String seat){
    	movies[index].reserveTicket(seat.charAt(0), Character.getNumericValue(seat.charAt(1)));
    	ticket.add(new Ticket(movies[index].getTitle(), movies[index].getStartTime(), movies[index].getEndTime(), seat, Theater.getTicketNumber()));
    }
    
    public void reserveTicket(String title, int startTime, int endTime, String seat, int ticketNum){
    	for(int i=0; i<movies.length; i++) {
    		if(title.equals(movies[i].getTitle())) {
    			movies[i].reserveTicket(seat.charAt(0), Character.getNumericValue(seat.charAt(1)));
    			break;
    		}
    	}
    	ticket.add(new Ticket(title,startTime, endTime, seat, ticketNum));
    }

    public void showTicketList() {
        for(int i=0; i<ticket.size(); i++) {
            System.out.println(ticket.get(i).toString());
        }
    }
    
    public int showTicketList_() {
    	if(ticket.size()==0) {
    		System.out.println("예매한 영화가 없습니다.");
    		return -1;
    	}
    	for(int i=0; i<ticket.size(); i++) {
            System.out.println((i+1) + ". " + ticket.get(i).getTicket());
        }
    	return 0;
    }
    
    public void cancelTicket(int index) {
    	String seat = ticket.get(index).getSeat();
    	for(int i=0; i<movies.length; i++) {
    		if(ticket.get(index).getTitle().equals(movies[i].getTitle())) {
    			movies[i].cancelTicket(seat.charAt(0), Character.getNumericValue(seat.charAt(1)));
    			break;
    		}
    	}
    	ticket.remove(index);
    	System.out.println("해당 티켓을 취소하였습니다.");
    	
    }
    
	public void setTitle(String title) {
		this.title = title;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public String toDisplay() {
		String result = "";
		for(int i=0; i<ticket.size(); i++) {
			if(ticket.get(i).getDate() != null) {
				result = result + ticket.get(i).getDate() + "에 " + this.id + "님의 " + ticket.get(i).getTitle() +" 영화 " + ticket.get(i).getSeat() + " 좌석이 예매되었습니다.\n";
			}
		}
		return result;
	}

    public boolean equals(String id, String password) {
        if(this.id.equals(id) && this.password.equals(password)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean equalsId(String id) {
        if(this.id.equals(id)) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toSaveUserInfo(){
        return this.id + " " + this.password;
    }

    public String toSaveTicketInfo(){
        String result = "";
        result = result + ticket.size();
        for(int i=0; i<this.ticket.size(); i++){
            result = result + this.ticket.get(i).toSaveTicket();
        }
        return result;
    }
}