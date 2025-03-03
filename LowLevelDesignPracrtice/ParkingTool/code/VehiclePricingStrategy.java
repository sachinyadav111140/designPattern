public class VehiclePricingStrategy {
    private VehiclePricing vehiclePricing;
    VehiclePricingStrategy(VehiclePricing vehiclePricing) {
        this.vehiclePricing = vehiclePricing;
    }
    public double calculatePrice(Ticket ticket) {
        return vehiclePricing.calculatePrice(ticket);
    }
}
