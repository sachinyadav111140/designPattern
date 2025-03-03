package behavioral.Observer.code;

public class Client {
    public static void main(String[] args) {
        Subject product1 = new Product("Product1","available" );
        product1.registerObserver(new User("User1"));
        product1.registerObserver(new User("User2"));
        product1.registerObserver(new User("User3"));
        product1.setAvailability("available");    
    }

}
