package level3.oopandsmallprojects;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean issued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public int getId() {
        return id;
    }

    public boolean isIssued() {
        return issued;
    }

    public void issueBook() {
        this.issued = true;
    }

    public void returnBook() {
        this.issued = false;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Status: " + (issued ? "Issued" : "Available");
    }
}

public class LibraryManagementSystem {

    public static Book findBook(ArrayList<Book> books, int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
    public static boolean isValidBookTitle(String title) {
        return title.matches("^[A-Za-z0-9][A-Za-z0-9 :'()-]*$");
    }

    public static boolean isValidAuthorName(String author) {
        return author.matches("[A-Za-z ]+");
    }

    public static boolean isDuplicateBook(ArrayList<Book> books, String title, String author) {

        for (Book book : books) {

            if (book.getTitle().trim().equalsIgnoreCase(title.trim())
                    && book.getAuthor().trim().equalsIgnoreCase(author.trim())) {

                return true;
            }
        }

        return false;
    }
public static void addBook(ArrayList<Book> books, Scanner scanner, int nextId) {

    String title;
    String author;

    // Book Title Validation
    while (true) {

        System.out.print("Enter Book Title : ");
        title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Book title cannot be empty.");
            continue;
        }

        if (!isValidBookTitle(title)) {
            System.out.println("Invalid book title.");
            continue;
        }

        break;
    }

    // Author Name Validation
    while (true) {

        System.out.print("Enter Author Name : ");
        author = scanner.nextLine().trim();

        if (author.isEmpty()) {
            System.out.println("Author name cannot be empty.");
            continue;
        }

        if (!isValidAuthorName(author)) {
            System.out.println("Author name should contain only alphabets.");
            continue;
        }

        break;
    }

    // Normalize spaces
    title = title.replaceAll("\\s+", " ").trim();
    author = author.replaceAll("\\s+", " ").trim();

    // Duplicate Check
    if (isDuplicateBook(books, title, author)) {
        System.out.println("Book already exists.");
        return;
    }

    books.add(new Book(nextId, title, author));
    System.out.println("Book added successfully.");
}
   
    public static void displayBooks(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void issueBook(ArrayList<Book> books, Scanner scanner) {
        System.out.print("Enter book ID to issue: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid book ID.");
            scanner.nextLine();
            return;
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        Book book = findBook(books, id);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isIssued()) {
            System.out.println("Book is already issued.");
        } else {
            book.issueBook();
            System.out.println("Book issued successfully.");
        }
    }

    public static void returnBook(ArrayList<Book> books, Scanner scanner) {
        System.out.print("Enter book ID to return: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid book ID.");
            scanner.nextLine();
            return;
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        Book book = findBook(books, id);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (!book.isIssued()) {
            System.out.println("Book was not issued.");
        } else {
            book.returnBook();
            System.out.println("Book returned successfully.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        int nextId = 1;

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
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
                    addBook(books, scanner, nextId);
                    nextId++;
                    break;
                case 2:
                    displayBooks(books);
                    break;
                case 3:
                    issueBook(books, scanner);
                    break;
                case 4:
                    returnBook(books, scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
