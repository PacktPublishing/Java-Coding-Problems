package modern.challenge;

public class Cream extends CakeDecorator {

    public Cream(Cake cake) {
        super(cake);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateWithCream();
    }

    private String decorateWithCream() {
        return "with Cream ";
    }    
}
