package Films;
import Film_type.Film_type;

public class Musical extends Program{
    private Film_type film_type;

    public Musical(String title, int devices) {
        super(title, devices);
        this.film_type = Film_type.MUSICAL;
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
        return title + ", typ: " + "muzyczny" + ", ile: " + devices + " urządzeia, " + "cena ";
    }
}
