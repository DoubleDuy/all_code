package Test;

import java.util.Scanner;

public class guideII {
    // เมธอดตรวจสอบผลการเรียน
    static boolean checkPass(float score) {
        // คำนวณ % ของคะแนนสอบ
        float percent = calPercent(score);
        // ตรวจสอบว่าผ่านหรือไม่
        return percent > 65;
    }

    // เมธอดคำนวณ % ของคะแนนสอบ
    static float calPercent(float score) {
        // คำนวณ % ของคะแนนสอบ
        return (score / 35) * 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับคะแนนสอบ
        System.out.print("Enter your score: ");
        float score = scanner.nextFloat();

        // เรียกใช้งานเมธอด checkPass() เพื่อตรวจสอบผลการเรียน
        boolean isPass = checkPass(score);

        // แสดงผลลัพธ์
        if (isPass) {
            System.out.printf("Congratulations, you got %.1f%%", calPercent(score));
        } else {
            System.out.printf("Sorry, you got %.1f%%", calPercent(score));
        }

        scanner.close();
    }
}
