import java.util.ArrayList;
import java.util.Scanner;

public class LibraryBookManagement {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create ArrayLists
        ArrayList<String> bookTitles = new ArrayList<>();
        ArrayList<String> authors = new ArrayList<>();
        ArrayList<Boolean> availability = new ArrayList<>();

        // Store at least 10 books
        bookTitles.add("Java Programming");
        authors.add("James");
        availability.add(true);

        bookTitles.add("Database Systems");
        authors.add("John");
        availability.add(false);

        bookTitles.add("Data Structures");
        authors.add("Mark");
        availability.add(true);

        bookTitles.add("Operating Systems");
        authors.add("Ahmed");
        availability.add(true);

        bookTitles.add("Computer Networks");
        authors.add("David");
        availability.add(false);

        bookTitles.add("Software Engineering");
        authors.add("Ali");
        availability.add(true);

        bookTitles.add("Artificial Intelligence");
        authors.add("Sara");
        availability.add(true);

        bookTitles.add("Machine Learning");
        authors.add("Andrew");
        availability.add(false);

        bookTitles.add("Cyber Security");
        authors.add("Michael");
        availability.add(true);

        bookTitles.add("Web Development");
        authors.add("Emily");
        availability.add(true);

        // Display Library Books
        System.out.println("===== Library Books =====");
        displayBooks(bookTitles, authors, availability);

        //  Add New Book
        System.out.println("\n===== Add New Book =====");

        System.out.print("Enter Book Title: ");
        String newTitle = input.nextLine().trim();

        System.out.print("Enter Author: ");
        String newAuthor = input.nextLine().trim();

        System.out.print("Available (true/false): ");
        boolean newAvailability = input.nextBoolean();

        if (newTitle.isEmpty() || newAuthor.isEmpty()) {
            System.out.println("Book title and author cannot be empty.");
        } else {
            bookTitles.add(newTitle);
            authors.add(newAuthor);
            availability.add(newAvailability);
            System.out.println("Book added successfully.");
        }

        System.out.println("\nUpdated Library:");
        displayBooks(bookTitles, authors, availability);

        //  Update Book
        System.out.println("\n===== Update Book =====");

        System.out.print("Enter Book Index: ");
        while (!input.hasNextInt()) {
            System.out.println("Invalid book index.");
            input.next();
            System.out.print("Enter Book Index: ");
        }
        int index = input.nextInt();
        input.nextLine();

        if (index >= 0 && index < bookTitles.size()) {

            System.out.print("New Title: ");
            String updatedTitle = input.nextLine();

            System.out.print("New Author: ");
            String updatedAuthor = input.nextLine();

            System.out.print("Available (true/false): ");
            boolean updatedAvailability = input.nextBoolean();

            bookTitles.set(index, updatedTitle);
            authors.set(index, updatedAuthor);
            availability.set(index, updatedAvailability);

            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Invalid book index.");
        }

        //  Search Book
        System.out.println("\n===== Search Book =====");

        input.nextLine(); // Clear buffer
        System.out.print("Enter Book Title: ");
        String searchTitle = input.nextLine();

        boolean found = false;

        for (int i = 0; i < bookTitles.size(); i++) {
            if (bookTitles.get(i).equalsIgnoreCase(searchTitle)) {
                System.out.println("\nBook Found!");
                System.out.println("Book Index: " + i);
                System.out.println("Author: " + authors.get(i));
                System.out.println("Available: " +
                        (availability.get(i) ? "Yes" : "No"));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }

        input.close();
    }

    // Method to display all books
    public static void displayBooks(ArrayList<String> bookTitles,
                                    ArrayList<String> authors,
                                    ArrayList<Boolean> availability) {

        for (int i = 0; i < bookTitles.size(); i++) {
            System.out.println("Book " + i + ":");
            System.out.println("Title: " + bookTitles.get(i));
            System.out.println("Author: " + authors.get(i));
            System.out.println("Available: " +
                    (availability.get(i) ? "Yes" : "No"));
            System.out.println();
        }
    }
}