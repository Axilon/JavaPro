package trains;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Trains {
	private ArrayList<Train>listTrain = new ArrayList<>();
	public void addTrain(Train train){
		if(train==null){
			throw new IllegalArgumentException("Null");
		}
		listTrain.add(train);
		
	}
	public ArrayList<Train> getListTrain(){
		return new ArrayList<Train>(listTrain);
	}
	
	public String getTrainByTime(String timeFrom, String timeTo){
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date from = null;
		Date to = null;
		
		try {
			from = sdf.parse(timeFrom) ;
			to = sdf.parse(timeTo);
		} catch (Exception e) {
			System.out.println("Date/time formating ERROR!");
		}
		for (Train train : listTrain) {
			if(compareTo(train.getDeparture(), from)!=-1&& compareTo(train.getDeparture(), to)!=1){
				sb.append(train).append(System.lineSeparator());
			}
		}
		return sb.toString();
		
	}
	
	public int compareTo(Date a, Date b){
		return a.compareTo(b);
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Train train : listTrain) {
			sb.append(train).append(System.lineSeparator());
		}
		return sb.toString();
	}
	
}
