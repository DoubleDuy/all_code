// ThesisView.java
import java.util.List;

public class V {
    public void displayThesisList(List<M> thesisList) {

        System.out.println("Thesis List:");
        for (M thesis : thesisList) {
            
            System.out.println(thesis.getTitle() + " by " + thesis.getAuthor() + (thesis.isBorrowed() ? " (Waiting for confirmation.)" : ""));

        }
    }
            
    public void displayUpdate(List<M> thesisList) {
        for (M thesis : thesisList) {
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayBorrowDetails(String details) {
        System.out.println(details);
    }
}