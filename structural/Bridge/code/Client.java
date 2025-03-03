package structural.Bridge.code;

public class Client {
    public static void main(String[] args) {
        
        PaymentGateway paymentGateway = new StripeGateway();
    
        PaymentGateway paymentGateway2 = new PayPalGateway();

        Payment payment = new CreditCardPayment(paymentGateway);
        payment.makePayment();  
        Payment payment2 = new PayPalPayment(paymentGateway2);
        payment2.makePayment();  

       
    }

}
