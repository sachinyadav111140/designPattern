public class PaymenyStrategy {
    private PaymentProcessor paymentProcessor;
    PaymenyStrategy(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }
    public void processPayment(double payment) {
        paymentProcessor.processPayment(payment);
    }

}
