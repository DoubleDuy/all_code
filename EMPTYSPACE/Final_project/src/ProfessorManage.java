import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ProfessorManage {
    private LibraryManagement library;
    private Scanner scanner;

    public ProfessorManage(LibraryManagement library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    // สำหรับลงทะเบียนอาจารย์
    public void registerProfessor() {
        System.out.println("\t");
        System.out.print("Please enter your name: ");
        String professorName = scanner.nextLine();
        System.out.print("Please enter your password: ");
        String professorPass = scanner.nextLine();

        // สร้าง Professor ใหม่
        Professor newProfessor = new Professor(professorName, professorPass);
        DataManage.saveProfessorDataToFile(newProfessor); // บันทึกข้อมูลอาจารย์ไปยังไฟล์

        System.out.println("Professor registered successfully.");
    }

    // เข้าสู่ระบบ
    public boolean loginProfessor() {
        System.out.println("\t");
        System.out.print("Please enter your name: ");
        String professorName = scanner.nextLine();
        System.out.print("Please enter your password: ");
        String password = scanner.nextLine();

        // ตรวจสอบว่าข้อมูลประจำตัวของอาจารย์ถูกต้องหรือไม่
        if (DataManage.checkProfessorCredentials(professorName, password)) {
            System.out.println("Login successful. Welcome, " + professorName + "!");
            return true;
        } else {
            System.out.println("Invalid credentials. Please try again.");
            return false;
        }
    }

    // ฟังก์ชันสำหรับแสดงวิทยานิพนธ์ทั้งหมด
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

    // แสดงวิทยานิพนธ์ทั้งหมด
    public void listAllTheses() {
        System.out.println("All Theses in the Library:"); // แสดงหัวข้อ
        displayAllTheses(); // เรียกใช้เพื่อแสดงวิทยานิพนธ์
    }

    // ฟังก์ชันสำหรับแสดงวิทยานิพนธ์ที่ถูกยืม
    private void listBorrowedTheses() {
        System.out.println("\t");
        System.out.println("Borrowed Theses:"); // แสดงหัวข้อ
        for (StudentLoan loan : library.getLoans()) {
            if (loan != null) {
                Thesis thesis = loan.getThesis();
                System.out.println("Thesis ID: " + thesis.getId() + ", Title: " + thesis.getTitle() + ", Borrowed by: "
                        + loan.getStudentName());
                System.out.println("Loan Date: " + loan.getLoanDate());

                // ตรวจสอบวันครบกำหนดการยืม
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(loan.getLoanDate());
                calendar.add(Calendar.DAY_OF_MONTH, 30); // เพิ่ม 30 วัน
                Date dueDate = calendar.getTime();

                System.out.println("Due Date: " + dueDate); // แสดงวันครบกำหนด
            }
        }
    }

    // เมธอดสำหรับจัดการวิทยานิพนธ์
    public void manageThesis() {
        boolean continueManaging = true;
        while (continueManaging) {
            System.out.println("\t");
            System.out.println("Select action:");
            System.out.println("1. Add Thesis: ");
            System.out.println("2. Edit Thesis: ");
            System.out.println("3. Delete Thesis: ");
            System.out.println("4. Allow Thesis Loan: ");
            System.out.println("5. List Borrowed Theses: ");
            System.out.println("6. List All Theses: ");
            System.out.println("7. Exit: ");
            System.out.print("-----> ");
            int actionChoice = scanner.nextInt();
            scanner.nextLine();

            switch (actionChoice) {
                case 1:
                    addThesis(); // ใช้สำหรับเพิ่มวิทยานิพนธ์
                    break;
                case 2:
                    editThesis(); // ใช้สำหรับแก้ไขวิทยานิพนธ์
                    break;
                case 3:
                    deleteThesis(); // ใช้สำหรับลบวิทยานิพนธ์
                    break;
                case 4:
                    manageThesisLoan(); // ใช้สำหรับอนุญาตให้ยืมวิทยานิพนธ์
                    break;
                case 5:
                    listBorrowedTheses(); // แสดงวิทยานิพนธ์ที่ถูกยืม
                    break;
                case 6:
                    listAllTheses(); // แสดงวิทยานิพนธ์ทั้งหมด
                    break;
                case 7:
                    continueManaging = false; // ออกจากการจัดการ
                    break;
                default:
                    System.out.println("Invalid choice. Please try again."); // ข้อความเมื่อเลือกไม่ถูกต้อง
            }
        }
    }

    // สำหรับเพิ่มวิทยานิพนธ์
    public void addThesis() {
        System.out.println("\t");
        System.out.print("Please enter the Thesis ID: ");
        String thesisId = scanner.nextLine();
        System.out.print("Please enter the Thesis Title: ");
        String thesisTitle = scanner.nextLine();
        System.out.print("Please enter the Academic Year: ");
        String academicYear = scanner.nextLine();
        System.out.print("Please enter the faculty: ");
        String faculty = scanner.nextLine();

        Thesis newThesis = new Thesis(thesisId, thesisTitle, academicYear, faculty);
        library.addThesis(newThesis); // เพิ่มวิทยานิพนธ์ใน LibraryManagement

        // อัปเดตไฟล์หลังจากเพิ่ม
        DataManage.updateThesisDataInFile(library);
        System.out.println("Thesis added successfully.");
    }

    // สำหรับแก้ไขวิทยานิพนธ์
    public void editThesis() {
        System.out.println("\t");
        System.out.print("Please enter the Thesis ID to edit: "); // ขอรหัสวิทยานิพนธ์ที่ต้องการแก้ไข
        String thesisId = scanner.nextLine();
        Thesis thesisToEdit = library.findThesisById(thesisId);

        if (thesisToEdit != null) {
            System.out.print("Enter new Thesis Title: "); // ขอชื่อวิทยานิพนธ์ใหม่
            String newTitle = scanner.nextLine();
            thesisToEdit.setTitle(newTitle); // อัปเดตชื่อวิทยานิพนธ์

            System.out.print("Enter new Year: "); // ขอปีใหม่
            String newYear = scanner.nextLine();
            thesisToEdit.setAcademicYear(newYear); // อัปเดตคณะ

            System.out.print("Enter new faculty: "); // ขอคณะใหม่
            String newFaculty = scanner.nextLine();
            thesisToEdit.setfaculty(newFaculty); // อัปเดตคณะ

            // อัปเดตข้อมูลวิทยานิพนธ์ในไฟล์
            DataManage.updateThesisDataInFile(library); // เรียกใช้เมธอดสำหรับอัปเดตไฟล์
            System.out.println("Thesis updated successfully."); // แสดงข้อความเมื่อแก้ไขสำเร็จ
        } else {
            System.out.println("Thesis not found."); // แสดงข้อความหากไม่พบวิทยานิพนธ์
        }
    }

    // สำหรับลบวิทยานิพนธ์
    public void deleteThesis() {
        System.out.println("\t");
        System.out.print("Please enter the Thesis ID to delete: "); // ขอรหัสวิทยานิพนธ์ที่ต้องการลบ
        String thesisId = scanner.nextLine();
        Thesis thesisToDelete = library.findThesisById(thesisId); // ค้นหาวิทยานิพนธ์ตามรหัส

        if (thesisToDelete != null) {
            library.removeThesis(thesisToDelete); // ลบวิทยานิพนธ์ออกจากระบบ
            DataManage.updateThesisDataInFile(library); // ใช้สำหรับอัปเดตไฟล์
            System.out.println("Thesis deleted successfully."); // แสดงข้อความเมื่อลบสำเร็จ
        } else {
            System.out.println("Thesis not found."); // แสดงข้อความหากไม่พบวิทยานิพนธ์
        }
    }

    // สำหรับอนุญาตให้ยืมวิทยานิพนธ์และยืนยันการยืม
    public void manageThesisLoan() {
        // แสดงรายชื่อนักศึกษาในระบบ
        System.out.println("Students who want to borrow a thesis:");
        for (int i = 0; i < library.getCount(); i++) {
            Thesis thesis = library.getThesis(i);
            Student s = library.getStudent(i);
            if (s != null) {
                System.out.println((i + 1) + ". ID: " + s.getStudentId() + ", Name: " + s.getName() + ", Thesis ID: "
                        + thesis.getId() + ", Title: " + thesis.getTitle() + ", Year: " + thesis.getAcademicYear());
                System.out.print("\t");
            }
        }

        // ให้ผู้ใช้เลือกนักศึกษา
        System.out.print("Please enter the number corresponding to the student who wants to borrow a thesis: ");
        int studentChoice = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        if (studentChoice > 0 && studentChoice <= library.getCount()) {
            Student selectedStudent = library.getStudent(studentChoice - 1); // เลือกนักศึกษา
            System.out.print("Please enter the Thesis ID to borrow: ");
            String thesisId = scanner.nextLine();
            Thesis thesisToLoan = library.findThesisById(thesisId);
            if (thesisToLoan != null) {
                // ตรวจสอบว่าวิทยานิพนธ์สามารถยืมได้หรือไม่
                if (!thesisToLoan.isAvailable()) {
                    System.out.println("This thesis is not available for loan.");
                    return;
                }

                // สร้างการยืม
                StudentLoan loan = new StudentLoan("L" + (library.getLoans().length + 1),
                        selectedStudent.getStudentId(),
                        thesisToLoan,
                        new Date(),
                        selectedStudent.getName(),
                        selectedStudent.getfaculty());

                // Approve the loan
                if (loginProfessor()) { // Use the existing instance
                    loan.approveLoan();
                    System.out.println("Loan request approved by professor.");
                    library.addLoan(loan);
                    // Save loan data
                    try {
                        DataManage.saveLoanDataToFile(loan);
                        DataManage.saveApprovedLoan(loan);
                        System.out.println("Thesis ID " + thesisId + " has been approved for borrowing.");
                    } catch (Exception e) {
                        System.out.println("An unexpected error occurred: " + e.getMessage());
                    }
                } else {
                    System.out.println("Invalid professor credentials. Loan request denied.");
                }
            }
        }
    }
}
