import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ComSciSmartShop { //ระดับคลาส
    // สร้างอาร์เรย์ 2 มิติ ขนาด 20 แถว 3 คอลัมน์
    public int PRODUCTS = 20;
    public String[][] products = new String[PRODUCTS][3];
    public ArrayList<String> orderHistory = new ArrayList<>();
    public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public String date = dateFormat.format(new Date()).split(" ")[0];
    public String time = dateFormat.format(new Date()).split(" ")[1];

    // เมธอดสำหรับรับข้อมูลสินค้าจากผู้ใช้
    public void setProduct() {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        
        while (i < PRODUCTS) {
            System.out.println("รหัสสินค้า (ใส่ 'xxx' เพื่อหยุด): ");
            String code = sc.nextLine();
            if (code.equalsIgnoreCase("xxx")) {
                break;
            }

            System.out.println("ชื่อสินค้า: ");
            String name = sc.nextLine();

            System.out.println("ราคาสินค้าต่อหน่วย: ");
            String price = sc.nextLine();

            products[i][0] = code;
            products[i][1] = name;
            products[i][2] = price;
            i++;
        }
    }

    // เมธอดสำหรับอ่านข้อมูลราคาสินค้าต่อหน่วย
    public double getPrice(String productCode) {
        for (int i = 0; i < PRODUCTS; i++) {
            if (products[i][0] != null && products[i][0].equals(productCode)) {
                try {
                    return Double.parseDouble(products[i][2]);
                } catch (NumberFormatException e) {
                    System.out.println("ราคาสินค้าต่อหน่วยไม่ถูกต้อง");
                    return -1;
                }
            }
        }
        System.out.println("ไม่พบรหัสสินค้า");
        return -1;
    }

    // เมธอดสำหรับคำนวณค่าสินค้า
    public void Compute_Price(double unitPrice, int quantity) {
        double totalPrice = unitPrice * quantity;
        System.out.printf("ราคารวมของสินค้าจำนวน %d ชิ้น คือ %.2f บาท\n", quantity, totalPrice);
        
        // เก็บข้อมูลลงใน ArrayList
        orderHistory.add(String.format("วันที่ขาย: ,รหัสสินค้า: %s, จำนวน: %d, ราคา: %.2f บาท",date, products[0][0], quantity, totalPrice));
    }

    public static void main(String[] args) {
        ComSciSmartShop shop = new ComSciSmartShop();
        shop.setProduct();
        
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("รหัสสินค้าที่ต้องการค้นหา: ");
            String productCode = sc.nextLine();
            
            double unitPrice = shop.getPrice(productCode);
            if (unitPrice != -1) {
                System.out.println("จำนวนสินค้าที่ลูกค้าซื้อ: ");
                int quantity = sc.nextInt();
                sc.nextLine(); // Consume the newline character
                
                shop.Compute_Price(unitPrice, quantity);
            } else {
                System.out.println("ใส่รหัสสินค้าใหม่อีกครั้ง");
            }
            
            System.out.println("ต้องการคำนวณราคาสินค้าอีกครั้งหรือไม่? (yes/no): ");
            String response = sc.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
        }
        
        // แสดงข้อมูลใน orderHistory
        System.out.println("ประวัติการสั่งซื้อ:");
        for (String order : shop.orderHistory) {
            System.out.println(order);
        }
    }
}
