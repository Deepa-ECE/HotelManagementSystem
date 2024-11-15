// ReportService.java
import java.util.HashMap;
import java.util.Map;

public class ReportService {
    private Map<String, Integer> reportData;

    public ReportService() {
        reportData = new HashMap<>();
        reportData.put("Total Bookings", 0);
        reportData.put("Total Revenue", 0);
        reportData.put("Customer Feedback Count", 0);
    }

    public void updateReport(String key, int value) {
        reportData.put(key, reportData.getOrDefault(key, 0) + value);
    }

    public void generateReport() {
        System.out.println("Hotel Management Report:");
        for (Map.Entry<String, Integer> entry : reportData.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}