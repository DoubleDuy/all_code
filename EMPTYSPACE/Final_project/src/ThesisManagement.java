import java.util.ArrayList;

public class ThesisManagement {
    private ArrayList<Thesis> theses;
    private ArrayList<StudentLoan> loans;

    public ThesisManagement() {
        theses = new ArrayList<>();
        loans = new ArrayList<>();
    }

    public void addThesis(Thesis thesis) {
        theses.add(thesis);
    }

    public void addLoan(StudentLoan loan) {
        loans.add(loan);
    }

    public Thesis findThesisByAcademicYear(String academicYear) {
        for (Thesis thesis : theses) {
            if (thesis.getId().equals(academicYear)) {
                return thesis;
            }
        }
        return null; // Not found
    }

    public Thesis findThesisById(String id) {
        for (Thesis thesis : theses) {
            if (thesis.getId().equals(id)) {
                return thesis;
            }
        }
        return null; // Not found
    }

    public Thesis findThesisByTitle(String title) {
        for (Thesis thesis : theses) {
            if (thesis.getId().equals(title)) {
                return thesis;
            }
        }
        return null; // Not found
    }
    
    public ArrayList<Thesis> getTheses() {
        return theses;
    }

    public ArrayList<StudentLoan> getLoans() {
        return loans;
    }
}