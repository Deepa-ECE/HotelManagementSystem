import java.util.HashMap;
import java.util.Scanner;

public class RoomManagement {
    private HashMap<String, String> rooms;

    public RoomManagement() {
        rooms = new HashMap<>();
        // Initialize some rooms
        rooms.put("101", "Available");
        rooms.put("102", "Available");
        rooms.put("103", "Occupied");
    }

    public void manageRooms(Scanner scanner) {
        while (true) {
            System.out.println("Room Management:");
            System.out.println("1. View Room Status");
            System.out.println("2. Update Room Status");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> viewRoomStatus();
                case 2 -> updateRoomStatus(scanner);
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewRoomStatus() {
        System.out.println("Room Status:");
        for (String room : rooms.keySet()) {
            System.out.println("Room " + room + ": " + rooms.get(room));
        }
    }

    private void updateRoomStatus(Scanner scanner) {
        System.out.print("Enter room number to update: ");
        String roomNumber = scanner.nextLine();
        if (rooms.containsKey(roomNumber)) {
            System.out.print("Enter new status (Available/Occupied): ");
            String status = scanner.nextLine();
            rooms.put(roomNumber, status);
            System.out.println("Room status updated successfully!");
        } else {
            System.out.println("Invalid room number. Please try again.");
        }
    }
}