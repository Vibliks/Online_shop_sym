
    public abstract class Program {
        protected String title;
        protected int devices;

        public Program(String title, int devices) {
            this.title = title;
            this.devices = devices;
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
            return title + " (" + getType() + ") on " + devices + " devices";
        }
    }

