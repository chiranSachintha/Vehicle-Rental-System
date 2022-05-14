import java.util.ArrayList;

public class ElectricCar extends Vehicle {
    public ElectricCar(String registrationNumber, String make, String model) {
        super(registrationNumber);
        this.scheduleList = new ArrayList<>();
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.vehicleType = VehicleType.ELECTRIC_CAR;
    }
}
