import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class LoLstuff {

    List<Champ> champs;

    public LoLstuff(List<Champ> root) {
        champs = root;
    }

    public static void main(String[] args) {
        LoLstuff ls = new LoLstuff(new Serialisation().readChampData());

        //System.out.println(ls.getDataSet());
        //System.out.println(ls.getFormattedNames());
        System.out.println(ls.getChampWithHighestBaseHp());
        //System.out.println(ls.getChampWithHighestHpOnLvl(20));
        //System.out.println(ls.getChampsWithLongNames(10));
        //System.out.println(ls.getChampsWithTag("Fighter"));
        //System.out.println(ls.getAllTags());


        //System.out.println(ls.primesForChamps());
        //System.out.println(ls.primesForChampsParallel());

        //System.out.println(ls.primesForChampsLazy());

    }

    public String getDataSet() {
        return champs.toString();
    }

    public String getFormattedNames() {
        return champs
                .stream()
                .map(x -> {return x.name;})
                .collect(Collectors.joining("\n"));
    }

    public String getChampWithHighestBaseHp() {
        return champs
                .stream()
                //.reduce((acc, x) -> (Double.compare(acc.stats.hp, x.stats.hp) > 0) ? acc : x)
                .max((x, y) -> Double.compare(x.stats.hp, y.stats.hp))
                .map(x -> x.name)
                .orElse(null);
    }

    public String getChampWithHighestHpOnLvl(int lvl) {
        return champs
                .stream()
                .max((x, y) ->
                        Double.compare(x.stats.hp + x.stats.hpperlevel * lvl, y.stats.hp + y.stats.hpperlevel * lvl))
                .map(x -> x.name)
                .orElse(null);
    }

    public List<String> getChampsWithLongNames(int charCount) {
        return champs
                .stream()
                .filter(x -> x.name.length() >= charCount)
                .map(x -> x.name)
                .collect(Collectors.toList());

    }

    public List<String> getChampsWithTag(String tag) {
        return champs
                .stream()
                .filter(x -> x.tags.contains(tag))
                .map(x -> x.name)
                .collect(Collectors.toList());
    }

    public Set<String> getAllTags() {
        return champs
                .stream()
                .flatMap(x -> x.tags.stream())
                .collect(Collectors.toSet());
    }

    public List<Integer> primesForChamps() {
        var start = System.nanoTime();
        var result = champs
                .stream()
                .map(x -> Primes.calcPrimes(4000))
                .collect(Collectors.toList());

        var end = System.nanoTime();
        System.out.println("Normal: " + (((double) end - start) / 1000000000) + " seconds");
        return result;
    }

    public List<Integer> primesForChampsParallel() {
        var start = System.nanoTime();
        var result = champs
                .parallelStream()
                .map(x -> Primes.calcPrimes(4000))
                .collect(Collectors.toList());

        var end = System.nanoTime();
        System.out.println("Parallel: " + (((double) end - start) / 1000000000) + " seconds");
        return result;
    }

    public int primesForChampsLazy() {
        var start = System.nanoTime();
        var result = champs
                .stream()
                .map(x -> Primes.calcPrimes(4000))
                .findFirst()
                .orElse(-1);

        var end = System.nanoTime();
        System.out.println("Normal: " + (((double) end - start) / 1000000000) + " seconds");
        return result;
    }

    public List<GuessingGameData> getGuessingGameData() {
        return champs
                .parallelStream()
                .map(x -> new GuessingGameData(x.name, x.description.replace(x.name, "???")))
                .collect(Collectors.toList());
    }

}
