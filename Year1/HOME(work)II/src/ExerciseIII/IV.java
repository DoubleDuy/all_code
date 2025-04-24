package ExerciseIII;

import java.util.Scanner;

public class IV {
    public static void main(String[] args) {
        String name,age;
        float w,h,BMI;
        final float weight,height;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        name=scan.nextLine();
        System.out.print("Enter your Age: ");
        age=scan.nextLine();
        System.out.print("Enter your Weight (pound): ");
        w=scan.nextFloat();
        System.out.print("Enter your Height (inch): ");
        h=scan.nextFloat();
        scan.close();

        height=(h*2.54f)/100; //convert to kg

        weight=(w*453.59f)/1000; //convert to 
        
        BMI = weight/(height*height);

        System.out.println("-----------------------");
        System.out.println("NAME : "+name);
        System.out.println("AGE : "+age);
        System.out.println("Weight : "+weight);
        System.out.println("Height : "+height);
        System.out.println("BMI : "+BMI);
    }
}
