package behavioral.Strategy.code;

public class Client {
    public static void main(String[] args) {
        Context context = new Context(new Strategy1());
        context.executeStrategy();

        context = new Context(new Strategy2());
        context.executeStrategy();

 }

}
