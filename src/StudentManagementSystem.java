import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //  Create Student List
        ArrayList<String> students = new ArrayList<>();

        students.add("Ali");
        students.add("Sara");
        students.add("Omar");
        students.add("Ahmed");
        students.add("Fatima");
        students.add("Khalid");
        students.add("Mona");
        students.add("Yousef");
        students.add("Aisha");
        students.add("Hassan");

        // Make a copy of the original list
        ArrayList<String> originalStudents = new ArrayList<>(students);

        //  Display Student Information
        System.out.println("===== STUDENT INFORMATION =====");
        System.out.println("Total Students: " + students.size());

        for (int i = 0; i < students.size(); i++) {
            System.out.println("Student " + i + ": " + students.get(i));
    }

        // Add New Students
        System.out.println("\n===== ADD NEW STUDENTS =====");

        System.out.print("Enter student name to add at the end: ");
        String newStudent = input.nextLine().trim();
        if (newStudent.isEmpty()) {
            System.out.println("Student name cannot be empty.");
        } else {
            students.add(newStudent);
            System.out.println("Student added successfully.");
        }

        System.out.print("Enter student name to insert: ");
        String insertStudent = input.nextLine().trim();

        System.out.print("Enter position (0-" + students.size() + "): ");
        while (!input.hasNextInt()) {
            System.out.println("Invalid position.");
            input.next();
            System.out.print("Enter position (0-" + students.size() + "): ");
        }
        int position = input.nextInt();
        input.nextLine();

        if (insertStudent.isEmpty()) {
            System.out.println("Student name cannot be empty.");
        } else if (position >= 0 && position <= students.size()) {
            students.add(position, insertStudent);
            System.out.println("Student inserted successfully.");
    } else {
            System.out.println("Invalid position.");
    }

        System.out.println("Updated Student List:");
        System.out.println(students);

        //  Update Student Information
        System.out.println("\n===== UPDATE STUDENT =====");

        System.out.print("Enter student index: ");
        while (!input.hasNextInt()) {
            System.out.println("Invalid index.");
            input.next();
            System.out.print("Enter student index: ");
        }
        int updateIndex = input.nextInt();
        input.nextLine();

        if (updateIndex >= 0 && updateIndex < students.size()) {

            System.out.print("Enter new student name: ");
            String updatedName = input.nextLine().trim();

            students.set(updateIndex, updatedName);

            System.out.println("Updated Student List:");
            System.out.println(students);

    } else {
            System.out.println("Invalid index.");
    }

        //  Search Student System
        System.out.println("\n===== SEARCH STUDENT =====");

        System.out.print("Enter student name to search: ");
        String searchName = input.nextLine();

        if (students.contains(searchName)) {
            System.out.println("Student found.");
            System.out.println("Index: " + students.indexOf(searchName));
    } else {
            System.out.println("Student not found.");
    }

        //  Remove Student System
        System.out.println("\n===== REMOVE STUDENT =====");

        System.out.println("Current List:");
        System.out.println(students);

        System.out.print("Enter student name to remove: ");
        String removeName = input.nextLine();

        if (students.remove(removeName)) {
            System.out.println("Student removed successfully.");
    } else {
            System.out.println("Student not found.");
    }

        System.out.print("Enter index to remove: ");
        int removeIndex = input.nextInt();

        if (removeIndex >= 0 && removeIndex < students.size()) {
            students.remove(removeIndex);
            System.out.println("Student removed successfully.");
    } else {
            System.out.println("Invalid index.");
    }

        System.out.println("Updated Student List:");
        System.out.println(students);

        //  Student List Analysis
        System.out.println("\n===== STUDENT LIST ANALYSIS =====");

        System.out.println("Total Students: " + students.size());
        System.out.println("Is List Empty? " + students.isEmpty());

        if (!students.isEmpty()) {
            System.out.println("First Student: " + students.get(0));
            System.out.println("Last Student: " + students.get(students.size() - 1));
    }

        // Sorting Students
        ArrayList<String> sortedStudents = new ArrayList<>(originalStudents);
        Collections.sort(sortedStudents);

        System.out.println("\n===== SORTED STUDENT LIST =====");
        System.out.println("Original List:");
        System.out.println(originalStudents);

        System.out.println("Sorted List:");
        System.out.println(sortedStudents);

        input.close();
    }
}
