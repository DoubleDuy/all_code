import java.util.Scanner;

public class emptyspaceIV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unitprice: ");
        float unitprice = sc.nextFloat();
        System.out.println("Month: ");
        int month = sc.nextInt();

        float InterestRate=0;
        if (unitprice <= 10000) {
            InterestRate = unitprice * 0.03f;
        } else {
            if (month <= 3) {
                InterestRate = unitprice * 0.05f;
            } else if (month > 3 && month <= 6) {
                InterestRate = unitprice * 0.075f;
            } else if (month > 6 && month <= 12) {
                InterestRate = unitprice * 0.10f;
            } else if (month > 12) {
                InterestRate = unitprice * 0.125f;
            }
        }
        System.out.println("Interest rate is " + InterestRate);
    }
}
