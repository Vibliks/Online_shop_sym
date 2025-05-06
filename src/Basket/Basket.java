package Basket;
import shop.*;
import Films.Program;
import Client.*;

import java.util.List;
import java.util.stream.Collectors;

public class Basket implements BasketInterface {
    private List<Program> programs;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Client.GetName()).append(":\n");
        for (Program wish : wishlist) {
            if(wish.Getcena(hasSubscription()) != -1) {
                sb.append("    ").append(wish.toString(sub)).append("\n");
            }
        }
        return sb.toString();
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    public List<Program> getPrograms() {
        return programs;
    }



}
