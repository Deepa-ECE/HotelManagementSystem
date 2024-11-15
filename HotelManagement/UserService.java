import java.util.HashMap;

public class UserService {
    private HashMap<String, String> userCredentials; // Stores username and password

    public UserService() {
        userCredentials = new HashMap<>();
    }

    // Method to register new user
    public boolean register(String username, String password) {
        if (userCredentials.containsKey(username)) {
            System.out.println("Username already exists. Please try a different one.");
            return false;
        }
        userCredentials.put(username, password);
        System.out.println("User " + username + " registered successfully.");
        return true;
    }

    // Method to log in a user
    public boolean login(String username, String password) {
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            System.out.println("Login successful. Welcome, " + username + "!");
            return true;
        }
        System.out.println("Invalid username or password.");
        return false;
    }

    // Method to change password
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(oldPassword)) {
            userCredentials.put(username, newPassword);
            System.out.println("Password changed successfully for " + username);
            return true;
        }
        System.out.println("Incorrect old password. Please try again.");
        return false;
    }
}