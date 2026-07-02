package level3.oopandsmallprojects;

import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private int id;
    private String name;
    private String phone;
    private String email;

    public Contact(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class ContactManagementSystem {

	public static void addContact(ArrayList<Contact> contacts, Scanner scanner, int nextId) {

	    String name;

	    while (true) {
	        System.out.print("Enter name: ");
	        name = scanner.nextLine().trim();

	        if (isValidName(name))
	            break;

	        System.out.println("Invalid name! Name should contain only alphabets and spaces.");
	    }

	    String phone;

	    while (true) {
	        System.out.print("Enter phone: ");
	        phone = scanner.nextLine().trim();

	        if (isValidPhone(phone))
	            break;

	        System.out.println("Invalid phone number! Enter exactly 10 digits starting with 6-9.");
	    }

	    String email;

	    while (true) {
	        System.out.print("Enter email: ");
	        email = scanner.nextLine().trim();

	        if (isValidEmail(email))
	            break;

	        System.out.println("Invalid email format.");
	    }

	    contacts.add(new Contact(nextId, name, phone, email));
	    System.out.println("Contact added successfully.");
	}
    public static boolean isValidName(String name) {
        return name.matches("[A-Za-z ]{2,50}");
    }

    public static boolean isValidPhone(String phone) {
        return phone.matches("[6-9][0-9]{9}");
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    public static void viewContacts(ArrayList<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public static Contact findContactById(ArrayList<Contact> contacts, int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }

    public static void searchContact(ArrayList<Contact> contacts, Scanner scanner) {
        System.out.print("Enter contact ID to search: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid ID.");
            scanner.nextLine();
            return;
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        Contact contact = findContactById(contacts, id);
        if (contact == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(contact);
        }
    }

    public static void updateContact(ArrayList<Contact> contacts, Scanner scanner) {

        System.out.print("Enter contact ID to update: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid ID.");
            scanner.nextLine();
            return;
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        Contact contact = findContactById(contacts, id);

        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        String name;

        while (true) {
            System.out.print("Enter new name: ");
            name = scanner.nextLine().trim();

            if (isValidName(name))
                break;

            System.out.println("Invalid name! Only alphabets and spaces are allowed.");
        }

        String phone;

        while (true) {
            System.out.print("Enter new phone: ");
            phone = scanner.nextLine().trim();

            if (isValidPhone(phone))
                break;

            System.out.println("Invalid phone number! Enter exactly 10 digits starting with 6-9.");
        }

        String email;

        while (true) {
            System.out.print("Enter new email: ");
            email = scanner.nextLine().trim();

            if (isValidEmail(email))
                break;

            System.out.println("Invalid email format.");
        }

        contact.setName(name);
        contact.setPhone(phone);
        contact.setEmail(email);

        System.out.println("Contact updated successfully.");
    }
    public static void deleteContact(ArrayList<Contact> contacts, Scanner scanner) {
        System.out.print("Enter contact ID to delete: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid ID.");
            scanner.nextLine();
            return;
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        Contact contact = findContactById(contacts, id);
        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        contacts.remove(contact);
        System.out.println("Contact deleted successfully.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();
        int nextId = 1;

        while (true) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
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
                    addContact(contacts, scanner, nextId);
                    nextId++;
                    break;
                case 2:
                    viewContacts(contacts);
                    break;
                case 3:
                    searchContact(contacts, scanner);
                    break;
                case 4:
                    updateContact(contacts, scanner);
                    break;
                case 5:
                    deleteContact(contacts, scanner);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}