package level1.corejava;

import java.util.Scanner;

public class NumberGridSearch {

    static Scanner sc = new Scanner(System.in);

    // Input Grid
    public static void inputGrid(int[][] grid) {

        System.out.println("Enter 9 numbers for the 3x3 grid:");

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print("Enter value at [" + row + "][" + col + "] : ");
                grid[row][col] = sc.nextInt();
            }
        }
    }

    // Display Grid
    public static void displayGrid(int[][] grid) {

        System.out.println("\n----- 3x3 Number Grid -----");

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col] + "\t");
            }
            System.out.println();
        }
    }

    // Search Number
    public static boolean searchNumber(int[][] grid, int searchNumber) {

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {

                if (grid[row][col] == searchNumber) {
                    System.out.println("\nNumber Found!");
                    System.out.println("Position : Row " + row + ", Column " + col);
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] grid = new int[3][3];

        inputGrid(grid);

        displayGrid(grid);

        System.out.print("\nEnter the number to search: ");
        int searchNumber = sc.nextInt();

        boolean found = searchNumber(grid, searchNumber);

        if (!found) {
            System.out.println("\nNumber Not Found!");
        }

        sc.close();
    }
}