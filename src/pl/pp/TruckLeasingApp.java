package pl.pp;
// File: TruckLeasingApp.java

import java.util.List;
import java.util.Scanner;

public class TruckLeasingApp {
    private static LeasingService leasingService = new LeasingService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Truck and Trailer Leasing System!");

        while (true) {
            Truck selectedTruck = selectTruck();
            if (selectedTruck == null) { // User might want to exit or made invalid choice early
                System.out.println("No truck selected or invalid choice.");
            }

            Trailer selectedTrailer = null;
            if (selectedTruck != null) {
                selectedTrailer = selectTrailer(selectedTruck);
            }

            displayLeaseSummary(selectedTruck, selectedTrailer);

            System.out.println("\nDo you want to start a new selection? (yes/no)");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("yes")) {
                break;
            }
            System.out.println("\n---------------------------------------\n");
        }
        System.out.println("Thank you for using the Leasing System!");
        scanner.close();
    }

    private static Truck selectTruck() {
        System.out.println("\nAvailable Trucks:");
        List<Truck> trucks = leasingService.getAllTrucks();
        if (trucks.isEmpty()) {
            System.out.println("No trucks available at the moment.");
            return null;
        }

        for (int i = 0; i < trucks.size(); i++) {
            System.out.println((i + 1) + ". " + trucks.get(i));
        }

        System.out.print("Select a truck by number (or 0 to skip): ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) return null;
            if (choice > 0 && choice <= trucks.size()) {
                return trucks.get(choice - 1);
            } else {
                System.out.println("Invalid truck selection.");
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return null;
        }
    }

    private static Trailer selectTrailer(Truck truck) {
        System.out.println("\nAvailable Trailers compatible with " + truck.getMake() + " " + truck.getRegistrationNumber() + ":");
        List<Trailer> trailers = leasingService.getCompatibleTrailers(truck);

        if (trailers.isEmpty()) {
            System.out.println("No compatible trailers available for this truck.");
            return null;
        }

        for (int i = 0; i < trailers.size(); i++) {
            System.out.println((i + 1) + ". " + trailers.get(i));
        }

        System.out.print("Select a trailer by number (or 0 for no trailer): ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) {
                return null;
            }
            if (choice > 0 && choice <= trailers.size()) {
                return trailers.get(choice - 1);
            } else {
                System.out.println("Invalid trailer selection.");
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return null;
        }
    }

    private static void displayLeaseSummary(Truck truck, Trailer trailer) {
        System.out.println("\n--- Lease Summary ---");
        if (truck == null) {
            System.out.println("No truck was selected for lease.");
            return;
        }

        System.out.println("Selected Truck: " + truck.getMake() + " " + truck.getYear() + " (Reg: " + truck.getRegistrationNumber() + ")");
        System.out.println("  Truck Lease Price: $" + String.format("%.2f", truck.getLeasePricePerMonth()) + "/month");

        if (trailer != null) {
            System.out.println("Selected Trailer: " + trailer.getTrailerType() + " (ID: " + trailer.getTrailerId() + ")");
            System.out.println("  Trailer Lease Price: $" + String.format("%.2f", trailer.getLeasePricePerMonth()) + "/month");
        } else if (truck != null) { // only print if a truck was selected but no trailer
            System.out.println("No trailer selected.");
        }

        double totalLeasePrice = leasingService.calculateTotalLeasePrice(truck, trailer);
        System.out.println("\nTOTAL MONTHLY LEASE PRICE: $" + String.format("%.2f", totalLeasePrice));
        System.out.println("---------------------");
    }
}