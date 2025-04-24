package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList alist = new ArrayList();
        String stdName;
        
        for (int i = 0; i < 3; i++) {
            System.out.print("Student Name " + (i + 1) + ": ");
            stdName = sc.nextLine();
            //เพิ่มข้อมูลเข้า ArrayList
            alist.add(stdName);
        }
        
        //เอาชื่อออกจาก ArrayList
        //alist.remove(1);

        System.out.println("--------Student Name List---------");
        for (int i = 0; i < alist.size(); i++) {
            //อ่านข้อมูลใน ArrayList ด้วย เมธอด get
            System.out.println(alist.get(i));
        }

        //ค้นหาชื่อใน ArrayList
        int result = alist.indexOf("Jennifer");
        System.out.println("Index of Jennifer : "+result);
    }
}
