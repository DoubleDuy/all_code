public class MyPoint {
    private int x;
    private int y;

public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getBeginX() {
        return x;
    }

    public int getBeginY() {
        return y;
    }

    public int getEndX() {
        return x;
    }

    public int getEndY() {
        return y;
    }

    public void setBeginX(int x) {
        this.x = x;
    }

    public void setBeginY(int y) {
        this.y = y;
    }

    public void setEndX(int x) {
        this.x = x;
    }

    public void setEndY(int y) {
        this.y = y;
    }

    public double distance(MyPoint other) {
        int xDiff = this.x - other.x;
        int yDiff = this.y - other.y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
