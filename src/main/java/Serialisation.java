import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Serialisation {

    public List<Champ> readChampData() {
        try(FileReader reader = new FileReader("LolChamps.json")) {
            JsonElement root = JsonParser.parseReader(reader);
            Gson gson = new Gson();
            List<Champ> champs = new ArrayList<>();
            for(JsonElement o : root.getAsJsonArray()) {
               champs.add(gson.fromJson(o,Champ.class));
            }
            return champs;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}


