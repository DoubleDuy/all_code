public class App {
    public static void main(String[] args) throws Exception {
        // Create a Point object
        //Point point = new Point(0, 0);
        //System.out.println("Point: " + point);

        // Create a MovablePoint object
        MovablePoint movablePoint = new MovablePoint(0, 0, 0.5f, 1.0f);
        System.out.println("MovablePoint before move: " + movablePoint);

        // Move the MovablePoint
        System.out.println("MovablePoint after move: " + movablePoint.move());
    }
}
