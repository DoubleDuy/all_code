package ExerciseV;

import java.util.Scanner;

public class III {
    public static void main(String[] args) {
        int serviceprice = 299,calloutminute,calloutprice=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the callout minute : ");
        calloutminute=sc.nextInt();
        sc.close();

        if (calloutminute > 200) {
            calloutprice = serviceprice + ((calloutminute - 200) * 3);
        }
        
        System.out.print(calloutprice);
    }
}
