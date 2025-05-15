package pl.pp;

public class Person {
    String forename;
    String surname;
    int age;
    String address;
    int yearOfBirth;

    public Person() {
        // Default constructor
    }

    public Person(String forename, String surname, int age) {
        this.forename = forename;
        this.surname = surname;
        this.age = age;
    }

    // Full constructor
    public Person(String forename, String surname, int age, String address, int yearOfBirth) {
        this.forename = forename;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.yearOfBirth = yearOfBirth;
    }

    public void displayInfo() { // Renamed hiToAll for clarity
        System.out.println("Name: " + (forename != null ? forename : "N/A") + " " +
                (surname != null ? surname : "N/A"));
        System.out.println("Age: " + age);
        if (yearOfBirth > 0) {
            System.out.println("Year of Birth: " + yearOfBirth);
        }
        if (address != null && !address.isEmpty()) {
            System.out.println("Address: " + address);
        }
        System.out.println("---");
    }

    public void growOlderBy(int years) { // Renamed growOld for clarity
        if (years > 0) {
            this.age += years;
        } else {
            System.out.println("Cannot age by a non-positive number of years.");
        }
    }

    public void becomeYounger() { // Renamed beYounger
        if (this.age > 0) {
            this.age--;
        } else {
            System.out.println("Age cannot be less than 0.");
        }
    }

    // Getters & Setters
    public String getForename() {
        return this.forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public int getAge() {
        return this.age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfBirth() {
        return this.yearOfBirth;
    }
}