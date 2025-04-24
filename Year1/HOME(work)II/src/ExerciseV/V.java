package ExerciseV;

import java.util.Scanner;

public class V {
    public static void main(String[] args) {
        int amount;
        float unitprice,totalprice,discountIprice=0,discountIIprice=0,netprice=0;
        final float discountI = 0.10f;
        final float discountII = 0.05f;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount of item : ");
        amount = sc.nextInt();
        System.out.print("Enter the unitprice of item : ");
        unitprice = sc.nextFloat();
        sc.close();

        totalprice = amount * unitprice;
        if (totalprice >= 10000) {
            discountIprice = totalprice * discountI;
            
            netprice = totalprice - discountIprice;
        } else if (totalprice < 10000) {
            discountIIprice = totalprice * discountII;

            netprice = totalprice -  discountIIprice;
        }

        System.out.println("------------------");
        System.out.println(totalprice);
        System.out.println(netprice);

    }
}
