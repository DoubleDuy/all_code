import java.util.Date;

public class Purchase {
    private String orderID;
    private Date orderDate;
    private String supplierID;
    private String companyName;
    private String contactName;
    private String productID;
    private Date shippedDate;
    private String shipAddress;
    private String paymentID;
    private int quantity;
    private double unitPrice;
    private String employeeID;

    // Constructor
    public Purchase(String orderID, Date orderDate, String supplierID, String productID, int quantity,
            double unitPrice) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.supplierID = supplierID;
        this.productID = productID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Purchase(String purchaseID, Date orderDate2, String supplierID2, String productID2, int quantity2,
            String unitPrice2) {
        //TODO Auto-generated constructor stub
    }

    // Getters and Setters
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    // Business methods
    public double calculateTotal() {
        return quantity * unitPrice;
    }

    public Supplier getSupplier(Supplier supplierService) {
        // This would typically use a service to fetch the supplier
        return supplierService.getSupplierById(supplierID);
    }

    public Ingredient getProduct(Ingredient ingredientService) {
        // This would typically use a service to fetch the ingredient
        return ingredientService.getIngredientById(productID);
    }
}