package ExerciseV;

import java.util.Scanner;

public class IV {
    public static void main(String[] args) {
        int amount;
        float unitprice,totalprice,discountprice=0,netprice;
        final float discount = 0.05f;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount of item : ");
        amount = sc.nextInt();
        System.out.print("Enter the unitprice of item : ");
        unitprice = sc.nextFloat();
        sc.close();

        totalprice = amount * unitprice;
        if (totalprice >= 1000) {
            discountprice = totalprice * discount;
            
            netprice = totalprice - discountprice;
        } else {
            netprice = totalprice;
        }

        System.out.println("------------------");
        System.out.println(totalprice);
        System.out.println(netprice);

    }
}
