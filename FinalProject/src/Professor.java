public class Professor extends User {
    public Professor(int userId, String name) {
        super(userId, name, "Professor");
    }

    public boolean approveBorrow() {
        // Logic for approval
        return true;
    }
}
