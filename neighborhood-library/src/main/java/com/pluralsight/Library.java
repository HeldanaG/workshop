
package com.pluralsight;

// Import required classes for user input and exception handling
import java.util.InputMismatchException;
import java.util.Scanner;


public class Library {

    // Create a Scanner object for user input
    static Scanner input = new Scanner(System.in);

    // Create and initialize an array of Book objects by calling createBookList() method
    static Book[] books = createBookList();

    public static void main(String[] args) {

        // Call the main menu method to start the application
        mainMenu();


    }

    // Displays the main menu and handles user choice
    public static void mainMenu() {

        // Boolean to keep the app running until user chooses to exit
        boolean appRunning = true;

        // Loop to keep showing the menu until appRunning becomes false
        while (appRunning) {
            try {
                // Display menu options
                System.out.println("\n📚✨~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("               WELCOME TO THE CODEO NEIGHBORHOOD LIBRARY               ");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~✨📚\n");
                System.out.println("Please select an option from the menu below:\n");
                System.out.println("  1️  Show Available Books");
                System.out.println("  2️  Show Checked Out Books");
                System.out.println("  3️  Exit Library\n");

                System.out.print("Enter your choice (1, 2, or 3): ");

                // Read user's menu choice
                String menuChoice = input.nextLine();
                while (menuChoice.isEmpty() || !menuChoice.matches("[1-3]")) {
                    System.out.print("Invalid input. Please enter 1, 2, or 3: ");
                    menuChoice = input.nextLine();
                }

                int choice = Integer.parseInt(menuChoice);
                // Handle each choice accordingly using switch
                switch (choice) {
                    case 1:
                        showAvailableBooks();
                        break;
                    case 2:
                        showCheckedOutBooks();
                        break;
                    case 3:
                        // Exit the program by making appRunning false
                        appRunning = false;
                        System.out.println("\nThank you for visiting the Codeo Library!");
                        System.out.println("We look forward to seeing you again :) .");
                        break;
                    default:
                        // returns back if user put invalid choice number
                        System.out.print("Invalid choice. Please enter 1, 2, or 3: ");
                        break;

                }
                // catches and returns back if user put invalid input
            } catch (InputMismatchException e) {
                System.out.println("Sorry! That doesn't look like a number. Please try again.");
                input.nextLine();
            }
        }
    }

    // Displays books that are not checked out and handle checkout process
    public static void showAvailableBooks() {


        System.out.println("\n📚✨~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("               📖 LIST OF AVAILABLE BOOKS 📖                     ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~✨📚\n");
        // Boolean to keep the app running until user chooses to exit
        boolean appRunning = true;
        // Loop to keep handling the process until appRunning becomes false
        while (appRunning) {
            try {


                int numCount=1;
                // Loop through all books and display only those not checked out
                for (Book book : books) {
                    if (!book.isCheckedOut()) {
                        System.out.println(numCount+ ". Id: " + book.getId() + " | ISBN: " + book.getIsbn() + " | Title: " + book.getTitle());
                        numCount++;
                    }
                }

                // Ask if user wants to check out a book
                System.out.print("\nWould you like to check out a book? (Y/N): ");
                String choice = input.nextLine();
                while (choice.isEmpty() || !(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N"))) {
                    System.out.print("Invalid Input! Please Enter Y or N: ");
                    choice = input.nextLine();
                }

                // checking user input
                if (choice.equalsIgnoreCase("y")) {

                    // Prompt for book Id to check out
                    System.out.print("Enter the Book ID you want to check out: ");
                    String bookIdInput = input.nextLine();
                    while (bookIdInput.isEmpty() || !bookIdInput.matches("\\d+")) {
                        System.out.print("Invalid input. Please enter a valid number: ");
                        bookIdInput = input.nextLine();
                    }
                    int bookId = Integer.parseInt(bookIdInput);

                    // Prompt for user's name
                    System.out.print("Enter your name: ");
                    String name = input.nextLine();
                    while (name.isEmpty() || name.matches("\\d+")) {
                        System.out.print("Invalid name. Please enter a valid name: ");
                        name = input.nextLine();
                    }

                    // Boolean to track if book is found
                    boolean found = false;

                    // Loop through books to find matching Id and check it out
                    for (Book book : books) {
                        if (book.getId() == bookId && !book.isCheckedOut()) {
                            book.checkOut(name); // Check out book
                            System.out.println("Book checked out successfully to " + name + "!");
                            found = true;
                            break;
                        }
                    }
                    // If no valid book is found
                    if (!found) {
                        System.out.println("Invalid book Id or book already checked out.");
                    }

                    System.out.print("\nWould you like to check out another book? (Y/N): ");
                    String lookAnotherBook = input.nextLine();

                    if (lookAnotherBook.equalsIgnoreCase("y")) {

                            // Prompt for book Id to check out
                            System.out.print("Enter the Book ID you want to check out: ");
                             bookId = input.nextInt();
                            input.nextLine();

                            // Prompt for user's name
                            System.out.print("Enter your name: ");
                             name = input.nextLine();

                            // Boolean to track if book is found
                            found = false;

                            // Loop through books to find matching Id and check it out
                            for (Book book : books) {
                                if (book.getId() == bookId && !book.isCheckedOut()) {
                                    book.checkOut(name); // Check out book
                                    System.out.println("Book checked out successfully to " + name + "!");
                                    found = true;
                                    break;
                                }
                            }
                            // If user doesn't want to search again, stop the loop
                    } else if (lookAnotherBook.equalsIgnoreCase("n")) {
                        appRunning = false;
                    } else {
                        System.out.print("Invalid Input! Please Enter y or n: ");
                        String lookAnotherBook2 = input.nextLine();

                        while (lookAnotherBook2.isEmpty() || lookAnotherBook2.matches("\\d+") || !(lookAnotherBook2.equalsIgnoreCase("Y") ||lookAnotherBook2.equalsIgnoreCase("N"))) {
                            System.out.print("Invalid Input! Please Enter Y or N: ");
                            lookAnotherBook2 = input.nextLine();

                            if (lookAnotherBook2.equalsIgnoreCase("y")) {
                                continue;
                                // If user doesn't want to search again, stop the loop
                            } else {
                                appRunning = false;
                            }
                        }
                    }

                } else {
                    // Exit available books menu based on user input "n"
                    appRunning = false;
                }

                // catch  invalid input type
            } catch (InputMismatchException e) {
                System.out.print("Invalid input type! Please enter a number: ");
                input.nextLine();
                continue; // Return to start again
            }
        }
    }

    // Displays all books that are currently checked out. and allows user to check a book back in or return to the main menu.
    public static void showCheckedOutBooks() {

        System.out.println("\n📚✨~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("                     📖 CHECKED OUT BOOKS 📖                         ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~✨📚\n");
        // Boolean to keep the app running until user chooses to exit
        boolean appRunnig = true;

        // Loop to keep handling the process until appRunning becomes false
        while (appRunnig) {
            try {

                int numCount=1;
                // Loop through books to show those checked out
                for (Book book : books) {
                    if (book.isCheckedOut()) {
                        System.out.println(numCount+ ". Id: " + book.getId() + " | ISBN: " + book.getIsbn() + " | Title: " + book.getTitle() + " | Checked out to: " + book.getCheckedOutTo());
                        numCount++;
                    }

                }

                // Ask user if they want to check in a book or go back to main menu
                System.out.print("\nType 'C' to check in a book, 'X' to go back to main menu: ");
                String choice = input.nextLine();

                // Check if input is empty or is a number after trimming
                while (choice.isEmpty() || choice.matches("\\d+") || !(choice.equalsIgnoreCase("C") ||choice.equalsIgnoreCase("X"))) {
                    System.out.print("Invalid input. Please enter a (C/X): ");
                    choice = input.nextLine().trim();
                }

                if (choice.equalsIgnoreCase("C")) {

                    // Prompt for book Id to check in
                    System.out.print("Enter book Id to check in: ");
                    String bookIdInput = input.nextLine();
                    while (bookIdInput.isEmpty() || !bookIdInput.matches("\\d+")) {
                        System.out.print("Invalid input. Please enter a valid number: ");
                        bookIdInput = input.nextLine();
                    }
                    int bookId = Integer.parseInt(bookIdInput);

                    // Boolean to track if book is found
                    boolean found = false;

                    // Loop through books to find matching Id and check it in
                    for (Book book : books) {
                        if (book.getId() == bookId && book.isCheckedOut()) {
                            book.checkIn();
                            System.out.println("Book checked in successfully!");
                            found = true;
                            break;
                        }
                    }

                    // If no valid book is found
                    if (!found) {
                        System.out.println("Invalid book Id or book is not checked out.");
                    }

                } else {
                    // Exit checked out books menu
                    appRunnig = false;
                }
                // catch  invalid input type
            } catch (InputMismatchException e) {
                System.out.print("Invalid input type! Please enter a number: ");
                input.nextLine();
                continue;
            }
        }
    }

    // creates a list of 20 sample books
    public static Book[] createBookList() {
        return new Book[]{
                new Book(101, "ISBN0001", "Alice in Wonderland"),
                new Book(102, "ISBN0002", "The Great Gatsby"),
                new Book(103, "ISBN0003", "Moby Dick"),
                new Book(104, "ISBN0004", "To Kill a Mockingbird"),
                new Book(105, "ISBN0005", "1984"),
                new Book(106, "ISBN0006", "Pride and Prejudice"),
                new Book(107, "ISBN0007", "The Catcher in the Rye"),
                new Book(108, "ISBN0008", "Jane Eyre"),
                new Book(109, "ISBN0009", "The Hobbit"),
                new Book(110, "ISBN0010", "War and Peace"),
                new Book(111, "ISBN0011", "The Odyssey"),
                new Book(112, "ISBN0012", "Little Women"),
                new Book(113, "ISBN0013", "The Lord of the Rings"),
                new Book(114, "ISBN0014", "Dracula"),
                new Book(115, "ISBN0015", "Crime and Punishment"),
                new Book(116, "ISBN0016", "The Alchemist"),
                new Book(117, "ISBN0017", "The Book Thief"),
                new Book(118, "ISBN0018", "Chronicles of Narnia"),
                new Book(119, "ISBN0019", "The Kite Runner"),
                new Book(120, "ISBN0020", "The Picture of Dorian Gray")
        };
    }
}
