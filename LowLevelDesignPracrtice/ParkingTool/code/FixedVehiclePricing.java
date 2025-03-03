public class FixedVehiclePricing implements VehiclePricing {
    private final double price = 10.0;
    
    @Override
    public double calculatePrice(Ticket ticket) {
        
        return price;
    }

}
