public class EmployeeType {
    private int employeeTypeID;
    private String titleOfCourtesy;
    private String employeeID;

    // Constructor
    public EmployeeType(int employeeTypeID, String titleOfCourtesy, String employeeID) {
        this.employeeTypeID = employeeTypeID;
        this.titleOfCourtesy = titleOfCourtesy;
        this.employeeID = employeeID;
    }

    // Getters and Setters
    public int getEmployeeTypeID() {
        return employeeTypeID;
    }

    public void setEmployeeTypeID(int employeeTypeID) {
        this.employeeTypeID = employeeTypeID;
    }

    public String getTitleOfCourtesy() {
        return titleOfCourtesy;
    }

    public void setTitleOfCourtesy(String titleOfCourtesy) {
        this.titleOfCourtesy = titleOfCourtesy;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
}