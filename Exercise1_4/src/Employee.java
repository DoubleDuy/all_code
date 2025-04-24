public class Employee {
    private int id;
    private String FirstName;
    private String LastName;
    private int Salary;

    public Employee(int id, String FirstName, String LastName, int Salary) {
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Salary = Salary;
    }
    
    public int getID() {
        return id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getName() {
        return FirstName + " " + LastName;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public int getAnnualSalary() {
        return Salary * 12;
    }

    public int raiseSalary(int percent) {
        int newSalary = (Salary * percent) / 100;
        return newSalary;
    }

    public String toString() {
        return "Employee "+id+" "+getName()+" "+Salary;
    }
}
