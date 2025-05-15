package pl.pp;

public class mojaSiodmaAplikacja {
    public static void main(String[] args) {
        System.out.println("--- Person Class Demo ---");

        Person person1 = new Person();
        person1.setForename("Matthew");
        person1.surname = "Smith"; // Direct field access still possible
        person1.age = 24;
        person1.setAddress("Warsaw, Main St 1");
        person1.setYearOfBirth(1999);
        person1.displayInfo();

        Person person2 = new Person("Darius", "Stone", 42, "Krakow, New Av 50", 1981);
        person2.displayInfo();

        System.out.println("\n--- Demon Task 2  ---");

        // Demonstrate growOlderBy(int years)
        System.out.println("Person1 original age: " + person1.getAge());
        person1.growOlderBy(10);
        System.out.println("Person1 after growOlderBy(10): " + person1.getAge());
        person1.displayInfo();

        // Demonstrate becomeYounger()
        System.out.println("Person2 current age: " + person2.getAge());
        person2.becomeYounger();
        person2.becomeYounger();
        System.out.println("Person2 after becomeYounger() twice: " + person2.getAge());
        person2.displayInfo();

        // New person object
        Person person3 = new Person("Homer", "Simpson", 30);
        System.out.println("Person3 initial state:");
        person3.displayInfo();

        person3.setAddress("Gdansk, Old Town 7");
        person3.setYearOfBirth(1993);
        System.out.println("Person3 after setting address and yearOfBirth:");
        person3.displayInfo();
        person3.growOlderBy(7);
        person3.becomeYounger();
        person3.displayInfo();
    }
}