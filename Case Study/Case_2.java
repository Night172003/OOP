import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

// Book class to represent Book
class Book {
    private static int nextId = 1001;
    private int id;
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.id = nextId++;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
//Library class to manage the books and their availability
class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    public void displayAvailableBooks() {
        System.out.println("\n\nAvailable Books:");
        System.out.println(" ID  | TITLE | AUTHOR");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getId()+ " |\t" + book.getTitle()+ " |\t" + book.getAuthor());
            }
        }
        System.out.println();
    }

    public void borrowBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book with ID #" + bookId + " has been borrowed.");
                    return;
                } else {
                    System.out.println("Book with ID #" + bookId + " is not available.");
                    return;
                }
            }
        }
        System.out.println("Book with ID #" + bookId + " not found in the library.");

    }

    public void returnBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book with ID #" + bookId + " has been returned!");
                    return;
                } else {
                    System.out.println("Book with ID #" + bookId + " has not been borrowed!");
                    return;
                }
            }
        }
        System.out.println("Book with ID #" + bookId + " not found in the library!");
    }
}
// LibraryManagement class for the user interface and interaction.
class LibraryManagement {
    private Library library;
    private Scanner scanner;

    public LibraryManagement() {
        this.library = new Library();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {

        System.out.println("\n\t\tMenu");
        System.out.println("(1) Add a Book");
        System.out.println("(2) Remove a Book");
        System.out.println("(3) Display all Available Books");
        System.out.println("(4) Borrow a Book");
        System.out.println("(5) Return a Book");
        System.out.println("(6) Exit");
        System.out.print("Enter your choice(Input designated number): ");
    }

    public void menu(){
        System.out.println("MDB Library Management System");
        int choice;
                do{
                    displayMenu();
                    choice = getUserChoice();
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    displayAvailableBooks();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    System.out.println("Exiting the program. \nThank you for using MDB Library Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. \nPlease try again!");
                    break;
            }
            System.out.println();
        }while (choice !=6);
    }

    private int getUserChoice(){
        while(true) {
            try{
            return Integer.parseInt(scanner.nextLine());
        }catch(NumberFormatException e){
                System.out.print("Invalid choice. \nPlease enter a valid menu option: ");
            }
        }
    }
    private void addBook() {
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author of the book: ");
        String author = scanner.nextLine();

        Book book = new Book(title, author);
        library.addBook(book);
        System.out.println("Book #" + book.getId() + " was added successfully." );
    }

    private void removeBook() {
        boolean isInputValid = false;
        while (!isInputValid) {
            try {
                System.out.print("Enter the ID of the book to remove: ");
                int bookId = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Are you sure you want to remove the book? (Y/N): ");
                String confirmation = scanner.nextLine().trim().toLowerCase();

                if (confirmation.equals("y") || confirmation.equals("yes")) {
                    boolean isBookRemoved = library.removeBook(bookId);
                    if (isBookRemoved) {
                        System.out.println("Book #" + bookId + " was removed successfully!");
                    } else {
                        System.out.println("Book with ID #" + bookId + " not found in the library. Removal failed!");
                    }
                } else {
                    System.out.println("Book removal canceled!");
                }

                isInputValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid book ID!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Please try again.");
                scanner.nextLine();
            }
        }
    }

    private void displayAvailableBooks() {
        library.displayAvailableBooks();
    }

    private void borrowBook() {
        boolean isInputValid = false;
        while (!isInputValid) {
            try {
                System.out.print("Enter the ID of the book to borrow: ");
                int bookId = scanner.nextInt();
                scanner.nextLine();

                library.borrowBook(bookId);
                isInputValid = true;
            } catch (Exception e) {
                System.out.println("ID must contain numbers only!");
                System.out.println("Please try again.");
                scanner.nextLine();
            }
        }
    }


    private void returnBook() {
        boolean isInputValid = false;
        while (!isInputValid) {
            try {
                System.out.print("Enter the ID of the book to return: ");
                int bookId = scanner.nextInt();
                scanner.nextLine();

                library.returnBook(bookId);
                isInputValid = true;
            } catch (Exception e) {
                System.out.println("ID must contain numbers only!");
                System.out.println("Please try again!");
                scanner.nextLine();
            }
        }
    }
}
// Main class is the entry point of the program
public class Case_2 {
    public static void main(String[] args) {
        LibraryManagement libraryManagement = new LibraryManagement();
        libraryManagement.menu();
    }
}
