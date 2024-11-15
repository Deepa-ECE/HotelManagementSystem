import java.util.ArrayList;

public class EmployeeService {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(int employeeId, String name, String position) {
        employees.add(new Employee(employeeId, name, position));
        System.out.println("Employee added: " + name);
    }

    public void viewEmployees() {
        System.out.println("Employees:");
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getEmployeeId() +
                               ", Name: " + employee.getName() +
                               ", Position: " + employee.getPosition());
        }
    }
}