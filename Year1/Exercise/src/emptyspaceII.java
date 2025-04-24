import java.util.Scanner;

import javax.swing.JOptionPane;

public class emptyspaceII {
    public static void main(String[] args) {
        int dayD,dayM;
        int hours;
        float payD, payM,payperD, payperM, ot, vatD, vatM, totalpayD, totalpayM;
        String name, id, typeID;

        Scanner sc = new Scanner(System.in);
        typeID = sc.next(JOptionPane.showInputDialog(null, "Type ID", "Input Form", JOptionPane.QUESTION_MESSAGE));
        
        switch (typeID) {
            case "D":
                
                
                name = sc.next(JOptionPane.showInputDialog(null, "Name", "Input Form", JOptionPane.QUESTION_MESSAGE));
                System.out.print("ID : ");
                id = sc.next(JOptionPane.showInputDialog(null, "ID", "Input Form", JOptionPane.QUESTION_MESSAGE));                
                System.out.print("Pay per Day : ");
                payperD = Float.parseFloat(JOptionPane.showInputDialog(null, "Enter pay per day", "Input Form", JOptionPane.QUESTION_MESSAGE));                
                System.out.print("amount of day : ");
                dayD = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter amount of the day", "Input Form", JOptionPane.QUESTION_MESSAGE));
                System.out.print("OT : ");
                hours = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter overtime(OT)", "Input Form", JOptionPane.QUESTION_MESSAGE));
        
                if (hours > 8) {
                    ot = (hours - 8) * 1.5f;
                    payD = payperD * dayD + ot;
                    vatD = payD * 0.05f;
                    totalpayD = payD - vatD;
                } else {
                    payD = payperD * dayD;
                    vatD = payD * 0.05f;
                    totalpayD = payD - vatD;
                }
                JOptionPane.showMessageDialog(null, "Pay : " + payD, "Output Form",JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Vatpat : " + vatD, "Output Form",JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Totalpay : " + totalpayD, "Output Form",JOptionPane.INFORMATION_MESSAGE);
                
                break;
        
            case "M":
                System.out.print("Name : ");
                name = sc.next();
                System.out.print("ID : ");
                id = sc.next();
                System.out.println("Pay per Month : ");
                payperM = sc.nextFloat();
                System.out.print("amount of day : ");
                dayM = sc.nextInt();
                System.out.println("OT : ");
                hours = sc.nextInt();
        
                if (dayM > 20) {
                    if (hours > 8) {
                        ot = (hours - 8) * 1.5f;
                        payM = payperM * (dayM+ot);
                        vatM = payM * 0.05f;
                        totalpayM = payM - vatM;
                    } else {
                        payM = payperM * dayM;
                        vatM = payM * 0.05f;
                        totalpayM = payM - vatM;
                    }
                } else {
                    payM = payperM * dayM;
                        vatM = payM * 0.05f;
                        totalpayM = payM - vatM;
                }
                JOptionPane.showMessageDialog(null, "Pay : " + payM, "Output Form",JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Vatpat : " + vatM, "Output Form",JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Totalpay : " + totalpayM, "Output Form",JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        
    }
}





