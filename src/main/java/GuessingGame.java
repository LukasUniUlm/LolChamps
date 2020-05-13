import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        LoLstuff ls = new LoLstuff(new Serialisation().readChampData());

        List<GuessingGameData> data = ls.getGuessingGameData();

        Scanner s = new Scanner(System.in);
        Random r = new Random();

        while(true) {
            var currentGuessData =  data.get(r.nextInt(data.size()));
            System.out.println("Who is this champion: " + currentGuessData.description);
            var line = s.nextLine();
            if(line.equals("exit")) {
                break;
            }
            if(line.equals(currentGuessData.name)) {
                System.out.println("Exactly!");
            } else {
                System.out.println("Wrong! The right answer would have been: " + currentGuessData.name);
            }
        }

    }
}

class GuessingGameData {
    String name;
    String description;

    public GuessingGameData(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
