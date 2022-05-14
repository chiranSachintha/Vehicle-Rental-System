import java.util.ArrayList;

public class Van extends Vehicle {
    public Van(String registrationNumber, String make, String model) {
        super(registrationNumber);
        this.scheduleList = new ArrayList<>();
        this.make = make;
        this.model = model;
        this.vehicleType = VehicleType.VAN;
    }
}
