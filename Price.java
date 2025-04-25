public class Price {
    private int price1;
    private int price2;
    private int price3;
    private int price4;

    public Price(int price1, int price2, int price3, int price4) {
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
        this.price4 = price4;
    }

    @Override
    public String toString() {
        return "[Price with Sub = " + price1 + ", Price up to 3 =" + price2 + ", Price below 3 =" + price3 + ", Price =" + price4 + "]";
    }

//    public Price(int price1, int price2, int price3) {
//        this.price1 = price1;
//        this.price2 = price2;
//        this.price3 = price3;
//    }
}
