package structural.Facade.code;

public class ECommerceFacade {
    private InventoryManager inventoryManager;
    private OrderFulfillment orderFulfillment;
    private PaymentProcessor paymentProcessor;

    public ECommerceFacade(InventoryManager inventoryManager, OrderFulfillment orderFulfillment, PaymentProcessor paymentProcessor) {
        this.inventoryManager = inventoryManager;
        this.orderFulfillment = orderFulfillment;
        this.paymentProcessor = paymentProcessor;
    }

    public void placeOrder() {
        inventoryManager.updateInventory();
        orderFulfillment.fulfillOrder();
        paymentProcessor.processPayment();
    }

}
