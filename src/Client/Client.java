package Client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import BOOL.BOOL;
import Film_type.Film_type;
import Films.Program;
import static BOOL.BOOL.*;
import Basket.*;
import Payment.Payment_Type;
import shop.*;

public class Client implements Wishlist {
    protected String name;
    private double saldo;
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
        if (sub) {
            this.cena = 0;
        } else {
            this.cena = 1;
        }
        this.basket = new Basket();

    }

    public void pack() {
        Pricelist cennik = Pricelist.getPricelist();

        // Filtrowanie programów z ceną
        List<Program> withPrice = wishlist.stream()
                .filter(program -> cennik.calculatePrice(program.getType(), program.getTitle(), program.getDevices(), hasSubscription()) != -1)
                .collect(Collectors.toList());

        // Przekazanie programów do koszyka
        basket.setProgram(withPrice);

        // Usunięcie ich z listy życzeń
        wishlist.removeAll(withPrice);
    }

    public void pay(Enum<Payment_Type> Payment,boolean bool){
        for (Program program : wishlist) {
            boolean temp = hasSubscription();
            saldo = saldo - program.Getcena(temp);
        }
    }

    public void pay(){
        for (Program program : wishlist) {
            boolean temp = hasSubscription();
            deductSaldo(program.Getcena(temp);
        }
    }
    public boolean hasSubscription() {
        return sub;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getWallet() {
        return saldo;
    }

    public void returnVOD(Film_type film, String name, int numbofDevices){

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
            if(wish.Getcena(hasSubscription()) == -1) {
                sb.append("    ").append(wish.toString(sub)).append("\n");
            }
        }
        return sb.toString();
    }
}
