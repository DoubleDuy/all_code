package Array;

import java.util.Scanner;

public class IV {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[3];
        double sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextDouble();
            sum += numbers[i];
        }

        double average = sum / numbers.length;

        System.out.println("\nNumber\tDifference from Average");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + "\t" + (numbers[i] - average));
        }

        scanner.close();
    }
}
