package Films;
import Film_type.Film_type;

public class Comedy extends Program {

    public Comedy(String title, int devices) {
        super(title, devices);
    }

    @Override
    public Film_type getType() {
        return Film_type.COMEDY;
    }

    @Override
    public String toString(boolean hasSubscription) {
        double cena = Getcena(hasSubscription);
        if (cena < 0) {
            return title + ", typ: komedia, ile: " + devices + " urządzenia, ceny brak";
        } else {
            return title + ", typ: komedia, ile: " + devices + " urządzenia, cena " + Getcena(hasSubscription);
        }
    }
}

