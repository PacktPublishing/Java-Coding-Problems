package modern.challenge;

import java.util.function.Consumer;

public class PizzaLambda {

    public void make(Pizza pizza, Consumer<Pizza> addTopIngredients) {        
        makeDough(pizza);
        addTopIngredients.accept(pizza);
        bake(pizza);
    }

    private void makeDough(Pizza p) {
        System.out.println("Make dough");
    }

    private void bake(Pizza p) {
        System.out.println("Bake the pizza");
    }
}
