import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Inventory inventory = new Inventory();

        boolean running = true;

        while (running) {
            System.out.println("\n===== Basic Library System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search by Title");
            System.out.println("5. Print All Books");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        addBookMenu(input, inventory);
                        break;

                    case 2:
                        System.out.print("Enter the book ID to borrow: ");
                        int borrowId = input.nextInt();
                        input.nextLine();

                        if (inventory.borrowBook(borrowId)) {
                            System.out.println("Book successfully borrowed.");
                        } else {
                            System.out.println("Book not found or already borrowed.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter the book ID to return: ");
                        int returnId = input.nextInt();
                        input.nextLine();

                        if (inventory.returnBook(returnId)) {
                            System.out.println("Book successfully returned.");
                        } else {
                            System.out.println("Book is not currently in the lending list.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter full or partial title: ");
                        String searchTitle = input.nextLine();

                        ArrayList<Book> results = inventory.searchByTitle(searchTitle);

                        if (results.isEmpty()) {
                            System.out.println("No matching book found.");
                        } else {
                            System.out.println("Matching books:");
                            for (Book book : results) {
                                book.printBookInfo();
                            }
                        }
                        break;

                    case 5:
                        inventory.printAll();
                        break;

                    case 6:
                        running = false;
                        System.out.println("Exiting the program. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Please choose a number from 1 to 6.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                input.nextLine();
            }
        }

        input.close();
    }

    public static void addBookMenu(Scanner input, Inventory inventory) {
        try {
            System.out.print("Enter book ID: ");
            int id = input.nextInt();
            input.nextLine();

            System.out.print("Enter title: ");
            String title = input.nextLine();

            System.out.print("Enter author: ");
            String author = input.nextLine();

            System.out.print("Enter ISBN number: ");
            String isbn = input.nextLine();

            System.out.print("Enter number of pages: ");
            int pages = input.nextInt();
            input.nextLine();

            Book book = new Book(id, title, author, isbn, pages);

            if (inventory.addBook(book)) {
                System.out.println("Book added to the library.");
            } else {
                System.out.println("A book with that ID already exists.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Book was not added.");
            input.nextLine();
        }
    }
}