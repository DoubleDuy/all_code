import java.util.Scanner;

public class emptyspace {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n;
            System.out.print("Size of arrays : ");
            n = scan.nextInt();
            String[][] products = new String[n][2];
            for (int i = 0; i < n; i++) {
                System.out.print("Number of products : ");
                products[i][0] = scan.next();
                System.out.print("Unitprice : ");
                products[i][1] = scan.next();
            }

            float totalprice = 0;
            for (int i = 0; i < n; i++) {
                totalprice += Float.parseFloat(products[i][1]) * Float.parseFloat(products[i][0]);
            }

            float vat, netprice;
            vat = totalprice * 0.07f;
            netprice = totalprice + vat;

            System.out.println("Totalprice is " + totalprice);
            System.out.println("VAT is " + vat);
            System.out.println("Net price is " + netprice);
        }
    }
}
