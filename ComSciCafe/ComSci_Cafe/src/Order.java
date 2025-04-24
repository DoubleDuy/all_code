import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Order {
    private String orderID;
    private int orderType;
    private Date orderDate;
    private String memberID;
    private String shipID;
    private String shipAddress;
    private double deliveryCost;
    private String employeeID;
    private String paymentID;
    private double subtotalPrice;
    private double discount;
    private double memberDiscount;
    private double totalPrice;
    private double vat;
    private char status;
    private List<OrderDetail> orderDetails;

    // Constructor
    public Order(String orderID, int orderType, Date orderDate) {
        this.orderID = orderID;
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.status = 'N'; // New order by default
        this.orderDetails = new ArrayList<>();
    }

    // Getters and Setters
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public double getMemberDiscount() {
        return memberDiscount;
    }

    public void setMemberDiscount(double memberDiscount) {
        this.memberDiscount = memberDiscount;
    }

    // Business methods
    public void addOrderDetail(OrderDetail detail) {
        orderDetails.add(detail);
        recalculateSubtotal();
    }

    public List<OrderDetail> getOrderDetails() {
        return new ArrayList<>(orderDetails);
    }

    private void recalculateSubtotal() {
        this.subtotalPrice = 0;
        for (OrderDetail detail : orderDetails) {
            this.subtotalPrice += detail.calculateSubtotal();
        }
    }

    public double calculateTotal() {
        double total = subtotalPrice;

        // Apply discounts
        double discountAmount = total * (discount / 100);
        double memberDiscountAmount = total * (memberDiscount / 100);
        total -= (discountAmount + memberDiscountAmount);

        // Add delivery cost
        total += deliveryCost;

        // Calculate VAT
        vat = total * 0.07; // Assuming 7% VAT
        total += vat;

        this.totalPrice = total;
        return total;
    }

    public void applyDiscount(double discountPercent) {
        this.discount = discountPercent;
        calculateTotal();
    }

    public String getOrderStatus() {
        switch (status) {
            case 'N':
                return "New";
            case 'P':
                return "Processing";
            case 'S':
                return "Shipped";
            case 'D':
                return "Delivered";
            case 'C':
                return "Completed";
            case 'X':
                return "Cancelled";
            default:
                return "Unknown";
        }
    }

    public boolean processPayment() {
        // Payment processing logic
        // Update status if payment successful
        status = 'P'; // Processing
        return true;
    }

    public Object getOrderDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrderDate'");
    }

    public String getVat() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVat'");
    }

    public double getSubtotalPrice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSubtotalPrice'");
    }
}