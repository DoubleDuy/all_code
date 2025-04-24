public class App {
    public static void main(String[] args) {
        MyCircle Circle = new MyCircle();
        System.out.println("Circle: " + Circle.toString());
        System.out.println("Circle Area: " + Circle.getArea());
        System.out.println("Circle Circumference: " + Circle.getCircumference());

        MyCircle customCircle = new MyCircle(5, 10, 7);
        System.out.println("Custom Circle: " + customCircle.toString());
        System.out.println("Custom Circle Area: " + customCircle.getArea());
        System.out.println("Custom Circle Circumference: " + customCircle.getCircumference());

        double distance = Circle.distance(customCircle);
        System.out.println("Distance between circles: " + distance);
    }
}
