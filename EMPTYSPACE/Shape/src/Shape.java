public class Shape {
    private String color = "Blue";

    Shape() {
    }

    Shape(String color) {
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        return 0;
    }
}
