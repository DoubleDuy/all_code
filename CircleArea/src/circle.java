public final class circle {
    //ประกาศattributeของคลาส
    private double radius = 1.0;
    private String color = "red";
    static final double pi = 3.14;
    
    //ประกาศ default constructor
    circle() {
    }

    protected circle(double r) {
        radius = r;
    }

    //ประกาศ concrete method
    protected double getRadius() {
        return radius;
    }

    protected double getArea() {
        return Math.PI *Math.pow(radius, 2);
    }
}


