package level2.intermediatejavautilities;

import java.util.Scanner;

public class PasswordStrength {

	    static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;':\",./<>?";

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.println("====================================");
	        System.out.println("     Password Strength Analyzer     ");
	        System.out.println("====================================");
	        System.out.print("Enter your password: ");
	        String password = sc.nextLine();

	        if (password.isEmpty()) {
	            System.out.println("Password cannot be empty!");
	        } else {
	            analyzePassword(password);
	        }

	        sc.close();
	    }

	    static void analyzePassword(String password) {
	        int score = 0;
	        StringBuilder suggestions = new StringBuilder();

	        // --- Rule 1: Minimum length ---
	        if (password.length() >= 8) {
	            score++;
	        } else {
	            suggestions.append("  - Use at least 8 characters\n");
	        }

	        // --- Rule 2: Has uppercase letter ---
	        boolean hasUpper = false;
	        for (char c : password.toCharArray()) {
	            if (Character.isUpperCase(c)) {
	                hasUpper = true;
	                break;
	            }
	        }
	        if (hasUpper) {
	            score++;
	        } else {
	            suggestions.append("  - Add at least one uppercase letter (A-Z)\n");
	        }

	        // --- Rule 3: Has lowercase letter ---
	        boolean hasLower = false;
	        for (char c : password.toCharArray()) {
	            if (Character.isLowerCase(c)) {
	                hasLower = true;
	                break;
	            }
	        }
	        if (hasLower) {
	            score++;
	        } else {
	            suggestions.append("  - Add at least one lowercase letter (a-z)\n");
	        }

	        // --- Rule 4: Has digit ---
	        boolean hasDigit = false;
	        for (char c : password.toCharArray()) {
	            if (Character.isDigit(c)) {
	                hasDigit = true;
	                break;
	            }
	        }
	        if (hasDigit) {
	            score++;
	        } else {
	            suggestions.append("  - Add at least one number (0-9)\n");
	        }

	        // --- Rule 5: Has special character ---
	        boolean hasSpecial = false;
	        for (char c : password.toCharArray()) {
	            if (SPECIAL_CHARS.indexOf(c) >= 0) {
	                hasSpecial = true;
	                break;
	            }
	        }
	        if (hasSpecial) {
	            score++;
	        } else {
	            suggestions.append("  - Add at least one special character (!@#$...)\n");
	        }

	        // --- Display Result ---
	        System.out.println("Password : " + "*".repeat(password.length()));
	        System.out.println("Length   : " + password.length() + " characters");
	        System.out.println("Score    : " + score + " / 5");

	        if (score == 5) {
	            System.out.println("Strength : STRONG - Great password!");
	        } else if (score >= 3) {
	            System.out.println("Strength : MEDIUM - Can be improved.");
	        } else {
	            System.out.println("Strength : WEAK   - Please change it.");
	        }

	        if (suggestions.length() > 0) {
	            System.out.println("\nSuggestions to improve:");
	            System.out.print(suggestions);
	        } else {
	            System.out.println("All rules passed! Your password is strong.");
	        }
	    }
	}
