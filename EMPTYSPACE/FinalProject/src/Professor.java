public class Professor {
    private String[][] pf = {
        {"6604800015", "001", "นายสิมิลัน วิยาภร", "วิทยาการคอมพิวเตอร์"},
        {"6604800008", "002", "นางสาวอาภัสรา เนตรสัก", "วิทยาการคอมพิวเตอร์"},
        {"6104200088", "20121998", "นายอดตาย สุดหล่อ", "วิศวกรรมไฟฟ้า"}
    };
    private String[] currentUser = new String[2];

    public String[][] getProfessor() {
        return pf;
    }

    public void setProfessor(String[][] pf) {
        this.pf = pf;
    }

    public String[] search(String id) {
        for (String[] pf : pf) {
            if (pf[0].equals(id)) {
                return pf;
            }
        }
        return null; // Not found
    }

    public String[] login(String id, String password) {
        for (String[] pf : pf) {
            if (pf[0].equals(id) && pf[1].equals(password)) {
                currentUser = new String[]{pf[2], pf[3]};
                return currentUser;
            }
        }
        return null; // Login failed
    }
}
