import java.util.HashMap;
import java.util.Map;

public class Pricelist {
    private static Pricelist INSTANCE;
    HashMap<String, Map<Film_type, Price>> HashPriceList = new HashMap<>();

    private Pricelist() {}

    public static Pricelist getPricelist() {
        if (INSTANCE == null) {
            INSTANCE = new Pricelist();
        }
        return INSTANCE;
    }

    // Full 6-param version
    public void add(Film_type film_type, String film_name, int price1, int price2, int price3, int price4) {
        Map<Film_type, Price> map = new HashMap<>();
        map.put(film_type, new Price(price1, price2, price3, price4));
        HashPriceList.put(film_name, map);
    }

    // Overloaded 5-param version
    public void add(Film_type film_type, String film_name, int price1, int price2, int price3) {
        add(film_type, film_name, price1, price2, price3, 0);
    }

    // Overloaded 4-param version
    public void add(Film_type film_type, String film_name, int price1, int price2) {
        add(film_type, film_name, price1, price2, 0, 0);
    }

    // Overloaded 4-param version
    public void add(Film_type film_type, String film_name) {
        add(film_type, film_name, 0, 0, 0, 0);
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

}
