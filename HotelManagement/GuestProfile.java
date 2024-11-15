public class GuestProfile {
    private String guestName;
    private String contactNumber;
    private String address;

    // Constructor
    public GuestProfile(String guestName, String contactNumber, String address) {
        this.guestName = guestName;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    // Getter methods
    public String getGuestName() {
        return guestName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getAddress() {
        return address;
    }

    // Display guest profile information
    public void displayGuestProfile() {
        System.out.println("Name: " + guestName);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Address: " + address);
    }
}