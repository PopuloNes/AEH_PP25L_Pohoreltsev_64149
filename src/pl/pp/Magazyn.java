package pl.pp;

public class Magazyn { // Polish for "Warehouse"
    private String warehouseNumber;
    private int totalCapacity;
    private int occupiedSpace;
    private String ownerName;
    private String ownerEmail;
    private String ownerPhoneNumber;

    public Magazyn(String warehouseNumber, int totalCapacity, String ownerName, String ownerEmail, String ownerPhoneNumber) {
        this.warehouseNumber = warehouseNumber;
        this.totalCapacity = Math.max(0, totalCapacity); // Ensure capacity is not negative
        this.occupiedSpace = 0;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.ownerPhoneNumber = ownerPhoneNumber;

        System.out.println("Warehouse " + this.warehouseNumber + " created for " + this.ownerName + ".");
        System.out.println("Total capacity: " + this.totalCapacity + " units.");
        printSeparator();
    }

    // Getters
    public String getWarehouseNumber() { return warehouseNumber; }
    public int getTotalCapacity() { return totalCapacity; }
    public int getOccupiedSpace() { return occupiedSpace; }
    public int getAvailableSpace() { return totalCapacity - occupiedSpace; }
    public String getOwnerName() { return ownerName; }
    public String getOwnerEmail() { return ownerEmail; }
    public String getOwnerPhoneNumber() { return ownerPhoneNumber; }

    // Setters
    public void setWarehouseNumber(String warehouseNumber) { this.warehouseNumber = warehouseNumber; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }


    public void addGoods(int unitsToAdd) {
        if (unitsToAdd <= 0) {
            System.out.println("Error: Cannot add zero or a negative number of units.");
        } else if (occupiedSpace + unitsToAdd <= totalCapacity) {
            occupiedSpace += unitsToAdd;
            System.out.println("Added " + unitsToAdd + " units. Remaining warehouse space: " + getAvailableSpace() + " units.");
        } else {
            System.out.println("Error: Not enough space. Available space: " + getAvailableSpace() + " units. Tried to add: " + unitsToAdd);
        }
        printSeparator();
    }

    public void removeGoods(int unitsToRemove) {
        if (unitsToRemove <= 0) {
            System.out.println("Error: Cannot remove zero or a negative number of units.");
        } else if (occupiedSpace >= unitsToRemove) {
            occupiedSpace -= unitsToRemove;
            System.out.println("Removed " + unitsToRemove + " units. Remaining warehouse space: " + getAvailableSpace() + " units.");
        } else {
            System.out.println("Error: Cannot remove more goods than available. Occupied space: " + occupiedSpace + " units. Tried to remove: " + unitsToRemove);
        }
        printSeparator();
    }

    public void checkOccupancy() {
        System.out.println("Warehouse Occupancy Status (" + warehouseNumber + "):");
        System.out.println("  Total Capacity: " + totalCapacity + " units.");
        System.out.println("  Occupied Space: " + occupiedSpace + " units.");
        System.out.println("  Available Space: " + getAvailableSpace() + " units.");
        printSeparator();
    }

    public void updateContactInfo(String newEmail, String newPhoneNumber) {
        this.ownerEmail = newEmail;
        this.ownerPhoneNumber = newPhoneNumber;
        System.out.println("Owner contact details updated for warehouse " + warehouseNumber + ".");
        System.out.println("  New email: " + this.ownerEmail);
        System.out.println("  New phone number: " + this.ownerPhoneNumber);
        printSeparator();
    }

    public void displayOwnerContact() {
        System.out.println("Warehouse " + warehouseNumber + " Owner: " + ownerName);
        System.out.println("  Email: " + ownerEmail);
        System.out.println("  Phone: " + ownerPhoneNumber);
        printSeparator();
    }

    private void printSeparator() {
        System.out.println("------------------------------------");
    }
}