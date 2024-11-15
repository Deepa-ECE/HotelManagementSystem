import java.util.Date;

public class Booking {
    private String bookingId;
    private GuestProfile guestProfile;
    private Room room;
    private Date checkInDate;
    private Date checkOutDate;

    public Booking(String bookingId, GuestProfile guestProfile, Room room, Date checkInDate, Date checkOutDate) {
        this.bookingId = bookingId;
        this.guestProfile = guestProfile;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public void displayBookingDetails() {
        System.out.println("Booking Details:");
        System.out.println("Guest Name: " + guestProfile.getGuestName());
        System.out.println("Guest Profile: " + guestProfile);
        System.out.println("Room Type: " + room.getType());
        System.out.println("Check-In Date: " + checkInDate);
        System.out.println("Check-Out Date: " + checkOutDate);
    }
    
    // Getters for all fields

    public String getBookingId() {
        return bookingId;
    }

    public GuestProfile getGuestProfile() {
        return guestProfile;
    }

    public Room getRoom() {
        return room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }
}