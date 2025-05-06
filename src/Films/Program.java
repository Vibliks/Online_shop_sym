package Films;
import Film_type.Film_type;
import shop.Pricelist;

public abstract class Program implements ProgramInterface {
        protected String title;
        protected int devices;
        protected boolean hasSubscription;
        public static int suma;

    public Program(String title, int devices) {
            this.title = title;
            this.devices = devices;
        }

//        public boolean Getifsub(){
//            return true;
//        }

    public double Getcena(boolean hasSubscription) {
        return Pricelist.calculatePrice(getType(), getTitle(), getDevices(), hasSubscription);
    }


    public void setHasSubscription(boolean hasSubscription) {
        this.hasSubscription = hasSubscription;
    }


    public String getTitle() {
            return title;
        }

        public int getDevices() {
            return devices;
        }


        public abstract Film_type getType();


    @Override
    public String toString(boolean hasSubscription) {
        double cena = Getcena(hasSubscription);

        if (cena < 0) {
            return title + ", typ: " + getType() + ", ile: " + devices + " urządzenia, ceny brak";
        } else {
            return title + ", typ: " + getType() + ", ile: " + devices + " urządzenia, cena " + Getcena(hasSubscription);


        }
    }



}
//                                      Król Lear, typ: obyczaj, ile: 4 urządzenia, cena 10.00
//                                      Korona      (COMEDY)          on 2 devices