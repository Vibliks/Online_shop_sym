package Films;
import Film_type.Film_type;

public class Musical extends Program {

    public Musical(String title, int devices) {
        super(title, devices);
    }

    @Override
    public Film_type getType() {
        return Film_type.MUSICAL;
    }


    @Override
    public String toString(boolean hasSubscription) {
        double cena = Getcena(hasSubscription);
        if (cena < 0) {
            return title + ", typ: muzyczny, ile: " + devices + " urządzenia, ceny brak";
        } else {
            return title + ", typ: muzyczny, ile: " + devices + " urządzenia, cena " + Getcena(hasSubscription);
        }
    }
}
