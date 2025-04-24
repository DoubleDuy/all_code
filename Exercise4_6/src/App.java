public class App {
    public static void main(String[] args) throws Exception {
        Animal obj = new Animal("POOK");
        System.out.println(obj.toString());

        Animal obj1 = new Mammal("POK");
        System.out.println(obj1.toString());

        Cat obj2 = new Cat("PAK");
        System.out.println(obj2.toString());
        obj2.greets();

        Dog obj3 = new Dog("PIK");
        System.out.println(obj3.toString());
        obj3.greets();
        obj3.greets(obj3);
    }
}
