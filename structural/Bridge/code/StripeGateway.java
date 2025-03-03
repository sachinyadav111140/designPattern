package structural.Bridge.code;

public class StripeGateway implements PaymentGateway {
    @Override
    public void processPayment(String paymentType, double amount) {
        System.out.println("Processing payment of " + amount + " using Stripe");
    }


}
