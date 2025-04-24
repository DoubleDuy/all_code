public class Rectangle extends Shape{
    private double length = 1.0;
    private double width = 1.0;

    Rectangle() {
    }
    
    Rectangle(double l, double w) {
        this.length = l;
        this.width = w;
    }

    public void setLength(double l) {
        this.length = l;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double w) {
        this.width = w;
    }

    public double getWidth() {
        return width;
    }

    
}
