package level1.corejava;

import java.util.Scanner;

public class TemperatureConverter {

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");

        System.out.print("Enter your choice: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid choice. Enter only 1 or 2.");
            scanner.close();
            return;
        }

        int choice = scanner.nextInt();

        if (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Enter only 1 or 2.");
            scanner.close();
            return;
        }

        System.out.print("Enter temperature value: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid temperature. Enter a numeric value.");
            scanner.close();
            return;
        }

        double temp = scanner.nextDouble();

        if (choice == 1) {
            double result = celsiusToFahrenheit(temp);
            System.out.println("Fahrenheit: " + result);
        } else {
            double result = fahrenheitToCelsius(temp);
            System.out.println("Celsius: " + result);
        }

        scanner.close();
    }
}