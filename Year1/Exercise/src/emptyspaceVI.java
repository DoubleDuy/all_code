import java.util.Scanner;

public class emptyspaceVI {
    public static void main(String[] args) {
        float price;
        float fixedRate = 0.013f;
        int months = 12;

        Scanner sc = new Scanner(System.in);
        System.out.println("ราคาสินค้า:");
        price = sc.nextFloat();
        System.out.println("จำนวนเดือนที่ต้องการผ่อน:");
        months = sc.nextInt();
        sc.close();

        if (months > 12) {
            System.out.println("Error ผ่อนได้นานสุด 12 เดือน");
            return;
        }
    
        // คำนวณยอดดอกเบี้ยทั้งหมด
        Float totalInterest = price * fixedRate * months;
    
        // คำนวณยอดรวมทั้งหมดที่ต้องชำระ (ราคาสินค้ารวมดอกเบี้ย)
        Float totalAmount = price + totalInterest;
    
        // คำนวณยอดผ่อนชำระต่อเดือน
        Float installmentPerMonth = totalAmount / months;
    
        // ส่งค่าผลลัพธ์
        System.out.println("ยอดดอกเบี้ยทั้งหมด: " + totalInterest);
        System.out.println("ยอดรวมทั้งหมดที่ต้องชำระ: " + totalAmount);
        System.out.println("ยอดผ่อนชำระต่อเดือน: " + installmentPerMonth);
    }
}
