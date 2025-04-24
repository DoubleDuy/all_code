package ControlStructures;

import java.util.Scanner;

public class I {
    public static void main(String[] args) {
        int amount;
        float price, totalPrice=0,vatprice=0,netprice=0;
        final float vat = 0.05f;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of items :");
        amount = sc.nextInt();
        System.out.print("Enter the price per item :");
        price = sc.nextFloat();

        totalPrice = amount * price;

        if (totalPrice >= 1000) {
            vatprice = totalPrice * vat;

            netprice = totalPrice - vatprice;
        }
        
        System.out.println("Total Price :"+totalPrice);
        System.out.println("Vat Price :" + vatprice);
        System.out.println("Net Price :"+netprice);
    }

}
