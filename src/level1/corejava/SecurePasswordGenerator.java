package level1.corejava;

import java.security.SecureRandom;
import java.util.Scanner;

public class SecurePasswordGenerator {

    public static boolean isValidChoice(String input) {
        return input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no");
    }

    public static String generatePassword(int length, boolean useUppercase, boolean useLowercase,
                                          boolean useNumbers, boolean useSpecial) {
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String special = "!@#$%^&*()-_=+[]{}|;:,.<>?/";

        StringBuilder allowedChars = new StringBuilder();

        if (useUppercase) {
            allowedChars.append(uppercase);
        }
        if (useLowercase) {
            allowedChars.append(lowercase);
        }
        if (useNumbers) {
            allowedChars.append(numbers);
        }
        if (useSpecial) {
            allowedChars.append(special);
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(index));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password length: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid length. Enter a valid integer.");
            scanner.close();
            return;
        }

        int length = scanner.nextInt();

        if (length <= 0) {
            System.out.println("Password length must be greater than 0.");
            scanner.close();
            return;
        }

        scanner.nextLine();

        System.out.print("Include uppercase letters? (yes/no): ");
        String upperInput = scanner.nextLine().trim();
        if (!isValidChoice(upperInput)) {
            System.out.println("Invalid input. Enter only yes or no.");
            scanner.close();
            return;
        }

        System.out.print("Include lowercase letters? (yes/no): ");
        String lowerInput = scanner.nextLine().trim();
        if (!isValidChoice(lowerInput)) {
            System.out.println("Invalid input. Enter only yes or no.");
            scanner.close();
            return;
        }

        System.out.print("Include numbers? (yes/no): ");
        String numberInput = scanner.nextLine().trim();
        if (!isValidChoice(numberInput)) {
            System.out.println("Invalid input. Enter only yes or no.");
            scanner.close();
            return;
        }

        System.out.print("Include special characters? (yes/no): ");
        String specialInput = scanner.nextLine().trim();
        if (!isValidChoice(specialInput)) {
            System.out.println("Invalid input. Enter only yes or no.");
            scanner.close();
            return;
        }

        boolean useUppercase = upperInput.equalsIgnoreCase("yes");
        boolean useLowercase = lowerInput.equalsIgnoreCase("yes");
        boolean useNumbers = numberInput.equalsIgnoreCase("yes");
        boolean useSpecial = specialInput.equalsIgnoreCase("yes");

        if (!useUppercase && !useLowercase && !useNumbers && !useSpecial) {
            System.out.println("Select at least one character type.");
            scanner.close();
            return;
        }

        String password = generatePassword(length, useUppercase, useLowercase, useNumbers, useSpecial);
        System.out.println("Generated Password: " + password);

        scanner.close();
    }
}