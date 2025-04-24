package ExerciseIV;

import java.util.Scanner;

import javax.swing.JOptionPane;

import java.text.DecimalFormat;

public class II {
    public static void main(String[] args) {
        // ประกาศตัวแปร
        int amount;
        float unitprice, totalPrice = 0;
        final float vat = 0.07f;
        
        amount = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Input amount", "Input Form", JOptionPane.QUESTION_MESSAGE));
        unitprice = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Input unitprice", "Input Form", JOptionPane.QUESTION_MESSAGE));
        
        totalPrice = (unitprice * amount)*vat + (unitprice*amount);
        // แสดงผลลัพธ์
        JOptionPane.showMessageDialog(null, " Totalprice is " + totalPrice, "Output Form",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
