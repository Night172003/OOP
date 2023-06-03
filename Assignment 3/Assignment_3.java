// Ryan Kyle A. Basilides  BSIT 2-2
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Inventory {
    private Map<String, Integer> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void addItem(String item, int quantity) {
        String uppercaseItem = item.toUpperCase();
        items.put(uppercaseItem, items.getOrDefault(uppercaseItem, 0) + quantity);
        System.out.println(uppercaseItem + " Item added successfully.");
    }

    public void removeItem(String item) {
        String uppercaseItem = item.toUpperCase();
        if (!items.containsKey(uppercaseItem)) {
            System.out.println("Item not found in the inventory!");
            return;
        }
        items.remove(uppercaseItem);
        System.out.println(uppercaseItem + " item removed successfully.");
    }

    public int getItemQuantity(String item) {
        return items.getOrDefault(item.toUpperCase(), 0);
    }
}

class InventoryManagement {
    private Inventory inventory;
    private Scanner scanner;

    public InventoryManagement() {
        inventory = new Inventory();
        scanner = new Scanner(System.in);
    }

    private void displayMenu() {
        System.out.println("\n********* Menu ***********");
        System.out.println("(1) Add Item            ");
        System.out.println("(2) Remove Item         ");
        System.out.println("(3) Check Item Quantity ");
        System.out.println("(4) Exit                ");
        System.out.println("**************************\n");
        System.out.print("Enter your choice: ");
    }

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

    private int getUserChoice() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid choice. \nPlease enter a valid menu option: ");
            }
        }
    }

    private void addItem() {
        System.out.print("Enter the item name: ");
        String itemName = scanner.nextLine();
        int quantity = getValidQuantity();
        inventory.addItem(itemName, quantity);
    }

    private void removeItem() {
        System.out.print("Enter the item name: ");
        String itemName = scanner.nextLine();
        inventory.removeItem(itemName);
    }

    private void checkItemQuantity() {
        System.out.print("Enter the item name: ");
        String itemName = scanner.nextLine();

        int quantity = inventory.getItemQuantity(itemName);
        if (quantity != 0) {
            System.out.println("Quantity of " + itemName + " in inventory: " + quantity);
        } else {
            System.out.println("Item not found in the inventory!");
        }
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

public class Assignment_3{
    public static void main(String[] args) {
        InventoryManagement inventoryManagement = new InventoryManagement();
        inventoryManagement.menu();
    }
}