package ExerciseV;

import java.util.Scanner;

public class II {
    public static void main(String[] args) {
        int mynum=20,number;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number:");
        number = scan.nextInt();
        scan.close();
        
        if (number > mynum) {
            mynum = number;
        }
        
        System.out.print(mynum);
    }
}
