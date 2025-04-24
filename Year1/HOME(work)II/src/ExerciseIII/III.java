package ExerciseIII;

import java.util.Scanner;

public class III {
    public static void main(String[] args) {
        int amount;
        float unitprice,totalprice,vatprice,netprice;
        final float vat=0.07f;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the amount of product: ");
        amount = scan.nextInt();
        System.out.print("Enter the unitprice of product: ");
        unitprice = scan.nextFloat();

        totalprice = unitprice*amount;
        vatprice = totalprice * vat;
        netprice = totalprice + vatprice;

        System.out.println("Total price is :"+totalprice);
        System.out.println("VAT Price is :"+vatprice);
        System.out.println("Net Price is :"+netprice);
    }
}
