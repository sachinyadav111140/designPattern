package structural.Facade.code;

public class PaymentProcessorImpl implements PaymentProcessor {
    @Override
    public void processPayment() {
        System.out.println("Payment processed successfully");
    }

}
