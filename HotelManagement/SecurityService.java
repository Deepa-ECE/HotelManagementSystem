// SecurityService.java
import java.util.HashMap;
import java.util.Map;

public class SecurityService {
    private Map<String, String> userCredentials;
    private Map<String, String> userRoles;

    public SecurityService() {
        userCredentials = new HashMap<>();
        userRoles = new HashMap<>();
    }

    public void registerUser(String username, String password) {
        userCredentials.put(username, password);
        userRoles.put(username, "Guest"); // Default role
        System.out.println("User registered: " + username);
    }

    public boolean loginUser(String username, String password) {
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }

    public void setUserRole(String username, String role) {
        if (userCredentials.containsKey(username)) {
            userRoles.put(username, role);
            System.out.println("Role updated for user " + username + ": " + role);
        } else {
            System.out.println("User not found.");
        }
    }

    public String getUserRole(String username) {
        return userRoles.getOrDefault(username, "Guest");
    }
}