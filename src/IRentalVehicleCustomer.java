public interface IRentalVehicleCustomer {
    void listAvailableVehicles(Schedule wantedSchedule, VehicleType type);

    boolean rentVehicle(String RegistrationNumber, Schedule wantedSchedule);
}
