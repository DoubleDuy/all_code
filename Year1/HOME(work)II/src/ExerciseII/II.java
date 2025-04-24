package ExerciseII;

import java.util.Scanner;

public class II {
    public static void main(String[] args) {
        byte amount;
        int unitprice;
        final float discount = 0.05f;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of products:");
        amount =scan.nextByte();
        System.out.print("Enter the unitprice:");
        unitprice=scan.nextInt();

        int totalprice = unitprice*amount;
        float discountprice = totalprice*discount;
        float netprice  = totalprice - discountprice;

        System.out.println("-----------------");
        System.out.println("Total Price :"+totalprice);
        System.out.println("Discount Price :"+discountprice);
        System.out.println("Net Price :"+netprice);
    }
}
