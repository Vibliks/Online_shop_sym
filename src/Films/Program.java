package Films;
import Film_type.Film_type;


public abstract class Program {
        protected String title;
        protected int devices;

        public Program(String title, int devices) {
            this.title = title;
            this.devices = devices;
        }

//        public boolean Getifsub(){
//            return true;
//        }

        public int Getcena(){



            return 0;
        }

        public String getTitle() {
            return title;
        }

        public int getDevices() {
            return devices;
        }

        public abstract Film_type getType();

        @Override
        public String toString() {
            return title + ", typ:" + getType() + ", ile: " + devices + " urządzeia, " + "cena " + Getcena();
        }
    }
//                                      Król Lear, typ: obyczaj, ile: 4 urządzenia, cena 10.00
//                                      Korona      (COMEDY)          on 2 devices