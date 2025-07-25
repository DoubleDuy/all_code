public class User {
    private String name;
    private String email;
    private String userID;
    private String department;

    public User(String name, String email, String userID, String department) {
        this.name = name;
        this.email = email;
        this.userID = userID;
        this.department = department;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}