package ExerciseV;

import java.util.Scanner;

public record VIII() {
    public static void main(String[] args) {
        String name;
        int bathroom, othersroom;
        int bathroomprice, othersroomprice, priceI = 450, priceII = 300, serviceprice = 1200, totalprice;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name : ");
        name = sc.next();

        while (!name.equalsIgnoreCase("zzzz")) {
            System.out.print("Enter the number of bathrooms : ");
            bathroom = sc.nextInt();
            System.out.print("Enter the number of othersrooms : ");
            othersroom = sc.nextInt();

            bathroomprice = bathroom * priceI;

            othersroomprice = othersroom * priceII;

            totalprice = bathroomprice + othersroomprice + serviceprice;

            System.out.println("--------------");
            System.out.println("NAME : " + name);
            System.out.println("TOTALPRICE : " + totalprice);

            System.out.print("\n");
            System.out.print("Enter the name : ");
            name = sc.next();
        }
        System.out.println("END");
        sc.close();

    }
}
