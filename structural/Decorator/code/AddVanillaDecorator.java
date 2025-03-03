package structural.Decorator.code;

public class AddVanillaDecorator extends CoffeeDecorator {

    public AddVanillaDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with vanilla";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }

}
