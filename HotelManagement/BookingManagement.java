import java.util.ArrayList;
import java.util.Scanner;

public class BookingManagement {
    private ArrayList<String> bookings;

    public BookingManagement() {
        bookings = new ArrayList<>();
    }

    public void manageBookings(Scanner scanner) {
        while (true) {
            System.out.println("Booking Management:");
            System.out.println("1. Add Booking");
            System.out.println("2. View All Bookings");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addBooking(scanner);
                case 2 -> viewBookings();
                case 3 -> cancelBooking(scanner);
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addBooking(Scanner scanner) {
        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter room number: ");
        String roomNumber = scanner.nextLine();
        bookings.add("Guest: " + guestName + ", Room: " + roomNumber);
        System.out.println("Booking added successfully!");
    }

    private void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
        } else {
            System.out.println("All Bookings:");
            for (String booking : bookings) {
                System.out.println(booking);
            }
        }
    }

    private void cancelBooking(Scanner scanner) {
        if (bookings.isEmpty()) {
            System.out.println("No bookings to cancel.");
            return;
        }
        System.out.println("Enter the index of the booking to cancel (starting from 1): ");
        int index = scanner.nextInt();
        if (index > 0 && index <= bookings.size()) {
            bookings.remove(index - 1);
            System.out.println("Booking canceled successfully!");
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }
}