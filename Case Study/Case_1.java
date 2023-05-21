import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Inventory class to manage items
class Inventory {
    //Creating a Hashmap
    private Map<String, Integer> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void addItem(String item, int quantity) {
        try {
            String uppercaseItem = item.toUpperCase();
            if (items.containsKey(uppercaseItem)) {
                int currentQuantity = items.get(uppercaseItem);
                items.put(uppercaseItem, currentQuantity + quantity);
            } else {
                items.put(uppercaseItem, quantity);
            }
            System.out.println(item.toUpperCase() + " Item added successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred while adding the item: " + e.getMessage());
        }
    }

    public void removeItem(String item, int quantity) {
        String uppercaseItem = item.toUpperCase();
        if (items.containsKey(uppercaseItem)) {
            int currentQuantity = items.get(uppercaseItem);
            if (currentQuantity >= quantity) {
                items.put(uppercaseItem, currentQuantity - quantity);
                System.out.println(item.toUpperCase() + " Item removed successfully.");
            } else {
                System.out.println("Insufficient quantity. \nUnable to remove the item!");
            }
        } else {
            System.out.println("Item not found in the inventory!");
        }
    }

    public int getItemQuantity(String item) {
        return items.getOrDefault(item.toUpperCase(), 0);
    }
}
// Inventory Management class for the user interface
class InventoryManagement {
    private Inventory inventory;
    private Scanner scanner;

    public InventoryManagement() {
        inventory = new Inventory();
        scanner = new Scanner(System.in);
    }
    //Menu for user to choose from
    private void displayMenu() {
        System.out.println("\n********* Menu ***********");
        System.out.println("*(1) Add Item            *");
        System.out.println("*(2) Remove Item         *");
        System.out.println("*(3) Check Item Quantity *");
        System.out.println("*(4) Exit                *");
        System.out.println("**************************\n");
        System.out.print("Enter your choice: ");
    }
    //Displays a menu to the user and prompts for their choice
    public void menu() {
        System.out.println("Welcome to MDB Inventory Management System!");

        int choice;
        do {
            displayMenu();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    checkItemQuantity();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        } while (choice != 4);
    }
    //Reads the user's choice from the console and handles exceptions when user enters an invalid choice
    private int getUserChoice() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid choice. \nPlease enter a valid menu option: ");
            }
        }
    }
    //Prompts user to enter item name and its quantity
    private void addItem() {
        System.out.print("Enter the item name: ");
        String itemName = scanner.nextLine();
        int quantity = getValidQuantity();

        inventory.addItem(itemName, quantity);
    }
    //Prompts user to enter item name to be removed from Map
    private void removeItem() {
        System.out.print("Enter the item name: ");
        String itemName = scanner.nextLine();
        int quantity = getValidQuantity();

        inventory.removeItem(itemName, quantity);
    }

    private void checkItemQuantity() {
        System.out.print("Enter the item name: ");
        String itemName = scanner.nextLine();

        int quantity = inventory.getItemQuantity(itemName);
        System.out.println("Quantity of " + itemName + " in inventory: " + quantity);
    }

    private int getValidQuantity() {
        while (true) {
            System.out.print("Enter the quantity: ");
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity. Please enter a valid integer value!");
            }
        }
    }
}
// Main Class serves as the entry point of the program
public class Case_1 {
    public static void main(String[] args) {
        InventoryManagement inventoryManagement = new InventoryManagement();
        inventoryManagement.menu();
    }
}
