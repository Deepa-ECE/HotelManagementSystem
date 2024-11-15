import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuestProfileManagement {
    private List<Guest> guestProfiles = new ArrayList<>();

    public void manageGuestProfiles(Scanner scanner) {
        while (true) {
            System.out.println("\nGuest Profile Management");
            System.out.println("1. Add Guest Profile");
            System.out.println("2. View Guest Profiles");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                addGuestProfile(scanner);
            } else if (choice == 2) {
                viewGuestProfiles();
            } else if (choice == 3) {
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addGuestProfile(Scanner scanner) {
        System.out.println("\n--- Add Guest Profile ---");
        System.out.print("Enter Guest Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Guest Contact Number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter Guest Email: ");
        String email = scanner.nextLine();

        Guest newGuest = new Guest(name, contactNumber, email);
        guestProfiles.add(newGuest);
        System.out.println("Guest profile added successfully.");
    }

    private void viewGuestProfiles() {
        System.out.println("\n--- View Guest Profiles ---");
        if (guestProfiles.isEmpty()) {
            System.out.println("No guest profiles available.");
        } else {
            for (Guest guest : guestProfiles) {
                System.out.println(guest);
            }
        }
    }

    // Inner class to represent a Guest profile
    private static class Guest {
        private String name;
        private String contactNumber;
        private String email;

        public Guest(String name, String contactNumber, String email) {
            this.name = name;
            this.contactNumber = contactNumber;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Contact Number: " + contactNumber + ", Email: " + email;
        }
    }
}
