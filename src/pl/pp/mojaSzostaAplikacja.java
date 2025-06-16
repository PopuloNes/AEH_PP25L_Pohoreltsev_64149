package pl.pp;


public class mojaSzostaAplikacja { // Class name updated as per Lab 6 requirement

    // Iterative method to calculate factorial
    public static long factorialIterative(int n) {
        if (n < 0) {
            // Factorial is not defined for negative numbers
            // Consider throwing an IllegalArgumentException for robust error handling
            System.err.println("Factorial not defined for negative numbers.");
            return -1;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Recursive method to calculate factorial
    public static long factorialRecursive(int n) {
        if (n < 0) {
            // Factorial is not defined for negative numbers
            System.err.println("Factorial not defined for negative numbers.");
            return -1;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

    public static void main(String[] args) {
        /*
        // --- Original Lab 5 Code - Commented out as per Lab 6 requirements ---
        // Obliczenia i wyświetlenie wyniku dla wartości przypisanych w kodzie aplikacji
        System.out.println("Obliczenia i wyświetlenie wyniku dla wartości przypisanych w kodzie aplikacji");
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Twoj wynik #1 to " + finalScore);
        }

        // Obliczenia i wyświetlenie wyniku dla wartości przypisanych w kodzie aplikacji (innych niż poprzednio)
        System.out.println("Obliczenia i wyświetlenie wyniku dla wartości przypisanych w kodzie aplikacji (innych niż poprzednio)");
        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Twoj wynik #2 to " + finalScore);
        }

        // Obliczenia za pomocą metody calculateScore_noArguments(), ale nadal dla wartości przypisanych w kodzie metody
        System.out.println("Obliczenia za pomocą metody calculateScore_noArguments(), ale nadal dla wartości przypisanych w kodzie metody");
        calculateScore_noArguments();

        // Obliczenia za pomocą metody calculateScore(), ale tym razem dla wartości wpisanych do argumentu wywołania metody
        System.out.println("Obliczenia za pomocą metody calculateScore(), ale tym razem dla wartości wpisanych do argumentu wywołania metody");
        calculateScore_arguments(true, 2500, 9, 2500);
        // można to wywołać za pomocą wcześniej zadeklarowanych zmiennych
        calculateScore_arguments(gameOver, score, levelCompleted, bonus);
        // ale widzicie, że wyświetlanie funkcji jest również z numerkiem #4 (bo takie wyświetlanie jest zapisane
        // w metodzie. Co zrobić, żeby tak nie było? Poniżej:

        // Obliczenia i wyświetlanie można uniezależnić od siebie dodając parametr, który ta metoda będzie zwracać
        System.out.println("Obliczenia i wyświetlanie można uniezależnić od siebie dodając parametr, który ta metoda będzie zwracać za pomocą return");
        finalScore = calculateScore_argumentsReturn(gameOver, score, levelCompleted, bonus);
        System.out.println("Twoj wynik #5 to " + finalScore);
        */

        // --- Lab 6: Factorial Calculation and Performance Measurement ---
        int numberForFactorial = 15; // You can change this value to test different numbers
        // Note: Factorials grow very fast. 'long' can hold up to 20!

        if (numberForFactorial > 20) {
            System.out.println("Warning: Factorial for numbers greater than 20 will overflow 'long'. Consider using BigInteger.");
        }
        if (numberForFactorial < 0) {
            System.out.println("Cannot calculate factorial for " + numberForFactorial + ". Please use a non-negative integer.");
            return; // Exit if number is negative
        }


        System.out.println("Calculating factorial for N = " + numberForFactorial);
        System.out.println("------------------------------------");

        // Iterative factorial calculation and timing
        long startTimeIterative = System.nanoTime();
        long iterativeResult = factorialIterative(numberForFactorial);
        long endTimeIterative = System.nanoTime();
        long durationIterative = endTimeIterative - startTimeIterative;

        System.out.println("Iterative Method:");
        if (iterativeResult != -1) { // Check if calculation was valid
            System.out.println("Factorial: " + iterativeResult);
        }
        System.out.println("Execution time: " + durationIterative + " ns");
        System.out.println();

        // Recursive factorial calculation and timing
        long startTimeRecursive = System.nanoTime();
        long recursiveResult = factorialRecursive(numberForFactorial);
        long endTimeRecursive = System.nanoTime();
        long durationRecursive = endTimeRecursive - startTimeRecursive;

        System.out.println("Recursive Method:");
        if (recursiveResult != -1) { // Check if calculation was valid
            System.out.println("Factorial: " + recursiveResult);
        }
        System.out.println("Execution time: " + durationRecursive + " ns");
        System.out.println("------------------------------------");

        // Simple comparison (optional)
        if (iterativeResult != -1 && recursiveResult != -1) {
            if (durationIterative < durationRecursive) {
                System.out.println("Iterative method was faster for N = " + numberForFactorial);
            } else if (durationRecursive < durationIterative) {
                System.out.println("Recursive method was faster for N = " + numberForFactorial);
            } else {
                System.out.println("Both methods had similar execution times for N = " + numberForFactorial);
            }
        }
    }

    /*
    // --- Original Lab 5 Helper Methods - Commented out ---
    private static void calculateScore_noArguments() {
        boolean gameOver = true;
        int score = 150;
        int levelCompleted = 2;
        int bonus = 1000;

        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Twoj wynik #3 to " + finalScore);
        }
    }
    private static void calculateScore_arguments(boolean gameOver, int score, int levelCompleted, int bonus) {
        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Twoj wynik #4 to " + finalScore);
        }
    }
    private static int calculateScore_argumentsReturn(boolean gameOver, int score, int levelCompleted, int bonus) {
        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
        }
        return finalScore;
    }
    */
}