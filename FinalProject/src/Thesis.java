public class Thesis {
    private int thesisId;
    private String title;
    private int academicYear;
    private String status;

    public Thesis(int thesisId, String title, int academicYear) {
        this.thesisId = thesisId;
        this.title = title;
        this.academicYear = academicYear;
        this.status = "Available";
    }

    // Getters and Setters
    public int getThesisId() {
        return thesisId;
    }

    public String getTitle() {
        return title;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public String getStatus() {
        return status;
    }

    public void updateThesis(String title, int academicYear) {
        this.title = title;
        this.academicYear = academicYear;
    }

    public void changeStatus(String status) {
        this.status = status;
    }
}
