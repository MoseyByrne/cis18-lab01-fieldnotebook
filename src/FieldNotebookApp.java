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
        nb.add(new Sighting("Bananna Slug", 3,
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
    }
}
