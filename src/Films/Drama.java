package Films;
import Film_type.Film_type;

public class Drama extends Program{
    private Film_type film_type;

    public Drama(String title, int devices) {
        super(title, devices);
        this.film_type = Film_type.DRAMA;
    }

    public String getTitle() {
        return title;
    }

    public int getDevices() {
        return devices;
    }

    @Override
    public Film_type getType(){
        return this.film_type;
    }

    @Override
    public String toString() {
        return title + ", typ: " + "obyczaj" + ", ile: " + devices + " urządzeia, " + "cena ";
    }
}
