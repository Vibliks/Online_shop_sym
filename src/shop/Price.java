package shop;

public class Price {
    private int withsub;
    private int acclimit;
    private int pricetolimit;
    private int abovelimit;

    public Price(int withsub, int acclimit, int pricetolimit, int abovelimit) {
        this.withsub = withsub;
        this.acclimit = acclimit;
        this.pricetolimit = pricetolimit;
        this.abovelimit = abovelimit;
    }


    @Override
    public String toString() {
        return "[shop.Price with Sub = " + withsub + ", shop.Price up to 3 = " + acclimit + ", shop.Price below 3 = " + pricetolimit + ", shop.Price = " + abovelimit + "]";
    }



    public void setwithsub(int withsub) {
        this.withsub = withsub;
    }

    public void setacclimit(int acclimit) {
        this.acclimit = acclimit;
    }

    public void setpricetolimit(int pricetolimit) {
        this.pricetolimit = pricetolimit;
    }

    public void setabovelimit(int abovelimit) {
        this.abovelimit = abovelimit;
    }


    public int getWithsub() {
        return withsub;
    }

    public int getAcclimit() {
        return acclimit;
    }

    public int getPricetolimit() {
        return pricetolimit;
    }

    public int getAbovelimit() {
        return abovelimit;
    }

}