package pl.pp;

import java.util.Scanner;

public class WiekWSekundach  {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Podaj swój wiek w latach: ");
        int wiekWLatach = scanner.nextInt();


        int wiekWSekundach = wiekWLatach * 365 * 24 * 60 * 60;


        System.out.println("Twój wiek w sekundach to: " + wiekWSekundach);


        scanner.close();
    }
}
