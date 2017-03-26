import java.util.Arrays;

/**
 * Created by Рома on 26.03.2017.
 */
public class Human {
    private String name;
    private String surname;
    private String [] phones;
    private String [] sites;
    private HumanAdress address;

    public Human(String name, String surname, String[] phones, String[] sites, HumanAdress address) {
        this.name = name;
        this.surname = surname;
        this.phones = phones;
        this.sites = sites;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public String[] getSites() {
        return sites;
    }

    public void setSites(String[] sites) {
        this.sites = sites;
    }

    public HumanAdress getHumanAdress() {
        return address;
    }

    public void setHumanAdress(HumanAdress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name - " + name +";\n"
                + "Surname - " + surname +";\n");
                sb.append ((phones!=null ? "Phones: " + Arrays.asList(phones).subList(0,phones.length)+", ": "")+"\n");
                sb.append((sites!=null ? "Sites: "+ Arrays.asList(sites).subList(0,sites.length):"")+"\n");
                sb.append("Address:" + address);


        return sb.toString();
    }
}
