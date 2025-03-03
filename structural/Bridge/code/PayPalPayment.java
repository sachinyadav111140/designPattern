package structural.Bridge.code;

public class PayPalPayment extends Payment {

    public PayPalPayment(PaymentGateway paymentGateway) {
        super(paymentGateway);
    }

    @Override
   public void makePayment() {
        System.out.println("Making payment using PayPal");
        paymentGateway.processPayment("PayPal", 100);
    }
}
