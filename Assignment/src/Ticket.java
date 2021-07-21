public class Ticket {
	private String title;
	private int startTime;
	private int endTime;
	private String seat;
	private int ticketNumber;
	private String date;
	

	public Ticket(String title, int startTime, int endTime, String seat, int ticketNumber) {
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.seat = seat;
		this.ticketNumber = ticketNumber;
		this.date = null;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getSeat() {
		return seat;
	}

	public String toString() {
		return "Ticket number: " + this.ticketNumber + " / " + this.title + " / " + this.startTime + ":00 - " + this.endTime + ":00 / Seat: " + this.seat;
	}

	public String getTicket() {
		return "Ticket: " + this.ticketNumber + " / 제목: " + this.title + " / 상영시간: " + this.startTime + ":00 - " + this.endTime + ":00 / Seat: " + this.seat;
	}
	
	public String toSaveTicket(){
		return "\n" + this.title + "/" + this.startTime + "/" + this.endTime + "/" + this.seat + "/" +this.ticketNumber;
	}
}