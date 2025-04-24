// PFC.java
public class PFC {
    private Professor pfmodel;
    private PFV pfview;
    private C thesisController; // Reference to ThesisController

    public PFC(Professor pfmodel, PFV pfview, C thesisController) {
        this.pfmodel = pfmodel;
        this.pfview = pfview;
        this.thesisController = thesisController; // Initialize the thesis controller
    }

    public String[][] getProfessor() {
        return pfmodel.getProfessor();
    }

    public void setProfessor(String[][] pf) {
        pfmodel.setProfessor(pf);
    }

    public String[] search(String pfid) {
        return pfmodel.search(pfid);
    }

    public String[] login(String pfid, String pfpassword) {
        return pfmodel.login(pfid, pfpassword);
    }

    public void updateView(String[] pfcurrentUser ) {
        pfview.showCurrentUser (pfcurrentUser );
    }

    public void approveThesisBorrowing(String title) {
        if (thesisController.borrowThesis(title, title)) {
            System.out.println("Thesis is not available or already borrowed.");
        } else {
            System.out.println("Thesis borrowing approved for: " + title);
        }
    }
    
}