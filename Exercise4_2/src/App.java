public class App {
    public static void main(String[] args) throws Exception {
        Student obj = new Student("Dina", "Bankok", "ComSci", 3, 20000);

        
        //ลูก new แม่ไม่ได้
        //Staff obj2 = new Person("Dina","Bangkok","Siam U",30000);
        
        //Staff obj2 = new Staff("Dina", "Bangkok", "Siam U", 30000); (1)

        //obj คลาสแม่ แต่ new คลาสลูก (2)
        Person obj2 = new Staff("Dina","Bangkok","Siam U",30000);
        obj.setAddress("Bangkok");
        System.out.println("Address :" + obj.getAddress());
        System.out.println(obj.toString());
        System.out.println(obj2.toString());
    }
}
