import java.util.Date;

public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        // Adding a professor
        Professor professor = new Professor("P001", "Dr. Smith", "smith@example.com");
        library.addProfessor(professor);

        // Adding a student
        Student student = new Student("S001", "John Doe", "john@example.com", "123456789");
        library.addStudent(student);

        // Adding a thesis
        Thesis thesis = new Thesis("T001", "AI Research", "2023", professor);
        library.addThesis(thesis);

        // Borrowing a thesis
        Loan loan = new Loan("L001", thesis, student, new Date(), null, "Borrowed");
        library.borrowThesis(loan);

        // Generating report
        library.generateReport();
    }
}