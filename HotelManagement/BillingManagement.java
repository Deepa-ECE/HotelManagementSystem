import java.util.HashMap;
import java.util.Scanner;

public class BillingManagement {
    private HashMap<String, Double> bills;

    public BillingManagement() {
        bills = new HashMap<>();
    }

    public void manageBilling(Scanner scanner) {
        while (true) {
            System.out.println("Billing Management:");
            System.out.println("1. Add Bill");
            System.out.println("2. View All Bills");
            System.out.println("3. Pay Bill");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addBill(scanner);
                case 2 -> viewBills();
                case 3 -> payBill(scanner);
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addBill(Scanner scanner) {
        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        bills.put(guestName, amount);
        System.out.println("Bill added successfully for " + guestName);
    }

    private void viewBills() {
        if (bills.isEmpty()) {
            System.out.println("No bills available.");
        } else {
            System.out.println("All Bills:");
            for (String guest : bills.keySet()) {
                System.out.println("Guest: " + guest + ", Amount: $" + bills.get(guest));
            }
        }
    }

    private void payBill(Scanner scanner) {
        if (bills.isEmpty()) {
            System.out.println("No bills to pay.");
            return;
        }
        System.out.print("Enter guest name to pay the bill: ");
        String guestName = scanner.nextLine();
        if (bills.containsKey(guestName)) {
            bills.remove(guestName);
            System.out.println("Bill paid successfully for " + guestName);
        } else {
            System.out.println("No bill found for " + guestName);
        }
    }
}