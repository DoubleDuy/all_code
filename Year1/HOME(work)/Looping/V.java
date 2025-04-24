package Looping;

import java.util.Scanner;

public class V {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalItems = 0;
        int itemsSameZipCode = 0;
        int itemsUnder30 = 0;
        int items30AndOlder = 0;
        int totalCustomers = 0;
        int totalAge = 0;

        System.out.println("Enter customer data. Enter 0 for zip code to end the day.");

        while (true) {
            System.out.print("Enter zip code: ");
            int zipCode = scanner.nextInt();

            if (zipCode == 0) {
                break; // End of the day
            }

            if (zipCode != 54984) {
                itemsSameZipCode++;
            }

            while (zipCode > 99999 || zipCode < 10000) {
                System.out.println("Invalid zip code. Please enter a 5-digit zip code.");
                System.out.print("Enter zip code: ");
                zipCode = scanner.nextInt();
            }

            System.out.print("Enter age: ");
            int age = scanner.nextInt();

            while (age < 10 || age > 110) {
                System.out.println("Invalid age. Please enter an age between 10 and 110.");
                System.out.print("Enter age: ");
                age = scanner.nextInt();
            }

            totalAge += age;
            totalCustomers++;

            System.out.print("Enter the number of items ordered: ");
            int itemsOrdered = scanner.nextInt();

            for (int i = 0; i < 2; i++) {
                if (itemsOrdered < 1 || itemsOrdered > 12) {
                    System.out.println("Invalid number of items. Please enter a number between 1 and 12.");
                    System.out.print("Enter the number of items ordered: ");
                    itemsOrdered = scanner.nextInt();
                }
            }

            if (itemsOrdered < 1) {
                System.out.println("Error: Invalid number of items. Order not counted.");
            } else {
                totalItems += itemsOrdered;

                if (age < 30) {
                    itemsUnder30 += itemsOrdered;
                } else {
                    items30AndOlder += itemsOrdered;
                }
            }
        }

        if (totalCustomers > 0) {
            double averageAge = (double) totalAge / totalCustomers;

            System.out.println("\nMarket Research Summary:");
            System.out.println("Total items ordered: " + totalItems);
            System.out.println("Items ordered by customers from the same zip code (54984): " + itemsSameZipCode);
            System.out.println("Items ordered by customers from other zip codes: " + (totalItems - itemsSameZipCode));
            System.out.println("Average customer age: " + averageAge);
            System.out.println("Items ordered by customers under 30: " + itemsUnder30);
            System.out.println("Items ordered by customers 30 and older: " + items30AndOlder);
        } else {
            System.out.println("No data entered. Exiting program.");
        }

        scanner.close();
    }
}
