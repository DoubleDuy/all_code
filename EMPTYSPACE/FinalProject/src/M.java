import java.time.LocalDateTime;

public class M {
    private String title;
    private String author;
    private boolean isBorrowed;
    private boolean isApproved; // สถานะการอนุมัติ
    private LocalDateTime borrowDate; // Date when the thesis was borrowed

    public M(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
        this.isApproved = false; // เริ่มต้นไม่อนุมัติ
    }
    
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void borrow(String borrowerId) {
        isBorrowed = true;
        borrowDate = LocalDateTime.now(); // Set the current date and time
    }

    public void returnThesis() {
        isBorrowed = false;
        isApproved = false; // รีเซ็ตสถานะการอนุมัติเมื่อคืน
        borrowDate = null; // Reset borrow date
    }
}