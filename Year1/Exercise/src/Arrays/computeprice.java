package Arrays;

import java.util.Scanner;

public class computeprice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float totalprice = 0;
        int amount, i;
        String ID;
        boolean found = false;
        String[] product = new String[] { "P01", "P02", "P03", "P04", "P05" };
        float[] price = new float[] { 100f, 125f, 75.50f, 25.75f, 300f };

        System.out.print("Input product ID :");
        ID = scan.next();
        System.out.print("Input amount :");
        amount = scan.nextInt();

        for (i = 0; i < product.length; i++) {
            if (product[i].equals(ID)) {
                found = true;
                totalprice = amount * price[i];
                break;
            }

            scan.close();
        }
        if (found = true) {
            System.out.println("Total Price is: " + totalprice);
        } else {
            System.out.println("Product ID " + ID + " is invalid");
        }
    }
}
