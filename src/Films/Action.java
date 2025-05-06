package Films;
import Film_type.Film_type;

public class Action extends Program {

    public Action(String title, int devices) {
        super(title, devices);
    }

    @Override
    public Film_type getType() {
        return Film_type.ACTION;
    }

    @Override
    public String toString(boolean hasSubscription) {
        double cena = Getcena(hasSubscription);
        if (cena < 0) {
            return title + ", typ: sensacja, ile: " + devices + " urządzenia, ceny brak";
        } else {
            return title + ", typ: sensacja, ile: " + devices + " urządzenia, cena " + Getcena(hasSubscription);
        }
    }
}
