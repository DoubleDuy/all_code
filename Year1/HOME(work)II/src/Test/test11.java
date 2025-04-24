package Test;

import java.text.SimpleDateFormat; // Import คลาส SimpleDateFormat เพื่อใช้ในการจัดรูปแบบวันที่และเวลา
import java.util.Date; // Import คลาส Date เพื่อใช้ในการจัดเก็บวันที่และเวลา
import java.util.Scanner; // Import คลาส Scanner เพื่อใช้ในการรับข้อมูลจากผู้ใช้

public class test11 {
    // ข้อมูลสินค้า
    static String[][] products = {
        //รหัสสินค้า,ชื่อสินค้า,ราคา,ขอที่มี
        {"001", "น้ำเปล่า", "15","50"},
        {"002", "ชาไทย", "25","40"},
        {"003", "ชาเขียว", "25","40"},
        {"004", "นมสด", "20","60"},
        {"005", "ขนมปัง", "10","60"},
        {"006", "คุกกี้", "15","30"},
        {"007", "เสื้อผ้า", "300","20"},
        {"008", "กางเกง", "250","15"},
        {"009", "รองเท้า", "500","10"},
        {"010", "หมวก", "150","10"},
        {"011", "โทรศัพท์มือถือ", "15000","5"},
        {"012", "โน้ตบุ๊ค", "20000","4"},
        {"013", "เครื่องปรับอากาศ", "7500","10"},
        {"014", "ทีวี", "10000","10"},
        {"015", "ตู้เย็น", "5500","6"},
        {"016", "เครื่องซักผ้า", "6000","5"},
        {"017", "เครื่องดูดฝุ่น", "4500","7"},
        {"018", "ไมโครเวฟ", "1500","10"},
        {"019", "เตารีด", "1000","15"},
        {"020", "กล้อง", "10000","10"}

    };

    // ข้อมูลสมาชิก
    static String[][] members = {
        {"001", "phonnumas","12345","phonnumas@siam.com"},
        {"002", "Earn","54321","Earn@siam.com"}
        // เพิ่มสมาชิกเพิ่มเติมตรงนี้
    };

    // ฟังก์ชันสำหรับตรวจสอบสมาชิก
    static boolean isMember(String memberId) {
        for (String[] member : members) {
            if (member[0].equals(memberId)) { // ตรวจสอบว่ารหัสสมาชิกที่รับเข้ามาตรงกับในฐานข้อมูลหรือไม่
                return true; // หากตรงกันให้คืนค่า true
            }
        }
        return false; // หากไม่ตรงให้คืนค่า false
    }

    // ฟังก์ชันสำหรับคำนวณราคาสินค้า
    static double calculatePrice(String productId, int quantity, boolean isMember) {
        double price = 0;
        for (String[] product : products) {
            if (product[0].equals(productId)) { // ตรวจสอบว่ารหัสสินค้าที่รับเข้ามาตรงกับในฐานข้อมูลหรือไม่
                price = Double.parseDouble(product[2]) * quantity; // คำนวณราคาโดยการคูณราคาของสินค้าด้วยจำนวนที่ซื้อ
                if (isMember) { // ถ้าเป็นสมาชิกจะได้รับส่วนลด
                    price *= 0.9; // ส่วนลดสำหรับสมาชิก 10%
                }
                break; // หยุดการวน loop เมื่อค้นพบสินค้า
            }
        }
        return price; // คืนค่าราคาที่คำนวณได้
    }

    // ฟังก์ชันสำหรับคำนวณภาษีมูลค่าเพิ่ม
    static double calculateVAT(double totalPrice) {
        return totalPrice * 0.07; // ภาษีมูลค่าเพิ่ม 7%
    }

    // ฟังก์ชันสำหรับคำนวณเงินทอน
    static double calculateChange(double totalPrice, double amountPaid) {
        return amountPaid - totalPrice; // คำนวณเงินทอนโดยหักยอดรวมที่ต้องชำระด้วยจำนวนเงินที่ลูกค้าจ่าย
    }

    // ฟังก์ชันสำหรับพิมพ์ใบเสร็จรับเงิน
    static void printReceipt(String memberId, String[][] purchasedProducts, double totalPrice, double amountPaid, double change ) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // กำหนดรูปแบบของวันที่
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss"); // กำหนดรูปแบบของเวลา
        Date date = new Date(); // สร้างอ็อบเจกต์ Date เพื่อใช้เก็บวันที่และเวลาปัจจุบัน

        System.out.println("\n----- ใบเสร็จรับเงิน -----");
        System.out.println("เลขที่ใบเสร็จ: " + System.currentTimeMillis()); // ใช้เวลาปัจจุบันเป็นเลขที่ใบเสร็จ
        System.out.println("วันที่ซื้อ: " + dateFormat.format(date)); // พิมพ์วันที่ซื้อโดยใช้รูปแบบที่กำหนด
        System.out.println("เวลาที่ซื้อ: " + timeFormat.format(date)); // พิมพ์เวลาที่ซื้อโดยใช้รูปแบบที่กำหนด
        for (String[] member : members) {
            if (member[0].equals(memberId)) { // ตรวจสอบว่ารหัสสมาชิกตรงกับในฐานข้อมูลหรือไม่
                System.out.println("ชื่อสมาชิก: " + member[1]); // พิมพ์ชื่อสมาชิก
                break; // หยุดการวน loop เมื่อค้นพบข้อมูลสมาชิก
            }
        }
        System.out.println("รายการสินค้าที่ซื้อ:");
        for (String[] product : purchasedProducts) {
            System.out.println("- " + product[1] + ": " + product[2] + " ชิ้น"); // พิมพ์รายการสินค้าที่ซื้อและจำนวน
        }
        System.out.println("ยอดรวมราคา: " + totalPrice + " บาท"); // พิมพ์ยอดรวมราคาสินค้า
        double discount = totalPrice * 0.1; // คำนวณส่วนลด 10%
        System.out.println("ส่วนลด: " + discount + " บาท"); // พิมพ์จำนวนส่วนลด
        double totalPriceAfterDiscount = totalPrice - discount; // คำนวณราคาหลังหักส่วนลด
        System.out.println("ราคาหลังหักส่วนลด: " + totalPriceAfterDiscount + " บาท"); // พิมพ์ราคาหลังหักส่วนลด
        double vat = calculateVAT(totalPriceAfterDiscount); // คำนวณภาษีมูลค่าเพิ่ม
        System.out.println("ภาษีมูลค่าเพิ่ม: " +vat + " บาท"); // พิมพ์จำนวนภาษีมูลค่าเพิ่ม
        double totalPriceWithVAT = totalPriceAfterDiscount + vat; // คำนวณราคารวมภาษีมูลค่าเพิ่ม
        System.out.println("รวมภาษีมูลค่า: " + totalPriceWithVAT + " บาท"); // พิมพ์ราคารวมภาษีมูลค่าเพิ่ม
        System.out.println("จำนวนเงินที่ลูกค้าจ่าย: " + amountPaid + " บาท"); // พิมพ์จำนวนเงินที่ลูกค้าจ่าย
        System.out.println("เงินทอน: " + (change - vat) + " บาท"); // พิมพ์จำนวนเงินทอนโดยหักภาษีมูลค่าเพิ่ม
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // สร้างอ็อบเจกต์ Scanner เพื่อรับข้อมูลจากผู้ใช้

        // รับรหัสสมาชิก
        System.out.print("กรุณาป้อนรหัสสมาชิก: "); // แสดงข้อความให้ผู้ใช้ป้อนรหัสสมาชิก
        String memberId = scanner.nextLine(); // รับรหัสสมาชิกจากผู้ใช้
        boolean isMember = isMember(memberId); // เรียกใช้ฟังก์ชันเพื่อตรวจสอบว่าเป็นสมาชิกหรือไม่

        // รับรายการสินค้าและจำนวนที่ซื้อ
        System.out.print("กรุณาป้อนจำนวนรายการสินค้าที่ต้องการซื้อ: "); // แสดงข้อความให้ผู้ใช้ป้อนจำนวนรายการสินค้า
        int numOfItems = scanner.nextInt(); // รับจำนวนรายการสินค้าที่ต้องการซื้อจากผู้ใช้
        String[][] purchasedProducts = new String[numOfItems][3]; // สร้างอาร์เรย์เพื่อเก็บข้อมูลรายการสินค้าที่ซื้อ
        for (int i = 0; i < numOfItems; i++) { // วนลูปเพื่อรับข้อมูลรายการสินค้า
            System.out.print("กรุณาป้อนรหัสสินค้า: "); // แสดงข้อความให้ผู้ใช้ป้อนรหัสสินค้า
            String productId = scanner.next(); // รับรหัสสินค้าจากผู้ใช้
            scanner.nextLine(); // ยกเลิกการอ่านข้อมูลในบรรทัดถัดไป
            System.out.print("กรุณาป้อนจำนวนที่ซื้อ: "); // แสดงข้อความให้ผู้ใช้ป้อนจำนวนที่ซื้อ
            int quantity = scanner.nextInt(); // รับจำนวนที่ซื้อจากผู้ใช้
            for (String[] product : products) { // วนลูปเพื่อค้นหาข้อมูลของสินค้าที่ตรงกับรหัสที่ผู้ใช้ป้อน
                if (product[0].equals(productId)) { // เมื่อพบรหัสสินค้าที่ตรงกัน
                    purchasedProducts[i][0] = productId; // เก็บรหัสสินค้าลงในอาร์เรย์
                    purchasedProducts[i][1] = product[1]; // เก็บชื่อสินค้าลงในอาร์เรย์
                    purchasedProducts[i][2] = Integer.toString(quantity); // เก็บจำนวนสินค้าที่ซื้อลงในอาร์เรย์
                    break; // ออกจาก loop เมื่อค้นพบสินค้า
                }
            }
        }

        // คำนวณราคารวมของสินค้าทั้งหมด
        double totalPrice = 0;
        for (String[] product : purchasedProducts) { // วนลูปเพื่อคำนวณราคารวมของสินค้าทั้งหมด
            totalPrice += calculatePrice(product[0], Integer.parseInt(product[2]), isMember); // เรียกใช้ฟังก์ชันเพื่อคำนวณราคารวม
        }

        // รับจำนวนเงินจากลูกค้า
        System.out.print("กรุณาป้อนจำนวนเงินที่ลูกค้าจ่าย: "); // แสดงข้อความให้ผู้ใช้ป้อนจำนวนเงินที่จ่าย
        double amountPaid = scanner.nextDouble(); // รับจำนวนเงินจากผู้ใช้

        // คำนวณเงินทอน
        double change = calculateChange(totalPrice, amountPaid); // เรียกใช้ฟังก์ชันเพื่อคำนวณเงินทอน

        // พิมพ์ใบเสร็จ
        printReceipt(memberId, purchasedProducts, totalPrice, amountPaid, change); // เรียกใช้ฟังก์ชันเพื่อพิมพ์ใบเสร็จ
    }
}
