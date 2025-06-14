package motorphgui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCSVReader {

    public List<Employee> readEmployees() {
        List<Employee> employees = new ArrayList<>();
        String csvFile = "C:\\Users\\HP\\OneDrive\\Desktop\\CP2\\Motorph\\employee.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;

            // Skip the header
            br.readLine();

            while ((line = br.readLine()) != null) {
                // Split line into columns considering quotes
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                // Clean up quotes
                for (int i = 0; i < values.length; i++) {
                    values[i] = values[i].replace("\"", "").trim();
                }

                // Create Employee using your constructor
                Employee emp = new Employee(values);
                employees.add(emp);
            }

        } catch (Exception e) {
            System.out.println("Error reading employee.csv: " + e.getMessage());
        }

        return employees;
    }
}
