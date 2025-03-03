public abstract class Vehicle {
    private String licensePlate;
    private VehicleType vehicleType;
    Vehicle(String licensePlate, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
