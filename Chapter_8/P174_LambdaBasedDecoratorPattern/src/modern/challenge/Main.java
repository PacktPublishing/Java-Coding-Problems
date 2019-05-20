package modern.challenge;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {        
        
        CakeDecorator nutsAndCream = new CakeDecorator(
                (Cake c) -> c.decorate(" with Nuts"),
                (Cake c) -> c.decorate(" with Cream"));
        Cake cake = nutsAndCream.decorate(new Cake("Base cake"));

        System.out.println(cake.getDecorations());
        
        System.out.println("\nOr, like this:\n");
        
        CakeDecorator nuts = new CakeDecorator(
                (Cake c) -> c.decorate(" with Nuts"));

        CakeDecorator cream = new CakeDecorator(
                (Cake c) -> c.decorate(" with Cream"));

        Cake baseCake = new Cake("Base cake");
        Cake nutsCake = nuts.decorate(baseCake);
        Cake creamCake = cream.decorate(nutsCake);

        System.out.println(baseCake.getDecorations());
        System.out.println(nutsCake.getDecorations());
        System.out.println(creamCake.getDecorations());
    }

}
