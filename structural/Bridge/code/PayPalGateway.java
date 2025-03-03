package structural.Bridge.code;

public class PayPalGateway implements PaymentGateway {
    @Override
    public void processPayment(String paymentType, double amount) {
        System.out.println("Processing payment using PayPal");
    }

}
