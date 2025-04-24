import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IntellectuaThesis system = new IntellectuaThesis();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        system.addStudent("Nuy", "nuy@gmail.com", "6604800008", "CS");
        system.addProfessor("John Alex", "john@gmail.com", "P001", "CS");
        system.addThesis("T001", "Machine Learning", 2023, "Alice");

        while (running) {
            System.out.println("\n--- Intellectua Thesis Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Professor");
            System.out.println("3. Add Thesis");
            System.out.println("4. Borrow Thesis");
            System.out.println("5. Return Thesis");
            System.out.println("6. View Borrow Records");
            System.out.println("7. Remove Student");
            System.out.println("8. Remove Professor");
            System.out.println("9. Remove Thesis");
            System.out.println("10. Search Thesis by Year");
            System.out.println("11. Search Thesis by Title");
            System.out.println("12. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Student ID: ");
                    String userID = scanner.nextLine();
                    System.out.print("Enter Student Department: ");
                    String department = scanner.nextLine();
                    system.addStudent(name, email, userID, department);
                    System.out.println("Student added successfully.");
                }
                case 2 -> {
                    System.out.print("Enter Professor Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Professor Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Professor ID: ");
                    String userID = scanner.nextLine();
                    System.out.print("Enter Professor Department: ");
                    String department = scanner.nextLine();
                    system.addProfessor(name, email, userID, department);
                    System.out.println("Professor added successfully.");
                }
                case 3 -> {
                    System.out.print("Enter Thesis ID: ");
                    String thesisID = scanner.nextLine();
                    System.out.print("Enter Thesis Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Thesis Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Thesis Author: ");
                    String author = scanner.nextLine();
                    system.addThesis(thesisID, title, year, author);
                    System.out.println("Thesis added successfully.");
                }
                case 4 -> {
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.nextLine();
                    System.out.print("Enter Thesis ID: ");
                    String thesisID = scanner.nextLine();
                    System.out.print("Enter Professor ID: ");
                    String professorID = scanner.nextLine();
                    String result = system.borrowThesis(studentID, thesisID, professorID);
                    System.out.println(result);
                }
                case 5 -> {
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.nextLine();
                    System.out.print("Enter Thesis ID: ");
                    String thesisID = scanner.nextLine();
                    String result = system.returnThesis(studentID, thesisID);
                    System.out.println(result);
                }
                case 6 -> {
                    System.out.println("\n--- Borrow Records ---");
                for (Loan loan : system.getBorrowRecords()) {
                    System.out.println("Loan ID: " + loan.getBorrowedID()
                    + ", Student: " + loan.getStudent().getName()
                    + ", Thesis: " + loan.getThesis().getTitle()
                    + ", Borrowed Date: " + loan.getBorrowedDate()
                    + ", Return Date: " + (loan.getReturnDate() != null ? loan.getReturnDate() : "Not Returned")
                    + ", Status: " + (loan.getReturnDate() == null ? "Borrowed" : "Returned"));
                    }
                }
                case 7 -> {
                    System.out.print("Enter Student ID to Remove: ");
                    String userID = scanner.nextLine();
                    system.removeStudent(userID);
                    System.out.println("Student removed successfully.");
                }
                case 8 -> {
                    System.out.print("Enter Professor ID to Remove: ");
                    String userID = scanner.nextLine();
                    system.removeProfessor(userID);
                    System.out.println("Professor removed successfully.");
                }
                case 9 -> {
                    System.out.print("Enter Thesis ID to Remove: ");
                    String thesisID = scanner.nextLine();
                    system.removeThesis(thesisID);
                    System.out.println("Thesis removed successfully.");
                }
                
                case 10 -> {
                    System.out.print("Enter the year to search theses: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("\n--- Theses Found by Year " + year + " ---");
                    for (Thesis thesis : system.searchThesisByYear(year)) {
                        System.out.println("Thesis ID: " + thesis.getThesisID()
                                + ", Title: " + thesis.getTitle()
                                + ", Author: " + thesis.getAuthor());
                    }
                }
                case 11 -> {
                    System.out.print("Enter the title to search theses: ");
                    String title = scanner.nextLine();
                    System.out.println("\n--- Theses Found by Title \"" + title + "\" ---");
                    for (Thesis thesis : system.searchThesisByTitle(title)) {
                        System.out.println("Thesis ID: " + thesis.getThesisID()
                                + ", Title: " + thesis.getTitle()
                                + ", Author: " + thesis.getAuthor()
                                + ", Year: " + thesis.getYear());
                    }
                }
                case 12 -> {
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}