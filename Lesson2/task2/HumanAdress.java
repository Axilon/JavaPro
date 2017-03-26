/**
 * Created by Рома on 26.03.2017.
 */
public class HumanAdress {
    private String country;
    private String city;
    private String street;

    public HumanAdress(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public HumanAdress() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Country - "+ country+"\n"
        + "City - " + city+"\n"
        + "Street - " + street +"\n");
        return sb.toString();
    }
}
