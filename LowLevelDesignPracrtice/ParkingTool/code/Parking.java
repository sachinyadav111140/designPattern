import java.util.List;
import java.util.Map;

public class Parking {
    Map<VehicleType,List<SpotStatus>> parkingSpots;

    Parking(Map<VehicleType,List<SpotStatus>> parkingSpots) {
        
        this.parkingSpots = parkingSpots;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        List<SpotStatus> spots = parkingSpots.get(vehicle.getVehicleType());
        for (int i = 0; i < spots.size(); i++) {
            if (spots.get(i) == SpotStatus.FREE) {
                spots.set(i, SpotStatus.OCCUPIED);
                return true;
            }
        }
        return false;
    }
    public boolean unParkVehicle(Vehicle vehicle) {
        List<SpotStatus> spots = parkingSpots.get(vehicle.getVehicleType());
        for (int i = 0; i < spots.size(); i++) {
            if (spots.get(i) == SpotStatus.OCCUPIED) {
                spots.set(i, SpotStatus.FREE);
                return true;
            }
        }
        return false;
    }

    public boolean checkAvailability(VehicleType vehicleType) {
        List<SpotStatus> spots = parkingSpots.get(vehicleType);
        for (int i = 0; i < spots.size(); i++) {
            if (spots.get(i) == SpotStatus.FREE) {
                return true;
            }
        }
        return false;
    }
    
}
