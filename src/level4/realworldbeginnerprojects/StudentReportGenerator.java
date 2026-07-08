package level4.realworldbeginnerprojects;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentReportGenerator {

    static ArrayList<String> studentNames = new ArrayList<>();

    public static int calculateTotal(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public static double calculateAverage(int[] marks) {
        return (double) calculateTotal(marks) / marks.length;
    }

    public static String findGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void printReport(String name, int[] marks) {
        int total = calculateTotal(marks);
        double average = calculateAverage(marks);
        String grade = findGrade(average);

        System.out.println("\n==============================");
        System.out.println("        STUDENT REPORT");
        System.out.println("==============================");
        System.out.println("Name      : " + name);

        for (int i = 0; i < marks.length; i++) {
            System.out.println("Subject " + (i + 1) + " : " + marks[i]);
        }

        System.out.println("Total     : " + total);
        System.out.printf("Average   : %.2f%n", average);
        System.out.println("Grade     : " + grade);
        System.out.println("==============================");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            String name;

            // Student Name Validation
            while (true) {

                System.out.print("Enter Student Name: ");
                name = scanner.nextLine().trim();

                if (name.isEmpty()) {
                    System.out.println("Name cannot be empty.");
                    continue;
                }

                if (!name.matches("[A-Za-z ]+")) {
                    System.out.println("Name should contain only alphabets and spaces.");
                    continue;
                }

                if (name.length() < 3) {
                    System.out.println("Name must contain at least 3 characters.");
                    continue;
                }

                if (name.length() > 30) {
                    System.out.println("Name cannot exceed 30 characters.");
                    continue;
                }

                boolean duplicate = false;

                for (String student : studentNames) {
                    if (student.equalsIgnoreCase(name)) {
                        duplicate = true;
                        break;
                    }
                }

                if (duplicate) {
                    System.out.println("Student name already exists.");
                    continue;
                }

                studentNames.add(name);

                break;
            }

            int numberOfSubjects;

            while (true) {

                System.out.print("Enter Number of Subjects: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.nextLine();
                    continue;
                }

                numberOfSubjects = scanner.nextInt();

                if (numberOfSubjects <= 0) {
                    System.out.println("Number of subjects must be greater than 0.");
                    continue;
                }

                scanner.nextLine();
                break;
            }

            int[] marks = new int[numberOfSubjects];

            for (int i = 0; i < numberOfSubjects; i++) {

                while (true) {

                    System.out.print("Enter Marks for Subject " + (i + 1) + ": ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid mark. Enter numbers only.");
                        scanner.nextLine();
                        continue;
                    }

                    int mark = scanner.nextInt();

                    if (mark < 0 || mark > 100) {
                        System.out.println("Marks must be between 0 and 100.");
                        continue;
                    }

                    marks[i] = mark;
                    break;
                }
            }

            scanner.nextLine();

            printReport(name, marks);

            System.out.print("\nDo you want to generate another report? (Y/N): ");
            String choice = scanner.nextLine().trim();

            if (!choice.equalsIgnoreCase("Y")) {
                System.out.println("Thank you!");
                break;
            }
        }

        scanner.close();
    }
}