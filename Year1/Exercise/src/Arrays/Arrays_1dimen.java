package Arrays;

import java.util.Scanner;

public class Arrays_1dimen {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int size, max, min;
            float average, sum = 0;
            System.out.println("Input size of the array:");
            size = scan.nextInt();

            int[] mynum = new int[size];
            int i;
            for (i = 0; i <= size - 1; i++) {
                System.out.print("Input mynum[" + i + "] :");
                mynum[i] = scan.nextInt();
            }

            max = min = mynum[0];
            sum += mynum[0];

            for (i = 1; i <= size - 1; i++) {
                if (mynum[i] > max) {
                    max = mynum[i];
                }
                if (mynum[i] < min) {
                    min = mynum[i];
                }
                sum += mynum[i];
            }

            average = sum / size;

            System.out.println("Max : " + max);
            System.out.println("Min : " + min);
            System.out.println("Average : " + average);
        }

    }
}
