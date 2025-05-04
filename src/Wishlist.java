import Films.Program;

import java.util.List;

public interface Wishlist {

    public void add(Program program);

    public void remove(Program program);

    public Wishlist getWishList();

    public String toString();
}
