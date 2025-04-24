//โจทย์ : เขียนโปรแกรมที่มี นักศึกษาทั้งหมด 30 คน หาค่าคะแนนเฉลี่ย จำนวนนักศึกษาที่ได้คะแนนมากกว่าคะแนนเฉลี่ย จำนวนนักศึกษาที่ได้คะแนนน้อยกว่าคะแนนเฉลี่ย และจำนวนนักศึกษาที่ได้คะแนนมากที่สุด โดยรับข้อมูลรหัสนักศึกษา ชื่อ และคะแนนรวม เก็บลงอาร์เรย์ 2 มิติ java code

package Arrays;

import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int numberOfStudents = 3;
            String[][] students = new String[numberOfStudents][3];
            for (int i = 0; i < numberOfStudents; i++) {
                System.out.print("ID : ");
                students[i][0] = scan.next();
                System.out.print("Name : ");
                students[i][1] = scan.next();
                System.out.print("Score : ");
                students[i][2] = scan.next();
            }

            float average, totalscore = 0;
            for (int i = 0; i < numberOfStudents; i++) {
                totalscore += Float.parseFloat(students[i][2]);
            }
            average = totalscore / numberOfStudents;

            int aboveAverage = 0, belowAverage = 0;
            for (int i = 0; i < numberOfStudents; i++) {
                if (Float.parseFloat(students[i][2]) > average) {
                    aboveAverage++;
                } else if (Float.parseFloat(students[i][2]) < average) {
                    belowAverage++;
                }
            }

            float maxScore = 0, currentScore;
            for (int i = 0; i < numberOfStudents; i++) {
                currentScore = Float.parseFloat(students[i][2]);
                if (currentScore > maxScore) {
                    maxScore = currentScore;
                }
            }

            System.out.println("Student Information");
            System.out.println("Average Score : " + average);
            System.out.println("Above Average Score : " + aboveAverage);
            System.out.println("Below Average Score : " + belowAverage);
            System.out.println("Max Score : " + maxScore);
        }
    }
}
