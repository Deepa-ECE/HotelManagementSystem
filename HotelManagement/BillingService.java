import java.util.ArrayList;

public class BillingService {
    private ArrayList<Bill> bills;

    public BillingService() {
        bills = new ArrayList<>();
    }

    public void generateBill(String customerName, double amount) {
        bills.add(new Bill(customerName, amount));
        System.out.println("Bill generated successfully for " + customerName);
    }

    public void viewBills() {
        if (bills.isEmpty()) {
            System.out.println("No bills available.");
        } else {
            System.out.println("Bill List:");
            for (Bill bill : bills) {
                System.out.println("Customer: " + bill.getCustomerName() +
                                   ", Amount: $" + bill.getAmount());
            }
        }
    }
}