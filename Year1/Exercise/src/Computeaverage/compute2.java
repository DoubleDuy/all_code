package Computeaverage;

import java.util.Scanner;

public class compute2 {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            float discount, vat, netprice, totalprice, pricediscount, unitprice;
            int amount;
            System.out.print("ราคาสินค้าต่อหน่วย : ");
            unitprice = scan.nextFloat();
            System.out.print("จำนวนที่ซื้อ : ");
            amount = scan.nextInt();

            totalprice = unitprice * amount;
            discount = totalprice * 0.1f;
            pricediscount = totalprice - discount;
            vat = pricediscount * 0.07f;
            netprice = pricediscount + vat;

            System.out.println("ราคาสินค้ารวม : " + totalprice + " บาท");
            System.out.println("ส่วนลด : " + discount + " บาท");
            System.out.println("ราคาหลังหักส่วนลด : " + pricediscount + " บาท");
            System.out.println("ภาษีมูลค่าเพิ่ม : " + vat + " บาท");
            System.out.println("ราคาสุทธิที่ต้องชำระ : " + netprice + " บาท");
        }

    }
}