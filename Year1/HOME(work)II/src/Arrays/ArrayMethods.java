package Arrays;

import  java.util.Arrays;
import  java.util.Scanner;

public class ArrayMethods {
     public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.print("Amount of Student :");
        int numStudent = scanner.nextInt();
        
        String[] names= new String[numStudent];
        double[] scores = new double[numStudent];
        
        for(int i =0; i < numStudent;i++){
            System.out.print("Fill the Name of Syudent No "+(i+1)+ " : ");
            names[i] = scanner.next();
            System.out.print("Exam score : ");
            scores[i] = scanner.nextDouble();
        }
        
        double sum = 0;
        for (double score : scores){
            sum += score;
        }
        double averageScore = sum / numStudent;
        System.out.println("\n");
        System.out.println("Average score : " + averageScore);
        
        int arraySize=names.length;
        System.out.println("Array size : " + arraySize);
        
        
        //Sort
        Arrays.sort(scores);
        for (int i = 0; i < numStudent; i++) {
            System.out.println("Sort : "+scores[i] + "\t");
        }
        
        //binary search
        int indexValue = Arrays.binarySearch(names, "s2");
        System.out.println("Binary search : " + indexValue);
            
        //fill เข้าไปแทนที่อาร์เรย์ทุกตัว

        //equals
        double[] scores2 = new double[] { 100.0, 90.0, 80.0 };
        boolean result = Arrays.equals(scores, scores2);
        System.out.println("Scores equal Scores2 : " +result );
    }
}
