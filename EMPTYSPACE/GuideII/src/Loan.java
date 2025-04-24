import java.time.LocalDate;

public class Loan {
    private String borrowedID;
    private Student student;
    private Thesis thesis;
    private LocalDate borrowedDate;
    private LocalDate returnDate;
    private Professor approvedBy;

    public Loan(String borrowedID, Student student, Thesis thesis, LocalDate borrowedDate, LocalDate returnDate, Professor approvedBy) {
        this.borrowedID = borrowedID;
        this.student = student;
        this.thesis = thesis;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.approvedBy = approvedBy;
    }

    public String getBorrowedID() { return borrowedID; }
    public void setBorrowedID(String borrowedID) { this.borrowedID = borrowedID; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public Thesis getThesis() { return thesis; }
    public void setThesis(Thesis thesis) { this.thesis = thesis; }
    public LocalDate getBorrowedDate() { return borrowedDate; }
    public void setBorrowedDate(LocalDate borrowedDate) { this.borrowedDate = borrowedDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
    public Professor getApprovedBy() { return approvedBy; }
    public void setApprovedBy(Professor approvedBy) { this.approvedBy = approvedBy; }
}