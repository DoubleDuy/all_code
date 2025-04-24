import java.util.ArrayList;
import java.util.List;
public class C {
    private List<M> thesisList;

    public C() {
        thesisList = new ArrayList<>();
    }

    public void addThesis(M thesis) {
        thesisList.add(thesis);
    }

    public List<M> getThesisList() {
        return thesisList;
    }

    public boolean borrowThesis(String title, String borrowerId) {
        for (M thesis : thesisList) {
            if (thesis.getTitle().equals(title) && !thesis.isBorrowed()) {
                thesis.borrow(borrowerId);
                return true;
            }
        }
        return false;
    }

    public boolean returnThesis(String title) {
        for (M thesis : thesisList) {
            if (thesis.getTitle().equals(title) && thesis.isBorrowed()) {
                thesis.returnThesis();
                return true;
            }
        }
        return false;
    }

    public List<M> getBorrowedByUser(String borrowerId) {
        List<M> borrowedTheses = new ArrayList<>();
        for (M thesis : thesisList) {
            if (borrowerId.equals(thesis.getBorrowDate())) {
                borrowedTheses.add(thesis);
            }
        }
        return borrowedTheses;
    }

    public String getBorrowDetails(String title) {
        for (M thesis : thesisList) {
            if (thesis.getTitle().equals(title) && thesis.isBorrowed()) {
                return "Thesis: " + thesis.getTitle() + ", Borrowed on: " + thesis.getBorrowDate();
            }
        }
        return "Thesis not found or not borrowed.";
    }
}
