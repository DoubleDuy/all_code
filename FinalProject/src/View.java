import java.util.ArrayList;

public class View {
    public void displayThesisList(ArrayList<Thesis> theses) {
        for (Thesis thesis : theses) {
            System.out.println("Thesis ID: " + thesis.getThesisId() + ", Title: " + thesis.getTitle() + ", Year: " + thesis.getAcademicYear());
        }
    }

    public void displayUserList(ArrayList<User> users) {
        for (User user : users) {
            System.out.println("User ID: " + user.getUserId() + ", Name: " + user.getName() + ", Role: " + user.getRole());
        }
    }

    public void showReport(ArrayList<BorrowingRecord> records) {
        for (BorrowingRecord record : records) {
            System.out.println("Record ID: " + record.getRecordId() + ", Thesis ID: " + record.getThesisId() + ", Student ID: " + record.getStudentId() + ", Status: " + record.updateRecordStatus());
        }
    }
}
