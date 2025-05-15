package pl.pp;

public class mojaDziewiataAplikacja { // Should be "mojaDziewiataAplikacja"
    public static void main(String[] args) {
        System.out.println("--- Warehouse (Magazyn) Demo ---");

        // Assuming at the beginning the warehouse has 5000 units of available space
        // and is managed by an owner with default data.
        Magazyn mainWarehouse = new Magazyn("WH-MAIN", 5000, "Default Corp Owner", "contact@defaultcorp.com", "+1-800-555-0000");

        // Operations as per the lab example
        mainWarehouse.addGoods(3000);  // Added 3000 units. Remaining space: 2000 units.
        mainWarehouse.removeGoods(1000);   // Removed 1000 units. Remaining space: 3000 units.
        mainWarehouse.addGoods(2500);  // Added 2500 units. Remaining space: 500 units.

        mainWarehouse.checkOccupancy(); // Occupied space: 4500 units. Available space: 500 units.

        mainWarehouse.updateContactInfo("owner@magazyn.pl", "+48 123 456 789");
        // Owner contact details updated.
        // New email: owner@magazyn.pl
        // New phone number: +48 123 456 789

        mainWarehouse.addGoods(600);   // Error: Not enough space. Available space: 500 units.

        // Additional tests
        System.out.println("\n--- Additional Warehouse Operations ---");
        mainWarehouse.displayOwnerContact();
        mainWarehouse.checkOccupancy();

        mainWarehouse.removeGoods(5000); // Error: Cannot remove more goods than available.
        mainWarehouse.addGoods(-100); // Error: Cannot add zero or a negative number of units.
        mainWarehouse.removeGoods(-50);  // Error: Cannot remove zero or a negative number of units.


        System.out.println("\n--- End of Warehouse (Magazyn) Demo ---");


        /*
         * Original demo code from Lab 8 (Person & Circle) for context,
         * not directly part of Lab 9's core task.
         */
        /*
        System.out.println("\n\n--- Original Demo Code from Previous Lab (Person & Circle) ---");
        Person person1 = new Person("Test", "Testowy", 25);
        person1.hiToAll();
        person1.growOld(10);
        person1.hiToAll();
        person1.setForename("ZmienionyTest");
        person1.hiToAll();
        System.out.println("Pobrane imię to " + person1.getForename() + " z wiekiem = " + person1.getAge());

        Circle circle1 = new Circle(1.2);
        circle1.getInfo();
        circle1.setRadius(2.6);
        circle1.getInfo();
        */
    }
}
