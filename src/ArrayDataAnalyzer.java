import java.util.Arrays;
import java.util.Scanner;

public class ArrayDataAnalyzer {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //  Create and Initialize Array
        int[] numbers = {45, 12, -5, 90, 33, 12, 0, 67, -20, 88, 45, 100, 7, -3, 55};

        // Make a copy before any updates
        int[] originalArray = Arrays.copyOf(numbers, numbers.length);

        //  Display Array Information
        System.out.println("===== ARRAY INFORMATION =====");
        System.out.println("Total Elements: " + numbers.length);
        int firstElement = numbers[0];
        int lastElement = numbers[numbers.length - 1];
        System.out.println("First Element: " + firstElement);
        System.out.println("Last Element: " + lastElement);

        System.out.println("\nArray Elements:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + " = " + numbers[i]);
    }

        //  Array Statistics
        int sum = 0;
        int maximum = numbers[0];
        int minimum = numbers[0];

        for (int num : numbers) {
            sum += num;

            if (num > maximum) {
                maximum = num;
            }

            if (num < minimum) {
                minimum = num;
            }
    }

        double average = (double) sum / numbers.length;

        System.out.println("\n===== ARRAY STATISTICS =====");
        System.out.println("Sum = " + sum);
        System.out.printf("Average = %.2f%n", average);
        System.out.println("Maximum = " + maximum);
        System.out.println("Minimum = " + minimum);

        //  Number Classification
        int positive = 0;
        int negative = 0;
        int zeros = 0;
        int even = 0;
        int odd = 0;

        for (int num : numbers) {

            if (num > 0) {
                positive++;
            } else if (num < 0) {
                negative++;
            } else {
                zeros++;
            }

            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
    }

        System.out.println("\n===== NUMBER CLASSIFICATION =====");
        System.out.println("Positive Numbers: " + positive);
        System.out.println("Negative Numbers: " + negative);
        System.out.println("Zeros: " + zeros);
        System.out.println("Even Numbers: " + even);
        System.out.println("Odd Numbers: " + odd);

        //  Search System
        System.out.println("\n===== SEARCH SYSTEM =====");
        System.out.print("Enter number to search: ");
        while (!input.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            input.next();
            System.out.print("Enter number to search: ");
        }
        int searchValue = input.nextInt();

        boolean found = false;
        int firstIndex = -1;
        int occurrences = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == searchValue) {
                if (!found) {
                    firstIndex = i;
                    found = true;
                }
                occurrences++;
            }
    }

        if (found) {
            System.out.println("Number found.");
            System.out.println("First Index: " + firstIndex);
            System.out.println("Occurrences: " + occurrences);
    } else {
            System.out.println("Number not found.");
    }

        //  Update Array Values
        System.out.println("\n===== UPDATE ARRAY =====");
        System.out.print("Enter index (0-" + (numbers.length - 1) + "): ");
        while (!input.hasNextInt()) {
            System.out.println("Invalid index.");
            input.next();
            System.out.print("Enter index (0-" + (numbers.length - 1) + "): ");
        }
        int index = input.nextInt();

        if (index >= 0 && index < numbers.length) {
            System.out.print("Enter new value: ");
            while (!input.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                input.next();
                System.out.print("Enter new value: ");
            }
            int newValue = input.nextInt();

            int oldValue = numbers[index];
            numbers[index] = newValue;

            System.out.println("Old Value: " + oldValue);
            System.out.println("New Value: " + newValue);
            System.out.println("Updated Array:");
            System.out.println(Arrays.toString(numbers));
    } else {
            System.out.println("Invalid index.");
    }

        //  Reverse Array (without creating a new array)
        System.out.println("\n===== ARRAY IN REVERSE ORDER =====");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
    }
        System.out.println();

        //  Sorting and Comparison
        int[] sortedArray = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedArray);

        System.out.println("\n===== SORTED ARRAY =====");
        System.out.println(Arrays.toString(sortedArray));

        System.out.println("\nOriginal Array (Unchanged):");
        System.out.println(Arrays.toString(originalArray));

        System.out.println("\nComparison:");
        System.out.println("Smallest Value: " + sortedArray[0]);
        System.out.println("Largest Value: " + sortedArray[sortedArray.length - 1]);
        System.out.println("Array analysis completed.");

        input.close();
    }
    }
