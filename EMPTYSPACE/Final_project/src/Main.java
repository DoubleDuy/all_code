import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement(); // Initialize the library
        Scanner scanner = new Scanner(System.in);

        // ตรวจสอบและสร้างไฟล์ approved_loans.txt หากไม่พบ
        DataManage.checkAndCreateApprovedLoansFile();

        // Load data from files
        DataManage.loadDataFromFile(library);
        DataManage.loadStudentDataFromFile(library); // Load all data including students, theses, and loans

        // Create managers
        StudentManage studentManager = new StudentManage(library, scanner);
        ProfessorManage professorManager = new ProfessorManage(library, scanner);

        // Run application
        boolean running = true; // Flag to control the main loop
        while (running) {
            System.out.println("\t");
            System.out.println("----------------------------");
            System.out.println("Select user type:");
            System.out.println("1. Student");
            System.out.println("2. Professor");
            System.out.print("-----> ");
            int userType = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (userType) {
                case 1:
                    studentManager.handleStudent(); // Handle student actions
                    break;
                case 2:
                    System.out.print("Please enter the password: ");
                    String password = scanner.nextLine();

                    if (password.equals("cs")) { // Check password
                        boolean continueProfessor = true;
                        while (continueProfessor) {
                            System.out.println("\t");
                            System.out.println("-------------------------");
                            System.out.println("1. Register as Professor");
                            System.out.println("2. Login as Professor");
                            System.out.println("3. Exit");
                            System.out.print("-----> ");
                            int professorChoice = scanner.nextInt();
                            scanner.nextLine(); // Clear the buffer

                            switch (professorChoice) {
                                case 1:
                                    professorManager.registerProfessor(); // Register a new professor
                                    break;
                                case 2:
                                    if (professorManager.loginProfessor()) { // Login professor
                                        professorManager.manageThesis(); // Go to thesis management
                                        continueProfessor = false; // Exit the loop after managing thesis
                                    }
                                    break;
                                case 3:
                                    continueProfessor = false; // Exit the professor options
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again."); // Handle invalid input
                            }
                        }
                    } else {
                        System.out.println("Incorrect password. Access denied."); // Handle incorrect password
                    }
                    break;
                default:
                    System.out.println("Invalid user type. Please select 1 for Student or 2 for Professor."); // Handle invalid user type
            }
        }
        scanner.close(); // Close the scanner
    }
}