package Looping;

import java.util.Scanner;

public class I {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter purchase price: $");
        double purchasePrice = scanner.nextDouble();

        // Calculate monthly payment

        double monthlyPayment = purchasePrice / 12.0;

        // Display account information
        System.out.println("\nAccount Information:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customerName);

        // Display monthly payments for the next 12 months
        if (accountNumber <= 9999) {
            System.out.println("\nMonthly Payments for the Next 12 Months:");
            for (int month = 1; month <= 12; month++) {
                System.out.printf("Month %2d: $%.2f%n", month, monthlyPayment);
            }
        } else {
            System.out.println("ERROR!!");
            System.out.println("Your Account Number : WRONG");

        }

        // Close the scanner
        scanner.close();
    }
}