import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class HourlyVehiclePricing implements VehiclePricing {
    Map<VehicleType, Double> vehicleTypeToHourlyRate = new HashMap<>();
    
    HourlyVehiclePricing() {
        vehicleTypeToHourlyRate.put(VehicleType.CAR, 10.0);
        vehicleTypeToHourlyRate.put(VehicleType.BIKE, 5.0);
        vehicleTypeToHourlyRate.put(VehicleType.TRUCK, 15.0);
    }

    @Override
    public double calculatePrice(Ticket ticket) {
        LocalDateTime checkOutTime = LocalDateTime.now() ;
        LocalDateTime checkInTime = ticket.getEntryTime();
        long hours = (long) Math.ceil(java.time.Duration.between(checkInTime, checkOutTime).toMinutes() / 60.0);
        return hours * vehicleTypeToHourlyRate.get(ticket.getVehicle().getVehicleType());
    }

}
