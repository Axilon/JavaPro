package ru.bk.rom4ik2103;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class EstateAgency {
    @XmlElement(name = "flat")
    private  ArrayList<Flat>listFlat = new ArrayList<>();
    private static EstateAgency estateAgency = new EstateAgency();

    private EstateAgency() {
        super();
    }
    public static EstateAgency getInstance(){
        return estateAgency;
    }

    public synchronized void addFlat(Flat flat){
        listFlat.add(flat);
    }

    public ArrayList<Flat> getListFlat() {
        return new ArrayList<>(listFlat);
    }

    public void deleteFlatFromList(String discription){
        int count = 0;
        if(discription!=null){
            for (Flat flat : listFlat) {
                if(flat.getDiscription().equalsIgnoreCase(discription)){
            listFlat.remove(count);
            break;
                }
        count++;
            }
        }
    }
    public Flat findFlatByDiscription(String discription){

        for (Flat flat:listFlat) {
            if(flat.getDiscription().equalsIgnoreCase(discription)
                    ||(flat.getDiscription().toLowerCase().indexOf(discription))>=0){
                return flat;
            }
        }
        return null;
    }

    public void changePrice(String discription, double price){
        for (Flat flat:listFlat) {
            if(flat.getDiscription().equalsIgnoreCase(discription)){
                flat.setPrice(price);
            }
        }
    }
    public ArrayList<Flat> flatsMoreThanPrice (double from){
        ArrayList<Flat> moreThanListOfFlats = new ArrayList<>();
        for (Flat flat: listFlat) {
            if( flat.getPrice()<=from){
                moreThanListOfFlats.add(flat);
            }
        }
        return  moreThanListOfFlats;
    }
    public ArrayList<Flat> flatsLessThanPrice(double to){
        ArrayList<Flat> lessThanListOfFlats = new ArrayList<>();
        for (Flat flat: listFlat) {
            if( flat.getPrice()<=to){
                lessThanListOfFlats.add(flat);
            }
        }
        return  lessThanListOfFlats;
    }
    public ArrayList<Flat> flatsFromToPrice(double from, double to){
        ArrayList<Flat>fromToListofFlats = new ArrayList<>();
        for (Flat flat: listFlat) {
            if(flat.getPrice()>= from && flat.getPrice()<=to){
                fromToListofFlats.add(flat);
            }
        }
        return fromToListofFlats;
    }


    public ArrayList<Flat> flatsFromAmountOfRooms (int from){
        ArrayList<Flat> moreThanListOfFlats = new ArrayList<>();
        for (Flat flat: listFlat) {
            if( flat.getRoomAmount()<=from){
                moreThanListOfFlats.add(flat);
            }
        }
        return  moreThanListOfFlats;
    }
    public ArrayList<Flat> flatsToAmountOfRooms(int to){
        ArrayList<Flat> lessThanListOfFlats = new ArrayList<>();
        for (Flat flat: listFlat) {
            if( flat.getRoomAmount()<=to){
                lessThanListOfFlats.add(flat);
            }
        }
        return  lessThanListOfFlats;
    }
    public ArrayList<Flat> flatsFromToAmountOfRooms(int from, int to) {
        ArrayList<Flat> fromToListofFlats = new ArrayList<>();
        for (Flat flat : listFlat) {
            if (flat.getRoomAmount() > from && flat.getRoomAmount() < to) {
                fromToListofFlats.add(flat);
            }
        }
        return fromToListofFlats;
    }
        @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        listFlat.stream()
                .forEachOrdered(n -> sb.append(n).append(System.lineSeparator()));
        return sb.toString();
    }

}
