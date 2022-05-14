import java.util.Date;
import java.util.List;

public class Vehicle implements IOverlappable {

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    String registrationNumber;
    String make;
    String model;
    VehicleType vehicleType;
    List<Schedule> scheduleList;
    public int hashCode() {
        return this.registrationNumber.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Vehicle) {
            Vehicle vehicle = (Vehicle) obj;
            return this.registrationNumber.equals(vehicle.registrationNumber);
        }
        return false;
    }

    public boolean addSchedule(Schedule schedule) {
        if (overlaps(schedule)) {
            return this.scheduleList.add(schedule);
        }
        return false;
    }

    public String toString() {
        return "Registration No: " + this.registrationNumber + ", Vehicle Type: " + this.vehicleType +
               ", Schedule List: " + this.scheduleList;
    }
    @Override
    public boolean overlaps(Schedule other) {
        Date newPickUpDate = other.pickUpDate;
        Date newDropOffDate = other.dropOffDate;
        for (Schedule schedule : this.scheduleList) {
            Date pickUpDate = schedule.pickUpDate;
            Date dropOffDate = schedule.dropOffDate;
            if ((newPickUpDate.compareTo(pickUpDate) >= 0 && newPickUpDate.compareTo(dropOffDate) < 0) ||
                (newDropOffDate.compareTo(pickUpDate) > 0 && newDropOffDate.compareTo(dropOffDate) <= 0)) {
                return false;
            }
        }
        return true;
    }
}
