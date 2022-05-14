import java.util.ArrayList;

public class Car extends Vehicle {
    public Car(String registrationNumber, String make, String model) {
        super(registrationNumber);
        this.scheduleList = new ArrayList<>();
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.vehicleType = VehicleType.CAR;
    }
}
