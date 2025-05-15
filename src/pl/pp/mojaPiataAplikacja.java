package pl.pp;

public class mojaPiataAplikacja {

    public static void printPattern(char symbol, int countInRow, int numberOfRows) {
        // Basic input validation
        if (countInRow <= 0 || numberOfRows <= 0) {
            System.out.println("The number of characters in a row and the number of rows must be positive.");
            return;
        }

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < countInRow; j++) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        /*
        // Calculations and display of the result for values assigned in the application code
        System.out.println("Calculations and display of the result for values assigned in the application code");
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your score #1 is " + finalScore);
        }

        // Calculations and display of the result for values assigned in the application code (different from before)
        System.out.println("Calculations and display of the result for values assigned in the application code (different from before)");
        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your score #2 is " + finalScore);
        }

        // Calculations using the calculateScore_noArguments() method, but still for values assigned in the method's code
        System.out.println("Calculations using the calculateScore_noArguments() method, but still for values assigned in the method's code");
        calculateScore_noArguments();

        // Calculations using the calculateScore() method, but this time for values entered as arguments to the method call
        System.out.println("Calculations using the calculateScore() method, but this time for values entered as arguments to the method call");
        calculateScore_arguments(true, 2500, 9, 2500);
        // this can be called using previously declared variables
        calculateScore_arguments(gameOver, score, levelCompleted, bonus);
        // but you see that the function display also has #4 (because such display is written
        // in the method. What to do to avoid this? See below:

        // Calculations and display can be made independent of each other by adding a parameter that this method will return
        System.out.println("Calculations and display can be made independent of each other by adding a parameter that this method will return using return");
        finalScore = calculateScore_argumentsReturn(gameOver, score, levelCompleted, bonus);
        System.out.println("Your score #5 is " + finalScore);
        */

        System.out.println("--- Start of Task-2 execution ---");

        System.out.println("\nExample 1:");
        printPattern('*', 5, 3);
        // Expected output:
        // *****
        // *****
        // *****

        System.out.println("\nExample 2:");
        printPattern('#', 10, 2);
        // Expected output:
        // ##########
        // ##########

        System.out.println("\nExample 3 (one row, one character):");
        printPattern('X', 1, 1);
        // Expected output:
        // X

        System.out.println("\nExample 4 (with incorrect data for validation demonstration):");
        printPattern('$', 0, 5);
        // Expected output:
        // The number of characters in a row and the number of rows must be positive.

        System.out.println("\nExample 5 (with other incorrect data):");
        printPattern('@', 5, -2);
        // Expected output:
        // The number of characters in a row and the number of rows must be positive.

        System.out.println("\n--- End of Task-2 execution ---");
    }

    /*
    private static void calculateScore_noArguments() {
        boolean gameOver = true;
        int score = 150;
        int levelCompleted = 2;
        int bonus = 1000;

        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your score #3 is " + finalScore);
        }
    }
    private static void calculateScore_arguments(boolean gameOver, int score, int levelCompleted, int bonus) {
        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your score #4 is " + finalScore);
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