package level2.intermediatejavautilities;

import java.io.*;

import java.util.Scanner;

public class FileEncryptor {

	    static final int SHIFT = 3; // You can change this key (1–25)

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.println("     File Encryptor / Decryptor         ");
	        System.out.println("     Algorithm: Caesar Cipher (Shift=3) ");
	        System.out.println("1. Encrypt a file");
	        System.out.println("2. Decrypt a file");
	        System.out.print("Choose option (1 or 2): ");
	        int choice = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Enter input file path  : ");
	        String inputPath = sc.nextLine().trim();

	        System.out.print("Enter output file path : ");
	        String outputPath = sc.nextLine().trim();

	        if (choice == 1) {
	            encryptFile(inputPath, outputPath);
	        } else if (choice == 2) {
	            decryptFile(inputPath, outputPath);
	        } else {
	            System.out.println("Invalid option. Please choose 1 or 2.");
	        }

	        sc.close();
	    }

	    // Reads each line → encrypts it → writes to output file
	    static void encryptFile(String inputPath, String outputPath) {
	        try (
	            BufferedReader reader = new BufferedReader(new FileReader(inputPath));
	            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))
	        ) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                writer.write(caesarShift(line, SHIFT));
	                writer.newLine();
	            }
	            System.out.println("\nFile encrypted successfully!");
	            System.out.println("Encrypted file saved at: " + outputPath);

	        } catch (FileNotFoundException e) {
	            System.out.println("Error: Input file not found → " + inputPath);
	        } catch (IOException e) {
	            System.out.println("File error: " + e.getMessage());
	        }
	    }

	    static void decryptFile(String inputPath, String outputPath) {
	        int reverseShift = 26 - SHIFT;
	        try (
	            BufferedReader reader = new BufferedReader(new FileReader(inputPath));
	            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))
	        ) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                writer.write(caesarShift(line, reverseShift));
	                writer.newLine();
	            }
	            System.out.println("\nFile decrypted successfully!");
	            System.out.println("Decrypted file saved at: " + outputPath);

	        } catch (FileNotFoundException e) {
	            System.out.println("Error: Input file not found → " + inputPath);
	        } catch (IOException e) {
	            System.out.println("File error: " + e.getMessage());
	        }
	    }

	    // Shifts all letters by 'shift' positions; leaves other chars as-is
	    static String caesarShift(String text, int shift) {
	        StringBuilder result = new StringBuilder();

	        for (char c : text.toCharArray()) {
	            if (Character.isUpperCase(c)) {
	                result.append((char) (('A') + (c - 'A' + shift) % 26));

	            } else if (Character.isLowerCase(c)) {
	                result.append((char) (('a') + (c - 'a' + shift) % 26));

	            } else {
	                result.append(c);
	            }
	        }

	        return result.toString();
	    }
	}