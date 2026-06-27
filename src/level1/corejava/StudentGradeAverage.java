package level1.corejava;

import java.util.Scanner;

public class StudentGradeAverage {

    public static double calculateAverage(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    public static char findGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter a valid integer.");
            scanner.close();
            return;
        }

        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Number of subjects must be greater than 0.");
            scanner.close();
            return;
        }

        int[] marks = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter mark for subject " + (i + 1) + ": ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid mark. Enter a number between 0 and 100.");
                scanner.close();
                return;
            }

            int mark = scanner.nextInt();

            if (mark < 0 || mark > 100) {
                System.out.println("Invalid mark. Mark must be between 0 and 100.");
                scanner.close();
                return;
            }

            marks[i] = mark;
        }

        double average = calculateAverage(marks);
        char grade = findGrade(average);

        System.out.printf("Average Marks: %.2f%n", average);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}