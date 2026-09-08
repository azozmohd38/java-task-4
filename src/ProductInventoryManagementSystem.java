import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class ProductInventoryManagementSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //  Create Product Lists
        ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Integer> productQuantities = new ArrayList<>();
        ArrayList<Double> productPrices = new ArrayList<>();

        productNames.add("Laptop");
        productQuantities.add(5);
        productPrices.add(750.50);

        productNames.add("Mouse");
        productQuantities.add(20);
        productPrices.add(15.50);

        productNames.add("Keyboard");
        productQuantities.add(10);
        productPrices.add(30.00);

        productNames.add("Monitor");
        productQuantities.add(8);
        productPrices.add(180.75);

        productNames.add("Printer");
        productQuantities.add(0);
        productPrices.add(250.00);

        productNames.add("Speaker");
        productQuantities.add(6);
        productPrices.add(55.25);

        productNames.add("USB Drive");
        productQuantities.add(25);
        productPrices.add(12.99);

        productNames.add("Webcam");
        productQuantities.add(3);
        productPrices.add(45.00);

        productNames.add("Headphones");
        productQuantities.add(15);
        productPrices.add(85.50);

        productNames.add("Router");
        productQuantities.add(4);
        productPrices.add(95.99);

        // 2. Display Inventory
        System.out.println("===== PRODUCT INVENTORY =====");
        displayInventory(productNames, productQuantities, productPrices);

        // 3. Add New Product
        System.out.println("\n===== ADD NEW PRODUCT =====");

        System.out.print("Enter Product Name: ");
        String name = input.nextLine().trim();

        System.out.print("Enter Quantity: ");
        while (!input.hasNextInt()) {
            System.out.println("Quantity must be a number.");
            input.next();
            System.out.print("Enter Quantity: ");
        }
        int quantity = input.nextInt();

        System.out.print("Enter Price: ");
        while (!input.hasNextDouble()) {
            System.out.println("Price must be a number.");
            input.next();
            System.out.print("Enter Price: ");
        }
        double price = input.nextDouble();
        input.nextLine();

        if (name.isEmpty() || quantity < 0 || price < 0) {
            System.out.println("Invalid product data.");
        } else {
            productNames.add(name);
            productQuantities.add(quantity);
            productPrices.add(price);
            System.out.println("Product added successfully.");
        }

        displayInventory(productNames, productQuantities, productPrices);

        // 4. Update Product Information
        System.out.println("\n===== UPDATE PRODUCT =====");

        System.out.print("Enter Product Index: ");
        while (!input.hasNextInt()) {
            System.out.println("Invalid product index.");
            input.next();
            System.out.print("Enter Product Index: ");
        }
        int index = input.nextInt();
        input.nextLine();

        if (index >= 0 && index < productNames.size()) {

            System.out.print("New Product Name: ");
            String newName = input.nextLine().trim();

            System.out.print("New Quantity: ");
            int newQuantity = input.nextInt();

            System.out.print("New Price: ");
            double newPrice = input.nextDouble();
            input.nextLine();

            if (newName.isEmpty() || newQuantity < 0 || newPrice < 0) {
                System.out.println("Invalid product data.");
            } else {
                productNames.set(index, newName);
                productQuantities.set(index, newQuantity);
                productPrices.set(index, newPrice);
                System.out.println("Product updated successfully.");
            }

        } else {
            System.out.println("Invalid product index.");
        }

        displayInventory(productNames, productQuantities, productPrices);

        //  Search Product System
        System.out.println("\n===== SEARCH PRODUCT =====");

        System.out.print("Enter Product Name: ");
        String search = input.nextLine().trim();

        int searchIndex = -1;
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).equalsIgnoreCase(search)) {
                searchIndex = i;
                break;
            }
        }

        if (searchIndex != -1) {

            System.out.println("Product Found!");
            System.out.println("Index: " + searchIndex);
            System.out.println("Quantity: " + productQuantities.get(searchIndex));
            System.out.println("Price: $" + productPrices.get(searchIndex));

        } else {
            System.out.println("Product not found.");
        }

        //  Stock Analysis
        System.out.println("\n===== STOCK ANALYSIS =====");

        int totalQuantity = 0;
        double totalValue = 0;

        for (int i = 0; i < productNames.size(); i++) {
            totalQuantity += productQuantities.get(i);
            totalValue += productQuantities.get(i) * productPrices.get(i);
        }

        System.out.println("Total Products: " + productNames.size());
        System.out.println("Total Quantity: " + totalQuantity);
        System.out.printf("Inventory Value: $%.2f%n", totalValue);

        //  Stock Status Checking
        System.out.println("\n===== STOCK STATUS =====");

        System.out.println("Low Stock (Quantity < 5):");
        for (int i = 0; i < productNames.size(); i++) {
            if (productQuantities.get(i) < 5 && productQuantities.get(i) > 0) {
                System.out.println(productNames.get(i));
            }
        }

        System.out.println("\nOut of Stock:");
        for (int i = 0; i < productNames.size(); i++) {
            if (productQuantities.get(i) == 0) {
                System.out.println(productNames.get(i));
            }
        }

        System.out.println("\nAvailable Stock:");
        for (int i = 0; i < productNames.size(); i++) {
            if (productQuantities.get(i) > 0) {
                System.out.println(productNames.get(i));
            }
        }

        //  Remove Product
        System.out.println("\n===== REMOVE PRODUCT =====");

        System.out.print("Enter Product Index: ");
        while (!input.hasNextInt()) {
            System.out.println("Invalid product index.");
            input.next();
            System.out.print("Enter Product Index: ");
        }
        int removeIndex = input.nextInt();

        if (removeIndex >= 0 && removeIndex < productNames.size()) {

            productNames.remove(removeIndex);
            productQuantities.remove(removeIndex);
            productPrices.remove(removeIndex);

            System.out.println("Product removed successfully.");

        } else {
            System.out.println("Invalid product index.");
        }

        displayInventory(productNames, productQuantities, productPrices);

        //  Sorting Products
        System.out.println("\n===== SORT BY NAME =====");

        ArrayList<String> sortedNames = new ArrayList<>(productNames);
        Collections.sort(sortedNames);

        for (String product : sortedNames) {
            int i = productNames.indexOf(product);
            System.out.println(product + " | Qty: " + productQuantities.get(i)
                    + " | Price: $" + productPrices.get(i));
        }

        System.out.println("\n===== SORT BY PRICE =====");

        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < productNames.size(); i++) {
            indexes.add(i);
        }

        Collections.sort(indexes, Comparator.comparing(productPrices::get));

        for (int i : indexes) {
            System.out.println(productNames.get(i) + " | Qty: "
                    + productQuantities.get(i) + " | Price: $"
                    + productPrices.get(i));
        }

        input.close();
        }

        // Method to Display Inventory
        public static void displayInventory(ArrayList<String> names,
                                        ArrayList<Integer> quantities,
                                        ArrayList<Double> prices) {

        for (int i = 0; i < names.size(); i++) {

            System.out.println("\nProduct " + i);
            System.out.println("Name: " + names.get(i));
            System.out.println("Quantity: " + quantities.get(i));
            System.out.printf("Price: $%.2f%n", prices.get(i));
        }
        }
    }
