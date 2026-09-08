import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreAnalysisSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //  Create Score List
        ArrayList<Integer> scores = new ArrayList<>();

        scores.add(85);
        scores.add(70);
        scores.add(95);
        scores.add(60);
        scores.add(45);
        scores.add(88);
        scores.add(76);
        scores.add(100);
        scores.add(55);
        scores.add(90);
        scores.add(67);
        scores.add(82);
        scores.add(49);
        scores.add(95);
        scores.add(73);

        // Keep a copy of the original list
        ArrayList<Integer> originalScores = new ArrayList<>(scores);

        // Display Score Information
        System.out.println("===== SCORE INFORMATION =====");
        System.out.println("Total Scores: " + scores.size());

        for (int i = 0; i < scores.size(); i++) {
            System.out.println("Score " + i + ": " + scores.get(i));
    }

        //  Calculate Score Statistics
        int total = 0;
        int highest = scores.get(0);
        int lowest = scores.get(0);

        for (int score : scores) {
            total += score;

            if (score > highest) {
                highest = score;
            }

            if (score < lowest) {
                lowest = score;
            }
    }

        double average = (double) total / scores.size();

        System.out.println("\n===== SCORE STATISTICS =====");
        System.out.println("Total Score: " + total);
        System.out.printf("Average: %.2f%n", average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);

        //  Score Classification
        int passed = 0;
        int failed = 0;
        int excellent = 0;
        int lowGrades = 0;

        for (int score : scores) {

            if (score >= 60) {
                passed++;
            } else {
                failed++;
            }

            if (score >= 90) {
                excellent++;
            }

            if (score < 50) {
                lowGrades++;
            }
    }

        System.out.println("\n===== SCORE CLASSIFICATION =====");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
        System.out.println("Excellent: " + excellent);
        System.out.println("Low Grades: " + lowGrades);

        //  Search Score System
        System.out.println("\n===== SEARCH SCORE =====");
        System.out.print("Enter score to search: ");
        while (!input.hasNextInt()) {
            System.out.println("Please enter a valid score.");
            input.next();
            System.out.print("Enter score to search: ");
        }
        int searchScore = input.nextInt();

        if (scores.contains(searchScore)) {

            int firstIndex = scores.indexOf(searchScore);
            int occurrences = 0;

            for (int score : scores) {
                if (score == searchScore)
                    occurrences++;
            }

            System.out.println("Score found.");
            System.out.println("First Position: " + firstIndex);
            System.out.println("Occurrences: " + occurrences);

    } else {
            System.out.println("Score not found.");
    }

        //  Update Score System
        System.out.println("\n===== UPDATE SCORE =====");
        System.out.print("Enter score index: ");
        while (!input.hasNextInt()) {
            System.out.println("Invalid index.");
            input.next();
            System.out.print("Enter score index: ");
        }
        int updateIndex = input.nextInt();

        if (updateIndex >= 0 && updateIndex < scores.size()) {

            System.out.print("Enter new score: ");
            while (!input.hasNextInt()) {
                System.out.println("Please enter a valid score.");
                input.next();
                System.out.print("Enter new score: ");
            }
            int newScore = input.nextInt();

            if (newScore < 0 || newScore > 100) {
                System.out.println("Score must be between 0 and 100.");
            } else {
                scores.set(updateIndex, newScore);
            }

            System.out.println("Updated Scores:");
            System.out.println(scores);

    } else {
            System.out.println("Invalid index.");
    }

        // Remove Score System
        System.out.println("\n===== REMOVE SCORE =====");

        System.out.println("Current Scores:");
        System.out.println(scores);

        System.out.print("Enter score value to remove: ");
        int removeValue = input.nextInt();

        if (scores.remove(Integer.valueOf(removeValue))) {
            System.out.println("Score removed successfully.");
    } else {
            System.out.println("Score not found.");
    }

        System.out.print("Enter index to remove: ");
        int removeIndex = input.nextInt();

        if (removeIndex >= 0 && removeIndex < scores.size()) {
            scores.remove(removeIndex);
            System.out.println("Score removed successfully.");
    } else {
            System.out.println("Invalid index.");
    }

        System.out.println("Updated Scores:");
        System.out.println(scores);

        //  Sorting and Reversing Scores
        ArrayList<Integer> sortedScores = new ArrayList<>(originalScores);

        Collections.sort(sortedScores);

        System.out.println("\n===== SORTED SCORES =====");
        System.out.println("Ascending:");
        System.out.println(sortedScores);

        Collections.reverse(sortedScores);

        System.out.println("Descending:");
        System.out.println(sortedScores);

        // Clear Score Data
        System.out.println("\n===== CLEAR SCORE DATA =====");

        scores.clear();

        System.out.println("After Clear:");
        System.out.println(scores);

        System.out.println("Is Empty: " + scores.isEmpty());

        input.close();
    }
    }