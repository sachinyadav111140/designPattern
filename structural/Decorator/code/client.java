package structural.Decorator.code;

public class client {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " " + coffee.getCost());
        coffee = new AddCreamDecorator(coffee);
        System.out.println(coffee.getDescription() + " " + coffee.getCost());
        coffee = new AddVanillaDecorator(coffee);
        System.out.println(coffee.getDescription() + " " + coffee.getCost());

        Coffee coffee2 = new LatteCoffee();
        System.out.println(coffee2.getDescription() + " " + coffee2.getCost());
        coffee2 = new AddCreamDecorator(coffee2);
        System.out.println(coffee2.getDescription() + " " + coffee2.getCost());
        coffee2 = new AddZeroSugarDecorator(coffee2);
        System.out.println(coffee2.getDescription() + " " + coffee2.getCost());
    }

}
