package Computeaverage;

public class compute {

    public static void main(String[] args) {

        // INPUT
        // ประกาศตัวแปรรับค่าตัวเลข 4 จำนวน
        int num1 = 3;
        int num2 = 8;
        int num3 = 4;
        int num4 = 7;
        // ประกาศตัวแปรเก็บผลรวมตัวเลข 4 จำนวน
        int sum;
        // ประกาศตัวแปรเก็บค่าเฉลี่ย
        float average;

        // step2:หาผลรวมของเลขทั้ง 4 จำนวน
        sum = num1 + num2 + num3 + num4;
        // step3:หาค่าเฉลี่ย
        average = sum / 4;
        // step4:แสดงผลลัพธ์
        System.out.println("Sum of 4 number = : " + sum);
        System.out.println("Average = : " + average);
    }
}
