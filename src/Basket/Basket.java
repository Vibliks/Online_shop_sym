package Basket;
import shop.*;
import java.util.List;
import Films.Program;
import Client.*;
import java.util.stream.Collectors;

public class Basket implements BasketInterface {
    private List<Program> program;


    public void clearProgram() {
        if (program != null) {
            program.clear();
        }
    }

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
                .map(program -> "    " + program.toString(true))
                .collect(Collectors.joining("\n", "\n", ""));
    }






}
