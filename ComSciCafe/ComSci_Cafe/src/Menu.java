public class Menu {
    private String menuID;
    private String menuName;
    private double unitPrice;
    private double hotUnitPrice;
    private double icedUnitPrice;
    private double frappeUnitPrice;
    private boolean discontinued;

    // Constructor
    public Menu(String menuID, String menuName, double unitPrice, double hotUnitPrice,
            double icedUnitPrice, double frappeUnitPrice, boolean discontinued) {
        this.menuID = menuID;
        this.menuName = menuName;
        this.unitPrice = unitPrice;
        this.hotUnitPrice = hotUnitPrice;
        this.icedUnitPrice = icedUnitPrice;
        this.frappeUnitPrice = frappeUnitPrice;
        this.discontinued = discontinued;
    }

    // Getters and Setters
    public String getMenuID() {
        return menuID;
    }

    public void setMenuID(String menuID) {
        this.menuID = menuID;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    // Business methods
    public double getPriceByType(String type) {
        switch (type.toLowerCase()) {
            case "hot":
                return hotUnitPrice;
            case "iced":
                return icedUnitPrice;
            case "frappe":
                return frappeUnitPrice;
            default:
                return unitPrice;
        }
    }

    public boolean isAvailable() {
        return !discontinued;
    }
}