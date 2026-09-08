import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class EmployeeSalaryManagementSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //  Create Employee Lists
        ArrayList<Integer> employeeIds = new ArrayList<>();
        ArrayList<String> employeeNames = new ArrayList<>();
        ArrayList<Double> employeeSalaries = new ArrayList<>();

        employeeIds.add(1001);
        employeeNames.add("Ali");
        employeeSalaries.add(850.0);

        employeeIds.add(1002);
        employeeNames.add("Sara");
        employeeSalaries.add(1200.0);

        employeeIds.add(1003);
        employeeNames.add("Ahmed");
        employeeSalaries.add(1500.0);

        employeeIds.add(1004);
        employeeNames.add("Fatima");
        employeeSalaries.add(950.0);

        employeeIds.add(1005);
        employeeNames.add("Omar");
        employeeSalaries.add(450.0);

        employeeIds.add(1006);
        employeeNames.add("Mona");
        employeeSalaries.add(700.0);

        employeeIds.add(1007);
        employeeNames.add("Khalid");
        employeeSalaries.add(550.0);

        employeeIds.add(1008);
        employeeNames.add("Aisha");
        employeeSalaries.add(400.0);

        employeeIds.add(1009);
        employeeNames.add("Yousef");
        employeeSalaries.add(1100.0);

        employeeIds.add(1010);
        employeeNames.add("Hassan");
        employeeSalaries.add(650.0);

        // Display Employee Information
        System.out.println("===== EMPLOYEE INFORMATION =====");
        displayEmployees(employeeIds, employeeNames, employeeSalaries);

        //  Salary Statistics
        double totalSalary = 0;
        double highestSalary = employeeSalaries.get(0);
        double lowestSalary = employeeSalaries.get(0);

        for (double salary : employeeSalaries) {
            totalSalary += salary;

            if (salary > highestSalary) {
                highestSalary = salary;
            }

            if (salary < lowestSalary) {
                lowestSalary = salary;
            }
        }

        double averageSalary = (double) totalSalary / employeeSalaries.size();

        System.out.println("\n===== SALARY STATISTICS =====");
        System.out.println("Total Employees: " + employeeNames.size());
        System.out.printf("Total Salary: %.2f%n", totalSalary);
        System.out.printf("Average Salary: %.2f%n", averageSalary);
        System.out.printf("Highest Salary: %.2f%n", highestSalary);
        System.out.printf("Lowest Salary: %.2f%n", lowestSalary);

        // 4. Salary Category Analysis
        int high = 0;
        int medium = 0;
        int low = 0;

        for (double salary : employeeSalaries) {

            if (salary > 1000) {
                high++;
            } else if (salary >= 500 && salary <= 1000) {
                medium++;
            } else {
                low++;
            }
        }

        System.out.println("\n===== SALARY CATEGORY ANALYSIS =====");
        System.out.println("High Salary Employees: " + high);
        System.out.println("Medium Salary Employees: " + medium);
        System.out.println("Low Salary Employees: " + low);

        // 5. Search Employee
        System.out.println("\n===== SEARCH EMPLOYEE =====");
        System.out.print("Enter Employee ID: ");
        while (!input.hasNextInt()) {
            System.out.println("Employee ID must be a number.");
            input.next();
            System.out.print("Enter Employee ID: ");
        }
        int searchId = input.nextInt();

        int position = employeeIds.indexOf(searchId);

        if (position != -1) {
            System.out.println("Employee Found");
            System.out.println("Name: " + employeeNames.get(position));
            System.out.printf("Salary: %.2f%n", employeeSalaries.get(position));
            System.out.println("Position: " + position);
        } else {
            System.out.println("Employee not found.");
        }

        //  Update Employee Salary
        System.out.println("\n===== UPDATE EMPLOYEE SALARY =====");
        System.out.print("Enter Employee Index: ");
        while (!input.hasNextInt()) {
            System.out.println("Invalid employee index.");
            input.next();
            System.out.print("Enter Employee Index: ");
        }
        int updateIndex = input.nextInt();

        if (updateIndex >= 0 && updateIndex < employeeSalaries.size()) {

            System.out.print("Enter New Salary: ");
            while (!input.hasNextDouble()) {
                System.out.println("Salary must be a number.");
                input.next();
                System.out.print("Enter New Salary: ");
            }
            double newSalary = input.nextDouble();

            if (newSalary < 0) {
                System.out.println("Salary cannot be negative.");
            } else {
                employeeSalaries.set(updateIndex, newSalary);
            }

            if (newSalary >= 0) {
                System.out.println("Salary updated successfully.");
            }
            System.out.println("Updated Employee:");
            System.out.println("ID: " + employeeIds.get(updateIndex));
            System.out.println("Name: " + employeeNames.get(updateIndex));
            System.out.printf("Salary: %.2f%n", employeeSalaries.get(updateIndex));

        } else {
            System.out.println("Invalid employee index.");
        }

        //  Remove Employee
        System.out.println("\n===== REMOVE EMPLOYEE =====");
        System.out.print("Enter Employee Index: ");
        while (!input.hasNextInt()) {
            System.out.println("Invalid employee index.");
            input.next();
            System.out.print("Enter Employee Index: ");
        }
        int removeIndex = input.nextInt();

        if (removeIndex >= 0 && removeIndex < employeeNames.size()) {

            employeeIds.remove(removeIndex);
            employeeNames.remove(removeIndex);
            employeeSalaries.remove(removeIndex);

            System.out.println("Employee removed successfully.");

        } else {
            System.out.println("Invalid employee index.");
        }

        System.out.println("\nUpdated Employee List:");
        displayEmployees(employeeIds, employeeNames, employeeSalaries);

        //  Sorting Employees
        System.out.println("\n===== SALARY SORTING =====");

        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < employeeNames.size(); i++) {
            indexes.add(i);
        }

        indexes.sort(Comparator.comparing(employeeSalaries::get));

        System.out.println("\nLowest to Highest:");
        for (int i : indexes) {
            System.out.printf("%s - %.2f%n",
                    employeeNames.get(i),
                    employeeSalaries.get(i));
        }

        Collections.reverse(indexes);

        System.out.println("\nHighest to Lowest:");
        int rank = 1;

        for (int i : indexes) {
            System.out.printf("%d. %s - %.2f%n",
                    rank,
                    employeeNames.get(i),
                    employeeSalaries.get(i));
            rank++;
        }

        //  Employee Salary Bonus Calculation
        System.out.println("\n===== BONUS CALCULATION =====");

        for (int i = 0; i < employeeNames.size(); i++) {

            double salary = employeeSalaries.get(i);
            double bonus;

            if (salary >= 1000)
                bonus = salary * 0.10;
            else if (salary >= 500)
                bonus = salary * 0.05;
            else
                bonus = salary * 0.02;

            double finalSalary = salary + bonus;

            System.out.println("---------------------------");
            System.out.println("Employee: " + employeeNames.get(i));
            System.out.printf("Current Salary: %.2f%n", salary);
            System.out.printf("Bonus: %.2f%n", bonus);
            System.out.printf("Final Salary: %.2f%n", finalSalary);
        }

        input.close();
        }

        // Method to display employee information
        public static void displayEmployees(ArrayList<Integer> ids,
                                        ArrayList<String> names,
                                        ArrayList<Double> salaries) {

        for (int i = 0; i < names.size(); i++) {
            System.out.println("\nEmployee " + i);
            System.out.println("ID: " + ids.get(i));
            System.out.println("Name: " + names.get(i));
            System.out.printf("Salary: %.2f%n", salaries.get(i));
        }
        }
    }