package ExerciseV;

import java.util.Scanner;

public class IX {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.print("Enter a number :");
            int num = sc.nextInt();

            num += i;

            if (num > 100) {
                break;
            }

            if (num < 0) {
                continue;
            }

            System.out.print(num);
        }        
    }
}
