import java.util.Date;
import java.util.Scanner;

public class StudentLoan extends Loan {
    private String studentName;
    private String course;
    private boolean isApproved; // ฟิลด์สำหรับสถานะการอนุมัติ
    private boolean approved;

    public StudentLoan(String id, String studentId, Thesis thesis, Date loanDate, String studentName, String course) {
        super(id, studentId, thesis, loanDate);
        this.studentName = studentName;
        this.course = course;
        this.isApproved = false; // เริ่มต้นสถานะเป็นไม่อนุมัติ
    }

    public void approveLoan() {
    this.isApproved = true; // Set the approval status to true
    System.out.println("Loan approved for student ID: " + this.studentId);
}

    public boolean isApproved() {
        return isApproved; // เมธอดสำหรับตรวจสอบสถานะการอนุมัติ
    }

    // เพิ่มเมธอดเพื่อแสดงข้อมูลการยืม
    public void displayLoanInfo() {
        System.out.println("Loan ID: " + getId());
        System.out.println("Student ID: " + getStudentId());
        System.out.println("Thesis Title: " + getThesis().getTitle());
        System.out.println("Loan Date: " + getLoanDate());
        System.out.println("Student Name: " + studentName);
        System.out.println("Course: " + course);
        System.out.println("Is Approved: " + (isApproved ? "Yes" : "No")); // แสดงสถานะการอนุมัติ
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourse() {
        return course;
    }

    // New method to request loan approval
    public void requestLoanApproval(LibraryManagement library, Scanner scanner) {

        ProfessorManage professorManager = new ProfessorManage(library, scanner);
        if (professorManager.loginProfessor()) {
            // Allow thesis loan
            approveLoan(); // ตั้งค่าสถานะการอนุมัติ
            System.out.println("Loan request approved by professor."); // แจ้งผลการอนุมัติ
        } else {
            System.out.println("Invalid professor credentials. Loan request denied.");
        }
    }

    
}