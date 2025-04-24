import java.util.Scanner;

public class emptyspaceV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ป้อนจำนวนเงินที่ต้องการแลก : ");
        int amount = scanner.nextInt();

        // คำนวณจำนวนเหรียญสิบบาท
        int tenBath = amount / 10;
        amount %= 10;

        // คำนวณจำนวนเหรียญห้าบาท
        int fiveBath = amount / 5;
        amount %= 5;

        // จำนวนเหรียญหนึ่งบาท
        int oneBath = amount;

        // แสดงผลลัพธ์
        System.out.println("จำนวนเงิน " + amount + " บาท สามารถแลกเป็น:");
        System.out.println("- เหรียญสิบบาท: " + tenBath + " เหรียญ");
        System.out.println("- เหรียญห้าบาท: " + fiveBath + " เหรียญ");
        System.out.println("- เหรียญหนึ่งบาท: " + oneBath + " เหรียญ");

        scanner.close();
    }
}



