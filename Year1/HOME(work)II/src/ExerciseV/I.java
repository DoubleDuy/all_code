package ExerciseV;

import java.util.Scanner;

public class I {
    public static void main(String[] args) {
        int number;
        double sqr=0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number : ");
        number=scan.nextInt();
        if (number % 2 == 0){
            sqr = Math.sqrt(number);
            System.out.print(sqr);
        } else {
            System.out.println("The entered number is not even.");
        }

    }
}
