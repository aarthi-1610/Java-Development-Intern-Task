package level4.realworldbeginnerprojects;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DailyTaskManager {

    private static final String FILE_NAME = "tasks.txt";

    public static ArrayList<String> loadTasks() {
        ArrayList<String> tasks = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return tasks;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    tasks.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks.");
        }

        return tasks;
    }

    public static void saveTasks(ArrayList<String> tasks) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (String task : tasks) {
                writer.println(task);
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    public static void addTask(ArrayList<String> tasks, Scanner scanner) {
        System.out.print("Enter task: ");
        String task = scanner.nextLine().trim();

        if (task.isEmpty()) {
            System.out.println("Task cannot be empty.");
            return;
        }

        tasks.add(task);
        saveTasks(tasks);
        System.out.println("Task added.");
    }

    public static void viewTasks(ArrayList<String> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public static void deleteTask(ArrayList<String> tasks, Scanner scanner) {
        System.out.print("Enter task number to delete: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input.");
            scanner.nextLine();
            return;
        }

        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        tasks.remove(index - 1);
        saveTasks(tasks);
        System.out.println("Task deleted.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = loadTasks();

        while (true) {
            System.out.println("\nDaily Task Manager");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask(tasks, scanner);
                    break;
                case 2:
                    viewTasks(tasks);
                    break;
                case 3:
                    deleteTask(tasks, scanner);
                    break;
                case 4:
                    saveTasks(tasks);
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}