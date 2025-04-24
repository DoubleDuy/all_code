public class Student {
    private String name;
    private String studentId;
    private String academicYear;
    private String faculty;

    public Student(String name, String studentId, String academicYear, String faculty) {
        this.name = name;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.faculty = faculty;
    }

    // ชื่อของนักศึกษา
    public String getName() {
        return name; // คืนค่าชื่อ
    }

    // รหัสนักศึกษา
    public String getStudentId() {
        return studentId; // คืนค่ารหัสนักศึกษา
    }

    // ปีการศึกษาของนักศึกษา
    public String getAcademicYear() {
        return academicYear; // คืนค่าปีการศึกษา
    }

    // คณะของนักศึกษา
    public String getfaculty() {
        return faculty; // คืนค่าคณะ
    }
}