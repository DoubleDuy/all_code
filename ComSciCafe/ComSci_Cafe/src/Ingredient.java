public class Ingredient {
    private String productID;
    private byte[] picture;
    private String productName;
    private String qtyPerUnit;
    private double unitPrice;
    private int unitsInStock;
    private int unitsInOrder;
    private int reorderLevel;
    private boolean discontinued;
    private char status;

    // Constructor
    public Ingredient(String productID, String productName, String qtyPerUnit, double unitPrice,
            int unitsInStock, int unitsInOrder, int reorderLevel, boolean discontinued) {
        this.productID = productID;
        this.productName = productName;
        this.qtyPerUnit = qtyPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.unitsInOrder = unitsInOrder;
        this.reorderLevel = reorderLevel;
        this.discontinued = discontinued;
        this.status = 'A'; // Active by default
    }

    // Getters and Setters
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Business methods
    public void updateStock(int quantity) {
        this.unitsInStock += quantity;
        if (quantity < 0) {
            // If quantity is negative, we're using ingredients
            System.out.println("Used " + (-quantity) + " units of " + productName);
        } else {
            // If quantity is positive, we're restocking
            System.out.println("Restocked " + quantity + " units of " + productName);
        }
    }

    public boolean isAvailable() {
        return !discontinued && unitsInStock > 0 && status == 'A';
    }

    public boolean needsReorder() {
        return unitsInStock <= reorderLevel;
    }

    public Ingredient getIngredientById(String productID2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIngredientById'");
    }

    public Object getReorderLevel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReorderLevel'");
    }

    public Object getUnitsInStock() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUnitsInStock'");
    }

    public String getUnitPrice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUnitPrice'");
    }

    public Object getUnitsInOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUnitsInOrder'");
    }

    public Object getQtyPerUnit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQtyPerUnit'");
    }
}