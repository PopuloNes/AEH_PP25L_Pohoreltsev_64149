package pl.pp;
// File: Vehicles.java

abstract class Vehicle {
    protected String registrationNumber;
    protected String vinNumber;
    protected String color;
    protected double price;
    protected double fuelConsumption; // L/100km or kWh/100km
    protected double fuelLevel;       // Liters or kWh
    protected double mileage;         // km
    protected FuelType fuelType;

    public Vehicle(String registrationNumber, String vinNumber, String color, double price,
                   double fuelConsumption, double initialFuelLevel, double mileage, FuelType fuelType) {
        this.registrationNumber = registrationNumber;
        this.vinNumber = vinNumber;
        this.color = color;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.fuelLevel = initialFuelLevel;
        this.mileage = mileage;
        this.fuelType = fuelType;
    }

    public void drive(double distance) {
        double fuelNeeded = (distance / 100.0) * fuelConsumption;
        if (fuelLevel >= fuelNeeded) {
            fuelLevel -= fuelNeeded;
            mileage += distance;
            System.out.println(this.getClass().getSimpleName() + " " + registrationNumber + " drove " + distance + " km. Fuel left: " + String.format("%.2f", fuelLevel));
        } else {
            System.out.println(this.getClass().getSimpleName() + " " + registrationNumber + " not enough fuel to drive " + distance + " km. Needs " + String.format("%.2f", fuelNeeded) + ", has " + String.format("%.2f", fuelLevel));
        }
    }

    public void refuel(double amount) {
        this.fuelLevel += amount;
        System.out.println(this.getClass().getSimpleName() + " " + registrationNumber + " refueled " + amount + ". Current fuel: " + String.format("%.2f", fuelLevel));
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public FuelType getFuelTypeInfo() {
        return fuelType;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
                "reg='" + registrationNumber + '\'' +
                ", vin='" + vinNumber + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", consumption=" + fuelConsumption +
                ", fuelLvl=" + String.format("%.2f", fuelLevel) +
                ", mileage=" + mileage +
                ", fuelType=" + fuelType.getFuelTypeName();
    }
}

class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String registrationNumber, String vinNumber, String color, double price,
               double fuelConsumption, double initialFuelLevel, double mileage, FuelType fuelType,
               int numberOfDoors) {
        super(registrationNumber, vinNumber, color, price, fuelConsumption, initialFuelLevel, mileage, fuelType);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", doors=" + numberOfDoors +
                '}';
    }
}

class Truck extends Vehicle {
    private double payloadCapacity;

    public Truck(String registrationNumber, String vinNumber, String color, double price,
                 double fuelConsumption, double initialFuelLevel, double mileage, FuelType fuelType,
                 double payloadCapacity) {
        super(registrationNumber, vinNumber, color, price, fuelConsumption, initialFuelLevel, mileage, fuelType);
        this.payloadCapacity = payloadCapacity;
    }

    public double getPayloadCapacity() {
        return payloadCapacity;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", payload=" + payloadCapacity + "kg" +
                '}';
    }
}

class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String registrationNumber, String vinNumber, String color, double price,
                      double fuelConsumption, double initialFuelLevel, double mileage, FuelType fuelType,
                      boolean hasSidecar) {
        super(registrationNumber, vinNumber, color, price, fuelConsumption, initialFuelLevel, mileage, fuelType);
        this.hasSidecar = hasSidecar;
    }

    public boolean hasSidecar() {
        return hasSidecar;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", sidecar=" + hasSidecar +
                '}';
    }
}

class ConstructionEquipment extends Vehicle {
    private double workedHours;

    public ConstructionEquipment(String registrationNumber, String vinNumber, String color, double price,
                                 double fuelConsumption, double initialFuelLevel, double mileage, FuelType fuelType,
                                 double workedHours) {
        super(registrationNumber, vinNumber, color, price, fuelConsumption, initialFuelLevel, mileage, fuelType);
        this.workedHours = workedHours;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public void operate(double hours) {
        this.workedHours += hours;
        double fuelConsumedDuringOperation = hours * (fuelConsumption / 10); // Simplified consumption
        if (fuelLevel >= fuelConsumedDuringOperation) {
            fuelLevel -= fuelConsumedDuringOperation;
            System.out.println(this.getClass().getSimpleName() + " " + registrationNumber + " operated for " + hours + " hours. Total worked hours: " + this.workedHours + ". Fuel left: " + String.format("%.2f", fuelLevel));
        } else {
            System.out.println(this.getClass().getSimpleName() + " " + registrationNumber + " not enough fuel to operate for " + hours + " hours.");
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", workedHrs=" + workedHours +
                '}';
    }
}