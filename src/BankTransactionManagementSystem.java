import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BankTransactionManagementSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Integer> accountNumbers = new ArrayList<>();
        ArrayList<String> customerNames = new ArrayList<>();
        ArrayList<Double> balances = new ArrayList<>();
        ArrayList<String> accountTypes = new ArrayList<>();
        ArrayList<String> accountStatus = new ArrayList<>();


        // Initial 10 Accounts


        accountNumbers.add(10001);
        customerNames.add("Ali");
        balances.add(2500.0);
        accountTypes.add("Savings");
        accountStatus.add("Active");

        accountNumbers.add(10002);
        customerNames.add("Ahmed");
        balances.add(5000.0);
        accountTypes.add("Current");
        accountStatus.add("Active");

        accountNumbers.add(10003);
        customerNames.add("Sara");
        balances.add(1200.0);
        accountTypes.add("Savings");
        accountStatus.add("Suspended");

        accountNumbers.add(10004);
        customerNames.add("Fatima");
        balances.add(8000.0);
        accountTypes.add("Current");
        accountStatus.add("Active");

        accountNumbers.add(10005);
        customerNames.add("Omar");
        balances.add(1500.0);
        accountTypes.add("Savings");
        accountStatus.add("Closed");

        accountNumbers.add(10006);
        customerNames.add("Mona");
        balances.add(9500.0);
        accountTypes.add("Current");
        accountStatus.add("Active");

        accountNumbers.add(10007);
        customerNames.add("Hassan");
        balances.add(3000.0);
        accountTypes.add("Savings");
        accountStatus.add("Active");

        accountNumbers.add(10008);
        customerNames.add("Noor");
        balances.add(700.0);
        accountTypes.add("Current");
        accountStatus.add("Suspended");

        accountNumbers.add(10009);
        customerNames.add("Salim");
        balances.add(6000.0);
        accountTypes.add("Savings");
        accountStatus.add("Active");

        accountNumbers.add(10010);
        customerNames.add("Aisha");
        balances.add(4500.0);
        accountTypes.add("Current");
        accountStatus.add("Active");

        int nextAccountNumber = 10011;

        int choice;

        do {

            System.out.println("\n========== BANK MENU ==========");
            System.out.println("1. Display Accounts");
            System.out.println("2. Create New Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer Money");
            System.out.println("6. Search Account");
            System.out.println("7. Banking Statistics");
            System.out.println("8. Account Status Analysis");
            System.out.println("9. Update Account");
            System.out.println("10. Remove Account");
            System.out.println("11. Sort Accounts");
            System.out.println("12. Exit");
            System.out.print("Enter Choice: ");

            while (!input.hasNextInt()) {
                System.out.println("Invalid Choice.");
                input.next();
                System.out.print("Enter Choice: ");
            }
            choice = input.nextInt();

            switch (choice) {


                // Display Accounts

                case 1:

                    for (int i = 0; i < accountNumbers.size(); i++) {

                        System.out.println("\nAccount Index : " + i);
                        System.out.println("Account Number: " + accountNumbers.get(i));
                        System.out.println("Customer      : " + customerNames.get(i));
                        System.out.println("Type          : " + accountTypes.get(i));
                        System.out.println("Balance       : " + balances.get(i));
                        System.out.println("Status        : " + accountStatus.get(i));
                    }

                    break;


                // Create Account

                case 2:

                    input.nextLine();

                    System.out.print("Customer Name: ");
                    String name = input.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Customer name cannot be empty.");
                        break;
                    }

                    System.out.print("Initial Balance: ");
                    double balance = input.nextDouble();

                    if (balance < 0) {
                        System.out.println("Balance cannot be negative.");
                        break;
                    }

                    input.nextLine();

                    System.out.print("Account Type (Savings/Current): ");
                    String type = input.nextLine().trim();

                    if (!type.equalsIgnoreCase("Savings") &&
                            !type.equalsIgnoreCase("Current")) {

                        System.out.println("Invalid Account Type.");
                        break;
                    }

                    accountNumbers.add(nextAccountNumber);
                    customerNames.add(name);
                    balances.add(balance);
                    accountTypes.add(type);
                    accountStatus.add("Active");

                    System.out.println("Account Created Successfully.");
                    System.out.println("Generated Account Number: " + nextAccountNumber);

                    nextAccountNumber++;

                    break;


                // Deposit

                case 3:

                    System.out.print("Enter Account Number: ");
                    while (!input.hasNextInt()) {
                        System.out.println("Account number must be a number.");
                        input.next();
                        System.out.print("Enter Account Number: ");
                    }
                    int depositAcc = input.nextInt();

                    int depositIndex = accountNumbers.indexOf(depositAcc);

                    if (depositIndex == -1) {
                        System.out.println("Account not found.");
                        break;
                    }

                    System.out.print("Deposit Amount: ");
                    while (!input.hasNextDouble()) {
                        System.out.println("Deposit amount must be a number.");
                        input.next();
                        System.out.print("Deposit Amount: ");
                    }
                    double deposit = input.nextDouble();

                    if (deposit <= 0) {
                        System.out.println("Invalid Amount.");
                        break;
                    }

                    balances.set(depositIndex,
                            balances.get(depositIndex) + deposit);

                    System.out.println("Deposit Completed.");
                    System.out.println("New Balance: " + balances.get(depositIndex));

                    break;


                // Withdraw

                case 4:

                    System.out.print("Enter Account Number: ");
                    while (!input.hasNextInt()) {
                        System.out.println("Account number must be a number.");
                        input.next();
                        System.out.print("Enter Account Number: ");
                    }
                    int withdrawAcc = input.nextInt();

                    int withdrawIndex = accountNumbers.indexOf(withdrawAcc);

                    if (withdrawIndex == -1) {
                        System.out.println("Account not found.");
                        break;
                    }

                    System.out.print("Withdrawal Amount: ");
                    while (!input.hasNextDouble()) {
                        System.out.println("Withdrawal amount must be a number.");
                        input.next();
                        System.out.print("Withdrawal Amount: ");
                    }
                    double withdraw = input.nextDouble();

                    if (withdraw <= 0) {
                        System.out.println("Invalid Amount.");
                    } else if (withdraw > balances.get(withdrawIndex)) {
                        System.out.println("Insufficient Balance.");
                    } else {

                        balances.set(withdrawIndex,
                                balances.get(withdrawIndex) - withdraw);

                        System.out.println("Withdrawal Successful.");
                        System.out.println("Remaining Balance: " +
                                balances.get(withdrawIndex));
                    }

                    break;


                // Transfer

                case 5:

                    System.out.print("Sender Account Number: ");
                    int sender = input.nextInt();

                    System.out.print("Receiver Account Number: ");
                    int receiver = input.nextInt();

                    int senderIndex = accountNumbers.indexOf(sender);
                    int receiverIndex = accountNumbers.indexOf(receiver);

                    if (sender == receiver) {
                        System.out.println("Sender and receiver must be different accounts.");
                        break;
                    }

                    if (senderIndex == -1 || receiverIndex == -1) {

                        System.out.println("Account not found.");
                        break;
                    }

                    System.out.print("Transfer Amount: ");
                    double amount = input.nextDouble();

                    if (amount <= 0) {

                        System.out.println("Invalid Amount.");

                    } else if (amount > balances.get(senderIndex)) {

                        System.out.println("Insufficient Balance.");

                    } else {

                        balances.set(senderIndex,
                                balances.get(senderIndex) - amount);

                        balances.set(receiverIndex,
                                balances.get(receiverIndex) + amount);

                        System.out.println("Transfer Successful.");
                    }

                    break;

                // Search

                case 6:

                    System.out.println("1. Search by Account Number");
                    System.out.println("2. Search by Customer Name");

                    int searchChoice = input.nextInt();

                    if (searchChoice == 1) {

                        System.out.print("Account Number: ");
                        int searchAcc = input.nextInt();

                        int index = accountNumbers.indexOf(searchAcc);

                        if (index == -1) {

                            System.out.println("Account not found.");

                        } else {

                            System.out.println(customerNames.get(index));
                            System.out.println("Balance: " + balances.get(index));
                            System.out.println("Status : " + accountStatus.get(index));
                        }

                    } else {

                        input.nextLine();

                        System.out.print("Customer Name: ");
                        String searchName = input.nextLine().trim();

                        boolean found = false;

                        for (int i = 0; i < customerNames.size(); i++) {

                            if (customerNames.get(i).equalsIgnoreCase(searchName)) {

                                System.out.println("Account Number: " + accountNumbers.get(i));
                                System.out.println("Balance: " + balances.get(i));
                                System.out.println("Status : " + accountStatus.get(i));

                                found = true;
                            }
                        }

                        if (!found)
                            System.out.println("Account not found.");
                    }

                    break;

                // Statistics

                case 7:

                    double total = 0;
                    double highest = balances.get(0);
                    double lowest = balances.get(0);

                    for (double b : balances) {

                        total += b;

                        if (b > highest)
                            highest = b;

                        if (b < lowest)
                            lowest = b;
                    }

                    double average = total / (double) balances.size();

                    System.out.println("Total Accounts : " + balances.size());
                    System.out.println("Total Balance  : " + total);
                    System.out.println("Average Balance: " + average);
                    System.out.println("Highest Balance: " + highest);
                    System.out.println("Lowest Balance : " + lowest);

                    break;


                // Status Analysis

                case 8:

                    int active = 0;
                    int suspended = 0;
                    int closed = 0;

                    for (String status : accountStatus) {

                        if (status.equalsIgnoreCase("Active"))
                            active++;

                        else if (status.equalsIgnoreCase("Suspended"))
                            suspended++;

                        else if (status.equalsIgnoreCase("Closed"))
                            closed++;
                    }

                    System.out.println("Active Accounts: " + active);
                    System.out.println("Suspended Accounts: " + suspended);
                    System.out.println("Closed Accounts: " + closed);

                    break;

                // Update

                case 9:

                    System.out.print("Enter Account Index: ");
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid Index.");
                        input.next();
                        System.out.print("Enter Account Index: ");
                    }
                    int update = input.nextInt();

                    if (update < 0 || update >= accountNumbers.size()) {

                        System.out.println("Invalid Index.");
                        break;
                    }

                    input.nextLine();

                    System.out.print("New Name: ");
                    customerNames.set(update, input.nextLine());

                    System.out.print("New Type: ");
                    accountTypes.set(update, input.nextLine());

                    System.out.print("New Status: ");
                    accountStatus.set(update, input.nextLine());

                    System.out.println("Updated Successfully.");

                    break;


                // Remove

                case 10:

                    System.out.print("Enter Account Index: ");
                    int remove = input.nextInt();

                    if (remove < 0 || remove >= accountNumbers.size()) {

                        System.out.println("Invalid Index.");

                    } else {

                        accountNumbers.remove(remove);
                        customerNames.remove(remove);
                        balances.remove(remove);
                        accountTypes.remove(remove);
                        accountStatus.remove(remove);

                        System.out.println("Account Removed.");
                    }

                    break;


                // Sorting

                case 11:

                    System.out.println("1. Balance Low -> High");
                    System.out.println("2. Balance High -> Low");
                    System.out.println("3. Customer Name A-Z");

                    int sort = input.nextInt();

                    for (int i = 0; i < balances.size() - 1; i++) {

                        for (int j = i + 1; j < balances.size(); j++) {

                            boolean swap = false;

                            if (sort == 1 && balances.get(i) > balances.get(j))
                                swap = true;

                            if (sort == 2 && balances.get(i) < balances.get(j))
                                swap = true;

                            if (sort == 3 &&
                                    customerNames.get(i).compareToIgnoreCase(customerNames.get(j)) > 0)
                                swap = true;

                            if (swap) {

                                Collections.swap(accountNumbers, i, j);
                                Collections.swap(customerNames, i, j);
                                Collections.swap(balances, i, j);
                                Collections.swap(accountTypes, i, j);
                                Collections.swap(accountStatus, i, j);
                            }
                        }
                    }

                    System.out.println("Accounts Sorted Successfully.");

                    break;

                case 12:
                    System.out.println("Thank You.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 12);

        input.close();
    }
}