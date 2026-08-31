import java.time.LocalDate;
import java.util.stream.Collectors;

public class FieldNotebookApp {
    static void main() {
        FieldNotebook nb = new FieldNotebook("A. Naturlist");
        nb.add(new BirdSighting("Marbled Murrelet", 2,
                LocalDate.of(2026, 3, 14), true));
        nb.add(new TreeSighting("Coast Redwood", 1,
                 LocalDate.of(2026, 3, 14), 87.4));
        nb.add(new BirdSighting("Steller's Jay", 6,
                LocalDate.of(2026, 3, 15)));
        nb.add(new Sighting("Banana Slug", 3,
                LocalDate.of(2026,3, 15)));
        nb.add(new TreeSighting("Douglas Fir", 4,
                LocalDate.of(2026, 3, 16), 52.0));

        nb.report();
        System.out.printf("Total organisms: %d%n", nb.totalOrganisms());
        System.out.printf("Species seen: %s%n", nb.speciesSeen());
        System.out.printf("Busiest species: %s%n", nb.busiestSpecies());
        System.out.println("Sightings over 2: " +
                nb.sightingOver(2).stream().map(Sighting::describe)
                        .collect(Collectors.toList())
        );
        System.out.println("----");
        new WeatherNote(LocalDate.of(2026,3,14), 48.0,"Sunny");
        nb.describeAll();

        System.out.println("-----");
        System.out.printf("Total organisms: %d%n", NotebookQueries.totalOrganisms(nb));
        System.out.printf("Species seen: %s%n", NotebookQueries.speciesSeen(nb));
        System.out.printf("Sightings over: %s%n", NotebookQueries.sightingsOver(nb, 2));
        System.out.printf("Busiest species: %s%n", NotebookQueries.busiestSpecies(nb));
        System.out.printf("Sight as string: %s%n", NotebookQueries.sightingsListAsString(nb));
        System.out.printf("Group by Month: %s%n", NotebookQueries.groupByMonth(nb));
    }
}
