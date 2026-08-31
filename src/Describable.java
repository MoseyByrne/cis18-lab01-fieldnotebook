import java.time.LocalDate;

public interface Describable {
    String describe();
    int getCount();
    String getSpecies();
    LocalDate getWhen();
}
