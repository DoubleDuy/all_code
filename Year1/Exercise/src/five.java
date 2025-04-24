import javax.swing.JOptionPane;

public class five {
    public static void main(String[] args) {
        // ประกาศตัวแปร
        int servicePrice, height, age;
        // รับข้อมูลส่วนสูงและอายุ
        height = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Input customr height", "Input Form", JOptionPane.QUESTION_MESSAGE));
        age = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Input cistomr age", "Input Form", JOptionPane.QUESTION_MESSAGE));
        // ตรวจสอบเงื่อนไขเพื่อหาราคาค่าตั๋วเครื่องเล่น
        if (height <= 120 || age <= 15) {
            servicePrice = 100;
        } else {
            servicePrice = 250;
        }
        // แสดงผลลัพธ์
        JOptionPane.showMessageDialog(null, " Ticket Price is " + servicePrice, "Output Form",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
