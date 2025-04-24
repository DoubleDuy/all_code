public class App {
public static void main(String[] args) throws Exception {
        Employee i = new Employee(001, "Double", "Duy", 15000);
        System.out.println("ID :" + i.getID());
        System.out.println("NAME :" + i.getName());
        System.out.println("Salary :" + i.getSalary());
        System.out.println("AnnualSalary :" + i.getAnnualSalary());
        System.out.println("RaiseSalary :" + i.raiseSalary(10));
        System.out.println(i.toString());
    }
}
