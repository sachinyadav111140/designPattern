public class CardPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double charge) {
        System.out.println("Processing card payment of " + charge);
    }

}
