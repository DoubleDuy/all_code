import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntellectuaThesis {
    private List<Student> students;
    private List<Professor> professors;
    private List<Thesis> theses;
    private List<Loan> borrowRecords;

    public IntellectuaThesis() {
        students = new ArrayList<>();
        professors = new ArrayList<>();
        theses = new ArrayList<>();
        borrowRecords = new ArrayList<>();
    }

    // Add/Remove/Update Students
    public void addStudent(String name, String email, String userID, String department) {
        students.add(new Student(name, email, userID, department));
    }

    public void removeStudent(String userID) {
        boolean removed = students.removeIf(student -> student.getUserID().equals(userID));
        if (!removed) {
            System.out.println("No student found with ID: " + userID);
        }
    }

    public void updateStudent(String userID, String name, String email, String department) {
        for (Student student : students) {
            if (student.getUserID().equals(userID)) {
                student.setName(name);
                student.setEmail(email);
                student.setDepartment(department);
                return;
            }
        }
        System.out.println("No student found with ID: " + userID);
    }

    // Add/Remove/Update Professors
    public void addProfessor(String name, String email, String userID, String department) {
        professors.add(new Professor(name, email, userID, department));
    }

    public void removeProfessor(String userID) {
        boolean removed = professors.removeIf(professor -> professor.getUserID().equals(userID));
        if (!removed) {
            System.out.println("No professor found with ID: " + userID);
        }
    }

    public void updateProfessor(String userID, String name, String email, String department) {
        for (Professor professor : professors) {
            if (professor.getUserID().equals(userID)) {
                professor.setName(name);
                professor.setEmail(email);
                professor.setDepartment(department);
                return;
            }
        }
        System.out.println("No professor found with ID: " + userID);
    }

    // Add/Remove/Update Theses
    public void addThesis(String thesisID, String title, int year, String author) {
        theses.add(new Thesis(thesisID, title, year, author));
    }

    public void removeThesis(String thesisID) {
        boolean removed = theses.removeIf(thesis -> thesis.getThesisID().equals(thesisID));
        if (!removed) {
            System.out.println("No thesis found with ID: " + thesisID);
        }
    }

   // เมธอดสำหรับค้นหาวิทยานิพนธ์ (Thesis) ตามปีที่เผยแพร่
public List<Thesis> searchThesisByYear(int year) {
    // ใช้ Stream API เพื่อแปลงรายการทีสิททั้งหมดเป็นสตรีม
    return theses.stream()
            // กรองเฉพาะทีสิทที่ปี (getYear) ตรงกับปีที่กำหนด
            .filter(thesis -> thesis.getYear() == year)
            // รวบรวมผลลัพธ์เป็นรายการ (List) และส่งคืน
            .collect(Collectors.toList());
}

// เมธอดสำหรับค้นหาวิทยานิพนธ์ (Thesis) โดยตรวจสอบคำในชื่อเรื่อง
public List<Thesis> searchThesisByTitle(String title) {
    // ใช้ Stream API เพื่อแปลงรายการทีสิททั้งหมดเป็นสตรีม
    return theses.stream()
            // กรองเฉพาะทีสิทที่ชื่อเรื่อง (getTitle) มีคำที่ตรงกับคำที่ค้นหา (case-insensitive)
            .filter(thesis -> thesis.getTitle().toLowerCase().contains(title.toLowerCase()))
            // รวบรวมผลลัพธ์เป็นรายการ (List) และส่งคืน
            .collect(Collectors.toList());
}
    // Borrow and Return Thesis
    public String borrowThesis(String studentID, String thesisID, String professorID) {
        // ค้นหาข้อมูลของนักศึกษา, ทีสิท และอาจารย์
    Student student = students.stream().filter(s -> s.getUserID().equals(studentID)).findFirst().orElse(null);
    Thesis thesis = theses.stream().filter(t -> t.getThesisID().equals(thesisID)).findFirst().orElse(null);
    Professor professor = professors.stream().filter(p -> p.getUserID().equals(professorID)).findFirst().orElse(null);

    // ตรวจสอบความถูกต้องของข้อมูล
    if (student == null || thesis == null || professor == null) {
        return "Invalid data. Please check student, thesis, or professor details.";
    }

    // ตรวจสอบว่านักศึกษาและอาจารย์อยู่ในแผนก CS เท่านั้น
    if (!"CS".equalsIgnoreCase(student.getDepartment())) {
        return "Only students from the CS department can borrow a thesis.";
    }
    if (!"CS".equalsIgnoreCase(professor.getDepartment())) {
        return "Only professors from the CS department can approve the loan.";
    }

    // ตรวจสอบว่า Thesis นี้มีคนยืมอยู่หรือไม่
    boolean isBorrowed = borrowRecords.stream()
        .anyMatch(loan -> loan.getThesis().getThesisID().equals(thesisID) && loan.getReturnDate() == null);

    if (isBorrowed) {
    return "This thesis is currently borrowed and cannot be borrowed again.";
}

    // ตรวจสอบว่านักศึกษามีทีสิทที่ยืมอยู่แล้วหรือไม่
    boolean hasActiveLoan = borrowRecords.stream()
            .anyMatch(loan -> loan.getStudent().getUserID().equals(studentID) && loan.getReturnDate() == null);

    if (hasActiveLoan) {
        return "You already have an active loan. Please return the current thesis before borrowing a new one.";
    }

    // กำหนดระยะเวลาการยืม 1 เดือน
    LocalDate borrowedDate = LocalDate.now();
    LocalDate returnDate = borrowedDate.plusMonths(1);

    // ดูประวิติว่ายืมไปแล้ว
    borrowRecords.add(new Loan(student.getUserID(), student, thesis, borrowedDate, null, professor));

    return "Thesis borrowed successfully! Approved by Professor " + professor.getName() 
    + ". You can borrow this thesis until " + returnDate + ".";
}
    public String returnThesis(String studentID, String thesisID) {
        for (Loan loan : borrowRecords) {
            if (loan.getStudent().getUserID().equals(studentID) && loan.getThesis().getThesisID().equals(thesisID)) {
                if (loan.getReturnDate() != null) {
                    return "Thesis has already been returned.";
                }
                loan.setReturnDate(LocalDate.now());
                return "Thesis returned successfully!";
            }
        }
        return "No active loan found.";
    }

    public List<Loan> getBorrowRecords() {
        return new ArrayList<>(borrowRecords);
    }
}