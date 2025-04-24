package Test;

import java.util.Scanner;

public class Testing2_2_6604800008 {

    // ประกาศอาร์เรย์ wage เป็นอาร์เรย์ 2 มิติ โดยมี 5 คอลัมน์
    static String[][] wage = new String[2][5];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // เรียกใช้เมธอด setData() เพื่อรับข้อมูลพนักงาน
        setData();

        // เรียกใช้เมธอด calWage() เพื่อคำนวณค่าจ้างพนักงาน
        calWage();

        // เรียกใช้เมธอด showData() เพื่อแสดงข้อมูลทั้งหมดในอาร์เรย์ wage
        showData();

        // เรียกใช้เมธอด searchData() เพื่อค้นหาข้อมูลพนักงาน
        System.out.println("โปรดป้อนรหัสพนักงานที่ต้องการค้นหา:");
        String employeeId = scanner.nextLine();
        searchData(employeeId);

        scanner.close();
    }

    // เมธอดสำหรับรับข้อมูลพนักงานเข้ามาเก็บไว้ในอาร์เรย์
    static void setData() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < wage.length; i++) {
            System.out.println("ป้อนรหัสพนักงาน:");
            wage[i][0] = scanner.nextLine();

            System.out.println("ป้อนชื่อ-นามสกุล:");
            wage[i][1] = scanner.nextLine();

            System.out.println("ป้อนอัตราค่าจ้างรายวัน:");
            wage[i][2] = scanner.nextLine();

            System.out.println("ป้อนจำนวนวันที่ทำงาน:");
            wage[i][3] = scanner.nextLine();

            System.out.println("ป้อนค่าจ้างที่พนักงานได้รับ:");
            wage[i][4] = scanner.nextLine();
        }
        scanner.close();
    }

    // เมธอดสำหรับคำนวณค่าจ้างพนักงาน
    static void calWage() {
        for (int i = 0; i < wage.length; i++) {
            double rate = Double.parseDouble(wage[i][2]);
            int days = Integer.parseInt(wage[i][3]);
            double totalWage = rate * days;
            wage[i][3] = Double.toString(totalWage);
        }
    }

    // เมธอดสำหรับค้นหาข้อมูลพนักงานในอาร์เรย์
    static void searchData(String employeeId) {
        boolean found = false;
        for (int i = 0; i < wage.length; i++) {
            if (wage[i][0].equals(employeeId)) {
                System.out.println("พบข้อมูลพนักงาน:");
                System.out.println("รหัสพนักงาน: " + wage[i][0]);
                System.out.println("ชื่อ-นามสกุล: " + wage[i][1]);
                System.out.println("อัตราค่าจ้างรายวัน: " + wage[i][2]);
                System.out.println("จำนวนวันที่ทำงาน: " + wage[i][3]);
                System.out.println("ค่าจ้างที่พนักงานได้รับ: " + wage[i][4]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("ไม่พบข้อมูลพนักงานที่ค้นหา");
        }
    }

    // เมธอดสำหรับแสดงข้อมูลทั้งหมดในอาร์เรย์ wage
    static void showData() {
        System.out.println("ข้อมูลพนักงานทั้งหมด:");
        for (int i = 0; i < wage.length; i++) {
            if (wage[i][0] == null) {
                break;
            }
            System.out.println("รหัสพนักงาน: " + wage[i][0]);
            System.out.println("ชื่อ-นามสกุล: " + wage[i][1]);
            System.out.println("ค่าจ้างที่ได้รับ: " + wage[i][3]);
            System.out.println("-----------------------------");
        }
    }
}
