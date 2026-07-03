package level3.oopandsmallprojects;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int rollNo;
    private String name;
    private int totalSubjects;
    private double totalMarks;
    private double average;

    public Student(int rollNo, String name, int totalSubjects, double totalMarks, double average) {
        this.rollNo = rollNo;
        this.name = name;
        this.totalSubjects = totalSubjects;
        this.totalMarks = totalMarks;
        this.average = average;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getTotalSubjects() {
        return totalSubjects;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public double getAverage() {
        return average;
    }

    public String toFileString() {
        return rollNo + "," + name + "," + totalSubjects + "," + totalMarks + "," + average;
    }

    public static Student fromFileString(String line) {
        String[] parts = line.split(",");

        if (parts.length != 5) {
            return null;
        }

        int rollNo = Integer.parseInt(parts[0]);
        String name = parts[1];
        int totalSubjects = Integer.parseInt(parts[2]);
        double totalMarks = Double.parseDouble(parts[3]);
        double average = Double.parseDouble(parts[4]);

        return new Student(rollNo, name, totalSubjects, totalMarks, average);
    }

    @Override
    public String toString() {
        return "\n-----------------------------"
                + "\nRoll Number   : " + rollNo
                + "\nName          : " + name
                + "\nSubjects      : " + totalSubjects
                + "\nTotal Marks   : " + totalMarks
                + "\nAverage Marks : " + String.format("%.2f", average)
                + "\n-----------------------------";
    }
}

public class StudentRecordSystem {

    private static final String FILE_NAME = "students.txt";

    public static void saveStudents(ArrayList<Student> students) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {

            for (Student student : students) {
                writer.println(student.toFileString());
            }

        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                Student student = Student.fromFileString(line);

                if (student != null) {
                    students.add(student);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        return students;
    }

    public static void addStudent(ArrayList<Student> students, Scanner scanner) {

        System.out.print("Enter Roll Number : ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid Roll Number.");
            scanner.nextLine();
            return;
        }

        int rollNo = scanner.nextInt();
        scanner.nextLine();

        // Duplicate Roll Number Check
        for (Student student : students) {

            if (student.getRollNo() == rollNo) {
                System.out.println("Roll Number already exists.");
                return;
            }
        }

        String name;

        while (true) {

            System.out.print("Enter Student Name : ");
            name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
            }
            else if (!name.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid name! Name should contain only alphabets and spaces.");
            }
            else {
                break;
            }
        }

        System.out.print("Enter Total Subjects : ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid Subject Count.");
            scanner.nextLine();
            return;
        }

        int totalSubjects = scanner.nextInt();

        if (totalSubjects <= 0) {
            System.out.println("Subjects must be greater than zero.");
            scanner.nextLine();
            return;
        }

        double totalMarks = 0;

        for (int i = 1; i <= totalSubjects; i++) {

            double mark;

            while (true) {

                System.out.print("Enter Marks of Subject " + i + " (0-100): ");

                if (!scanner.hasNextDouble()) {
                    System.out.println("Invalid Marks.");
                    scanner.nextLine();
                    continue;
                }

                mark = scanner.nextDouble();

                if (mark >= 0 && mark <= 100) {
                    break;
                }

                System.out.println("Marks should be between 0 and 100.");
            }

            totalMarks += mark;
        }

        scanner.nextLine();

        double average = totalMarks / totalSubjects;

        Student student = new Student(rollNo, name, totalSubjects, totalMarks, average);

        students.add(student);

        saveStudents(students);

        System.out.println("\nStudent Added Successfully.");
    }

    public static void viewStudents(ArrayList<Student> students) {

        if (students.isEmpty()) {
            System.out.println("No Student Records Found.");
            return;
        }

        System.out.println("\n===== STUDENT RECORDS =====");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = loadStudents();

        while (true) {

            System.out.println("\n========== STUDENT RECORD SYSTEM ==========");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.print("Enter Your Choice : ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid Choice.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addStudent(students, scanner);
                    break;

                case 2:
                    viewStudents(students);
                    break;

                case 3:
                    saveStudents(students);
                    System.out.println("Thank You!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}