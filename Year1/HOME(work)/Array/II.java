package Array;

import java.util.Scanner;

public class II {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[31];
        while (scanner.hasNextInt()) {
            int studentId = scanner.nextInt();
            int classroomNumber = scanner.nextInt();
            int score = scanner.nextInt();
            scores[classroomNumber] += score;
        }
        for (int i = 1; i <= 30; i++) {
            System.out.println("Classroom " + i + ": " + scores[i]);
        }
    }
}