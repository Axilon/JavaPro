import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.*;

/**
 * Created by Рома on 26.03.2017.
 */
public class JSONWorker {
    public static  void saveHumanToJSONFile(Human human, File file)  {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonSt = gson.toJson(human);
        try (PrintWriter pw = new PrintWriter(file)){
            pw.println(gsonSt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static  Human loadFromJSONFile(File file){
        Gson gson = new Gson();
        Human human = null;
        try {
            human = gson.fromJson(new FileReader(file),Human.class);
        } catch (JsonSyntaxException | JsonIOException |FileNotFoundException e) {
            e.printStackTrace();
        }
        return human;
    }
}
