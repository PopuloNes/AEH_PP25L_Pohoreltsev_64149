package pl.pp;


import java.util.List;
import java.util.Set; // Using Set for compatible trailer types for uniqueness

class Truck {
    private String registrationNumber;
    private String vinNumber;
    private FuelType fuelType;
    private int enginePowerHP; // Мощность
    private String make; // Марка
    private int year; // Год выпуска
    private double leasePricePerMonth; // Цена лизинга грузовика
    private Set<String> compatibleTrailerTypes; // Типы прицепов, которые может тянуть

    public Truck(String registrationNumber, String vinNumber, FuelType fuelType, int enginePowerHP,
                 String make, int year, double leasePricePerMonth, Set<String> compatibleTrailerTypes) {
        this.registrationNumber = registrationNumber;
        this.vinNumber = vinNumber;
        this.fuelType = fuelType;
        this.enginePowerHP = enginePowerHP;
        this.make = make;
        this.year = year;
        this.leasePricePerMonth = leasePricePerMonth;
        this.compatibleTrailerTypes = compatibleTrailerTypes;
    }

    // Getters
    public String getRegistrationNumber() { return registrationNumber; }
    public String getVinNumber() { return vinNumber; }
    public FuelType getFuelType() { return fuelType; }
    public int getEnginePowerHP() { return enginePowerHP; }
    public String getMake() { return make; }
    public int getYear() { return year; }
    public double getLeasePricePerMonth() { return leasePricePerMonth; }
    public Set<String> getCompatibleTrailerTypes() { return compatibleTrailerTypes; }

    public boolean canPullTrailerType(String trailerType) {
        return compatibleTrailerTypes.contains(trailerType);
    }

    @Override
    public String toString() {
        return "Truck: " + make + " " + year + " (Reg: " + registrationNumber +
                ", HP: " + enginePowerHP + ", Fuel: " + fuelType.getFuelTypeName() +
                ", Lease: $" + String.format("%.2f", leasePricePerMonth) + "/month" +
                ", Compatible Trailers: " + compatibleTrailerTypes + ")";
    }
}

class Trailer {
    private String trailerId;
    private String trailerType; // e.g., "Reefer", "Flatbed", "Tanker", "HeavyHaul"
    private String description;
    private double leasePricePerMonth; // Цена лизинга прицепа

    public Trailer(String trailerId, String trailerType, String description, double leasePricePerMonth) {
        this.trailerId = trailerId;
        this.trailerType = trailerType;
        this.description = description;
        this.leasePricePerMonth = leasePricePerMonth;
    }

    // Getters
    public String getTrailerId() { return trailerId; }
    public String getTrailerType() { return trailerType; }
    public String getDescription() { return description; }
    public double getLeasePricePerMonth() { return leasePricePerMonth; }

    @Override
    public String toString() {
        return "Trailer: " + trailerType + " (ID: " + trailerId +
                ", Desc: " + description +
                ", Lease: $" + String.format("%.2f", leasePricePerMonth) + "/month)";
    }
}