public class PaymentMethod {
    private String paymentID;
    private String paymentName;

    // Constructor
    public PaymentMethod(String paymentID, String paymentName) {
        this.paymentID = paymentID;
        this.paymentName = paymentName;
    }

    // Getters and Setters
    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    // Business methods
    public boolean processPayment(double amount) {
        // Payment processing logic based on payment type
        System.out.println("Processing payment of " + amount + " using " + paymentName);
        return true; // Assuming payment is successful
    }
}