public class App {
    public static void main(String[] args) throws Exception {
        MyPoint p1 = new MyPoint(1, 6);
        MyPoint p2 = new MyPoint(3, 4);
        MyPoint p3 = new MyPoint(5, 7);

        MyTriangle Triangle = new MyTriangle(p1, p2, p3);

        System.out.println("Perimeter :"+ Triangle.getPerimeter());
        System.out.println("Type :"+ Triangle.getType());
    }
}
