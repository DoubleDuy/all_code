package ExerciseV;

import java.util.Scanner;

public class VI {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        // รับ Username
        System.out.print("ป้อน Username: ");
        String username = scanner.nextLine();

        // รับ Password
        System.out.print("ป้อน Password: ");
        String password = scanner.nextLine();

        // ตรวจสอบ Username และ Password
        boolean isValidLogin = false;
        if (username.equals("admin") && password.equals("1234")) {
            isValidLogin = true;
        }

        // แสดงผลลัพธ์
        if (isValidLogin) {
            System.out.println("Welcome to system!");
        } else {
            System.out.println("Username or Password is invalid!");
        }
    }
    
}
