package pl.pp;
// File: FuelTypes.java

interface FuelType {
    String getFuelTypeName();
}

class DieselFuel implements FuelType {
    @Override
    public String getFuelTypeName() {
        return "Diesel";
    }
}

class PetrolFuel implements FuelType {
    @Override
    public String getFuelTypeName() {
        return "Petrol";
    }
}

class ElectricFuel implements FuelType {
    @Override
    public String getFuelTypeName() {
        return "Electric";
    }
}