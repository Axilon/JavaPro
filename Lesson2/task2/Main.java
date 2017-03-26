import java.io.File;

/**
 * Created by Рома on 26.03.2017.
 */
public class Main {
    public static void main(String[] args) {

        String [] phones = {"093-093-03-03","093-33-33245"};
        String [] sites = {"blablalba"};
        Human human = new Human("Roma","Boma",phones,sites,new HumanAdress("Ukr","Kiev","pupl"));
        JSONWorker.saveHumanToJSONFile(human,new File("humansave.txt"));

        Human hum = JSONWorker.loadFromJSONFile(new File("human.txt"));
        System.out.println(hum);



    }
}
