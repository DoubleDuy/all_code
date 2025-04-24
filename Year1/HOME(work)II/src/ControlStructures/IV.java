package ControlStructures;

import java.util.Scanner;

public class IV {
    public static void main(String[] args) {
        String name,id;
        int totalscore, midscore, finalscore, score = 0;
        char grade = 'A';
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your NAME : ");
        name = sc.next();
        System.out.print("Enter Your ID : ");
        id = sc.next();
        System.out.print("Enter Score : ");
        score=sc.nextInt();
        System.out.print("Enter Midterm Score : ");
        midscore=sc.nextInt();
        System.out.print("Enter Final Exam Score : ");
        finalscore = sc.nextInt();
        
        totalscore = midscore + finalscore + score;

        if (totalscore >= 80 && totalscore <= 100) {
            grade = 'A';
        } else if (totalscore >= 70 && totalscore < 80) {
            grade = 'B';
        } else if (totalscore >= 60 && totalscore < 70) {
            grade = 'C';
        } else if (totalscore >= 50 && totalscore < 60) {
            grade = 'D';
        } else if (totalscore >= 0 && totalscore < 50) {
            grade = 'F';
        }
        
        System.out.println("NAME : " + name);
        System.out.println("ID : " + id);
        System.out.println("SCORE : " + score);
        System.out.println("MIDTERM : " + midscore);
        System.out.println("FINALTERM : " + finalscore);
        System.out.println("------------------------");
        System.out.println("TOTALSCORE : " + totalscore);
        System.out.println("GRADE : " + grade);
    }
}
