package structural.Facade.code;

public class Client {
    public static void main(String[] args) {
        ECommerceFacade eCommerceFacade = new ECommerceFacade( new InventoryManagerImpl(), new OrderFulfillmentImpl(), new PaymentProcessorImpl());
        eCommerceFacade.placeOrder();
    }

}
