public class PFV {
    public void showCurrentUser(String[] pfcurrentUser) {
        if (pfcurrentUser != null) {
            System.out.println("อาจารย์: " + pfcurrentUser[0]);
        } else {
            System.out.println("ไม่มีในรายชื่อ");
        }
    }
}