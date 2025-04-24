package Test;

import java.util.Arrays;
import java.util.Scanner;

public class Testing2_1_6604800008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min, max, sum=0;
        int[][] score = new int[30][4];
        for (int i = 0; i < score.length; i++) {
            System.out.print("ป้อนรหัสนักศึกษาของนักเรียนที่ " + (i + 1) + " : ");
            int studentId = sc.nextInt();
            score[i][0] = studentId;

            System.out.print("ป้อนคะแนนเก็บของนักเรียนที่ " + (i + 1) + " : ");
            int attendScore = sc.nextInt();
            score[i][1] = attendScore;

            System.out.print("ป้อนคะแนนสอบกลางภาคของนักเรียนที่ " + (i + 1) + " : ");
            int midtermScore = sc.nextInt();
            score[i][2] = midtermScore;

            System.out.print("ป้อนคะแนนสอบกลางปลายของนักเรียนที่ " + (i + 1) + " : ");
            int finalScore = sc.nextInt();
            score[i][3] = finalScore;
        }

        // คำนวณคะแนนรวมและเก็บลงในอาร์เรย์ TotalScore
        int[] totalScore = new int[30];
        for (int i = 0; i < score.length; i++) {
            totalScore[i] = score[i][1] + score[i][2] + score[i][3];

            sum += totalScore[i];
            
            System.out.println("\t");
            System.out.println("คะแนนรวมคนที่"+i+" = "+totalScore[i]);
        }
        
        
        // เรียงลำดับคะแนนในอาร์เรย์ totalScore จากมากไปน้อย
        Arrays.sort(totalScore);


        //หาค่าสูงสุด ต่ำสุด
        max = min = totalScore [0];
        System.out.print("\t");
        for (int i = 0; i < totalScore.length; i++) {
            if (totalScore[i] > max) {
                max = totalScore[i];
            }
            if (totalScore[i] < min) {
                min = totalScore[i];
            }            
        }
        System.out.println("คะแนนต่ำสุด: " + min);
        System.out.println("คะแนนสูงสุด: " + max);


        //หาคะแนนเฉลี่ย
        float avg = sum / totalScore.length;
        System.out.println("คะแนนเฉลี่ย: " + avg);


        int[] frequency = new int[7]; // มี 7 ช่วงคะแนน
        for (int i = 0; i < totalScore.length; i++) {
            if (totalScore[i] >= 0 && totalScore[i] <= 40) {
                frequency[0]++;
            } else if (totalScore[i] >= 41 && totalScore[i] <= 50) {
                frequency[1]++;
            } else if (totalScore[i] >= 51 && totalScore[i] <= 60) {
                frequency[2]++;
            } else if (totalScore[i] >= 61 && totalScore[i] <= 70) {
                frequency[3]++;
            } else if (totalScore[i] >= 71 && totalScore[i] <= 75) {
                frequency[4]++;
            } else if (totalScore[i] >= 76 && totalScore[i] <= 80) {
                frequency[5]++;
            } else if (totalScore[i] >= 81 && totalScore[i] <= 100) {
                frequency[6]++;
            }
        }
        
        System.out.println("ความถี่ของคนที่ได้คะแนนในแต่ละช่วงคะแนน:");
        System.out.println("0 - 40: " + frequency[0] + " คน");
        System.out.println("41 - 50: " + frequency[1] + " คน");
        System.out.println("51 - 60: " + frequency[2] + " คน");
        System.out.println("61 - 70: " + frequency[3] + " คน");
        System.out.println("71 - 75: " + frequency[4] + " คน");
        System.out.println("76 - 80: " + frequency[5] + " คน");
        System.out.println("81 - 100: " + frequency[6] + " คน");
    }
}
