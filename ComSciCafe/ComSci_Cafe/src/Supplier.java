public class Supplier {
    private String supplierID;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String phone;
    private String fax;

    // Constructor
    public Supplier(String supplierID, String companyName, String contactName, String contactTitle,
            String address, String city, String region, String postalCode,
            String country, String phone, String fax) {
        this.supplierID = supplierID;
        this.companyName = companyName;
        this.contactName = contactName;
        this.contactTitle = contactTitle;
        this.address = address;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.fax = fax;
    }

    // Getters and Setters
    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    // Business methods
    public String getContactInfo() {
        return contactName + " (" + contactTitle + ") - " + phone;
    }

    public boolean fulfillOrder(Purchase purchase) {
        // Logic to fulfill a purchase order
        System.out.println("Fulfilling order " + purchase.getOrderID() + " by " + companyName);
        return true; // Assuming order fulfillment is successful
    }

    public Supplier getSupplierById(String supplierID2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSupplierById'");
    }
}