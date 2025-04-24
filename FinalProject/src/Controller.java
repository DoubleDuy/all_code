import java.util.ArrayList;
import java.util.Date;

public class Controller {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Thesis> theses = new ArrayList<>();
    private ArrayList<BorrowingRecord> borrowingRecords = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void addThesis(Thesis thesis) {
        theses.add(thesis);
    }

    public void borrowThesis(int thesisId, int studentId, int professorId) {
        // Check thesis availability
        for (Thesis thesis : theses) {
            if (thesis.getThesisId() == thesisId && thesis.getStatus().equals("Available")) {
                // Create a borrowing record and change status
                thesis.changeStatus("Borrowed");
                borrowingRecords.add(new BorrowingRecord(borrowingRecords.size() + 1, thesisId, studentId, professorId, new Date(), new Date())); // Simplified return date
                break;
            }
        }
    }

    public void returnThesis(int thesisId) {
        for (Thesis thesis : theses) {
            if (thesis.getThesisId() == thesisId && thesis.getStatus().equals("Borrowed")) {
                thesis.changeStatus("Available");
                // Update corresponding borrowing record status
                break;
            }
        }
    }

    public ArrayList<Thesis> searchThesis(String title, int year) {
        ArrayList<Thesis> results = new ArrayList<>();
        for (Thesis thesis : theses) {
            if ((title != null && thesis.getTitle().contains(title)) || (year != 0 && thesis.getAcademicYear() == year)) {
                results.add(thesis);
            }
        }
        return results;
    }
}
