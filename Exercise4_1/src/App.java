public class App {
    public static void main(String[] args) throws Exception {

        Circle obj = new Circle(5, "Green");

        Cylinder obj2 = new Cylinder(5, 10);

        System.out.println(obj.toString());
        System.out.println(obj.getArea());
        System.out.println("\t");
        System.out.println(obj2.getVolume());
    }
}
