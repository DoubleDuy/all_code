import java.util.Scanner;

public class homeVI {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float number, calloutminute = 0, calloutcost = 0, text = 0, textcost = 0, serviceprice, totalprice,
                promotionprice = 199;
        System.out.print("เบอร์โทรศัพท์ : ");
        number = scan.nextInt();
        System.out.print("ป้อนจำนวนนาทีที่โทรออก : ");
        calloutminute = scan.nextInt();
        System.out.print("ป้อนจำนวนข้อความ : ");
        text = scan.nextInt();

        if (calloutminute > 100) {
            calloutcost = (calloutminute - 100) * 2.50f;
        }

        if (text >= 1 && text <= 50) {
            textcost = text * 3.00f;
        } else if (text >= 51 && text <= 100) {
            textcost = text * 2.00f;
        } else {
            textcost = text * 1.50f;
        }

        totalprice = calloutcost + textcost;
        serviceprice = totalprice + promotionprice;

        System.out.println("ราคารวม(ค่าโทร+ต่าข้อความ) : " + totalprice + "บาท");
        System.out.println("ค่าบริการทั้งหมด : " + serviceprice + "บาท");

    }
}
