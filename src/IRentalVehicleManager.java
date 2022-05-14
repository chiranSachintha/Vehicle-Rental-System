public interface IRentalVehicleManager {
    boolean addVehicle(Vehicle v);

    boolean deleteVehicle(String RegistrationNumber);

    void listVehicles();

    void listVehiclesOrdered();

    void generateReport(String fileName);
}
