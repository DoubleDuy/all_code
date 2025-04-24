import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    // In-memory storage for services
    private static final Map<String, Menu> menuItems = new HashMap<>();
    private static final Map<String, Ingredient> ingredients = new HashMap<>();
    private static final Map<String, Supplier> suppliers = new HashMap<>();
    private static final Map<String, Employee> employees = new HashMap<>();
    private static final Map<String, Member> members = new HashMap<>();
    private static final Map<String, Order> orders = new HashMap<>();
    private static final Map<String, PaymentMethod> paymentMethods = new HashMap<>();
    private static final Map<String, Shipper> shippers = new HashMap<>();

    public static void main(String[] args) {
        // Initialize sample data
        initializeSampleData();

        // Display welcome message
        System.out.println("===================================");
        System.out.println("   ☕ COFFEE SHOP MANAGEMENT SYSTEM ☕");
        System.out.println("===================================");

        // Display main menu
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMAIN MENU:");
            System.out.println("1. Process New Order");
            System.out.println("2. View Menu");
            System.out.println("3. Manage Inventory");
            System.out.println("4. Process Purchase Order");
            System.out.println("5. View Reports");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    processNewOrder();
                    break;
                case "2":
                    viewMenu();
                    break;
                case "3":
                    manageInventory();
                    break;
                case "4":
                    processPurchaseOrder();
                    break;
                case "5":
                    viewReports();
                    break;
                case "0":
                    exit = true;
                    System.out.println("Thank you for using the Coffee Shop Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void initializeSampleData() {
        // Initialize menu items
        System.out.println("----------BEVERAGES----------");
        menuItems.put("M101", new Menu("M101", "Espresso", 0.0, 40.0, 0.0, 0.0, false));
        menuItems.put("M102", new Menu("M102", "Americano", 0.0, 50.0, 60.0, 0.0, false));
        menuItems.put("M103", new Menu("M103", "Cappuccino", 0.0, 50.0, 60.0, 70.0, false));
        menuItems.put("M104", new Menu("M104", "Latte", 0.0, 40.0, 45.0, 50.0, false));
        menuItems.put("M105", new Menu("M105", "Mocha", 0.0, 50.0, 55.0, 60.0, false));
        System.out.println("----------DESSERTS----------");
        menuItems.put("M201", new Menu("M201", "Chesse Cake", 50.0, 0.0, 0.0, 0.0, false));
        menuItems.put("M202", new Menu("M202", "Cookie", 30.0, 0.0, 0.0, 0.0, false));
        menuItems.put("M203", new Menu("M203", "Butter Croissant", 45.0, 0.0, 0.0, 0.0, false));
        menuItems.put("M204", new Menu("M204", "Browny", 45.0, 0.0, 0.0, 0.0, false));
        menuItems.put("M205", new Menu("M205", "Pumpkin Pie", 50.0, 0.0, 0.0, 0.0, false));

        // Initialize ingredients
        ingredients.put("I001", new Ingredient("I001", "Coffee Beans (Arabica)", "1kg bag", 450.0, 20, 10, 5, false));
        ingredients.put("I002", new Ingredient("I002", "Fresh Milk", "1L carton", 45.0, 50, 20, 10, false));
        ingredients.put("I003", new Ingredient("I003", "Sugar", "1kg bag", 35.0, 30, 0, 5, false));
        ingredients.put("I004", new Ingredient("I004", "Chocolate Syrup", "750ml bottle", 120.0, 10, 5, 3, false));

        // Initialize suppliers
        suppliers.put("S001", new Supplier("S001", "Premium Coffee Co.", "John Bean", "Sales Manager",
                "123 Coffee Road", "Bangkok", "Central", "10330", "Thailand", "02-123-4567", "02-123-4568"));
        suppliers.put("S002", new Supplier("S002", "Dairy Fresh", "Mary Milk", "Account Executive",
                "456 Dairy Street", "Bangkok", "Central", "10400", "Thailand", "02-234-5678", "02-234-5679"));

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Initialize employees
            employees.put("E001", new Employee("E001", "Somchai", "Jaidee", "Manager", 1, "Mr.",
                    dateFormat.parse("1985-05-15"), dateFormat.parse("2020-01-10"),
                    "123 Staff Road", "Bangkok", "Central", "10330", "Thailand", "081-111-1111"));
            employees.put("E002", new Employee("E002", "Somsri", "Rakdee", "Barista", 2, "Ms.",
                    dateFormat.parse("1990-10-20"), dateFormat.parse("2021-03-15"),
                    "456 Staff Road", "Bangkok", "Central", "10330", "Thailand", "082-222-2222"));

            // Initialize members
            members.put("MEM001", new Member("MEM001", "Wichai Customer", "089-333-3333"));
            members.put("MEM002", new Member("MEM002", "Wanida Regular", "089-444-4444"));
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }

        // Initialize payment methods
        paymentMethods.put("PM001", new PaymentMethod("PM001", "Cash"));
        paymentMethods.put("PM002", new PaymentMethod("PM002", "Credit Card"));
        paymentMethods.put("PM003", new PaymentMethod("PM003", "Mobile Banking"));

        // Initialize shippers
        shippers.put("SH001", new Shipper("SH001", "SpeedBike Delivery", "02-555-5555"));
        shippers.put("SH002", new Shipper("SH002", "CoffeeDash", "02-666-6666"));
    }

    private static void processNewOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== NEW ORDER =====");

        // Generate order ID
        String orderID = "ORD" + System.currentTimeMillis() % 10000;

        // Create a new order
        Order order = new Order(orderID, 1, new Date());

        // Select member
        System.out.println("\nSelect Member:");
        System.out.println("0. Guest (No Member)");
        List<Member> memberList = new ArrayList<>(members.values());
        for (int i = 0; i < memberList.size(); i++) {
            Member member = memberList.get(i);
            System.out.println((i + 1) + ". " + member.getMemberName() + " (" + member.getMemberID() + ")");
        }

        System.out.print("Enter choice: ");
        int memberChoice = Integer.parseInt(scanner.nextLine());

        if (memberChoice > 0 && memberChoice <= memberList.size()) {
            Member selectedMember = memberList.get(memberChoice - 1);
            order = selectedMember.placeOrder(order);
            System.out.println("Member selected: " + selectedMember.getMemberName());
            System.out.println("Applied member discount: " + (order.getMemberDiscount() * 100) + "%");
        } else {
            System.out.println("Proceeding as guest order");
        }

        // Add items to order
        boolean addingItems = true;
        while (addingItems) {
            System.out.println("\nAvailable Menu Items:");
            List<Menu> menuList = new ArrayList<>(menuItems.values());
            for (int i = 0; i < menuList.size(); i++) {
                Menu menu = menuList.get(i);
                if (menu.isAvailable()) {
                    System.out.println((i + 1) + ". " + menu.getMenuName());
                }
            }
            

            System.out.print("Select item (0 to finish): ");
            int itemChoice = Integer.parseInt(scanner.nextLine());

            if (itemChoice > 0 && itemChoice <= menuList.size()) {
                Menu selectedMenu = menuList.get(itemChoice - 1);

                // Select drink type
                System.out.println("Select drink type:");
                System.out.println("1. Hot (฿" + selectedMenu.getPriceByType("hot") + ")");
                System.out.println("2. Iced (฿" + selectedMenu.getPriceByType("iced") + ")");
                System.out.println("3. Frappe (฿" + selectedMenu.getPriceByType("frappe") + ")");

                System.out.print("Enter choice: ");
                int typeChoice = Integer.parseInt(scanner.nextLine());

                String drinkType;
                double price;

                switch (typeChoice) {
                    case 1:
                        drinkType = "hot";
                        break;
                    case 2:
                        drinkType = "iced";
                        break;
                    case 3:
                        drinkType = "frappe";
                        break;
                    default:
                        drinkType = "unitprice";
                        break;
                }
        
    
                price = selectedMenu.getPriceByType(drinkType);
                
                System.out.print("Enter quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                
                
            
                // Add to order
                OrderDetail detail = new OrderDetail(order.getOrderID(), selectedMenu.getMenuID(),
                        selectedMenu.getMenuName() + " (" + drinkType.substring(0, 1).toUpperCase() +
                                drinkType.substring(1) + ")",
                        price, quantity);

                order.addOrderDetail(detail);

                System.out.println("Added: " + quantity + "x " + detail.getMenuName() + " - ฿" +
                        detail.calculateSubtotal());

            } else {
                addingItems = false;
            }
        }

        // Display order summary
        System.out.println("\n----- ORDER SUMMARY -----");
        System.out.println("Order ID: " + order.getOrderID());
        System.out.println("Date: " + new Date());
        System.out.println("\nItems:");

        for (OrderDetail detail : order.getOrderDetails()) {
            System.out.println(detail.getQuantity() + "x " + detail.getMenuName() +
                    " - ฿" + detail.calculateSubtotal());
        }

        double total = order.calculateTotal();
        System.out.println("\nSubtotal: ฿" + order.getSubtotalPrice());

        if (order.getMemberDiscount() > 0) {
            System.out.println("Member Discount: ฿" + (order.getSubtotalPrice() * order.getMemberDiscount()));
        }

        System.out.println("VAT (7%): ฿" + order.getVat());
        System.out.println("TOTAL: ฿" + total);

        // Select employee who processed the order
        System.out.println("\nSelect Employee processing this order:");
        List<Employee> employeeList = new ArrayList<>(employees.values());
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            System.out.println((i + 1) + ". " + employee.getFullName() + " (" + employee.getTitle() + ")");
        }

        System.out.print("Enter choice: ");
        int employeeChoice = Integer.parseInt(scanner.nextLine());

        if (employeeChoice > 0 && employeeChoice <= employeeList.size()) {
            Employee selectedEmployee = employeeList.get(employeeChoice - 1);
            selectedEmployee.processOrder(order);
            System.out.println("Order processed by: " + selectedEmployee.getFullName());
        }

        // Process payment
        System.out.println("\nSelect Payment Method:");
        List<PaymentMethod> paymentList = new ArrayList<>(paymentMethods.values());
        for (int i = 0; i < paymentList.size(); i++) {
            PaymentMethod payment = paymentList.get(i);
            System.out.println((i + 1) + ". " + payment.getPaymentName());
        }

        System.out.print("Enter choice: ");
        int paymentChoice = Integer.parseInt(scanner.nextLine());

        if (paymentChoice > 0 && paymentChoice <= paymentList.size()) {
            PaymentMethod selectedPayment = paymentList.get(paymentChoice - 1);
            selectedPayment.processPayment(total);
            order.processPayment();
            System.out.println("Payment processed with: " + selectedPayment.getPaymentName());
            System.out.println("Order status: " + order.getOrderStatus());
        }

        // Save order to our in-memory storage
        orders.put(order.getOrderID(), order);

        System.out.println("\nOrder has been completed successfully!");
    }

    private static void viewMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("ID\tName\t\tUnitPrice\tHot\tIced\tFrappe\tStatus");
        System.out.println("----------------------------------------------------------");

        for (Menu item : menuItems.values()) {
            System.out.printf("%-5s\t%-15s\t%.2f\t%.2f\t%.2f\t%.2f\t%s\n",
                    item.getMenuID(),
                    item.getMenuName(),
                    item.getPriceByType("unitprice"),
                    item.getPriceByType("hot"),
                    item.getPriceByType("iced"),
                    item.getPriceByType("frappe"),
                    item.isAvailable() ? "Available" : "Discontinued");
        }
    }

    private static void manageInventory() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== INVENTORY MANAGEMENT =====");
        System.out.println("1. View Inventory");
        System.out.println("2. Update Stock");
        System.out.println("0. Back to Main Menu");

        System.out.print("Enter choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("\n----- CURRENT INVENTORY -----");
                System.out.println("ID\tName\t\tUnit\tPrice\tIn Stock\tOn Order\tReorder Level");
                System.out.println("-------------------------------------------------------------------------");

                for (Ingredient ingredient : ingredients.values()) {
                    System.out.printf("%-5s\t%-20s\t%-5s\t%.2f\t%d\t%d\t%d\n",
                            ingredient.getProductID(),
                            ingredient.getProductName(),
                            ingredient.getQtyPerUnit(),
                            ingredient.getUnitPrice(),
                            ingredient.getUnitsInStock(),
                            ingredient.getUnitsInOrder(),
                            ingredient.getReorderLevel());

                    if (ingredient.needsReorder()) {
                        System.out.println("⚠️ " + ingredient.getProductName() + " needs to be reordered!");
                    }
                }
                break;

            case "2":
                System.out.println("\n----- UPDATE STOCK -----");
                List<Ingredient> ingredientList = new ArrayList<>(ingredients.values());

                for (int i = 0; i < ingredientList.size(); i++) {
                    Ingredient ingredient = ingredientList.get(i);
                    System.out.println((i + 1) + ". " + ingredient.getProductName() +
                            " (Current stock: " + ingredient.getUnitsInStock() + ")");
                }

                System.out.print("Select ingredient to update (0 to cancel): ");
                int ingredientChoice = Integer.parseInt(scanner.nextLine());

                if (ingredientChoice > 0 && ingredientChoice <= ingredientList.size()) {
                    Ingredient selectedIngredient = ingredientList.get(ingredientChoice - 1);

                    System.out.print("Enter quantity change (+ to add, - to remove): ");
                    int quantityChange = Integer.parseInt(scanner.nextLine());

                    selectedIngredient.updateStock(quantityChange);
                    System.out.println("Stock updated successfully!");
                }
                break;

            case "0":
                return;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private static void processPurchaseOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== PURCHASE ORDER =====");

        // Generate purchase order ID
        String purchaseID = "PO" + System.currentTimeMillis() % 10000;

        // Select supplier
        System.out.println("\nSelect Supplier:");
        List<Supplier> supplierList = new ArrayList<>(suppliers.values());

        for (int i = 0; i < supplierList.size(); i++) {
            Supplier supplier = supplierList.get(i);
            System.out.println((i + 1) + ". " + supplier.getCompanyName() + " - " + supplier.getContactInfo());
        }

        System.out.print("Enter choice: ");
        int supplierChoice = Integer.parseInt(scanner.nextLine());

        if (supplierChoice <= 0 || supplierChoice > supplierList.size()) {
            System.out.println("Invalid supplier selection. Returning to main menu.");
            return;
        }

        Supplier selectedSupplier = supplierList.get(supplierChoice - 1);

        // Select ingredient to order
        System.out.println("\nSelect Ingredient to Order:");
        List<Ingredient> ingredientList = new ArrayList<>(ingredients.values());

        for (int i = 0; i < ingredientList.size(); i++) {
            Ingredient ingredient = ingredientList.get(i);
            System.out.println((i + 1) + ". " + ingredient.getProductName() +
                    " (Current stock: " + ingredient.getUnitsInStock() +
                    ", Unit Price: ฿" + ingredient.getUnitPrice() + ")");
        }

        System.out.print("Enter choice: ");
        int ingredientChoice = Integer.parseInt(scanner.nextLine());

        if (ingredientChoice <= 0 || ingredientChoice > ingredientList.size()) {
            System.out.println("Invalid ingredient selection. Returning to main menu.");
            return;
        }

        Ingredient selectedIngredient = ingredientList.get(ingredientChoice - 1);

        System.out.print("Enter quantity to order: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        if (quantity <= 0) {
            System.out.println("Invalid quantity. Returning to main menu.");
            return;
        }

        // Create purchase order
        Purchase purchase = new Purchase(
                purchaseID,
                new Date(),
                selectedSupplier.getSupplierID(),
                selectedIngredient.getProductID(),
                quantity,
                selectedIngredient.getUnitPrice());

        // Display purchase order summary
        System.out.println("\n----- PURCHASE ORDER SUMMARY -----");
        System.out.println("Purchase Order ID: " + purchase.getOrderID());
        System.out.println("Date: " + new Date());
        System.out.println("Supplier: " + selectedSupplier.getCompanyName());
        System.out.println("Product: " + selectedIngredient.getProductName());
        System.out.println("Quantity: " + quantity);
        System.out.println("Unit Price: ฿" + selectedIngredient.getUnitPrice());
        System.out.println("Total: ฿" + purchase.calculateTotal());

        // Confirm order
        System.out.print("\nConfirm purchase order? (Y/N): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {
            // Simulate order fulfillment
            boolean fulfilled = selectedSupplier.fulfillOrder(purchase);

            if (fulfilled) {
                // Update ingredient stock (in a real system this would happen when receiving
                // the order)
                selectedIngredient.updateStock(quantity);
                System.out.println("Purchase order has been placed successfully!");
            } else {
                System.out.println("Failed to place purchase order.");
            }
        } else {
            System.out.println("Purchase order cancelled.");
        }
    }

    private static void viewReports() {
        System.out.println("\n===== REPORTS =====");
        System.out.println("1. Sales Summary");
        System.out.println("2. Inventory Status");
        System.out.println("3. Popular Items");
        System.out.println("0. Back to Main Menu");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("\n----- SALES SUMMARY -----");
                if (orders.isEmpty()) {
                    System.out.println("No orders to display.");
                } else {
                    System.out.println("Order ID\tDate\t\tItems\tTotal");
                    System.out.println("------------------------------------------");

                    double totalSales = 0;
                    int totalOrders = 0;

                    for (Order order : orders.values()) {
                        System.out.printf("%-10s\t%tF\t%d\t฿%.2f\n",
                                order.getOrderID(),
                                order.getOrderDate(),
                                order.getOrderDetails().size(),
                                order.calculateTotal());

                        totalSales += order.calculateTotal();
                        totalOrders++;
                    }

                    System.out.println("------------------------------------------");
                    System.out.println("Total Orders: " + totalOrders);
                    System.out.println("Total Sales: ฿" + totalSales);
                    System.out.println("Average Order Value: ฿" + (totalOrders > 0 ? totalSales / totalOrders : 0));
                }
                break;

            case "2":
                System.out.println("\n----- INVENTORY STATUS -----");
                System.out.println("ID\tName\t\tStatus\t\tStock Level");
                System.out.println("--------------------------------------------------");

                for (Ingredient ingredient : ingredients.values()) {
                    String status;
                    if (ingredient.needsReorder()) {
                        status = "⚠️ Low Stock";
                    } else if (ingredient.isAvailable()) {
                        status = "✅ Available";
                    } else {
                        status = "❌ Unavailable";
                    }

                    System.out.printf("%-5s\t%-20s\t%-15s\t%d/%d\n",
                            ingredient.getProductID(),
                            ingredient.getProductName(),
                            status,
                            ingredient.getUnitsInStock(),
                            ingredient.getReorderLevel());
                }
                break;

            case "3":
                System.out.println("\n----- POPULAR ITEMS -----");
                System.out.println("This report would show statistics about the most ordered items.");
                System.out.println("(Requires order history database for accurate reporting)");
                break;

            case "0":
                return;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    // Helper inner classes for services

    // Service interface implementations
    static class MenuServiceImpl implements MenuService {
        @Override
        public Menu getMenuById(String menuID) {
            return menuItems.get(menuID);
        }

        public void addMenuItem(Menu menu) {
            menuItems.put(menu.getMenuID(), menu);
        }
    }

    // Additional getters for Order class that weren't in the original code
    static {
        // Using reflection to add these methods would be the proper way,
        // but for simplicity we'll assume they exist in the actual implementation
        // These methods would need to be added to the Order class
    }
}