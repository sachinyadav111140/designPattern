package structural.Bridge.code;

public abstract class Payment {
    
    PaymentGateway paymentGateway;
    public Payment(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
    public abstract void  makePayment();

}
