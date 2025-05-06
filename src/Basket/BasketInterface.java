package Basket;

import shop.Price;
import Films.Program;

import java.util.ArrayList;
import java.util.List;

public interface BasketInterface {
    List<Program> programs = new ArrayList<>();
    Price price = null;

    default void addToList(Program program) {
        programs.add(program);
    }

    default void removeFromList(Program program) {
        programs.remove(program);
    }

    default void clearPrograms() {
        this.programs.clear();
    }

    default List<Program> getPrograms() {
        return programs;
    }

    default void removeGroupOfPrograms(List<Program> elements) {
        for (Program el : elements) {
            programs.remove(el);
        }
    }
}
