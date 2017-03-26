package trains;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Train {
	private int id = 0;
	private String from;
	private String to;
	private Date date;
	private Date departure;
	public Train(int id, String from, String to, Date date, Date departure) {
		super();
		this.from = from;
		this.to = to;
		this.date = date;
		this.departure = departure;
		this.id = id;
		
	}
	public Train() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDeparture() {
		return departure;
	}
	public void setDeparture(Date departure) {
		this.departure = departure;
	}
	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm");
		return "Train : \n----------------\nid-" + id+"\nFrom: "+ from+"\nTo: "+ to+"\n"
				+ "Date: "+dateFormat.format(date)+"\nDeparture: "+time.format(departure);
	}
	
}
