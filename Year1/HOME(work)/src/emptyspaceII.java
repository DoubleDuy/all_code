import java.util.Scanner;

public class emptyspaceII {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the score: ");
        int score = sc.nextInt();

        if (score < 50 || score == false) {
            System.out.print("YOU FAIL!!");
        }
    }
}