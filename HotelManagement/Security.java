import java.util.HashMap;

public class Security {
    private HashMap<String, String> users = new HashMap<>(); // Store username and password

    // Method to add a user
    public void addUser(String username, String password) {
        users.put(username, password);
        System.out.println("User added: " + username);
    }

    // Method to authenticate a user
    public boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}