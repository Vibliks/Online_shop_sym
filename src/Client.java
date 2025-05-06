import java.util.ArrayList;
import java.util.List;
import BOOL.BOOL;
import Films.Program;
import static BOOL.BOOL.*;

public class Client implements Wishlist{
    private String name;
    private int saldo;
    private BOOL SUB;
    private boolean sub;
    List<Program> wishlist = new ArrayList<>();
    private float cena;


    public Client(String name, int saldo, BOOL SUB) {
        this.name = name;
        this.saldo = saldo;
        if(SUB == YES) {
            this.sub = true;
        } else {this.sub = false;}
        this.wishlist = new ArrayList<>();
        if(sub == true){
            this.cena = 0;
        } else {
            this.cena = 1;
        }
    }



//    public void add(Program program) {
//        wishlist.add(program);
//    }

//    public List<Program> getWishList() {
//        return wishlist;
//    }

    public boolean hasSubscription() {
        return sub;
    }

    public int getSaldo() {
        return saldo;
    }

    public String getName() {
        return name;
    }

    public void deductSaldo(int amount) {
        this.saldo -= amount;
    }

//    @Override
//    public String toString() {
//        return name + ":\n\t" + for(Program film : wishlist){
//            String s = "\n\t" + getWishList().toString();
//        };
//                //"Client{name='" + name + "', saldo=" + saldo + ", sub=" + sub + ", wishlist=" + wishlist + "}";
//    }

    @Override
    public void add(Program program) {
        wishlist.add(program);
    }

    @Override
    public void remove(Program program) {
        wishlist.remove(program);
    }

    @Override
    public Wishlist getWishList(){
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(":\n");
        for (Program wish : wishlist) {
            sb.append("    ").append(wish.toString(sub)).append("\n");
        }



        return sb.toString();
    }

    public Basket GetBasket(){
        return new Basket();
    }

//    private double getPricePerDevice(Map<String, Map<GENRE, shop.Price>> prices, String title, GENRE genre, int devices) {
//        if (!prices.containsKey(title)) return -1.0;
//        if (!prices.get(title).containsKey(genre)) return -1.0;
//
//        boolean hasSub = (bool == hasSubscription.YES);
//        return prices.get(title).get(genre).getPricePerDevice(hasSub, devices);
//    }
//
//
//    private int getDevices(Program p) {
//        if (p instanceof Action) return ((Action) p).getDevices();
//        if (p instanceof Comedy) return ((Comedy) p).getDevices();
//        if (p instanceof Drama) return ((Drama) p).getDevices();
//        if (p instanceof Musical) return ((Musical) p).getDevices();
//        return 0;
//    }
//
//    @Override
//    public String toString() {
//        shop.Pricelist pricelist = shop.Pricelist.getPricelist();
//        Map<String, Map<GENRE, shop.Price>> prices = pricelist.getPrices();
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(name).append(":\n");
//
//        for (Program p : wishlist) {
//            double price = getPricePerDevice(prices, p.getTitle(), p.getGenre(), getDevices(p));
//            sb.append(p.toString());
//            sb.append(", ");
//            sb.append(price >= 0 ? "cena " + String.format("%.2f", price) : "ceny brak");
//            sb.append("\n");
//        }
//
//        return sb.toString();
//    }
}
// czy ma sub ile urzączeń 4