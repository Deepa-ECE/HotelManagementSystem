import java.util.ArrayList;

public class FeedbackService {
    private ArrayList<Feedback> feedbackList = new ArrayList<>();

    public void addFeedback(String customerName, String comments, int rating) {
        feedbackList.add(new Feedback(customerName, comments, rating));
        System.out.println("Feedback added from: " + customerName);
    }

    public void viewFeedback() {
        System.out.println("Customer Feedback:");
        for (Feedback feedback : feedbackList) {
            System.out.println("Customer: " + feedback.getGuestUsername() +
                               ", Comments: " + feedback.getComments() +
                               ", Rating: " + feedback.getRating());
        }
    }
}