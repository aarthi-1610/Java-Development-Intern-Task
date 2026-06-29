package level2.intermediatejavautilities;

import java.util.Scanner;

public class TicTacToe {

 static char[] board = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
 static char currentPlayer = 'X';

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     System.out.println("   Welcome to Tic-Tac-Toe!  ");
     System.out.println(" Player 1 → X  |  Player 2 → O");
     System.out.println(" Enter the position number to place your mark.");

     boolean gameOver = false;

     while (!gameOver) {
         displayBoard();
         System.out.print("Player " + currentPlayer + ", choose position (1-9): ");

         // --- Input validation ---
         if (!sc.hasNextInt()) {
             System.out.println("Please enter a number between 1 and 9.");
             sc.next(); // clear invalid input
             continue;
         }

         int position = sc.nextInt();

         if (position < 1 || position > 9) {
             System.out.println("Invalid! Enter a number between 1 and 9.");
             continue;
         }

         if (board[position - 1] == 'X' || board[position - 1] == 'O') {
             System.out.println("That spot is already taken! Choose another.");
             continue;
         }

         // Place the mark
         board[position - 1] = currentPlayer;

         // Check result
         if (checkWin()) {
             displayBoard();
             System.out.println("Congratulations! Player " + currentPlayer + " wins!");
             gameOver = true;

         } else if (checkDraw()) {
             displayBoard();
             System.out.println("It's a draw! Well played by both!");
             gameOver = true;

         } else {
             // Switch player
             currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
         }
     }

     sc.close();
 }

 // Prints the 3x3 board in a readable grid format
 static void displayBoard() {
     System.out.println("\n " + board[0] + " | " + board[1] + " | " + board[2]);
     System.out.println("---+---+---");
     System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
     System.out.println("---+---+---");
     System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
     System.out.println();
 }

 // Checks all 8 possible winning combinations
 static boolean checkWin() {
     // Three rows
     if (board[0] == board[1] && board[1] == board[2]) return true;
     if (board[3] == board[4] && board[4] == board[5]) return true;
     if (board[6] == board[7] && board[7] == board[8]) return true;
     // Three columns
     if (board[0] == board[3] && board[3] == board[6]) return true;
     if (board[1] == board[4] && board[4] == board[7]) return true;
     if (board[2] == board[5] && board[5] == board[8]) return true;
     // Two diagonals
     if (board[0] == board[4] && board[4] == board[8]) return true;
     if (board[2] == board[4] && board[4] == board[6]) return true;
     return false;
 }

 static boolean checkDraw() {
     for (char cell : board) {
         if (cell != 'X' && cell != 'O') return false; // still has empty spot
     }
     return true;
 }
}