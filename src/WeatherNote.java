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
        return String.format("Weather on %s: %.1f degrees C, %s", date, temperatureC, conditions);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public String getSpecies() {
        return "Weather";
    }

    @Override
    public LocalDate getWhen() {
        return this.date;
    }
}
