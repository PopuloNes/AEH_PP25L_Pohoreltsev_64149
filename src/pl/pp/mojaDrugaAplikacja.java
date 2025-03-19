package pl.pp;

import java.util.Scanner;

public class mojaDrugaAplikacja {
    public static void main(String[] args) {
        double x = 10; //utworzenie zmiennej typu double i przypisanie jej wartości 10
        double y = 2;
        Scanner scanner = new Scanner(System.in);
        var result = x + y;
        System.out.println("x + y = " + result);
        result = x - y;
        System.out.println("x - y = " + result);
        result = x * y;
        System.out.println("x * y = " + result);
        result = x / y;
        System.out.println("x / y = " + result);
        result = x % y;
        System.out.println("x % y = " + result);
        System.out.println("Wpisz dwie liczby rozdzielone klawiszem Enter:");
        double first = scanner.nextDouble(); //prośba o wpisanie wartości typu double
        double second = scanner.nextDouble();
        System.out.println("x + y = " + (first + second));
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Proszę podaj swoje imię:");
//        String forename = scanner.nextLine();
//
//        System.out.println("Proszę podaj swoje imię:");
//        String surname = scanner.nextLine();
//
//        scanner.close();
//
//        System.out.println("Witaj " + forename + " " + surname );

    }
}
