import java.util.Date;

public class BorrowingRecord {
    private int recordId;
    private int thesisId;
    private int studentId;
    private int professorId;
    private Date borrowDate;
    private Date returnDate;
    private String status;

    public BorrowingRecord(int recordId, int thesisId, int studentId, int professorId, Date borrowDate, Date returnDate) {
        this.recordId = recordId;
        this.thesisId = thesisId;
        this.studentId = studentId;
        this.professorId = professorId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = "Borrowed";
    }

    // Getters and Setters
    public int getRecordId() {
        return recordId;
    }

    public int getThesisId() {
        return thesisId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String updateRecordStatus() {
        return status;
    }
}
