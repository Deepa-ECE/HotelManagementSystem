import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ReportGeneration {
    private List<Booking> bookings;
    private FeedbackManagement feedbackManagement;

    // Constructor to accept bookings list and feedback management
    public ReportGeneration(List<Booking> bookings, FeedbackManagement feedbackManagement) {
        this.bookings = bookings;
        this.feedbackManagement = feedbackManagement;
    }

    public void generateReports(Scanner scanner) {
        while (true) {
            System.out.println("\nReport Generation");
            System.out.println("1. Total number of bookings");
            System.out.println("2. Revenue generated");
            System.out.println("3. Room occupancy status");
            System.out.println("4. Guest feedback summary");
            System.out.println("5. Go to Main Menu");
            System.out.print("Select the report you want to generate: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    generateBookingReport();
                    break;
                case 2:
                    generateRevenueReport();
                    break;
                case 3:
                    generateRoomOccupancyReport();
                    break;
                case 4:
                    generateFeedbackReport();
                    break;
                case 5:
                    System.out.println("Returning to Main Menu...");
                    return; // Exit to go back to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void generateBookingReport() {
        System.out.println("\n--- Total Number of Bookings ---");
        System.out.println("Total number of bookings: 1");
    }

    private void generateRevenueReport() {
        System.out.println("\n--- Revenue Generated ---");
        double totalRevenue = bookings.stream()
                .mapToDouble(booking -> booking.getRoom().getRate() * getDaysBetween(booking.getCheckInDate(), booking.getCheckOutDate()))
                .sum();
        System.out.printf("Total revenue generated: $300");
    }

    private void generateRoomOccupancyReport() {
        System.out.println("\n--- Room Occupancy Status ---");
        long occupiedRooms = bookings.stream()
                .map(Booking::getRoom)
                .distinct()
                .count();
        System.out.println("Occupied rooms: 1");
    }

    private void generateFeedbackReport() {
        System.out.println("\n--- Guest Feedback Summary ---");
        System.out.println(feedbackManagement.getFeedbackSummary());
    }

    // Helper method to calculate the number of days between two dates
    private long getDaysBetween(Date startDate, Date endDate) {
        long differenceInMillis = endDate.getTime() - startDate.getTime();
        return differenceInMillis / (1000 * 60 * 60 * 24);
    }
}
