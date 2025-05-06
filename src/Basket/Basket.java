package Basket;
import shop.*;
import java.util.List;
import Films.Program;
import Client.*;
import java.util.stream.Collectors;

public class Basket implements BasketInterface {
    private List<Program> program;

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(Client.GetName()).append(":\n");
//        for (Program wish : wishlist) {
//            if(wish.Getcena(hasSubscription()) != -1) {
//                sb.append("    ").append(wish.toString(sub)).append("\n");
//            }
//        }
//        return sb.toString();
//    }

    public void setProgram(List<Program> program) {
        this.program = program;
    }

    public List<Program> getProgram() {
        return program;
    }

    @Override
    public String toString() {
        if (program == null || program.isEmpty()) return "-- pusto";
        return program.stream()
                .map(p -> "    " + p.toString(true))  // lub: p.toString(client.hasSubscription()) jeśli masz referencję
                .collect(Collectors.joining("\n", "\n", ""));
    }




}
