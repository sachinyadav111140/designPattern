package structural.Bridge.code;

public class CreditCardPayment extends Payment {

    public CreditCardPayment(PaymentGateway paymentGateway) {
        super(paymentGateway);
    }

    @Override
   public void makePayment() {
        System.out.println("Making payment using credit card");
        paymentGateway.processPayment("credit card", 100.0);
    }

}
