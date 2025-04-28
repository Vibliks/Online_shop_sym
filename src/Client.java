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



    public Client(String name, int saldo, BOOL SUB) {
        this.name = name;
        this.saldo = saldo;
        if(SUB == YES) {
            this.sub = true;
        } else {this.sub = false;}
        this.wishlist = new ArrayList<>();
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
    public Wishlist getWishList() {
        return this;
    }
}
