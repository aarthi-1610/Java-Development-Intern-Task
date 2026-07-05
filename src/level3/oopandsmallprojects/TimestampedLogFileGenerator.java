package level3.oopandsmallprojects;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimestampedLogFileGenerator {

    public static String getCurrentTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    public static void writeLog(String level, String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("log.txt", true))) {
            writer.println("[" + getCurrentTimestamp() + "] [" + level + "] " + message);
        } catch (IOException e) {
            System.out.println("Error writing log file.");
        }
    }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);

    	System.out.print("Enter Log Level (INFO/WARNING/ERROR): ");
    	String level = scanner.nextLine().trim().toUpperCase();

    	if (!(level.equals("INFO") || level.equals("WARNING") || level.equals("ERROR"))) {
    	    System.out.println("Invalid log level. Please enter INFO, WARNING, or ERROR.");
    	    scanner.close();
    	    return;
    	}


    	System.out.print("Enter Log Message: ");
    	String message = scanner.nextLine().trim();

 
    	if (message.isEmpty()) {
    	    System.out.println("Message cannot be empty.");
    	    scanner.close();
    	    return;
    	}

    	writeLog(level, message);

    	System.out.println("Log saved successfully.");

    	scanner.close();
    }
}