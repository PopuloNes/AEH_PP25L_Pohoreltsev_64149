package pl.pp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class mojaDwunastaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFilePathStr;
        Path inputFilePath;
        File inputFile;

        // Get and validate input file path
        while (true) {
            System.out.print("Enter input file path: ");
            inputFilePathStr = scanner.nextLine();
            // Normalize path to handle various inputs (e.g., with spaces, relative)
            try {
                inputFilePath = Paths.get(inputFilePathStr).toAbsolutePath().normalize();
                inputFile = inputFilePath.toFile();
            } catch (Exception e) { // Catch potential exceptions from Paths.get, e.g., invalid characters
                System.out.println("Error: Invalid path format. Please try again.");
                continue;
            }


            if (inputFile.exists() && inputFile.isFile()) {
                break; // Valid file found
            } else {
                if (!inputFile.exists()) {
                    System.out.println("Error: Input file not found at '" + inputFilePath + "'. Please try again.");
                } else if (!inputFile.isFile()) {
                    System.out.println("Error: The path '" + inputFilePath + "' points to a directory, not a file. Please try again.");
                }
            }
        }

        System.out.print("Enter output file path: ");
        String outputFilePathStr = scanner.nextLine();
        Path outputFilePath;
        try {
            outputFilePath = Paths.get(outputFilePathStr).toAbsolutePath().normalize();
        } catch (Exception e) {
            System.err.println("Error: Invalid output path format. Exiting.");
            scanner.close();
            return;
        }


        int lineCount = 0;
        String inputFileName = inputFilePath.getFileName().toString();

        try {
            // Count lines in input file
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath.toFile()))) {
                while (reader.readLine() != null) {
                    lineCount++;
                }
            } catch (IOException e) {
                System.err.println("Error reading input file '" + inputFileName + "': " + e.getMessage());
                scanner.close();
                return; // Critical error, cannot proceed
            }

            // Display to console
            System.out.println("Input file '" + inputFileName + "' contains " + lineCount + " lines.");

            // Write to output file
            // Ensure parent directory for output file exists
            File outputFile = outputFilePath.toFile();
            File parentDir = outputFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                if (!parentDir.mkdirs()) {
                    System.err.println("Error: Could not create parent directories for output file: " + parentDir.getAbsolutePath());
                    scanner.close();
                    return;
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                writer.write("Input file: " + inputFileName);
                writer.newLine();
                writer.write("Number of lines: " + lineCount);
                System.out.println("Results successfully written to: " + outputFilePath.toString());
            } catch (IOException e) {
                System.err.println("Error writing to output file '" + outputFilePath.toString() + "': " + e.getMessage());
            }

        } catch (Exception e) {
            // General catch for other unexpected issues
            System.err.println("An unexpected error occurred: " + e.getMessage());
            // e.printStackTrace(); // Useful for debugging, but can be verbose
        } finally {
            scanner.close();
            // System.out.println("Processing finished.");
        }
    }
}