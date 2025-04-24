package ExerciseIV;

import java.util.Scanner;

public class I {
    public static void main(String[] args) {
        String ID,name;
        int enscore,midscore,finalscore,totalscore;
        char grade='A';
        
        Scanner scan = new Scanner(System.in);
        System.out.print("ID :");
        ID = scan.nextLine();
        System.out.print("NAME :");
        name = scan.nextLine();
        System.out.print("Attend Score :");
        enscore = scan.nextInt();
        System.out.print("Midterm Score :");
        midscore= scan.nextInt();
        System.out.print("Finalterm Score :");
        finalscore = scan.nextInt();
        
        totalscore = enscore+midscore+finalscore;
        
        if(totalscore>=80 && totalscore==100){
            grade = 'A';
        }else if(totalscore>=70 && totalscore<80){
            grade = 'B';
        }else if(totalscore>=60 && totalscore<70){
            grade = 'C';
        }else if(totalscore>=50 && totalscore<60){
            grade = 'D';
        }else if(totalscore<50){
            grade = 'F';
        }
        
        System.out.println("--------------------");
        System.out.println("ID : "+ID);
        System.out.println("NAME : "+name);
        System.out.println("Totalscore : "+totalscore);
        System.out.println("Grade : "+grade);
    }    
}
