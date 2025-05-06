package Films;
import Film_type.Film_type;

public class Drama extends Program {

    public Drama(String title, int devices) {
        super(title, devices);
    }

    @Override
    public Film_type getType() {
        return Film_type.DRAMA;
    }

    @Override
    public String toString(boolean hasSubscription) {
        double cena = Getcena(hasSubscription);
        if (cena < 0) {
            return title + ", typ: obyczaj, ile: " + devices + " urządzenia, ceny brak";
        } else {
            return title + ", typ: obyczaj, ile: " + devices + " urządzenia, cena " + Getcena(hasSubscription);
        }
    }
}
