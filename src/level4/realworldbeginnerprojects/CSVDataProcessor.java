package level4.realworldbeginnerprojects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class CSVDataProcessor {

    // Check numeric value
    public static boolean isNumeric(String value) {

        if (value == null || value.trim().isEmpty())
            return false;

        if (value.equalsIgnoreCase("NaN"))
            return false;

        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void processCSV(String fileName) {

        int totalRows = 0;
        int validRows = 0;
        int duplicateRows = 0;
        int invalidRows = 0;
        int emptyValues = 0;
        int nanValues = 0;

        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        HashSet<String> duplicateChecker = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {

                // Ignore blank line
                if (line.trim().isEmpty())
                    continue;

                // Skip header
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                totalRows++;

                String[] duplicateParts = line.split(",");

                StringBuilder normalizedRow = new StringBuilder();

                for (String part : duplicateParts) {
                    normalizedRow.append(part.trim()).append(",");
                }

                if (!duplicateChecker.add(normalizedRow.toString())) {
                    duplicateRows++;
                    continue;
                }
                
                String[] parts = line.split(",");

                boolean rowValid = false;

                for (String cell : parts) {

                    cell = cell.trim();

                    // Empty cell
                    if (cell.isEmpty()) {
                        emptyValues++;
                        continue;
                    }

                    // NaN
                    if (cell.equalsIgnoreCase("NaN")) {
                        nanValues++;
                        continue;
                    }

                    // Numeric value
                    if (isNumeric(cell)) {

                        double number = Double.parseDouble(cell);

                        sum += number;

                        if (number < min)
                            min = number;

                        if (number > max)
                            max = number;

                        rowValid = true;
                    }
                }

                if (rowValid)
                    validRows++;
                else
                    invalidRows++;
            }

            System.out.println("\n========================================");
            System.out.println("        CSV PROCESSING SUMMARY");
            System.out.println("========================================");

            System.out.println("Total Rows           : " + totalRows);
            System.out.println("Valid Rows           : " + validRows);
            System.out.println("Duplicate Rows       : " + duplicateRows);
            System.out.println("Invalid Rows         : " + invalidRows);
            System.out.println("Empty Values         : " + emptyValues);
            System.out.println("NaN Values           : " + nanValues);

            System.out.println("----------------------------------------");

            if (validRows > 0) {

                double average = sum / validRows;

                System.out.printf("Sum                 : %.2f%n", sum);
                System.out.printf("Average             : %.2f%n", average);
                System.out.printf("Minimum             : %.2f%n", min);
                System.out.printf("Maximum             : %.2f%n", max);

            } else {

                System.out.println("No valid numeric data found.");

            }

            System.out.println("========================================");

        } catch (IOException e) {
            System.out.println("Error reading the CSV file.");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter CSV file name: ");
        String fileName = scanner.nextLine().trim();

        if (fileName.isEmpty()) {
            System.out.println("File name cannot be empty.");
            scanner.close();
            return;
        }

        if (!fileName.toLowerCase().endsWith(".csv")) {
            System.out.println("Please enter a valid CSV file.");
            scanner.close();
            return;
        }

        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File not found.");
            scanner.close();
            return;
        }

        processCSV(fileName);

        scanner.close();
    }
}