import java.time.LocalDateTime;

public class Thesis {
    private String id;
    private String title;
    private String academicYear;
    private String faculty;
    private boolean available;
    private LocalDateTime borrowDate; // Date when the thesis was borrowed


    public Thesis(String id, String title, String academicYear, String faculty) {
        this.id = id;
        this.title = title;
        this.academicYear = academicYear;
        this.faculty = faculty;
        this.available = true;
    }


    public String getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


    public String getAcademicYear() {
        return academicYear;
    }


    public String getfaculty() { // สามารถเข้าถึงคณะได้
        return faculty;
    }


    public boolean isAvailable() {
        return available; // สถานะการให้ยืม
    }

    public void setAvailable(boolean available) {
        this.available = available; // ตั้งค่าสถานะการให้ยืม
        borrowDate = LocalDateTime.now(); // Set the current date and time
    }


    public void setTitle(String title) {
        this.title = title; // ตั้งชื่อวิทยานิพนธ์ใหม่
    }


    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear; // ตั้งปีการศึกษาใหม่
    }

    
    public void setfaculty(String faculty) {
        this.faculty = faculty; // ตั้งค่าคณะใหม่
    }


    public void returnThesis() {
        available = false; // รีเซ็ตสถานะการอนุมัติเมื่อคืน
        borrowDate = null; // Reset borrow date
    }
}