public class Student extends User {
    public Student(int userId, String name) {
        super(userId, name, "Student");
    }

    public void requestBorrow() {
        // Logic to request thesis borrow
    }
}