public class Member {
    private String memberID;
    private String memberName;
    private String phone;

    // Constructor
    public Member(String memberID, String memberName, String phone) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.phone = phone;
    }

    // Getters and Setters
    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Business methods
    public Order placeOrder(Order order) {
        order.setMemberID(this.memberID);
        double discount = calculateDiscount();
        order.setMemberDiscount(discount);
        return order;
    }

    public double calculateDiscount() {
        // Logic to calculate member discount
        return 0.05; // Example: 5% discount for members
    }
}