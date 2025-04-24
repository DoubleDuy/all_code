import java.util.Date;
import java.util.List;

public class LibraryManagement {
    private Thesis[] theses;
    private Student[] students;
    private StudentLoan[] loans;
    private List<StudentLoan> returnedLoans;
    private int thesisCount;
    private int studentCount;
    private int loanCount;
    private static final int MAX_THESIS = 10;
    private static final int MAX_STUDENTS = 10;
    private static final int MAX_LOANS = 10;

    public LibraryManagement() {
        theses = new Thesis[MAX_THESIS];
        students = new Student[MAX_STUDENTS];
        loans = new StudentLoan[MAX_LOANS];
        thesisCount = 0;
        studentCount = 0;
        loanCount = 0;
    }

    // เพิ่มวิทยานิพนธ์
    public void addThesis(Thesis thesis) {
        if (thesisCount < MAX_THESIS) {
            theses[thesisCount] = thesis;
            thesisCount++;
        } else {
            System.out.println("Cannot add more theses. The limit has been reached.");
        }
    }

    // สำหรับเพิ่มนักศึกษา
    public void addStudent(Student student) {
        if (studentCount < MAX_STUDENTS) {
            students[studentCount] = student; // เพิ่มนักศึกษาในอาร์เรย์
            studentCount++; // เพิ่มตัวนับนักศึกษา
        } else {
            System.out.println("Cannot add more students. The limit has been reached."); // แสดงข้อความหากไม่สามารถเพิ่มนักศึกษาได้
        }
    }

    // สำหรับดึงวิทยานิพนธ์ตามดัชนี
    public Thesis getThesis(int index) {
        if (index >= 0 && index < thesisCount) {
            return theses[index]; // คืนค่าวิทยานิพนธ์หากดัชนีถูกต้อง
        }
        return null; // คืนค่า null หากดัชนีไม่ถูกต้อง
    }

    // สำหรับคืนค่าจำนวนวิทยานิพนธ์
    public int getCount() {
        return thesisCount; // คืนค่าจำนวนวิทยานิพนธ์
    }

    // สำหรับค้นหานักศึกษาตามรหัส
    public Student findStudentById(String studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equals(studentId)) {
                return students[i]; // คืนค่านักศึกษาเมื่อพบ
            }
        }
        return null; // คืนค่า null หากไม่พบ
    }

    public Thesis findThesisById(String id) {
        for (int i = 0; i < thesisCount; i++) {
            if (theses[i].getId().equals(id)) {
                return theses[i]; // คืนค่าวิทยานิพนธ์เมื่อพบ
            }
        }
        return null; // คืนค่า null หากไม่พบ
    }

    // สำหรับค้นหาวิทยานิพนธ์ตามรปีการศึกษา
    public Thesis findThesisByAcademicYear(String academicYear) {
        for (int i = 0; i < thesisCount; i++) {
            if (theses[i].getAcademicYear().equals(academicYear)) {
                return theses[i]; // คืนค่าวิทยานิพนธ์เมื่อพบ
            }
        }
        return null; // คืนค่า null หากไม่พบ
    }

    public Thesis findThesisByTitle(String title) {
        for (int i = 0; i < thesisCount; i++) {
            if (theses[i].getTitle().equals(title)) {
                return theses[i]; // คืนค่าวิทยานิพนธ์เมื่อพบ
            }
        }
        return null; // คืนค่า null หากไม่พบ
    }

    // สำหรับลบวิทยานิพนธ์
    public void removeThesis(Thesis thesis) {
        for (int i = 0; i < thesisCount; i++) {
            if (theses[i].equals(thesis)) {
                // เลื่อนวิทยานิพนธ์ที่เหลือไปทางซ้าย
                for (int j = i; j < thesisCount - 1; j++) {
                    theses[j] = theses[j + 1];
                }
                theses[thesisCount - 1] = null; // เคลียร์ตำแหน่งสุดท้าย
                thesisCount--; // ลดตัวนับวิทยานิพนธ์
                return;
            }
        }
    }

    public static void showReturnInformation(LibraryManagement library) {
        List<StudentLoan> returnedLoans = library.getReturnedLoans(); // Assuming you have a method to get returned loans
        
                if (returnedLoans.isEmpty()) {
                    System.out.println("No returned theses available."); // Inform if there are no returned theses
                    return; // Exit if there are no returned loans
                }
        
                System.out.println("Returned Thesis Information:"); // Header for the output
                System.out.printf("%-15s %-15s %-15s %-20s %-20s%n", "Return ID", "Student ID", "Thesis ID", "Return Date",
                        "Student Name"); // Table header
        
                for (StudentLoan loan : returnedLoans) {
                    System.out.printf("%-15s %-15s %-15s %-20s %-20s%n",
                            loan.getId(),
                            loan.getStudentId(),
                            loan.getThesis().getId(),
                            loan.getLoanDate().toString(), // Format the date as needed
                            loan.getStudentName());
                }
            }
        
            public List<StudentLoan> getReturnedLoans() {
                return returnedLoans; // Assuming you have a list of returned loans
            }
        
            // สำหรับดึงข้อมูลการยืม
    public StudentLoan[] getLoans() {
        return loans; // คืนค่าอาร์เรย์การยืม
    }

    // สำหรับเพิ่มการยืม
    public void addLoan(StudentLoan loan) {
        if (loanCount < MAX_LOANS) {
            loans[loanCount] = loan;
            loanCount++;
        } else {
            System.out.println("Cannot add more loans. The limit has been reached."); // แสดงข้อความหากไม่สามารถเพิ่มการยืมได้
        }
    }

    // ฟังก์ชันสำหรับบันทึกการยืม
    public void recordLoan(Student student, Thesis thesis) {
        if (isThesisAvailable(thesis)) { // ตรวจสอบว่าวิทยานิพนธ์สามารถยืมได้
            Date loanDate = new Date(); // รับวันที่ปัจจุบัน
            StudentLoan loan = new StudentLoan("L" + (loanCount + 1), student.getStudentId(), thesis, loanDate, student.getName(), student.getfaculty());
            addLoan(loan); // เพิ่มการยืมในอาร์เรย์การยืม
        } else {
            System.out.println("Thesis is not available for loan."); // แสดงข้อความหากวิทยานิพนธ์ไม่สามารถยืมได้
        }
    }

    // ฟังก์ชันตรวจสอบว่าวิทยานิพนธ์สามารถยืมได้หรือไม่
    private boolean isThesisAvailable(Thesis thesis) {
        for (StudentLoan loan : loans) {
            if (loan != null && loan.getThesis().equals(thesis)) {
                return false; // หากมีการยืมวิทยานิพนธ์นี้อยู่แล้ว
            }
        }
        return true; // วิทยานิพนธ์สามารถยืมได้
    }

    // ใหม่สำหรับดึงนักศึกษาตามดัชนี
    public Student getStudent(int index) {
        if (index >= 0 && index < studentCount) {
            return students[index]; // คืนค่านักศึกษาเมื่อถูกต้อง
        }
        return null; // คืนค่า null หากไม่ถูกต้อง
    }

    // สำหรับดึงข้อมูลวิทยานิพนธ์ทั้งหมด
    public Thesis[] getTheses() {
        return theses; // คืนค่าอาร์เรย์วิทยานิพนธ์ทั้งหมด
    }

    // ฟังก์ชันสำหรับดึงข้อมูลการยืมตามรหัสนักศึกษา
    public StudentLoan[] getLoansByStudentId(String studentId) {
        StudentLoan[] studentLoans = new StudentLoan[MAX_LOANS];
        int count = 0;
        for (StudentLoan loan : loans) {
            if (loan != null && loan.getStudentId().equals(studentId)) {
                studentLoans[count++] = loan; // เพิ่มการยืมของนักศึกษา
            }
        }
        return studentLoans; // คืนค่าการยืมของนักศึกษา
        }
}