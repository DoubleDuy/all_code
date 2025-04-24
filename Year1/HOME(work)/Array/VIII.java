package Array;

import java.util.Scanner;

public class VIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double coffeePrice = 2.00;
        double[] addInPrices = { 0.89, 0.25, 0.59, 1.50, }; // Cream, Sugar, Cinnamon, Whipped Cream
        boolean orderComplete = false;
        double totalOrderPrice = 0.0;

        System.out.println("Welcome to Jumpin' Jive Coffee Shop!");

        // Display add-ins and their prices
        System.out.println("Add-ins:");
        for (int i = 0; i < addInPrices.length; i++) {
            System.out.println((i + 1) + ". Add-in " + (i + 1) + " - $" + addInPrices[i]);
        }
        System.out.println("Enter add-ins (1-" + addInPrices.length + ") or 0 to finish:");

        while (!orderComplete) {
            int addInChoice = scanner.nextInt();

            if (addInChoice == 0) {
                orderComplete = true;
            } else if (addInChoice >= 1 && addInChoice <= addInPrices.length) {
                totalOrderPrice += addInPrices[addInChoice - 1];
                System.out.println("Add-in " + addInChoice + " added. Price: $" + addInPrices[addInChoice - 1]);
            } else {
                System.out.println("Sorry, we do not carry that.");
            }

            if (!orderComplete) {
                System.out.println("Current total: $" + (coffeePrice + totalOrderPrice));
                System.out.println("Enter another add-in (1-" + addInPrices.length + ") or 0 to finish:");
            }
        }

        System.out.println("Thank you for your order!");
        System.out.println("Total price: $" + (coffeePrice + totalOrderPrice));

        scanner.close();
    }
}
