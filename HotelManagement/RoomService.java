// RoomService.java
import java.util.HashMap;
import java.util.Map;

public class RoomService {
    private Map<Integer, String> roomStatus;

    public RoomService() {
        roomStatus = new HashMap<>();
        // Initialize room status (e.g., 101: Available, 102: Occupied)
        roomStatus.put(101, "Available");
        roomStatus.put(102, "Occupied");
        roomStatus.put(103, "Under Maintenance");
    }

    public void updateRoomStatus(int roomNumber, String status) {
        if (roomStatus.containsKey(roomNumber)) {
            roomStatus.put(roomNumber, status);
            System.out.println("Room " + roomNumber + " status updated to: " + status);
        } else {
            System.out.println("Room number not found.");
        }
    }

    public void viewRoomStatus() {
        System.out.println("Room Status:");
        for (Map.Entry<Integer, String> entry : roomStatus.entrySet()) {
            System.out.println("Room " + entry.getKey() + ": " + entry.getValue());
        }
    }
}