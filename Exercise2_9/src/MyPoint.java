public class MyPoint {
    private int x;
    private int y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(MyPoint other) {
        int xDiff = this.x - other.x;
        int yDiff = this.y - other.y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    
}
