import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Champ {
    String id;
    int key;
    String name;
    String title;
    Set<String> tags;
    String description;
    Stats stats;


    @Override
    public String toString() {
        return "Champ{" +
                "id='" + id + '\'' +
                ", key=" + key +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", tags=" + tags.toString() +
                ", description='" + description + '\'' +
                ", stats=" + stats +
                '}';
    }
}
