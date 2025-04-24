public class OrderDetail {
    private String orderID;
    private String menuID;
    private String menuName;
    private double finalPrice;
    private int quantity;

    // Constructor
    public OrderDetail(String orderID, String menuID, String menuName, double finalPrice, int quantity) {
        this.orderID = orderID;
        this.menuID = menuID;
        this.menuName = menuName;
        this.finalPrice = finalPrice;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

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
        this.menuName = menuID;
    }

    public int getQuantity() {
        return quantity;
    }

    // Business methods
    public double calculateSubtotal() {
        return finalPrice * quantity;
    }

    public Menu getMenuItem(MenuService menuService) {
        // This would typically use a service to fetch the menu item
        return menuService.getMenuById(menuID);
    }
}