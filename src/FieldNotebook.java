import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FieldNotebook {
    private String owner;
    private List<Sighting> sightings;

    public FieldNotebook(String owner){
        this.owner = owner;
        this.sightings = new ArrayList<>();
    }

    public void add(Sighting s) {
        sightings.add(s);
    }

    public int totalOrganisms(){
        return sightings.stream().mapToInt(Sighting::getCount).sum();
    }

    public List<String> speciesSeen() {
        return sightings.stream()
                .map(Sighting::getSpecies)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public String busiestSpecies() {
        Map<String, Integer> totals = new HashMap<>();
        for(Sighting s : sightings ) {
            totals.merge(s.getSpecies(), s.getCount(), Integer::sum);
        }
        return totals.entrySet().stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public List<Sighting> sightingOver(int n) {
        return sightings.stream().filter( s -> s.getCount() >n)
                .collect(Collectors.toList());
    }

    public void report() {
        System.out.printf("--- %s's notebook ---%n", owner);
        for(Sighting s : sightings) {
            System.out.println(" " + s.describe());
        }
    }
}
