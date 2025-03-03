package structural.Decorator.code;

public class AddCreamDecorator extends CoffeeDecorator {

    public AddCreamDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with cream";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }

}
