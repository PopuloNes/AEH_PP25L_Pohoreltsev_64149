package pl.pp;
// File: LeasingService.java

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LeasingService {
    private List<Truck> availableTrucks;
    private List<Trailer> availableTrailers;

    public LeasingService() {
        this.availableTrucks = new ArrayList<>();
        this.availableTrailers = new ArrayList<>();
        initializeInventory(); // Populate with some data
    }

    private void initializeInventory() {
        // Sample Fuel Types
        FuelType diesel = new DieselFuel();
        FuelType electric = new ElectricFuel();

        // Sample Trucks
        availableTrucks.add(new Truck("TRK001", "VIN001", diesel, 500, "Volvo FH", 2022, 2500.00,
                Set.of("Reefer", "Flatbed", "GeneralCargo")));
        availableTrucks.add(new Truck("TRK002", "VIN002", diesel, 650, "Scania R", 2023, 3200.00,
                Set.of("Reefer", "Flatbed", "HeavyHaul", "Tanker", "GeneralCargo")));
        availableTrucks.add(new Truck("TRK003", "VIN003", electric, 550, "Tesla Semi", 2024, 3000.00,
                Set.of("Reefer", "GeneralCargo")));
        availableTrucks.add(new Truck("TRK004", "VIN004", diesel, 480, "MAN TGX", 2021, 2200.00,
                Set.of("Flatbed", "GeneralCargo")));


        // Sample Trailers
        availableTrailers.add(new Trailer("TLR01", "Reefer", "Refrigerated unit for temperature-sensitive goods", 800.00));
        availableTrailers.add(new Trailer("TLR02", "Flatbed", "Open bed for oversized cargo", 600.00));
        availableTrailers.add(new Trailer("TLR03", "HeavyHaul", "For extra heavy and large loads", 1200.00));
        availableTrailers.add(new Trailer("TLR04", "Tanker", "For liquid transport", 950.00));
        availableTrailers.add(new Trailer("TLR05", "GeneralCargo", "Standard box trailer", 500.00));
    }

    public List<Truck> getAllTrucks() {
        return new ArrayList<>(availableTrucks); // Return a copy
    }

    public List<Trailer> getCompatibleTrailers(Truck truck) {
        if (truck == null) return new ArrayList<>();
        return availableTrailers.stream()
                .filter(trailer -> truck.canPullTrailerType(trailer.getTrailerType()))
                .collect(Collectors.toList());
    }

    public List<Trailer> getAllTrailers() { // Method to get all trailers if needed
        return new ArrayList<>(availableTrailers);
    }

    public double calculateTotalLeasePrice(Truck truck, Trailer trailer) {
        double total = 0;
        if (truck != null) {
            total += truck.getLeasePricePerMonth();
        }
        if (trailer != null) {
            total += trailer.getLeasePricePerMonth();
        }
        return total;
    }
}