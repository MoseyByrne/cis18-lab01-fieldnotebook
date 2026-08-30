import java.time.LocalDate;

public class BirdSighting extends Sighting {
    private boolean heardOnly;

    public BirdSighting(String species, int count, LocalDate when) {
        this(species, count, when, false, "");
    }

    public BirdSighting(String species, int count, LocalDate when, boolean heardOnly) {
        this(species, count, when, heardOnly, "");
    }

    public BirdSighting(String species, int count, LocalDate when, boolean heardOnly, String notes){
        super(species, count, when, notes);
        this.heardOnly = heardOnly;
    }

    public String describe(){
        String how = this.heardOnly ? "heard" : "seen";
        return  String.format("%dx %s (%s) on %s", count, species, how, when);
    }

    public boolean isHeardOnly() {
        return heardOnly;
    }
}
