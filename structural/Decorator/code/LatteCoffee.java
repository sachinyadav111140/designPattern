package structural.Decorator.code;

public class LatteCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Latte Coffee";
    }

    @Override
    public double getCost() {
        return 3;
    }
}
