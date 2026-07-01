package level2.intermediatejavautilities;

import java.io.*;

import java.util.Scanner;

public class ExpenseTracker {

	    static final String FILE_NAME = "expenses.txt"; 
	    static final String SEPARATOR = "|";
	    static Scanner sc = new Scanner(System.in);

	    public static void main(String[] args) {
	        System.out.println("       Personal Expense Tracker         ");
	

	        boolean running = true;
	        while (running) {
	            System.out.println("\n--- MENU ---");
	            System.out.println("1. Add Expense");
	            System.out.println("2. View All Expenses");
	            System.out.println("3. View Total Spending");
	            System.out.println("4. View by Category");
	            System.out.println("5. Exit");
	            System.out.print("Choose option: ");

	            if (!sc.hasNextInt()) {
	                System.out.println("Please enter a number from the menu.");
	                sc.next();
	                continue;
	            }

	            int choice = sc.nextInt();
	            sc.nextLine(); // consume newline

	            switch (choice) {
	                case 1: addExpense();       break;
	                case 2: viewAllExpenses();  break;
	                case 3: viewTotal();        break;
	                case 4: viewByCategory();   break;
	                case 5:
	                    System.out.println("Goodbye! Keep tracking your expenses wisely.");
	                    running = false;
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please pick 1-5.");
	            }
	        }

	        sc.close();
	    }

	    // Adds a new expense entry to the file
	    static void addExpense() {
	        System.out.print("Category (Food / Travel / Bills / Shopping / Other): ");
	        String category = sc.nextLine().trim();

	        System.out.print("Description: ");
	        String description = sc.nextLine().trim();

	        System.out.print("Amount (Rs): ");
	        if (!sc.hasNextDouble()) {
	            System.out.println("Invalid amount. Please enter a number.");
	            sc.next();
	            return;
	        }
	        double amount = sc.nextDouble();
	        sc.nextLine();

	        if (amount <= 0) {
	            System.out.println("Amount must be greater than zero.");
	            return;
	        }

	        // Format: Category|Description|Amount
	        String record = category + SEPARATOR + description + SEPARATOR + String.format("%.2f", amount);

	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
	            writer.write(record);
	            writer.newLine();
	            System.out.println("Expense saved: " + category + " - " + description + " - Rs " + String.format("%.2f", amount));
	        } catch (IOException e) {
	            System.out.println("Error saving expense: " + e.getMessage());
	        }
	    }

	    // Reads and prints all saved expenses
	    static void viewAllExpenses() {
	        System.out.println("\n--- All Expenses ---");
	        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
	            String line;
	            int count = 1;
	            while ((line = reader.readLine()) != null) {
	                if (!line.trim().isEmpty()) {
	                    String[] parts = line.split("\\" + SEPARATOR);
	                    if (parts.length == 3) {
	                        System.out.printf("%-3d %-12s %-25s Rs %s%n",
	                            count++, parts[0], parts[1], parts[2]);
	                    }
	                }
	            }
	            if (count == 1) {
	                System.out.println("No expenses recorded yet.");
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("No expenses recorded yet.");
	        } catch (IOException e) {
	            System.out.println("Error reading file: " + e.getMessage());
	        }
	    }

	    // Calculates and prints the total spending
	    static void viewTotal() {
	        double total = 0;
	        int count = 0;

	        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                if (!line.trim().isEmpty()) {
	                    String[] parts = line.split("\\" + SEPARATOR);
	                    if (parts.length == 3) {
	                        total += Double.parseDouble(parts[2].trim());
	                        count++;
	                    }
	                }
	            }
	            System.out.println("\n--- Spending Summary ---");
	            System.out.println("Total Expenses : " + count);
	            System.out.printf("Total Amount   : Rs %.2f%n", total);

	        } catch (FileNotFoundException e) {
	            System.out.println("No expenses yet. Total: Rs 0.00");
	        } catch (IOException e) {
	            System.out.println("Error reading file: " + e.getMessage());
	        }
	    }

	    // Filters and shows expenses by a specific category
	    static void viewByCategory() {
	        System.out.print("Enter category to filter (Food / Travel / Bills / Shopping / Other): ");
	        String filter = sc.nextLine().trim();
	        double categoryTotal = 0;
	        int count = 0;

	        System.out.println("\n--- Expenses under: " + filter + " ---");

	        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                if (!line.trim().isEmpty()) {
	                    String[] parts = line.split("\\" + SEPARATOR);
	                    if (parts.length == 3 && parts[0].equalsIgnoreCase(filter)) {
	                        System.out.printf("  %-25s Rs %s%n", parts[1], parts[2]);
	                        categoryTotal += Double.parseDouble(parts[2].trim());
	                        count++;
	                    }
	                }
	            }

	            if (count == 0) {
	                System.out.println("No expenses found for category: " + filter);
	            } else {
	                System.out.printf("  Total for %-10s : Rs %.2f%n", filter, categoryTotal);
	            }

	        } catch (FileNotFoundException e) {
	            System.out.println("No expenses recorded yet.");
	        } catch (IOException e) {
	            System.out.println("Error reading file: " + e.getMessage());
	        }
	    }
	}