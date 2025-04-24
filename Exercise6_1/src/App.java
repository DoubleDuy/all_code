public class App {
    public static void main(String[] args) throws Exception {
        Shape obj = new Circle(2, "Black", false);
        System.out.println(obj.getArea());
        System.out.println(obj.getPerimeter());
        System.out.println(obj.toString());

        // Creating a Circle object
        Circle circle = new Circle(5.0, "blue", true);
        System.out.println("Circle:");
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());
        System.out.println(circle.toString());
        System.out.println();

        // Creating a Rectangle object
        Rectangle rectangle = new Rectangle(4.0, 6.0, "green", false);
        System.out.println("Rectangle:");
        System.out.println("Width: " + rectangle.getWidth());
        System.out.println("Length: " + rectangle.getLength());
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());
        System.out.println(rectangle.toString());
        System.out.println();

        // Creating a Square object
        Square square = new Square(4.0, "yellow", true);
        System.out.println("Square:");
        System.out.println("Side: " + square.getSide());
        System.out.println("Area: " + square.getArea());
        System.out.println("Perimeter: " + square.getPerimeter());
        System.out.println(square.toString());
    }
}
