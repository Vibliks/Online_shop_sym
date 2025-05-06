package Client;

import Basket.Basket;
import Films.Program;

public interface Wishlist {

    public void add(Program program);

    public void remove(Program program);

    public Wishlist getWishList();

    public Basket getBasket();

    public String toString();

}
