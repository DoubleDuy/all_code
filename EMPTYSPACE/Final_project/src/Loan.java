import java.time.LocalDate;
import java.util.Date;

public class Loan {
    private String id;
    protected String studentId;
    private Thesis thesis;
    private Date loanDate;
    private boolean isConfirmed;
    private boolean isLoanAllowed;
    private Date returnDate;

    public Loan(String id, String studentId, Thesis thesis, Date loanDate) {
        this.id = id;
        this.studentId = studentId;
        this.thesis = thesis;
        this.loanDate = loanDate;
        this.isConfirmed = false;
        this.isLoanAllowed = false;
    }

    public void confirmLoan() {
        this.isConfirmed = true;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public String getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public Thesis getThesis() {
        return thesis;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public boolean isLoanAllowed() {
        return isLoanAllowed;
    }

    public void setLoanAllowed(boolean loanAllowed) {
        this.isLoanAllowed = loanAllowed;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}