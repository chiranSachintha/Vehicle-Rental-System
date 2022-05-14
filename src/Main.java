import java.text.ParseException;
import java.util.Scanner;

public class Main {
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        WestminsterRentalVehicle westminsterRentalVehicle = new WestminsterRentalVehicle();
        while (true) {
            System.out.println(".....Customer Menu.....");
            System.out.println("     * To find a vehicle please enter `find`");
            System.out.println("     * To rent a vehicle please enter `rent`");
            System.out.println("     * Move Admin Menu please enter `admin`");
            System.out.println("     * To exit please enter `exit`");
            System.out.print("Enter a key: ");
            String input = reader.next();
            if (input.equals("exit")) {
                break;
            }
            switch (input) {
                case "find":
                case "rent":
                    Main.customerPortal(input, westminsterRentalVehicle);
                    break;
                case "admin":
                    Main.adminPortal(westminsterRentalVehicle);
            }
        }
    }

    public static void adminPortal(WestminsterRentalVehicle westminsterRentalVehicle) {
        String registerNo;
        String make;
        String model;
        String type;
        String input;
        while (true) {
            System.out.println(".....Admin Menu.....");
            System.out.println("     * To add a vehicle please enter `add`");
            System.out.println("     * To delete a vehicle please enter `delete`");
            System.out.println("     * To get vehicle list please enter `list`");
            System.out.println("     * To get customer menu please enter `customer`");
            System.out.print("Press a key: ");
            input = reader.next();
            input = input.toLowerCase();
            if (input.equals("customer")) {
                break;
            }
            switch (input) {
                case "add":
                    System.out.print("     * Enter vehicle registerNo: ");
                    registerNo = reader.next();
                    System.out.print("     * Enter vehicle make: ");
                    make = reader.next();
                    System.out.print("     * Enter vehicle model: ");
                    model = reader.next();
                    System.out.print("     * Enter vehicle vehicle type: ");
                    type = reader.next();
                    VehicleType vehicleType = WestminsterRentalVehicle.getVehicleType(type);
                    if (vehicleType == VehicleType.OTHER) {
                        System.out.println(type + "vehicle type not available");
                        break;
                    }
                    if (westminsterRentalVehicle.addVehicle(registerNo, make, model, vehicleType)) {
                        System.out.println("Successfully Added");
                    } else {
                        System.out.println("Operation failed");
                    }
                    break;
                case "delete":
                    System.out.print("     * Enter vehicle registerNo: ");
                    registerNo = reader.next();
                    westminsterRentalVehicle.deleteVehicle(registerNo);
                    break;
                case "list":
                    westminsterRentalVehicle.listVehicles();
            }
        }
    }

    public static void customerPortal(String input, WestminsterRentalVehicle westminsterRentalVehicle) {
        String type;
        String pickUpDate;
        String dropOffDate;
        Schedule schedule;
        switch (input) {
            case "find":
                System.out.print("     * Enter vehicle type: ");
                type = reader.next();
                VehicleType vehicleType = WestminsterRentalVehicle.getVehicleType(type);
                System.out.print("     * Enter pick-up date: ");
                pickUpDate = reader.next();
                System.out.print("     * Enter drop-Off date: ");
                dropOffDate = reader.next();
                try {
                    schedule = new Schedule(pickUpDate, dropOffDate);
                    westminsterRentalVehicle.listAvailableVehicles(schedule, vehicleType);
                } catch (ParseException parseException) {
                    System.out.println("     * Invalid date format. Date format should be yyyy-MM-dd");
                }
                break;
            case "rent":
                System.out.print("     * Enter vehicle registerNo: ");
                String registerNo = reader.next();
                System.out.print("     * Enter pick-up date: ");
                pickUpDate = reader.next();
                System.out.print("     * Enter drop-Off date: ");
                dropOffDate = reader.next();
                try {
                    schedule = new Schedule(pickUpDate, dropOffDate);
                    if (westminsterRentalVehicle.rentVehicle(registerNo, schedule)) {
                        System.out.println("     * Rent Successfully");
                    } else {
                        System.out.println("     * Failed to Rent");
                    }
                } catch (ParseException parseException) {
                    System.out.println("     * Invalid date format. Date format should be yyyy-MM-dd");
                }
        }
    }
}
