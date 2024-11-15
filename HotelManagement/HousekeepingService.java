// HousekeepingService.java
import java.util.ArrayList;
import java.util.List;

public class HousekeepingService {
    private List<String> tasks;

    public HousekeepingService() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void viewTasks() {
        System.out.println("Housekeeping Tasks:");
        if (tasks.isEmpty()) {
            System.out.println("No tasks assigned.");
        } else {
            for (String task : tasks) {
                System.out.println("- " + task);
            }
        }
    }

    public void markTaskCompleted(String task) {
        if (tasks.remove(task)) {
            System.out.println("Task completed: " + task);
        } else {
            System.out.println("Task not found: " + task);
        }
    }
}