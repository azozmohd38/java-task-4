import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CustomerOrderManagement {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //  ArrayLists
        ArrayList<Integer> orderIds = new ArrayList<>();
        ArrayList<String> customerNames = new ArrayList<>();
        ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        ArrayList<String> orderStatus = new ArrayList<>();

        // 15 Orders
        orderIds.add(1001); customerNames.add("Ali"); productNames.add("Laptop"); quantities.add(2); prices.add(750.0); orderStatus.add("Pending");
        orderIds.add(1002); customerNames.add("Sara"); productNames.add("Phone"); quantities.add(3); prices.add(400.0); orderStatus.add("Completed");
        orderIds.add(1003); customerNames.add("Ahmed"); productNames.add("Tablet"); quantities.add(1); prices.add(600.0); orderStatus.add("Pending");
        orderIds.add(1004); customerNames.add("John"); productNames.add("Monitor"); quantities.add(2); prices.add(300.0); orderStatus.add("Cancelled");
        orderIds.add(1005); customerNames.add("Fatima"); productNames.add("Keyboard"); quantities.add(5); prices.add(50.0); orderStatus.add("Completed");
        orderIds.add(1006); customerNames.add("Mohammed"); productNames.add("Mouse"); quantities.add(4); prices.add(30.0); orderStatus.add("Pending");
        orderIds.add(1007); customerNames.add("David"); productNames.add("Printer"); quantities.add(1); prices.add(250.0); orderStatus.add("Completed");
        orderIds.add(1008); customerNames.add("Emily"); productNames.add("Camera"); quantities.add(2); prices.add(900.0); orderStatus.add("Pending");
        orderIds.add(1009); customerNames.add("Omar"); productNames.add("Speaker"); quantities.add(3); prices.add(150.0); orderStatus.add("Completed");
        orderIds.add(1010); customerNames.add("Aisha"); productNames.add("SSD"); quantities.add(2); prices.add(200.0); orderStatus.add("Cancelled");
        orderIds.add(1011); customerNames.add("James"); productNames.add("Router"); quantities.add(2); prices.add(120.0); orderStatus.add("Pending");
        orderIds.add(1012); customerNames.add("Noor"); productNames.add("TV"); quantities.add(1); prices.add(1200.0); orderStatus.add("Completed");
        orderIds.add(1013); customerNames.add("Khalid"); productNames.add("Projector"); quantities.add(1); prices.add(1500.0); orderStatus.add("Pending");
        orderIds.add(1014); customerNames.add("Lina"); productNames.add("Smart Watch"); quantities.add(2); prices.add(350.0); orderStatus.add("Completed");
        orderIds.add(1015); customerNames.add("Adam"); productNames.add("Headphones"); quantities.add(4); prices.add(100.0); orderStatus.add("Pending");

        // Display Orders
        System.out.println("===== ALL ORDERS =====");
        displayOrders(orderIds, customerNames, productNames, quantities, prices, orderStatus);

        // Add Order
        System.out.println("\n===== ADD NEW ORDER =====");

        input.nextLine();

        System.out.print("Customer Name: ");
        String customer = input.nextLine().trim();

        System.out.print("Product Name: ");
        String product = input.nextLine().trim();

        if (customer.isEmpty() || product.isEmpty()) {
            System.out.println("Customer and product names cannot be empty.");
            input.close();
            return;
        }

        System.out.print("Quantity: ");
        int qty = input.nextInt();

        if (qty <= 0) {
            System.out.println("Invalid quantity.");
            return;
        }

        System.out.print("Price: ");
        double price = input.nextDouble();

        if (price < 0) {
            System.out.println("Invalid price.");
            return;
        }

        input.nextLine();

        System.out.print("Status (Pending/Completed/Cancelled): ");
        String status = input.nextLine().trim();

        if (!(status.equalsIgnoreCase("Pending")
                || status.equalsIgnoreCase("Completed")
                || status.equalsIgnoreCase("Cancelled"))) {

            System.out.println("Invalid status.");
            return;
        }

        int newId = orderIds.get(orderIds.size() - 1) + 1;

        orderIds.add(newId);
        customerNames.add(customer);
        productNames.add(product);
        quantities.add(qty);
        prices.add(price);
        orderStatus.add(status);

        System.out.println("Order added successfully.");
        System.out.println("Updated Order Count: " + orderIds.size());

        // ================= Statistics =================
        double totalSales = 0;
        double highest = quantities.get(0) * prices.get(0);
        double lowest = highest;

        for (int i = 0; i < orderIds.size(); i++) {

            double total = quantities.get(i) * prices.get(i);

            totalSales += total;

            if (total > highest)
                highest = total;

            if (total < lowest)
                lowest = total;
        }

        double average = totalSales / (double) orderIds.size();

        System.out.println("\n===== ORDER REPORT =====");
        System.out.println("Total Orders: " + orderIds.size());
        System.out.printf("Total Sales: %.2f%n", totalSales);
        System.out.printf("Average Order: %.2f%n", average);
        System.out.printf("Highest Order: %.2f%n", highest);
        System.out.printf("Lowest Order: %.2f%n", lowest);

        //  Status Analysis
        int pending = 0, completed = 0, cancelled = 0;

        for (String s : orderStatus) {

            if (s.equalsIgnoreCase("Pending")) {
                pending++;
            } else if (s.equalsIgnoreCase("Completed")) {
                completed++;
            } else if (s.equalsIgnoreCase("Cancelled")) {
                cancelled++;
            }
        }

        System.out.println("\n===== STATUS REPORT =====");
        System.out.println("Pending Orders: " + pending);
        System.out.println("Completed Orders: " + completed);
        System.out.println("Cancelled Orders: " + cancelled);

        // ================= Search =================
        System.out.println("\n===== SEARCH =====");
        System.out.println("1. Search by Order ID");
        System.out.println("2. Search by Customer Name");
        System.out.print("Choice: ");
        int choice = input.nextInt();

        boolean found = false;

        if (choice == 1) {

            System.out.print("Order ID: ");
            int id = input.nextInt();

            for (int i = 0; i < orderIds.size(); i++) {

                if (orderIds.get(i) == id) {
                    displayOneOrder(i, orderIds, customerNames, productNames, quantities, prices, orderStatus);
                    found = true;
                    break;
                }
            }

        } else {

            input.nextLine();
            System.out.print("Customer Name: ");
            String name = input.nextLine().trim();

            for (int i = 0; i < customerNames.size(); i++) {

                if (customerNames.get(i).equalsIgnoreCase(name)) {
                    displayOneOrder(i, orderIds, customerNames, productNames, quantities, prices, orderStatus);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Order not found.");
        }

        // ================= Update =================
        System.out.println("\n===== UPDATE ORDER =====");
        System.out.print("Order Index: ");
        int index = input.nextInt();

        if (index >= 0 && index < orderIds.size()) {

            input.nextLine();

            System.out.print("New Customer: ");
            customerNames.set(index, input.nextLine().trim());

            System.out.print("New Product: ");
            productNames.set(index, input.nextLine().trim());

            System.out.print("New Quantity: ");
            int q = input.nextInt();

            if (q > 0)
                quantities.set(index, q);

            System.out.print("New Price: ");
            double p = input.nextDouble();

            if (p >= 0)
                prices.set(index, p);

            input.nextLine();

            System.out.print("New Status: ");
            String st = input.nextLine().trim();

            if (st.equalsIgnoreCase("Pending") ||
                    st.equalsIgnoreCase("Completed") ||
                    st.equalsIgnoreCase("Cancelled")) {

                orderStatus.set(index, st);
            }

            System.out.println("Updated Order:");
            displayOneOrder(index, orderIds, customerNames, productNames, quantities, prices, orderStatus);

        } else {
            System.out.println("Invalid index.");
        }

        // ================= Discount =================
        System.out.println("\n===== DISCOUNT =====");
        System.out.print("Enter Order Index: ");
        int d = input.nextInt();

        if (d >= 0 && d < orderIds.size()) {

            double total = quantities.get(d) * prices.get(d);
            double discount = 0;

            if (total >= 5000) {
                discount = 0.15;
            } else if (total >= 2000) {
                discount = 0.10;
            } else if (total >= 1000) {
                discount = 0.05;
            }

            double discountAmount = total * discount;
            double finalPrice = total - discountAmount;

            System.out.printf("Original Price: %.2f%n", total);
            System.out.printf("Discount Amount: %.2f%n", discountAmount);
            System.out.printf("Final Price: %.2f%n", finalPrice);
        }

        // ================= Remove =================
        System.out.println("\n===== REMOVE ORDER =====");
        System.out.print("Order Index: ");
        int remove = input.nextInt();

        if (remove >= 0 && remove < orderIds.size()) {

            orderIds.remove(remove);
            customerNames.remove(remove);
            productNames.remove(remove);
            quantities.remove(remove);
            prices.remove(remove);
            orderStatus.remove(remove);

            System.out.println("Order removed successfully.");

            displayOrders(orderIds, customerNames, productNames, quantities, prices, orderStatus);

        } else {
            System.out.println("Invalid index.");
        }

        //  Sort by Total (Ascending)
        System.out.println("\n===== SORT BY TOTAL (LOW TO HIGH) =====");

        for (int i = 0; i < orderIds.size() - 1; i++) {

            for (int j = i + 1; j < orderIds.size(); j++) {

                double total1 = quantities.get(i) * prices.get(i);
                double total2 = quantities.get(j) * prices.get(j);

                if (total1 > total2) {
                    swap(orderIds, customerNames, productNames, quantities, prices, orderStatus, i, j);
                }
            }
        }

        displayOrders(orderIds, customerNames, productNames, quantities, prices, orderStatus);

        // ================= Sort by Total (Descending) =================
        System.out.println("\n===== SORT BY TOTAL (HIGH TO LOW) =====");

        Collections.reverse(orderIds);
        Collections.reverse(customerNames);
        Collections.reverse(productNames);
        Collections.reverse(quantities);
        Collections.reverse(prices);
        Collections.reverse(orderStatus);

        displayOrders(orderIds, customerNames, productNames, quantities, prices, orderStatus);

        // ================= Sort by Customer Name =================
        System.out.println("\n===== SORT BY CUSTOMER NAME =====");

        for (int i = 0; i < customerNames.size() - 1; i++) {

            for (int j = i + 1; j < customerNames.size(); j++) {

                if (customerNames.get(i).compareToIgnoreCase(customerNames.get(j)) > 0) {
                    swap(orderIds, customerNames, productNames, quantities, prices, orderStatus, i, j);
                }
            }
        }

        displayOrders(orderIds, customerNames, productNames, quantities, prices, orderStatus);

        input.close();
    }

    // ================= Display All =================
    public static void displayOrders(ArrayList<Integer> orderIds,
                                     ArrayList<String> customerNames,
                                     ArrayList<String> productNames,
                                     ArrayList<Integer> quantities,
                                     ArrayList<Double> prices,
                                     ArrayList<String> orderStatus) {

        for (int i = 0; i < orderIds.size(); i++) {

            double total = quantities.get(i) * prices.get(i);

            System.out.println("---------------------------");
            System.out.println("Order Index: " + i);
            System.out.println("Order ID: " + orderIds.get(i));
            System.out.println("Customer: " + customerNames.get(i));
            System.out.println("Product: " + productNames.get(i));
            System.out.println("Quantity: " + quantities.get(i));
            System.out.println("Price: " + prices.get(i));
            System.out.println("Total: " + total);
            System.out.println("Status: " + orderStatus.get(i));
        }
    }

    // ================= Display One =================
    public static void displayOneOrder(int i,
                                       ArrayList<Integer> orderIds,
                                       ArrayList<String> customerNames,
                                       ArrayList<String> productNames,
                                       ArrayList<Integer> quantities,
                                       ArrayList<Double> prices,
                                       ArrayList<String> orderStatus) {

        double total = quantities.get(i) * prices.get(i);

        System.out.println("Order ID: " + orderIds.get(i));
        System.out.println("Customer: " + customerNames.get(i));
        System.out.println("Product: " + productNames.get(i));
        System.out.println("Quantity: " + quantities.get(i));
        System.out.println("Price: " + prices.get(i));
        System.out.println("Total: " + total);
        System.out.println("Status: " + orderStatus.get(i));
    }

    // ================= Swap =================
    public static void swap(ArrayList<Integer> orderIds,
                            ArrayList<String> customerNames,
                            ArrayList<String> productNames,
                            ArrayList<Integer> quantities,
                            ArrayList<Double> prices,
                            ArrayList<String> orderStatus,
                            int i, int j) {

        Collections.swap(orderIds, i, j);
        Collections.swap(customerNames, i, j);
        Collections.swap(productNames, i, j);
        Collections.swap(quantities, i, j);
        Collections.swap(prices, i, j);
        Collections.swap(orderStatus, i, j);
    }
}