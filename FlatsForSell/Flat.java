package ru.bk.rom4ik2103;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "flat")
public class Flat implements Serializable{
    private static final long serialVersionUID = 1l;
    private String discription;
    private int roomAmount;
    private String adress;
    private int floor;
    private double price;

    public Flat(String discription, int roomAmount, String adress, int floor, double price) {
        this.discription = discription;
        this.roomAmount = roomAmount;
        this.adress = adress;
        this.floor = floor;
        this.price = price;
    }

    public Flat() {
    }
    @XmlElement
    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
    @XmlElement
    public int getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(int roomAmount) {
        this.roomAmount = roomAmount;
    }
    @XmlElement
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    @XmlElement
    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
    @XmlElement
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "<p>Flat" +"<br>"+
                "discription=" + discription +"<br>"+
                "roomAmount=" + roomAmount +"<br>"+
                "adress=" + adress +"<br>"+
                "floor=" + floor +"<br>"+
                "price=" + price +"<br></p>";
    }
}
