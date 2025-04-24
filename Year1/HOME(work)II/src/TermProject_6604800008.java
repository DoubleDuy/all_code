import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TermProject_6604800008 {
    static String[][] products = {
            {"P001", "มันฝรั่งทอดกรอบ", "22.00", "50"},
            {"P002", "ลูกอม", "10.00", "30"},
            {"P003", "นม", "25.00", "40" },
            {"P004", "น้ำหวาน", "20.00", "100"},
            {"P005", "โยเกิร์ต", "18.00", "30"},
            {"P006", "ไอศครีม", "30.00", "40"},
            // เพิ่มสินค้าตามความต้องการ
    };

    // ข้อมูลสมาชิก
    static String[][] members = {
            {"M001", "Dina", "0646450407", "dina@siam.edu"},
            {"M002", "Mai", "0812345678", "mai@siam.edu" },
            {"M003", "Yok", "0823456789", "yok@siam.edu"},
            {"M004", "Prem", "0867891234", "prem@siam.edu" },
            {"M005", "Guide", "0834567891", "guide@siam.edu" },
            {"M006", "Peter", "0845678912", "peter@siam.edu"},
            {"M007", "Bas", "0856789123", "bas@siam.edu" },
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

    // ฟังก์ชันคำนวณราคารวม
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
            totalPrice += price * Double.parseDouble(quantity);
            
            double vat=totalPrice*0.07;
            totalPrice+=vat;
            
            // หากเป็นสมาชิกจะได้รับส่วนลด 10%
            if (isMember) {
                totalPrice*=0.9;
            }
            
        }


        return totalPrice;
    }

    // ฟังก์ชันพิมพ์ใบเสร็จ
    static void printReceipt(String customerId, String[][] shoppingList, double totalPrice, boolean isMember,
        double paymentAmount, double change) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String receiptNo = "R" + dateFormat.format(new Date()).replace("-", "").replace(":", "").replace(" ", "");
        String date = dateFormat.format(new Date()).split(" ")[0];
        String time = dateFormat.format(new Date()).split(" ")[1];

        System.out.println("\t");
        System.out.println("===== Receipt =====");
        System.out.println("Receipt Number: " + receiptNo);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Member: " + (isMember ? "Yes" : "No"));
        System.out.println("Items:");
        for (String[] item : shoppingList) {
            System.out.println("- " + item[1] + "x " + getItemName(item[0]) + " - " + Double.parseDouble(item[1]) * getItemPrice(item[0]) + " THB");
        }
        //double vat=totalPrice*0.07;
        //System.out.println("Vat: " + vat + " THB");
        System.out.println("Total Price: " + totalPrice + " THB");
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