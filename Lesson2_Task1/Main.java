package trains;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {


	public static void main(String[] args) {
		Trains trains1 = new Trains();
		GregorianCalendar gc = new GregorianCalendar(2013, Calendar.DECEMBER, 19, 16, 37);
		Train t1 = new Train(1,"Kiev", "Moscow", gc.getTime(),gc.getTime());
		trains1.addTrain(t1);
		TrainsXMLWorker.saveToXML(trains1, "trainSave.xml");
		System.out.println(trains1);
		
		
		Trains trains2 = TrainsXMLWorker.loadTrainsLogFromFile(new File("trains.xml"));
		System.out.println(trains2);
		System.out.println(trains2.getTrainByTime("15:00", "19:00"));
	}

}
