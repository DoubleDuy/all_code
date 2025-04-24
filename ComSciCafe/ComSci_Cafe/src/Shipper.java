public class Shipper {
    private String shipID;
    private String shipName;
    private String phone;

    // Constructor
    public Shipper(String shipID, String shipName, String phone) {
        this.shipID = shipID;
        this.shipName = shipName;
        this.phone = phone;
    }

    // Getters and Setters
    public String getShipID() {
        return shipID;
    }

    public void setShipID(String shipID) {
        this.shipID = shipID;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    // Business methods
    public boolean deliverOrder(Order order) {
        // Logic to deliver an order
        System.out.println("Delivering order " + order.getOrderID() + " using " + shipName);
        return true; // Assuming delivery is successful
    }
}