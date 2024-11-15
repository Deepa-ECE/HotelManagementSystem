import java.util.HashMap;
import java.util.Scanner;

public class UserSecurityManagement {
    private HashMap<String, String> userRoles; // username -> role
    private UserService userService;

    public UserSecurityManagement(UserService userService) {
        this.userRoles = new HashMap<>();
        this.userService = userService;
       
        userRoles.put("deepa", "Guest");
    }

    public void manageSecurity(Scanner scanner) {
        while (true) {
            System.out.println("Security Management:");
            System.out.println("1. Assign Role to User");
            System.out.println("2. View User Roles");
            System.out.println("3. Change Password");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    assignRole(scanner);
                    break;
                case 2:
                    viewUserRoles();
                    break;
                case 3:
                    changePassword(scanner);
                    break;
                case 4:
                    return; // Exit the loop
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void assignRole(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter role: ");
        String role = scanner.nextLine();
        userRoles.put(username, role);
        System.out.println("Role assigned successfully.");
    }

    private void viewUserRoles() {
        System.out.println("User Roles:");
        for (String user : userRoles.keySet()) {
            System.out.println("Username: " + user + ", Role: " + userRoles.get(user));
        }
    }

    private void changePassword(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter old password: ");
        String oldPassword = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        
        boolean success = userService.changePassword(username, oldPassword, newPassword);
        if (success) {
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Password change failed.");
        }
    }
}