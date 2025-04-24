package Test;

import java.util.Scanner;

class Customer {
    int height;
    int parkHours;
    int playItems;
    double parkFee;
    double playFee;
    double totalFee;

    public Customer(int height, int parkHours, int playItems) {
        this.height = height;
        this.parkHours = parkHours;
        this.playItems = playItems;
    }

    public void calculateParkFee() {
        if (height <= 90) {
            parkFee = 150;
        } else if (height <= 120) {
            parkFee = 250;
        } else if (height <= 150) {
            parkFee = 300;
        } else {
            parkFee = 350;
        }
        parkFee = parkFee * parkHours / 2.0;
    }

    public void calculatePlayFee() {
        if (playItems == 0) {
            if (height <= 90) {
                playFee = 100;
            } else if (height <= 120) {
                playFee = 150;
            } else if (height <= 150) {
                playFee = 200;
            } else {
                playFee = 300;
            }
        } else {
            playFee = playItems * 50;
        }
    }

    public void calculateTotalFee() {
        totalFee = parkFee + playFee;
    }

    public String[] getCustomerInfo() {
        String[] info = new String[7];
        info[0] = String.valueOf(height);
        info[1] = String.valueOf(parkHours);
        info[2] = String.valueOf(playItems == 0 ? "เหมา" : playItems);
        info[3] = String.format("%.2f", parkFee);
        info[4] = String.format("%.2f", playFee);
        info[5] = String.format("%.2f", totalFee);
        return info;
    }
}

public class KidDream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int numcustomer = scanner.nextInt();

        Customer[] customer = new Customer[numcustomer];
        String[][] customerData = new String[numcustomer][7];

        for (int i = 0; i < numcustomer; i++) {
            System.out.printf("\ncustomer %d\n", i + 1);
            System.out.print("Enter height (cm): ");
            int height = scanner.nextInt();
            System.out.print("Enter park hours: ");
            int parkHours = scanner.nextInt();
            System.out.print("Enter number of play items (0 if none): ");
            int playItems = scanner.nextInt();

            customer[i] = new Customer(height, parkHours, playItems);
            customer[i].calculateParkFee();
            customer[i].calculatePlayFee();
            customer[i].calculateTotalFee();

            customerData[i] = customer[i].getCustomerInfo();
        }

        System.out.println("\nVisitor Information:");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("No. |   Height   | Park Hours | Play Items |  Park Fee  |  Play Fee  | Total Fee");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = 0; i < numcustomer; i++) {
            System.out.printf("%-4d|", i + 1);
            for (int j = 0; j < 7; j++) {
                System.out.printf(" %-11s|", customerData[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------");
    
    }
}
