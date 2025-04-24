import java.util.Scanner;
import java.lang.Math;

public class homeIII {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            double X, Y, A = 0, B = 0, result, distance;
            System.out.print("input X -->");
            X = scan.nextInt();
            System.out.print("input Y -->");
            Y = scan.nextInt();

            result = Math.sqrt((A - X) * (A - X) + (B - Y) * (B - X));
            distance = result;

            System.out.print("Distance from (0,0) to (X,Y) is " + distance);
        }
    }
}
