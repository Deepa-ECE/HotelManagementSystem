import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class HotelManagementSystem {
    private UserManagement userManagement;
    private BookingManagement bookingManagement;
    private BillingManagement billingManagement;
    private RoomManagement roomManagement;
    private HousekeepingManagement housekeepingManagement;
    private ReportGeneration reportGeneration;
    private GuestProfileManagement guestProfileManagement;
    private RestaurantManagement restaurantManagement;
    private FeedbackManagement feedbackManagement;
    private UserSecurityManagement userSecurityManagement;
    private UserService userService;
   private List<Booking> bookings = new ArrayList<>();
    public HotelManagementSystem() {
        feedbackManagement = new FeedbackManagement();
        userManagement = new UserManagement();
        bookingManagement = new BookingManagement();
        billingManagement = new BillingManagement();
        roomManagement = new RoomManagement();
        housekeepingManagement = new HousekeepingManagement();
        reportGeneration = new ReportGeneration(bookings,feedbackManagement);
        guestProfileManagement = new GuestProfileManagement();
        restaurantManagement = new RestaurantManagement();
        
        userService = new UserService();
        userSecurityManagement = new UserSecurityManagement(userService);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Hotel Management System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                userManagement.register(scanner);
            } else if (choice == 2) {
                if (userManagement.login(scanner)) {
                    mainMenu(scanner);
                }
            } else if (choice == 3) {
                System.out.println("Thank you for using Hotel Management System. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void mainMenu(Scanner scanner) {
        while (true) {
         
            System.out.println("Hotel Management System Menu:");
               System.out.println("1. Room Management");
            System.out.println("2. Booking Management");
            System.out.println("3. Billing Management");
        
            System.out.println("4. Housekeeping Management");
            System.out.println("5. Report Generation");
            System.out.println("6. Guest Profile Management");
            System.out.println("7. Restaurant Management");
            System.out.println("8. Feedback Management");
            System.out.println("9. User Security Management");
            System.out.println("10. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> roomManagement.manageRooms(scanner);
                 case 2 -> bookingManagement.manageBookings(scanner);
                case 3 -> billingManagement.manageBilling(scanner);
        
                case 4 -> housekeepingManagement.manageHousekeeping(scanner);
                case 5 -> reportGeneration.generateReports(scanner);
                case 6 -> guestProfileManagement.manageGuestProfiles(scanner);
                case 7 -> restaurantManagement.manageRestaurant(scanner);
                case 8 -> feedbackManagement.manageFeedback(scanner);
                case 9 -> userSecurityManagement.manageSecurity(scanner);
                case 10 -> {
                    System.out.println("Logged out successfully.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}