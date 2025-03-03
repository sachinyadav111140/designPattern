public class CashPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double charge) {
        System.out.println("Processing cash payment of " + charge);
    }

}
