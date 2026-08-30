import java.time.LocalDate;

public class WeatherNote implements Describable{
    private LocalDate date;
    private double temperatureC;
    private String conditions;

    public WeatherNote(LocalDate date, double temperatureC, String conditions) {
        this.date =date;
        this.temperatureC = temperatureC;
        this.conditions = conditions;
    }

    @Override
    public String describe() {
        return String.format("Wether on %s: %.1f degrees C, %s", date, temperatureC, conditions);
    }
}
