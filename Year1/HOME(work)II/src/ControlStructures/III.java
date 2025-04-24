package ControlStructures;

import  java.util.Scanner;

public class III {
    public static void main(String[] args) {
        int amount;
        float price, totalPrice=0,vatprice=0,netprice=0;
        final float vatI = 0.10f,vatII=0.15f,vatIII=0.20f;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of items :");
        amount = sc.nextInt();
        System.out.print("Enter the price per item :");
        price = sc.nextFloat();

        totalPrice = amount * price;

        if (totalPrice >= 1001 && totalPrice <= 5000) {
            vatprice = totalPrice * vatI;
            netprice = totalPrice - vatprice;
        } else if (totalPrice >= 5001 && totalPrice <= 10000) {
            vatprice = totalPrice * vatII;
            netprice = totalPrice - vatprice;
        }else if(totalPrice > 10000){
            vatprice = totalPrice * vatIII;
            netprice = totalPrice - vatprice;
        }
        
        System.out.println("Total Price :"+ totalPrice);
        System.out.println("Vat Price :" + vatprice);
        System.out.println("Net Price :"+ netprice);
    }
}
