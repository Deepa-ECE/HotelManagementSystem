import java.util.ArrayList;

   import java.util.Date;

import java.util.List;

public class BookingService {
    private List<Booking> bookings;
    List<Room> rooms = new ArrayList<>(); // Assuming you have a list of rooms to work with


    // Constructor
    public BookingService() {
        bookings = new ArrayList<>();
    }



    public Booking createBooking(String firstName, String lastName, String email, String roomType, Date checkInDate, Date checkOutDate) {
        // Create a GuestProfile object with the required data
        GuestProfile guestProfile = new GuestProfile(firstName, lastName, email);

        // Create a Room object (make sure to pass the right arguments)
        int roomId = 101;  // Example room ID
        double price = 100.00;  // Example price
        boolean isAvailable = true;  // Example availability status
        Room room = new Room(roomId, roomType, price, isAvailable);

        // Create a Booking object with the generated details
        String bookingId = generateBookingId();  // You can implement your own method to generate booking IDs
        Booking booking = new Booking(bookingId, guestProfile, room, checkInDate, checkOutDate);

        // Return the created booking
        return booking;
    }

    // Method to generate a booking ID (you can customize this method)
    private String generateBookingId() {
        return "B" + System.currentTimeMillis();  // Simple example to generate unique booking IDs based on timestamp
    }

    public static void main(String[] args) {
        // Example usage of createBooking method
        BookingService bookingService = new BookingService();

        // Sample data
        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@example.com";
        String roomType = "Single";
        Date checkInDate = new Date();  // You can replace this with a specific date
        Date checkOutDate = new Date(); // You can replace this with a specific date

        // Create a booking using the createBooking method
        Booking booking = bookingService.createBooking(firstName, lastName, email, roomType, checkInDate, checkOutDate);

        // Display the booking details
        booking.displayBookingDetails();
    }

    // Method to view all bookings
    public void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (Booking booking : bookings) {
                booking.displayBookingDetails();
                System.out.println("--------------------------");
            }
        }
    }

    // Method to cancel a booking
    public boolean cancelBooking(String bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                bookings.remove(booking);
                System.out.println("Booking canceled successfully!");
                return true;
            }
        }
        System.out.println("Booking ID not found.");
        return false;
    }

    // Method to find a booking by ID
    public Booking findBookingById(String bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                return booking;
            }
        }
        return null; // Booking not found
    }
    public Room getRoomByType(String roomType) {
    // Implement logic to retrieve a Room object based on room type
    // This could involve searching through a list or database of rooms
    for (Room room : rooms) { // Assuming you have a list of rooms
        if (room.getType().equalsIgnoreCase(roomType)) {
            return room;
        }
    }
    return null; // Return null or throw an exception if no room found
}
}