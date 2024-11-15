public class Feedback {
    private String guestUsername;
    private String comments;
    private int rating;

    public Feedback(String guestUsername, String comments, int rating) {
        this.guestUsername = guestUsername;
        this.comments = comments;
        this.rating = rating;
    }

    public String getGuestUsername() {
        return guestUsername;
    }

    public String getComments() {
        return comments;
    }

    public int getRating() {
        return rating;
    }
}