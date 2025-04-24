import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public String[][] getStudent() {
        return model.getStudent();
    }

    public void setStudent(String[][] student) {
        model.setStudent(student);
    }

    public String[] search(String id) {
        return model.search(id);
    }

    public String[] login(String id, String password) {
        return model.login(id, password);
    }

    public void updateView(String[] currentUser) {
        view.showCurrentUser(currentUser);
    }

    public List<M> getBorrowedThesis(C thesisController) {
        List<M> borrowedThesis = new ArrayList<>();
        for (M thesis : thesisController.getThesisList()) {
            if (thesis.isBorrowed()) {
                borrowedThesis.add(thesis);
            }
        }
        return borrowedThesis;
    }
}
