public class circle {
    static double radius = 1.0;


    circle() {
    }

    public circle(double r) {
        radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double r) {

    }
    
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public String toString() {
        return "Circle with radius: " + radius;
    }
}
