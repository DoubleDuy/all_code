package Arrays;
import java.util.Scanner;

public class ExamII {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);;
        String[][] StudentScore =new String[2][7];
        float totalscore=0;
        for(int i=0;i<2;i++){
            System.out.print("ID : ");
            StudentScore[i][0]=sc.next();
            System.out.print("Name : ");
            StudentScore[i][1]=sc.next();
            
            //Score
            System.out.print("Score : ");
            StudentScore[i][2]=sc.next();
            if(Float.parseFloat(StudentScore[i][2])>50){
                System.out.println("Wrong Score! Please enter a score between 0 and 50.");
                System.out.print("Score : ");
                StudentScore[i][2]=sc.next();
            }

            //midscore
            System.out.print("Midterm Score : ");
            StudentScore[i][3]=sc.next();
            if(Float.parseFloat(StudentScore[i][3])>20){
                System.out.println("Wrong Score! Please enter a score between 0 and 20.");
                System.out.print("Midterm Score : ");
                StudentScore[i][3]=sc.next();
            }
            
            //finalscore
            System.out.print("Finalterm Score : ");
            StudentScore[i][4]=sc.next();
            if(Float.parseFloat(StudentScore[i][4])>30){
                System.out.println("Wrong Score! Please enter a score between 0 and 30.");
                System.out.print("Finalterm Score : ");
                StudentScore[i][4]=sc.next();
            }
            
            totalscore+=Float.parseFloat(StudentScore[i][2])+Float.parseFloat(StudentScore[i][3])+Float.parseFloat(StudentScore[i][4]);
            
            totalscore=Float.parseFloat(StudentScore[i][5]);
            
        }
        for(int i=0;i<2;i++){
            
        }
    }
}

