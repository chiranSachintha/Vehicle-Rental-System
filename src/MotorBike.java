import java.util.ArrayList;

public class MotorBike extends Vehicle {
    public MotorBike(String registrationNumber, String make, String model) {
        super(registrationNumber);
        this.scheduleList = new ArrayList<>();
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.vehicleType = VehicleType.MOTORBIKE;
    }
}
