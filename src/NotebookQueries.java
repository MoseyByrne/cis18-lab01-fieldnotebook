import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NotebookQueries {

    // C1 sum(s.count for s in sightings)
    public static int totalOrganisms(FieldNotebook nb) {
        return nb.getSightings().stream().mapToInt(Describable::getCount).sum();
    }

    // C2 sorted({s.species for s in sightings})
    public static List<String> speciesSeen(FieldNotebook nb) {
        return nb.getSightings().stream().map(Describable::getSpecies).distinct().sorted().toList();
    }

    // C3 [s for s in sightings if s.count > n]
    public static List<Describable> sightingsOver(FieldNotebook nb, int n) {
        return nb.getSightings().stream().filter(s -> s.getCount() > n).toList();
    }

    // C4 max(totals, key=totals.get)
    public static String busiestSpecies(FieldNotebook nb) {
        return nb.getSightings().stream().collect(Collectors.groupingBy(
                Describable::getSpecies,
                Collectors.summingInt(Describable::getCount)
        )).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    // C5 ".join(s.species for s in sightings)
    public static String sightingsListAsString(FieldNotebook nb) {
        return nb.getSightings().stream().map(Describable::getSpecies).collect(Collectors.joining(", "));
    }

    // C6: return a Map<String, List<Sighting>> grouping every sighting by the month it was recorded in.
    public static Map<String, List<Describable>> groupByMonth(FieldNotebook nb) {
        return nb.getSightings().stream().collect(Collectors.groupingBy(
                s -> s.getWhen().getMonth().toString()
        ));
    }
}
