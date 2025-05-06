package shop;

import Film_type.Film_type;

import java.util.HashMap;
import java.util.Map;

public class Pricelist {
    private static Pricelist INSTANCE;
    HashMap<String, Map<Film_type, Price>> HashPriceList = new HashMap<>();

    private Pricelist() {
    }

    public static Pricelist getPricelist() {
        if (INSTANCE == null) {
            INSTANCE = new Pricelist();
        }
        return INSTANCE;
    }

    public void add(Film_type film_type, String film_name, int price1, int price2, int price3, int price4) {
        Map<Film_type, Price> map = new HashMap<>();
        map.put(film_type, new Price(price1, price2, price3, price4));
        HashPriceList.put(film_name, map);
    }

    public void add(Film_type film_type, String film_name, int acclimit, int pricetolimit, int abovelimit) {
        add(film_type, film_name, 0, acclimit, pricetolimit, abovelimit);
    }


    public void add(Film_type film_type, String film_name, int withsub, int noSubPrice) {
        add(film_type, film_name, withsub, 0, noSubPrice, 0);
    }


    public void add(Film_type film_type, String film_name) {
        add(film_type, film_name, 0, 0, 0, 0);
    }


    public void remove(Film_type film_type, String film_name) {
        Map<Film_type, Price> innerMap = HashPriceList.get(film_name);
        if (innerMap != null) {
            Price price = innerMap.get(film_type);
            if (price != null) {
                price.setwithsub(0);
                price.setacclimit(0);
                price.setpricetolimit(0);
                price.setabovelimit(0);
            }
        }
    }

    public Price get(Film_type genre, String title) {
        Map<Film_type, Price> innerMap = HashPriceList.get(title);
        if (innerMap != null) {
            return innerMap.get(genre);
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String filmName : HashPriceList.keySet()) {
            sb.append("Film: ").append(filmName).append("\n");
            Map<Film_type, Price> innerMap = HashPriceList.get(filmName);
            for (Map.Entry<Film_type, Price> entry : innerMap.entrySet()) {
                sb.append("  Type: ").append(entry.getKey())
                        .append(" → ").append(entry.getValue()).append("\n");
            }
        }
        return sb.toString();
    }

    public static double calculatePrice(Film_type genre, String title, int numDevices, boolean hasSubscription) {
        Pricelist cennik = Pricelist.getPricelist();
        Price rule = cennik.get(genre, title);

        if (rule == null) {
            return -1;  // brak ceny
        }


        if(hasSubscription == true) {
            if (numDevices <= 3) {
                return rule.getWithsub();
            } else { return  3 * rule.getWithsub() + (numDevices - 3) * rule.getAbovelimit(); }
        } else {
            if (numDevices <= 3) {
                return rule.getPricetolimit() * numDevices;
            } else { return  3 * rule.getPricetolimit() + (numDevices - 3) * rule.getAbovelimit(); }
        }

    }
}