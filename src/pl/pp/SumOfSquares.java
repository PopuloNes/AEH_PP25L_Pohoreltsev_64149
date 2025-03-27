package pl.pp;
import java.util.Scanner;

public class SumOfSquares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lowerLimit, upperLimit;

        while (true) {
            System.out.print("Enter lower and upper integer limits: ");
            lowerLimit = scanner.nextInt();
            upperLimit = scanner.nextInt();

            if (upperLimit <= lowerLimit) {
                System.out.println("Done");
                break;
            }

            int sum = 0;
            for (int i = lowerLimit; i <= upperLimit; i++) {
                sum += i * i;
            }

            System.out.printf("The sum of the squares from %d to %d is %d%n", lowerLimit * lowerLimit, upperLimit * upperLimit, sum);
        }

        scanner.close();
    }
}