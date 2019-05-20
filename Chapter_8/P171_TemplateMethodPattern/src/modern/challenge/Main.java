package modern.challenge;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("Neapolitan pizza:");
        Pizza nPizza = new Pizza();
        PizzaMaker nMaker = new NeapolitanPizza();
        nMaker.make(nPizza);
        
        System.out.println();
        
        System.out.println("Greek pizza:");
        Pizza gPizza = new Pizza();
        PizzaMaker gMaker = new GreekPizza();
        gMaker.make(gPizza);
        
        System.out.println();
        
        System.out.println("Sicilian pizza:");
        Pizza sPizza = new Pizza();
        new PizzaLambda().make(sPizza, (Pizza p) 
                -> System.out.println("Add: bits of tomato, onion, anchovies, and herbs"));        
    }
    
}
