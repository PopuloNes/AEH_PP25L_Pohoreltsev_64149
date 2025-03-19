package pl.pp;

import java.util.Scanner;

public class WiekWSekundach {
    public static void main(String[] args) {
        // Utworzenie skanera do odczytu danych od użytkownika
        Scanner scanner = new Scanner(System.in);

        // Poproszenie o podanie wieku w latach
        System.out.print("Podaj swój wiek w latach: ");
        int wiekWLatach = scanner.nextInt();

        // Przeliczenie wieku na sekundy
        int wiekWSekundach = wiekWLatach * 365 * 24 * 60 * 60; // Zakładamy 365 dni w roku

        // Wyświetlenie wyniku
        System.out.println("Twój wiek w sekundach to: " + wiekWSekundach);

        // Zamknięcie skanera
        scanner.close();
    }
}
