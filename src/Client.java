import java.util.ArrayList;
import java.util.List;
import BOOL.BOOL;
import Films.Program;
import static BOOL.BOOL.*;

public class Client {
    private String name;
    private int saldo;
    private BOOL SUB;
    private boolean sub;
    private List<Program> wishList;

    public Client(String name, int saldo, BOOL SUB) {
        this.name = name;
        this.saldo = saldo;
        if(SUB == YES) {
            this.sub = true;
        } else {this.sub = false;}
        this.wishList = new ArrayList<>();
    }

    public void add(Program program) {
        wishList.add(program);
    }

    public List<Program> getWishList() {
        return wishList;
    }

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

    @Override
    public String toString() {
        return "Client{name='" + name + "', saldo=" + saldo + ", sub=" + sub + ", wishList=" + wishList + "}";
    }
}
