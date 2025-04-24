public class Circle extends Shape {
    public double radius;

    Circle() {
    }

    Circle(double radius) {
        this.radius = radius;
    }

    Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //override abstract method super class
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    //override concrete method super class
    @Override
    public String toString() {
        //return "[Shape : Circle ,color"+color+"filled"+filled+"]";
        return "[Shape : Circle, " + super.toString() + "]";
    }
}
