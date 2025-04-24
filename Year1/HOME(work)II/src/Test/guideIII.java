package Test;

import java.util.Scanner;

public class guideIII {
    // เมธอดคำนวณพื้นที่สี่เหลี่ยม
    static int RectangleArea(int width, int height) {
        return width * height;
    }

    // เมธอดคำนวณพื้นที่สามเหลี่ยม
    static float TriangleArea(int base, float height) {
        return (base * height) / 2;
    }

    // เมธอดคำนวณพื้นที่วงกลม
    static float CircleArea(float radius) {
        return (float) (Math.PI * radius * radius);
    }

    // เมธอดออกจากโปรแกรม
    static void Exit() {
        System.out.println("Exiting program...");
        System.exit(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // แสดงเมนู
            System.out.println("Menu:");
            System.out.println("1. Rectangle Area");
            System.out.println("2. Triangle Area");
            System.out.println("3. Circle Area");
            System.out.println("4. Exit Program");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            // ตรวจสอบตามเมนูที่เลือก
            switch (choice) {
                case 1:
                    System.out.print("Enter width of rectangle: ");
                    int width = scanner.nextInt();
                    System.out.print("Enter height of rectangle: ");
                    int height = scanner.nextInt();
                    int rectangleArea = RectangleArea(width, height);
                    System.out.println("Rectangle area: " + rectangleArea);
                    break;
                case 2:
                    System.out.print("Enter base of triangle: ");
                    int base = scanner.nextInt();
                    System.out.print("Enter height of triangle: ");
                    float triangleHeight = scanner.nextFloat();
                    float triangleArea = TriangleArea(base, triangleHeight);
                    System.out.println("Triangle area: " + triangleArea);
                    break;
                case 3:
                    System.out.print("Enter radius of circle: ");
                    float radius = scanner.nextFloat();
                    float circleArea = CircleArea(radius);
                    System.out.println("Circle area: " + circleArea);
                    break;
                case 4:
                    Exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
