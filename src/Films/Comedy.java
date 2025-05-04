package Films;
import Film_type.Film_type;

public class Comedy extends Program{
    private Film_type film_type;

    public Comedy(String title, int devices) {
        super(title, devices);
        this.film_type = Film_type.COMEDY;
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
        return title + ", typ: " + "komedia" + ", ile: " + devices + " urządzeia, " + "cena ";
    }
}
