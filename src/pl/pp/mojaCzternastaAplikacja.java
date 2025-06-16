package pl.pp;
// File: RentalTest.java

import java.util.ArrayList;
import java.util.List;

public class mojaCzternastaAplikacja {
    public static void main(String[] args) {
        // Create fuel type instances
        FuelType dieselType = new DieselFuel();
        FuelType petrolType = new PetrolFuel();
        FuelType electricType = new ElectricFuel();

        // Create a list to hold vehicles
        List<Vehicle> vehicles = new ArrayList<>();

        // Create sample vehicles
        Car myCar = new Car("KR12345", "VINCAR001", "Blue", 50000, 6.5, 45, 10000, petrolType, 5);
        vehicles.add(myCar);

        Truck myTruck = new Truck("WGM5432", "VINTRK002", "White", 120000, 25.0, 200, 150000, dieselType, 12000);
        vehicles.add(myTruck);

        Motorcycle myMotorcycle = new Motorcycle("SCZBIKE", "VINMOTO003", "Black", 25000, 4.0, 15, 5000, petrolType, false);
        vehicles.add(myMotorcycle);

        ConstructionEquipment myExcavator = new ConstructionEquipment("KOP111", "VINCEX004", "Yellow", 300000, 10.0, 100, 500, dieselType, 1250);
        vehicles.add(myExcavator);

        Car myElectricCar = new Car("ELC4R", "VINELC005", "Silver", 90000, 15.0, 60, 2000, electricType, 5);
        vehicles.add(myElectricCar);

        System.out.println("--- Initial Vehicle States ---");
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }

        System.out.println("\n--- Performing Operations ---");

        // Test Car
        System.out.println("\nTesting Car: " + myCar.getRegistrationNumber());
        myCar.drive(100);
        myCar.refuel(20);
        myCar.drive(700);

        // Test Truck
        System.out.println("\nTesting Truck: " + myTruck.getRegistrationNumber());
        myTruck.drive(300);
        System.out.println("Truck payload: " + myTruck.getPayloadCapacity() + "kg");

        // Test Motorcycle
        System.out.println("\nTesting Motorcycle: " + myMotorcycle.getRegistrationNumber());
        myMotorcycle.drive(50);
        System.out.println("Motorcycle has sidecar: " + myMotorcycle.hasSidecar());

        // Test Construction Equipment
        System.out.println("\nTesting Excavator: " + myExcavator.getRegistrationNumber());
        myExcavator.drive(5);
        myExcavator.operate(8);
        myExcavator.refuel(50);
        myExcavator.operate(3);

        // Test Electric Car
        System.out.println("\nTesting Electric Car: " + myElectricCar.getRegistrationNumber());
        myElectricCar.drive(200);
        myElectricCar.refuel(40);
        myElectricCar.drive(100);

        System.out.println("\n--- Final Vehicle States ---");
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }
}