import java.util.List;

public class Student {
    private String[][] student = {
        {"6604800015", "001", "นายสิมิลัน วิยาภร", "วิทยาการคอมพิวเตอร์"},
        {"6604800008", "002", "นางสาวอาภัสรา เนตรสัก", "วิทยาการคอมพิวเตอร์"},
        {"6104200088", "20121998", "นายอดตาย สุดหล่อ", "วิศวกรรมไฟฟ้า"}
    };
    private String[] currentUser = new String[2];

    public String[][] getStudent() {
        return student;
    }

    public void setStudent(String[][] student) {
        this.student = student;
    }

    public String[] search(String id) {
        for (String[] s : student) {
            if (s[0].equals(id)) {
                return s;
            }
        }
        return null; // Not found
    }

    public String[] login(String id, String password) {
        for (String[] s : student) {
            if (s[0].equals(id) && s[1].equals(password)) {
                currentUser = new String[] { s[2], s[3] };
                return currentUser;
            }
        }
        return null; // Login failed
    }
    
    public void displayThesisList(List<M> thesisList) {
    System.out.println("Thesis List:");
    for (M thesis : thesisList) {
        String status = thesis.isBorrowed() ? (thesis.isApproved() ? " (Approved)" : " (Waiting for approval)") : "";
        System.out.println(thesis.getTitle() + " by " + thesis.getAuthor() + status);
    }
}
}
