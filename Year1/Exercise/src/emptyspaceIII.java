import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class emptyspaceIII {
    public static void main(String[] args) {
        InputStreamReader reader = new InputStreamReader(System.in);
        Scanner scanner = new Scanner(System.in);

        // รับข้อมูลราคาสินค้าต่อหน่วย
        System.out.print("UnitPrice: ");
        double unitPrice = Integer.parseInt(
        JOptionPane.showInputDialog(null, "Enter UnitPrice", "Input Form", JOptionPane.QUESTION_MESSAGE));

        // รับข้อมูลจำนวนสินค้าที่ลูกค้าซื้อ
        System.out.print("Amount: ");
        int quantity =  Integer.parseInt(
        JOptionPane.showInputDialog(null, "Enter Amount", "Input Form", JOptionPane.QUESTION_MESSAGE));

        // คำนวณราคาสินค้ารวม
        double total = unitPrice * quantity;

        // คำนวณภาษีมูลค่าเพิ่ม
        double vat = total * 0.07;

        // คำนวณราคาสินค้ารวมภาษีมูลค่าเพิ่ม
        double grandTotal = total + vat;

        // จัดรูปแบบราคาสินค้ารวมภาษีมูลค่าเพิ่ม
        DecimalFormat df = new DecimalFormat("###,###.##");
        String formattedGrandTotal = df.format(grandTotal);

        // แสดงผลลัพธ์
        JOptionPane.showMessageDialog(null, 
            "UnitPrice: " + formattedGrandTotal + " Baht", 
            "Amount", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}
