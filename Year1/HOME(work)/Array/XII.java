package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Sale {
    String date;
    String time;
    int amount;
    int salespersonNumber;

    public Sale(String date, String time, int amount, int salespersonNumber) {
        this.date = date;
        this.time = time;
        this.amount = amount;
        this.salespersonNumber = salespersonNumber;
    }
}

class Salesperson {
    int number;
    String name;
    List<Sale> sales;

    public Salesperson(int number, String name) {
        this.number = number;
        this.name = name;
        this.sales = new ArrayList<>();
    }
}

public class VacationPropertySalesApp {
    public static void main(String[] args) {
        List<Salesperson> salespeople = initializeSalespeople();

        // Simulating sales data
        // Add your logic to populate actual sales data

        // Calculate and print total sales and commissions for each salesperson
        printTotalSalesAndCommissions(salespeople);

        // Calculate and print total sales for each month
        printTotalSalesByMonth(salespeople);

        // Calculate and print total sales and commissions based on the time of day
        printSalesAndCommissionsByTime(salespeople);
    }

    private static List<Salesperson> initializeSalespeople() {
        // Initialize salespeople with their numbers and names
        // You can add more salespeople as needed
        List<Salesperson> salespeople = new ArrayList<>();
        salespeople.add(new Salesperson(1, "John Doe"));
        salespeople.add(new Salesperson(2, "Jane Smith"));
        // Add more salespeople here...

        return salespeople;
    }

    private static void printTotalSalesAndCommissions(List<Salesperson> salespeople) {
        // Implement logic to calculate and print total sales and commissions for each
        // salesperson
    }

    private static void printTotalSalesByMonth(List<Salesperson> salespeople) {
        // Implement logic to calculate and print total sales for each month
    }

    private static void printSalesAndCommissionsByTime(List<Salesperson> salespeople) {
        // Implement logic to calculate and print total sales and commissions based on
        // the time of day
    }
}
