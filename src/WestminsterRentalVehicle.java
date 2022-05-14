import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class WestminsterRentalVehicle implements IRentalVehicleManager, IRentalVehicleCustomer {
    private final Set<Vehicle> vehicleStore = new HashSet<>();

    @Override
    public void listAvailableVehicles(Schedule wantedSchedule, VehicleType type) {
        System.out.println(".....Details of Available Vehicles.....");
        for (Vehicle vehicle : vehicleStore) {
            if (vehicle.vehicleType == type && vehicle.overlaps(wantedSchedule)) {
                System.out.println(vehicle);
            }
        }
    }

    @Override
    public boolean rentVehicle(String registrationNumber, Schedule wantedSchedule) {
        Vehicle dummyVehicle  = new Vehicle(registrationNumber);
        for (Vehicle vehicle : vehicleStore) {
            if (vehicle.equals(dummyVehicle) && vehicle.overlaps(wantedSchedule)) {
                return vehicle.addSchedule(wantedSchedule);
            }
        }
        return false;
    }

    @Override
    public boolean addVehicle(Vehicle v) {
        return vehicleStore.add(v);
    }

    public boolean addVehicle(String registrationNumber, String make, String model, VehicleType type) {
        if (type == VehicleType.CAR) {
            return addVehicle(new Car(registrationNumber, make, model));
        }
        if (type == VehicleType.VAN) {
            return addVehicle(new Van(registrationNumber, make, model));
        }
        if (type == VehicleType.MOTORBIKE) {
            return addVehicle(new MotorBike(registrationNumber, make, model));
        }
        if (type == VehicleType.ELECTRIC_CAR) {
            return addVehicle(new ElectricCar(registrationNumber, make, model));
        }
        return false;
    }

    @Override
    public boolean deleteVehicle(String registrationNumber) {
        return vehicleStore.remove(new Vehicle(registrationNumber));
    }

    @Override
    public void listVehicles() {
        System.out.println(".....Details of Available Vehicles.....");
        for (Vehicle vehicle : vehicleStore) {
            System.out.println(vehicle);
        }
    }

    @Override
    public void listVehiclesOrdered() {

    }

    @Override
    public void generateReport(String fileName) {

    }

    public static VehicleType getVehicleType(String type) {
        type = type.toLowerCase(Locale.ROOT);
        switch (type) {
            case "car":
                return VehicleType.CAR;
            case "van":
                return VehicleType.VAN;
            case "motorbike":
                return VehicleType.MOTORBIKE;
            case "electric_car":
                return VehicleType.ELECTRIC_CAR;
            default:
                return VehicleType.OTHER;
        }
    }
}
