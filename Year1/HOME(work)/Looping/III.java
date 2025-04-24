package Looping;

import java.util.Scanner;

public class III {
    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter the number of working years remaining: ");
        int workingYears = scanner.nextInt();

        System.out.print("Enter the annual amount of money you can save: ");
        double annualSavings = scanner.nextDouble();

        // Close the scanner to avoid resource leak
        scanner.close();

        // Constants
        final double INTEREST_RATE = 0.03;
        final double RETIREMENT_SPENDING = 50000;

        // Calculate retirement savings schedule
        double savings = 0;
        int year = 0;

        System.out.println("Retirement Savings Schedule:");

        while (year <= 40 && savings >= 0) {
            System.out.printf("Year %d: $%.2f\n", year, savings);

            // Calculate interest on savings
            savings = savings * (1 + INTEREST_RATE);

            // Deduct retirement spending
            savings -= RETIREMENT_SPENDING;

            // Add annual savings during working years
            if (year < workingYears) {
                savings += annualSavings;
            }

            // Ensure savings is not negative
            if (savings < 0) {
                savings = 0;
            }

            // Increment the year
            year++;
        }
    }
}
