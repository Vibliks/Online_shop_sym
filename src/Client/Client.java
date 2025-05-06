package Client;

import java.util.ArrayList;
import java.util.List;
import BOOL.BOOL;
import Films.Program;
import static BOOL.BOOL.*;
import Basket.*;

public class Client implements Wishlist {
    protected String name;
    private int saldo;
    private BOOL SUB;
    private boolean sub;
    List<Program> wishlist = new ArrayList<>();
    private float cena;
    Basket basket;
    Wishlist wishlist1;


    public Client(String name, int saldo, BOOL SUB) {
        this.name = name;
        this.saldo = saldo;
        if (SUB == YES) {
            this.sub = true;
        } else {
            this.sub = false;
        }
        this.wishlist = new ArrayList<>();
        if (sub == true) {
            this.cena = 0;
        } else {
            this.cena = 1;
        }
    }

    public void pack() {

    }

    public boolean hasSubscription() {
        return sub;
    }

    public int getSaldo() {
        return saldo;
    }

    public Basket getBasket() {
        return basket;
    }

    public String getName() {
        return name;
    }

    public void deductSaldo(int amount) {
        this.saldo -= amount;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(":\n");
        for (Program wish : wishlist) {
            sb.append("    ").append(wish.toString(sub)).append("\n");
        }


        return sb.toString();
    }

    public String getWishlist() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(":\n");
        for (Program wish : wishlist) {
            if(wish.Getcena(hasSubscription()) != -1) {
                sb.append("    ").append(wish.toString(sub)).append("\n");
            }
        }
        return sb.toString();
    }
}
