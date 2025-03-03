package structural.Decorator.code;

public class AddZeroSugarDecorator extends CoffeeDecorator {

    public AddZeroSugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with zero sugar";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }
}
