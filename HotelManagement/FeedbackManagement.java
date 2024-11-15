import java.util.ArrayList;
import java.util.Scanner;

public class FeedbackManagement {
    private ArrayList<Feedback> feedbackList;

    public FeedbackManagement() {
        feedbackList = new ArrayList<>();
    }

    public void manageFeedback(Scanner scanner) {
        while (true) {
            System.out.println("Feedback Management:");
            System.out.println("1. Submit Feedback");
            System.out.println("2. View Feedbacks");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    submitFeedback(scanner);
                    break;
                case 2:
                    viewFeedbacks();
                    break;
                case 3:
                    return; // Exit the loop
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void submitFeedback(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your comments: ");
        String comments = scanner.nextLine();
        System.out.print("Enter your rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Feedback feedback = new Feedback(username, comments, rating);
        feedbackList.add(feedback);
        System.out.println("Thank you for your feedback!");
    }

    private void viewFeedbacks() {
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available.");
            return;
        }

        System.out.println("Feedbacks:");
        for (Feedback feedback : feedbackList) {
            System.out.println("User: " + feedback.getGuestUsername());
            System.out.println("Comments: " + feedback.getComments());
            System.out.println("Rating: " + feedback.getRating());
            System.out.println("---------------------");
        }
    }

    public String getFeedbackSummary() {
        if (feedbackList.isEmpty()) {
            return "No feedback available.";
        }

        int totalRatings = 0;
        for (Feedback feedback : feedbackList) {
            totalRatings += feedback.getRating();
        }
        double averageRating = (double) totalRatings / feedbackList.size();
        
        return String.format("Total Feedbacks: %d, Average Rating: %.2f/5", feedbackList.size(), averageRating);
    }
}
