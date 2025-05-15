package pl.pp;

public class mojaOsmaAplikacja {
    public static void main(String[] args) {
        System.out.println("--- Bank Account (Konto) Demo ---");

        Konto myAccount = new Konto("ACC001", 1000.0, "John Doe", "john.doe@example.com", "555-0101");

        // Operations as per the lab example
        myAccount.withdraw(900.0);
        myAccount.deposit(250.0);
        myAccount.withdraw(50.0);
        myAccount.withdraw(400.0); // Attempt to overdraw

        // Additional tests
        System.out.println("\n--- Additional Account Operations ---");
        myAccount.displayAccountInfo();

        myAccount.deposit(100.0);
        myAccount.withdraw(50.0);

        myAccount.withdraw(-20.0); // Invalid withdrawal attempt
        myAccount.deposit(-50.0);  // Invalid deposit attempt

        System.out.println("\n--- Updating Account Holder Details ---");
        myAccount.setEmail("j.doe.updated@example.com");
        myAccount.setPhoneNumber("555-0202");
        System.out.println("Updated Email: " + myAccount.getEmail());
        System.out.println("Updated Phone: " + myAccount.getPhoneNumber());
        myAccount.displayAccountInfo();

        System.out.println("\n--- End of Bank Account (Konto) Demo ---");

        /*
         * Original demo code from Lab 8 description using Person and Circle
         * (can be kept for context or removed if not required for submission)
         * Note on Person.growOld() in the original demo:
         * The method public int growOld(int age){ this.age += age; return age; }
         * adds the parameter 'age' to 'this.age' but returns the original parameter 'age',
         * not the updated 'this.age'. This might be misleading if the return value is used.
         * A more typical implementation would be:
         * public void growOlderBy(int years){ this.age += years; }
         * or
         * public int growOlderBy(int years){ this.age += years; return this.age; }
         */
        /*
        System.out.println("\n\n--- Original Demo Code (Person & Circle) ---");
        Person person1 = new Person("DemoUser", "LastName", 30);
        person1.hiToAll();
        person1.growOld(5); // Using the original demo's growOld
        person1.hiToAll();
        person1.setForename("UpdatedDemoUser");
        person1.hiToAll();
        System.out.println("Fetched name: " + person1.getForename() + ", age: " + person1.getAge());

        Circle circle1 = new Circle(1.5);
        circle1.getInfo();
        circle1.setRadius(3.0);
        circle1.getInfo();
        */
    }
}