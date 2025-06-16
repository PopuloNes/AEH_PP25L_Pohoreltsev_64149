package pl.pp;


interface FuelType {
    String getFuelTypeName();
}

class DieselFuel implements FuelType {
    @Override
    public String getFuelTypeName() {
        return "Diesel";
    }
}

class PetrolFuel implements FuelType { // Less common for heavy trucks, but for completeness
    @Override
    public String getFuelTypeName() {
        return "Petrol";
    }
}

class ElectricFuel implements FuelType { // Increasingly relevant
    @Override
    public String getFuelTypeName() {
        return "Electric";
    }
}

// You could add LNGFuel, CNGFuel etc. if needed