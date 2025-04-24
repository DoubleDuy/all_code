package ExerciseV;

import  java.util.Scanner;

public class VII {
    public static void main(String[] args) {
        char grade = 'A';
        boolean status=true;
        int score, midscore, finalscore, totalscore;

        Scanner sc = new Scanner(System.in);
        System.out.print("Attend Score : ");
        score = sc.nextInt();
        System.out.print("Midterm Score : ");
        midscore = sc.nextInt();
        System.out.print("Finalterm Score : ");
        finalscore = sc.nextInt();

        totalscore = score + midscore + finalscore;

        
            if (totalscore >= 0 && totalscore <= 100) {
                if (totalscore >= 90 && totalscore == 100) {
                    grade = 'A';
                } else if (totalscore >= 80 && totalscore < 90) {
                    grade = 'B';
                } else if (totalscore >= 70 && totalscore < 80) {
                    grade = 'C';
                } else if (totalscore >= 60 && totalscore < 70) {
                    grade = 'D';
                } else if (totalscore < 60) {
                    grade = 'F';
                }
            } else {
                System.out.println("Invalid Score");
            }
            
        
        
        

        System.out.println("-----------------");
        System.out.println("Total Score : " + totalscore);
        System.out.println("Grade       : " + grade);
    }
}

