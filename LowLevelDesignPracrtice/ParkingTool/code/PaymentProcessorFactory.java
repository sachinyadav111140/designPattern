public class PaymentProcessorFactory {
    public static PaymentProcessor getPaymentProcessor(PaymentType paymentType) {
        switch (paymentType) {
            case CARD:
                return new CardPaymentProcessor();
            case CASH:
                return new CashPaymentProcessor();
            default:
                return new CashPaymentProcessor();
        }
    }

}
