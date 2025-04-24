import java.util.List;

public class StudentView {
    public void showCurrentUser(String[] currentUser) {
        if (currentUser != null) {
            System.out.println("นักศึกษา: " + currentUser[0]);
            System.out.println("สาขาวิชา: " + currentUser[1]);
        } else {
            System.out.println("ไม่มีในรายชื่อ");
        }
    }

    public void displayThesisList(List<M> thesisList) {
    System.out.println("Thesis List:");
    for (M thesis : thesisList) {
        String status = thesis.isBorrowed() ? (thesis.isApproved() ? " (Approved)" : " (Waiting for approval)") : "";
        System.out.println(thesis.getTitle() + " by " + thesis.getAuthor() + status);
    }
}

    public void displayBorrowDetails(String details) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayBorrowDetails'");
    }
}
