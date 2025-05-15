package pl.pp;

public class Konto { // Polish for "Account"
    private String accountNumber;
    private double balance;
    private String ownerName;
    private String email;
    private String phoneNumber;

    public Konto(String accountNumber, double initialBalance, String ownerName, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.ownerName = ownerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        System.out.println("Account created for " + this.ownerName + " with number " + this.accountNumber +
                ". Initial balance: PLN " + String.format("%.2f", this.balance));
        printSeparator();
    }

    // Getters
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public String getOwnerName() { return ownerName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }

    // Setters
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited PLN " + String.format("%.2f", amount) + ". New balance: PLN " + String.format("%.2f", this.balance));
        } else {
            System.out.println("Deposit amount must be positive.");
        }
        printSeparator();
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Withdrew PLN " + String.format("%.2f", amount) + ". Remaining balance: PLN " + String.format("%.2f", this.balance));
        } else {
            System.out.println("Insufficient funds. You have PLN " + String.format("%.2f", this.balance) + " on your account.");
        }
        printSeparator();
    }

    public void displayAccountInfo() {
        System.out.println("Account Holder: " + this.ownerName);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Email: " + this.email);
        System.out.println("Phone: " + this.phoneNumber);
        System.out.println("Current Balance: PLN " + String.format("%.2f", this.balance));
        printSeparator();
    }

    private void printSeparator() {
        System.out.println("------------------------------------");
    }
}