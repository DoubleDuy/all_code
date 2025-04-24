package Test;

import java.util.Scanner;

public class Cashier {
    // ข้อมูลสินค้า
    static String[][] products = {
        // ระบุรหัส ชื่อ ราคา จำนวนในสต็อคของสินค้า
            {"B01", "ขนมปัง", "25.00", "50"},
            {"B02", "น้ำอัดลม", "15.00", "30"},
            {"B03", "มันฝรั่งทอด", "20.00", "40"},
            {"B04", "ไส้กรอก", "50.00", "100"},
            {"B05", "น้ำเปล่า", "10.00", "20"},
            {"B06", "M150", "10.00", "20"},
            {"B07", "EnegyDrinks", "10.00", "10"},
            {"B08", "Fanta Orange 325ml", "15.00", "30"},
            {"B09", "A&W Root Beer", "16.00", "40"},
            {"C01", "Black Peper Chicken Burger", "45.00", "10"},
            {"C02", "Hoegaarden Rosee", "150.00", "20"},
            {"C03", "ขนมจีบไก่", "19.00", "48"},
            {"C04", "Nutella Eclair", "30.00", "8"},
            {"C05", "ต้มข่าไก่", "40.00", "10"},
            {"C06", "ปลาผัดขึ้นฉ่าย", "45.00", "5"},
            {"C07", "หมูคั่วกลิ้ง", "35.00", "8"},
            {"C08", "ปีกไก่ไข่พะโล้", "45.00", "3"},
            {"C09", "Espresso", "30.00", "99"},          
            // เพิ่มสินค้าตามความต้องการ
    };

    // ข้อมูลสมาชิก
    static String[][] members = {
            {"M001", "Similun", "6604800015", "similan.wiy@siam.edu"},
            {"M002", "Wiyaphon", "1500048066", "wiy.similan@edu.siam"},
            // เพิ่มสมาชิกตามความต้องการ
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับรหัสสมาชิก
        System.out.print("Enter customer ID: ");
        String customerId = scanner.next();

        // ตรวจสอบสมาชิก
        boolean isMember = checkMembership(customerId);

        // รับรายการสินค้า
        String[][] shoppingList = getShoppingList();

        // คำนวณราคารวม
        double totalPrice = calculateTotalPrice(shoppingList, isMember);

        // รับจำนวนเงินจากลูกค้า
        System.out.print("Enter payment amount: ");
        double paymentAmount = scanner.nextDouble();

        // คำนวณเงินทอน
        double change = paymentAmount - totalPrice;

        // พิมพ์ใบเสร็จ
        printReceipt(customerId, shoppingList, totalPrice, isMember, paymentAmount, change);

        scanner.close();
    }

    // ฟังก์ชันตรวจสอบสมาชิก
    static boolean checkMembership(String customerId) {
        for (String[] member : members) {
            if (member[0].equals(customerId)) {
                return true;
            }
        }
        return false;
    }

    // ฟังก์ชันรับรายการสินค้า
static String[][] getShoppingList() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter number of products: ");
    int numProducts = scanner.nextInt();

    String[][] shoppingList = new String[numProducts][2];
    for (int i = 0; i < numProducts; i++) {
        System.out.printf("Enter product code for item %d: ", i + 1);
        String productCode = scanner.next();
        System.out.printf("Enter quantity for item %d: ", i + 1);
        String quantity = scanner.next();
        shoppingList[i][0] = productCode;
        shoppingList[i][1] = quantity;
    }
    return shoppingList;
}

    /// ฟังก์ชันคำนวณราคารวม
static double calculateTotalPrice(String[][] shoppingList, boolean isMember) {
    double totalPrice = 0;
    for (String[] item : shoppingList) {
        String productCode = item[0];
        String quantity = item[1];
        double price = 0;

        // ค้นหาราคาของสินค้า
        for (String[] product : products) {
            if (product[0].equals(productCode)) {
                price = Double.parseDouble(product[2]);
                break;
            }
        }

        // คำนวณราคารวมของสินค้า
        totalPrice += price * Integer.parseInt(quantity);
    }

    // เพิ่มการคำนวณภาษี 7%
    double tax = totalPrice * 0.07;
    totalPrice += tax;

    // หากเป็นสมาชิกจะได้รับส่วนลด 10%
    if (isMember) {
        totalPrice *= 0.9;
    }

    return totalPrice;
}

    // ฟังก์ชันพิมพ์ใบเสร็จ
static void printReceipt(String customerId, String[][] shoppingList, double totalPrice, boolean isMember, double paymentAmount, double change) {
    System.out.println("===== Receipt =====");
    System.out.println("Customer ID: " + customerId);
    System.out.println("Date: " + java.time.LocalDate.now());
    System.out.println("Time: " + java.time.LocalTime.now());
    System.out.println("Member: " + (isMember ? "Yes" : "No"));
    System.out.println("Items:");
    for (String[] item : shoppingList) {
        double itemPrice = Double.parseDouble(item[1]) * getItemPrice(item[0]);
        System.out.println("- " + item[1] + "x " + getItemName(item[0]) + " - " + itemPrice + " THB");
    }
    double tax = totalPrice * 0.07;
    System.out.println("Tax (7%): " + tax + " THB");
    totalPrice += tax;
    System.out.println("Total Price (incl. tax): " + totalPrice + " THB");
    System.out.println("Payment: " + paymentAmount + " THB");
    System.out.println("Change: " + change + " THB");
    System.out.println("==================");
}

    // ฟังก์ชันคืนชื่อสินค้า
    static String getItemName(String productCode) {
        for (String[] product : products) {
            if (product[0].equals(productCode)) {
                return product[1];
            }
        }
        return "";
    }

    // ฟังก์ชันคืนราคาสินค้า
    static double getItemPrice(String productCode) {
        for (String[] product : products) {
            if (product[0].equals(productCode)) {
                return Double.parseDouble(product[2]);
            }
        }
        return 0;
    }
}