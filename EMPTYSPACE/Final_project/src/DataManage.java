import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataManage {
    
    // โหลดข้อมูลทั้งหมดจากไฟล์
    public static void loadDataFromFile(LibraryManagement library) {
        loadThesisDataFromFile(library); // โหลดข้อมูลวิทยานิพนธ์
        loadStudentDataFromFile(library); // โหลดข้อมูลนักศึกษา
        loadLoanDataFromFile(library); // โหลดข้อมูลการยืม
        checkAndCreateApprovedLoansFile(); // ตรวจสอบและสร้างไฟล์การอนุมัติการยืม
        loadApprovedLoans(library); // โหลดข้อมูลการอนุมัติการยืม
    }

    // ฟังก์ชันตรวจสอบและสร้างไฟล์ approved_loans.txt
    public static void checkAndCreateApprovedLoansFile() {
        File file = new File("C:\\Users\\DINA\\OneDrive\\Documents\\JAVA\\EMPTYSPACE\\Final_project\\textData\\approved_loans.txt");
        
        // ตรวจสอบว่าไฟล์มีอยู่หรือไม่
        if (!file.exists()) {
            try {
                // สร้างไฟล์ใหม่
                file.createNewFile();
                System.out.println("Approved loans file created: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Error creating approved loans file: " + e.getMessage());
            }
        }
    }

    // โหลดข้อมูลนักศึกษาจากไฟล์
    public static void loadStudentDataFromFile(LibraryManagement library) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\DINA\\OneDrive\\Documents\\JAVA\\EMPTYSPACE\\Final_project\\textData\\student.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // แยกข้อมูลด้วยเครื่องหมาย
                if (parts.length == 4) {
                    Student student = new Student(parts[0], parts[1], parts[2], parts[3]);
                    library.addStudent(student); // เพิ่มนักศึกษาเข้าสู่ LibraryManagement
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading student data: " + e.getMessage()); // แสดงข้อความหากเกิดข้อผิดพลาดในการโหลดข้อมูลนักศึกษา
        }
    }

    // บันทึกข้อมูลนักศึกษาไปยังไฟล์
    public static void saveStudentDataToFile(Student student) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\DINA\\OneDrive\\Documents\\JAVA\\EMPTYSPACE\\Final_project\\textData\\students.txt", true))) {
            bw.write(student.getName() + "," + student.getStudentId() + "," + student.getAcademicYear() + "," + student.getfaculty());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving student data: " + e.getMessage()); // แสดงข้อความหากเกิดข้อผิดพลาดในการบันทึกข้อมูลนักศึกษา
        }
    }

    // บันทึกข้อมูลอาจารย์ไปยังไฟล์
    public static void saveProfessorDataToFile(Professor professor) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\DINA\\OneDrive\\Documents\\JAVA\\EMPTYSPACE\\Final_project\\textData\\professors.txt", true))) {
            bw.write(professor.getName() + "," + professor.getPassword());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving professor data: " + e.getMessage()); // แสดงข้อความหากเกิดข้อผิดพลาดในการบันทึกข้อมูลอาจารย์
        }
    }

    // ตรวจสอบข้อมูลประจำตัวของอาจารย์
    public static boolean checkProfessorCredentials(String name, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:\\Users\\DINA\\OneDrive\\Documents\\JAVA\\EMPTYSPACE\\Final_project\\textData\\professors.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // แยกข้อมูลด้วยเครื่องหมาย
                if (parts.length == 2 && parts[0].equals(name) && parts[1].equals(password)) {
                    return true; // ข้อมูลประจำตัวตรงกัน
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading professor data: " + e.getMessage()); // แสดงข้อความหากเกิดข้อ ผิดพลาดในการโหลดข้อมูลอาจารย์
        }
        return false; // ข้อมูลประจำตัวไม่ตรงกัน
    }
    
    // ตรวจสอบข้อมูลประจำตัวของอาจารย์
    public static boolean checkStudentCredentials(String name, String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\DINA\\OneDrive\\Documents\\JAVA\\EMPTYSPACE\\Final_project\\textData\\students.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // แยกข้อมูลด้วยเครื่องหมาย
                if (parts.length == 2 && parts[0].equals(name) && parts[1].equals(id)) {
                    return true; // ข้อมูลประจำตัวตรงกัน
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading professor data: " + e.getMessage()); // แสดงข้อความหากเกิดข้อ ผิดพลาดในการโหลดข้อมูลอาจารย์
        }
        return false; // ข้อมูลประจำตัวไม่ตรงกัน
    }

    // บันทึกข้อมูลวิทยานิพนธ์ไปยังไฟล์
    public static void saveThesisDataToFile(Thesis thesis) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\DINA\\OneDrive\\Documents\\JAVA\\EMPTYSPACE\\Final_project\\textData\\theses.txt", true))) {
            bw.write(thesis.getId() + "," + thesis.getTitle() + "," + thesis.getAcademicYear() + "," + thesis.getfaculty());
            bw.newLine(); // เพิ่มบรรทัดใหม่
        } catch (IOException e) {
            System.out.println("Error saving thesis data: " + e.getMessage()); // แสดงข้อความ หากเกิดข้อผิดพลาดในการบันทึกข้อมูลวิทยานิพนธ์
        }
    }

    // โหลดข้อมูลวิทยานิพนธ์จากไฟล์
    public static void loadThesisDataFromFile(LibraryManagement library) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\DINA\\OneDrive\\Documents\\JAVA\\EMPTYSPACE\\Final_project\\textData\\theses.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // แยกข้อมูลด้วยเครื่องหมาย
                if (parts.length == 4) {
                    Thesis thesis = new Thesis(parts[0], parts[1], parts[2], parts[3]);
                    library.addThesis(thesis); // เพิ่มวิทยานิพนธ์เข้าสู่ LibraryManagement
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading thesis data: " + e.getMessage()); // แสดงข้อความหากเกิดข้อผิดพลาดในการโหลดข้อมูลวิทยานิพนธ์
        }
    }

    // อัปเดตข้อมูลวิทยานิพนธ์ในไฟล์
    public static void updateThesisDataInFile(LibraryManagement library) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\DINA\\OneDrive\\Documents\\JAVA\\EMPTYSPACE\\Final_project\\textData\\theses.txt"))) {
            for (int i = 0; i < library.getCount(); i++) {
                Thesis thesis = library.getThesis(i);
                if (thesis != null) {
                    bw.write(thesis.getId() + "," + thesis.getTitle() + "," + thesis.getAcademicYear() + "," + thesis.getfaculty());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error updating thesis data: " + e.getMessage()); // แสดงข้อความหากเกิดข้อผิดพลาดในการอัปเดตข้อมูลวิทยานิพนธ์
        }
    }

    // บันทึกข้อมูลทั้งหมดไปยังไฟล์
    public static void saveAllDataToFile(LibraryManagement library) {
        // บันทึกข้อมูลนักศึกษา
        for (int i = 0; i < library.getCount(); i++) {
            Student student = library.getStudent(i);
            if (student != null) {
                saveStudentDataToFile(student); // บันทึกข้อมูลนักศึกษา
            }
        }

        // บันทึกข้อมูลวิทยานิพนธ์
        for (int i = 0; i < library.getCount(); i++) {
            Thesis thesis = library.getThesis(i);
            if (thesis != null) {
                saveThesisDataToFile(thesis); // บันทึกข้อมูลวิทยานิพนธ์
            }
        }

        // บันทึกข้อมูลการยืม
        for (StudentLoan loan : library.getLoans()) {
            if (loan != null) {
                saveLoanDataToFile(loan); // บันทึกข้อมูลการยืม
            }
        }
    }

    // บันทึกข้อมูลการยืมไปยังไฟล์
    static void saveLoanDataToFile(StudentLoan loan) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\DINA\\OneDrive\\Documents\\JAVA\\EMPTYSPACE\\Final_project\\textData\\loans.txt", true))) {
            bw.write(loan.getId() + "," + loan.getStudentId() + "," + loan.getThesis().getId() + "," + loan.getLoanDate() + "," + loan.getStudentName());
            bw.newLine(); // เพิ่มบรรทัดใหม่
        } catch (IOException e) {
            System.out.println("Error saving loan data: " + e.getMessage()); // แสดงข้อความหากเกิดข้อผิดพลาดในการบันทึกข้อมูลการยืม
        }
    }

    // โหลดข้อมูล การยืมจากไฟล์
    public static void loadLoanDataFromFile(LibraryManagement library) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy"); // กำหนดรูปแบบวันที่
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\DINA\\OneDrive\\Documents\\JAVA\\EMPTYSPACE\\Final_project\\textData\\loans.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // แยกข้อมูลด้วยเครื่องหมาย
                if (parts.length == 5) {
                    Thesis thesis = library.findThesisById(parts[2]); // ค้นหาวิทยานิพนธ์ตามรหัส
                    if (thesis != null) {
                        Date loanDate = dateFormat.parse(parts[3]); // แปลงสตริงเป็นวันที่
                        StudentLoan loan = new StudentLoan(parts[0], parts[1], thesis, loanDate, parts[4], "Your Course Here");
                        library.addLoan(loan); // เพิ่มข้อมูลการยืมเข้าสู่ LibraryManagement
                    } else {
                        System.out.println("Thesis not found for loan ID: " + parts[0]); // แสดงข้อความหากไม่พบวิทยานิพนธ์
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading loan data: " + e.getMessage()); // แสดงข้อความหากเกิดข้อผิดพลาดในการโหลดข้อมูลการยืม
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage()); // แสดงข้อความหากเกิดข้อผิดพลาดในการแปลงวันที่
        }
    }

    // บันทึกข้อมูลการอนุมัติการยืมไปยังไฟล์
    public static void saveApprovedLoan(StudentLoan loan) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\DINA\\OneDrive\\Documents\\JAVA\\EMPTYSPACE\\Final_project\\textData\\approved_loans.txt", true))) {
            bw.write(loan.getId() + "," + loan.getStudentId() + "," + loan.getThesis().getId() + "," + loan.getLoanDate() + "," + loan.getStudentName());
            bw.newLine(); // เพิ่มบรรทัดใหม่
        } catch (IOException e) {
            System.out.println("Error saving approved loan data: " + e.getMessage()); // แสดงข้อความหากเกิดข้อผิดพลาดในการบันทึกข้อมูลการอนุมัติการยืม
        }
    }

    // โหลดข้อมูลการอนุมัติการยืมจากไฟล์
    public static void loadApprovedLoans(LibraryManagement library) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy"); // กำหนดรูปแบบวันที่
        File file = new File(
                "C:\\Users\\DINA\\OneDrive\\Documents\\JAVA\\EMPTYSPACE\\Final_project\\textData\\approved_loans.txt");

        // ตรวจสอบว่าไฟล์มีอยู่หรือไม่
        if (!file.exists()) {
            System.out.println("Approved loans file not found. Please create the file: " + file.getAbsolutePath());
            return; // ออกจากเมธอดหากไฟล์ไม่พบ
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // แยกข้อมูลด้วยเครื่องหมาย
                if (parts.length == 5) {
                    Thesis thesis = library.findThesisById(parts[2]); // ค้นหาวิทยานิพนธ์ตามรหัส
                    if (thesis != null) {
                        Date loanDate = dateFormat.parse(parts[3]); // แปลงสตริงเป็นวันที่
                        StudentLoan loan = new StudentLoan(parts[0], parts[1], thesis, loanDate, parts[4],
                                "Your Course Here");
                        library.addLoan(loan); // เพิ่มข้อมูลการยืมเข้าสู่ LibraryManagement
                    } else {
                        System.out.println("Thesis not found for approved loan ID: " + parts[0]); // แสดงข้อความหากไม่พบวิทยานิพนธ์
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading approved loans data: " + e.getMessage()); // แสดงข้อความหากเกิดข้อผิดพลาดในการโหลดข้อมูลการอนุมัติการยืม
        } catch (ParseException e) {
            System.out.println("Error parsing date in approved loans: " + e.getMessage()); // แสดงข้อความหากเกิดข้อผิดพลาดในการแปลงวันที่
        }
    }
    
    public static void saveReturn(StudentLoan loan) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(
                "C:\\Users\\DINA\\OneDrive\\Documents\\JAVA\\EMPTYSPACE\\Final_project\\textData\\returns.txt",
                true))) {
            bw.write(loan.getId() + "," + loan.getStudentId() + "," + loan.getThesis().getId() + ","
                    + loan.getLoanDate() + "," + loan.getStudentName());
            bw.newLine(); // Add a new line
        } catch (IOException e) {
            System.out.println("Error saving return data: " + e.getMessage()); // Display error message if saving fails
        }
    }

    public static void loadReturn(LibraryManagement library) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy"); // Define the date format
    File file = new File("C:\\Users\\DINA\\OneDrive\\Documents\\JAVA\\EMPTYSPACE\\Final_project\\textData\\returns.txt");

    // Check if the file exists
    if (!file.exists()) {
        System.out.println("Returns file not found. Please create the file: " + file.getAbsolutePath());
        return; // Exit the method if the file is not found
    }

   //
}

}