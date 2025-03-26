package pl.pp;
import java.util.Scanner;

public class DaysToWeeksV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // First functionality: converting days to weeks and days
        while (true) {
            System.out.print("Enter the number of days (or enter a non-positive value to complete this part): ");
            int days = scanner.nextInt();
            if (days <= 0) {
                System.out.println("Let's move on to temperature conversion.");
                break;
            }
            int weeks = days / 7;
            int remainingDays = days % 7;
            System.out.println(days + " days — is " + weeks + " weeks and " + remainingDays + " days.");
        }

        // Second functionality: temperature conversion
        while (true) {
            System.out.print("Enter temperature in degrees Fahrenheit (enter -1 to exit): ");
            double fahrenheit = scanner.nextDouble();
            if (fahrenheit == -1) {
                System.out.println("The program is complete.");
                break;
            }
            // Calculate temperature in degrees Celsius
            double celsius = (fahrenheit - 32) * 5 / 9;
            // Calculate temperature in degrees Kelvin
            double kelvin = celsius + 273.15;
            // Output values accurate to two decimal places
            System.out.printf("Fahrenheit: %.2f, Celsius: %.2f, Kelvin: %.2f%n", fahrenheit, celsius, kelvin);
        }

        scanner.close();
    }
}