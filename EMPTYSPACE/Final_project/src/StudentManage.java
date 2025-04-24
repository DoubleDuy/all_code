import java.util.Date;
import java.util.Scanner;

public class StudentManage {
    private LibraryManagement library;
    private Scanner scanner;
    private StudentLoan[] pendingLoans;
    private int pendingLoanCount;

    public StudentManage(LibraryManagement library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
        this.pendingLoans = new StudentLoan[10];
        this.pendingLoanCount = 0;
    }

    // สำหรับจัดการนักศึกษา
    public void handleStudent() {
        System.out.print("Please enter your Student ID[10]: ");
        String studentId = scanner.nextLine();
        
        // ค้นหานักศึกษาในระบบ
        Student existingStudent = library.findStudentById(studentId);
        if (existingStudent != null) {
            System.out.println("Welcome back, " + existingStudent.getName() + "!");
            showStudentMenu(existingStudent); // Show the student menu
            return;
        }

        // หากไม่พบนักศึกษาให้ลงทะเบียนใหม่
        System.out.print("Student not found. Please enter your name to register: ");
        String name = scanner.nextLine();

        // ตรวจสอบว่ามีนักศึกษาในระบบที่มีชื่อหรือรหัสนักศึกษาเดียวกันหรือไม่
        for (int i = 0; i < library.getCount(); i++) {
            Student student = library.getStudent(i);
            if (student != null && (student.getName().equals(name) || student.getStudentId().equals(studentId))) {
                System.out.println("Registration failed. A student with the same name or ID already exists.");
                return;
            }
        }

        System.out.print("Please enter your Academic Year: ");
        String academicYear = scanner.nextLine();
        System.out.print("Please enter your faculty: ");
        String faculty = scanner.nextLine();

        // เพิ่ม Student ใหม่ลงในระบบ
        Student newStudent = new Student(name, studentId, academicYear, faculty);
        library.addStudent(newStudent);
        DataManage.saveStudentDataToFile(newStudent); // บันทึกข้อมูลนักศึกษาไปยังไฟล์

        // แสดงข้อมูลนักศึกษา
        System.out.println("Student registered successfully.");
        System.out.println("\t");
        System.out.println("Student Information:");
        System.out.println("Name: " + newStudent.getName());
        System.out.println("Student ID: " + newStudent.getStudentId());
        System.out.println("Academic Year: " + newStudent.getAcademicYear());
        System.out.println("Faculty: " + newStudent.getfaculty());

        showStudentMenu(newStudent); // Show the student menu
    }

    // Method to show the student menu
    private void showStudentMenu(Student student) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Borrow Thesis");
            System.out.println("2. Return Thesis");
            System.out.println("3. View Thesis List");
            System.out.println("4. Find Thesis by ID");
            System.out.println("5. Find Thesis by Year");
            System.out.println("6. Find Thesis by Title");
            System.out.println("7. View Borrowed Thesis Status");
            System.out.println("8. Log Out");
            System.out.print("-----> ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    borrowThesis(student); // Call the method to borrow a thesis
                    break;
                case 2:
                    returnThesis(student); // Call the method to return a thesis
                    break;
                case 3:
                    displayAllTheses(); // Call the method to find thesis by ID
                    break;
                case 4:
                    findThesisById(); // Call the method to find thesis by Year
                    break;
                case 5:
                    findThesisByAcademicYear(); // Call the method to find thesis by Year
                    break;
                case 6:
                    findThesisByTitle(); // Call the method to find thesis by Title
                    break;
                case 7:
                    viewBorrowedThesisStatus(student); // Call the method to view borrowed thesis status

                    break;
                case 8:
                    exit = true; // Log out
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void displayAllTheses() {
        System.out.println("List of Theses:"); // แสดงหัวข้อ
        for (int i = 0; i < library.getCount(); i++) {
            Thesis thesis = library.getThesis(i);
            if (thesis != null) {
                System.out.println("ID: " + thesis.getId() + ", Title: " + thesis.getTitle() + ", Year: "
                        + thesis.getAcademicYear() + ", Faculty: " + thesis.getfaculty()); // แสดงข้อมูลวิทยานิพนธ์
            }
        }
    }
    
    private void findThesisById() {
        System.out.print("Please enter the Thesis ID: ");
        String thesisId = scanner.nextLine();
        Thesis thesis = library.findThesisById(thesisId);
        if (thesis != null) {
            System.out.println("Thesis Found: ID: " + thesis.getId() + ", Title: " + thesis.getTitle() +", Year:"+thesis.getAcademicYear() + ", Faculty: " + thesis.getfaculty());
        } else {
            System.out.println("No thesis found with ID: " + thesisId);
        }
    }

    private void findThesisByAcademicYear() {
        System.out.print("Please enter the Thesis Year: ");
        String thesisYear = scanner.nextLine();
        Thesis thesis = library.findThesisByAcademicYear(thesisYear);
        if (thesis != null) {
            System.out.println("Thesis Found: ID: " + thesis.getId() + ", Title: " + thesis.getTitle() +", Year: " + thesis.getAcademicYear() + ", Faculty: " + thesis.getfaculty());
        } else {
            System.out.println("No thesis found with Year: " + thesisYear);
        }
    }

    // Method to find thesis by Title
    private void findThesisByTitle() {
        System.out.print("Please enter the Thesis Title: ");
        String thesisTitle = scanner.nextLine();
        Thesis thesis = library.findThesisByTitle(thesisTitle);
        if (thesis != null) {
            System.out.println("Thesis Found: ID: " + thesis.getId() + ", Title: " + thesis.getTitle() + ", Year: "
                    + thesis.getAcademicYear() + ", Faculty: " + thesis.getfaculty());
        } else {
            System.out.println("No thesis found with Title: " + thesisTitle);
        }
    }
    
    private void viewBorrowedThesisStatus(Student student) {
    System.out.println("\n--- Borrowed Thesis Status ---");
    boolean hasLoans = false;
    for (int i = 0; i < pendingLoanCount; i++) {
        if (pendingLoans[i].getStudentId().equals(student.getStudentId())) {
            // Check if the loan is approved
            if (pendingLoans[i].isApproved()) {
                System.out.println("Thesis ID: " + pendingLoans[i].getThesis().getId() +
                        ", Title: " + pendingLoans[i].getThesis().getTitle() +
                        ", Status: (Already Approved)");
            } else {
                System.out.println("Thesis ID: " + pendingLoans[i].getThesis().getId() +
                        ", Title: " + pendingLoans[i].getThesis().getTitle() +
                        ", Status: (waiting for Approval)");
            }
            hasLoans = true;
        }
    }
    if (!hasLoans) {
        System.out.println("You have no loans.");
    }
}
    
    // Method to borrow a thesis
    private void borrowThesis(Student student) {
        System.out.println("\t");
        System.out.println("Select a thesis to borrow:");

        // แสดงวิทยานิพนธ์ที่สามารถยืมได้ตามคณะของนักศึกษา
        boolean thesisFound = false; // ตัวแปรเพื่อตรวจสอบว่าพบวิทยานิพนธ์หรือไม่
        for (int i = 0; i < library.getCount(); i++) {
            Thesis thesis = library.getThesis(i);
            if (thesis.isAvailable() && thesis.getfaculty().equals(student.getfaculty())) {
                System.out.println(thesis.getId() + ": " + thesis.getTitle()); // แสดงรหัสและชื่อวิทยานิพนธ์
                thesisFound = true; // พบวิทยานิพนธ์ที่สามารถยืมได้
            }
        }

        if (!thesisFound) {
            System.out.println("No theses available for borrowing according to the student's faculty ."); // แสดงข้อความหากไม่พบวิทยานิพนธ์
            return; // ออกจากเมธอด
        }

        System.out.println("\t");
        System.out.print("Please enter the Thesis ID to borrow: "); // ขอให้ผู้ใช้กรอกรหัสวิทยานิพนธ์
        String id = scanner.nextLine();
        Thesis thesisToBorrowI = library.findThesisById(id);

        //ID
        // ตรวจสอบว่าวิทยานิพนธ์สามารถยืมได้หรือไม่
        if (thesisToBorrowI != null) {
            // ตรวจสอบว่ามีการยืมวิทยานิพนธ์นี้ไปแล้วหรือไม่
            for (int i = 0; i < pendingLoanCount; i++) {
                if (pendingLoans[i].getThesis().getId().equals(thesisToBorrowI.getId()) &&
                        pendingLoans[i].getStudentId().equals(student.getStudentId())) {
                    System.out.println("You have already requested to borrow this thesis."); // แจ้งว่านักศึกษาได้ทำการยืมไปแล้ว
                    return; // ออกจากเมธอด
                }
            }

            if (thesisToBorrowI.isAvailable() && thesisToBorrowI.getfaculty().equals(student.getfaculty())) {
                // สร้าง StudentLoan object
                StudentLoan loan = new StudentLoan("L" + (library.getLoans().length + 1),
                        student.getStudentId(),
                        thesisToBorrowI,
                        new Date(), // วันที่ปัจจุบัน
                        student.getName(),
                        "Your Course Here"); // กำหนดหลักสูตร

                // บันทึกการยืมที่รอการอนุมัติในอาร์เรย์
                if (pendingLoanCount < pendingLoans.length) {
                    pendingLoans[pendingLoanCount] = loan; // เพิ่มการยืมในอาร์เรย์
                    pendingLoanCount++; // เพิ่มตัวนับ
                    System.out.println(
                            "Thesis ID " + id + " has been noted. You can request approval from the professor later.");
                } else {
                    System.out.println("Cannot store more pending loans.");
                }
            } else {
                System.out.println("Cannot borrow this thesis due to incorrect faculty."); // แสดงข้อความหากคณะไม่ตรงกัน
            }
        } else {
            System.out.println("No thesis found with this ID."); // แสดงข้อความหากไม่พบวิทยานิพนธ์
        }
    }

    private void returnThesis(Student student) {
        System.out.println("\t");
        System.out.println("Select a thesis to return:");

        // Display borrowed theses
        boolean thesisFound = false; // Variable to check if any thesis is found
        for (int i = 0; i < library.getLoans().length; i++) {
            StudentLoan loan = library.getLoans()[i];
            if (loan != null && loan.getStudentId().equals(student.getStudentId())) {
                System.out
                        .println("Thesis ID: " + loan.getThesis().getId() + ", Title: " + loan.getThesis().getTitle());
                thesisFound = false; // Thesis found
            }
        }

        if (thesisFound) {
            System.out.println("You have no borrowed theses to return."); // Message if no theses found
            return; // Exit the method
        }

        System.out.print("Please enter the Thesis ID to return: "); // Prompt for Thesis ID
        String thesisId = scanner.nextLine();
        Thesis thesisToReturn = library.findThesisById(thesisId); // Find the thesis by ID

        if (thesisToReturn != null) {
            // Check if the thesis is currently borrowed by the student
            boolean isBorrowed = false;
            for (StudentLoan loan : library.getLoans()) {
                if (loan != null && loan.getThesis().getId().equals(thesisId)
                        && loan.getStudentId().equals(student.getStudentId())) {
                    isBorrowed = true; // Thesis is borrowed by the student
                    break;
                }
            }

            if (isBorrowed) {
                thesisToReturn.returnThesis(); // Call the return method in Thesis class
                System.out.println("Thesis ID " + thesisId + " has been returned successfully."); // Success message
            } else {
                System.out.println("This thesis was not borrowed by you."); // Error message
            }
        } else {
            System.out.println("No thesis found with this ID."); // Error message if thesis not found
        }
    }
}