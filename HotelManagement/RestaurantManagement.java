import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantManagement {
    private ArrayList<String> menuItems;
    private ArrayList<String> orders;

    public RestaurantManagement() {
        menuItems = new ArrayList<>();
        orders = new ArrayList<>();
        // Adding some sample menu items
        menuItems.add("Pasta");
        menuItems.add("Pizza");
        menuItems.add("Burger");
    }

    public void manageRestaurant(Scanner scanner) {
        while (true) {
            System.out.println("Restaurant Management:");
            System.out.println("1. View Menu");
            System.out.println("2. Add Menu Item");
            System.out.println("3. Take Order");
            System.out.println("4. View Orders");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewMenu();
                    break;
                case 2:
                    addMenuItem(scanner);
                    break;
                case 3:
                    takeOrder(scanner);
                    break;
                case 4:
                    viewOrders();
                    break;
                case 5:
                    return; // Exit the loop
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewMenu() {
        System.out.println("Menu Items:");
        for (String item : menuItems) {
            System.out.println("- " + item);
        }
    }

    private void addMenuItem(Scanner scanner) {
        System.out.print("Enter new menu item: ");
        String item = scanner.nextLine();
        menuItems.add(item);
        System.out.println("Menu item added successfully.");
    }

    private void takeOrder(Scanner scanner) {
        System.out.print("Enter order: ");
        String order = scanner.nextLine();
        orders.add(order);
        System.out.println("Order placed successfully.");
    }

    private void viewOrders() {
        System.out.println("Orders:");
        for (String order : orders) {
            System.out.println("- " + order);
        }
    }
}