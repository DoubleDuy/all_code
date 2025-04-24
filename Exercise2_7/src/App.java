public class App {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(1, 1);
        MyPoint p2 = new MyPoint(4, 5);
    
        MyLine line = new MyLine(p1, p2);
    
        System.out.println("Begin: " + line.getBegin());
        System.out.println("End: " + line.getEnd());
        System.out.println("Length: " + line.getLength());
        System.out.println("Gradient: " + line.getGradient());
        System.out.println(line);
    }
}
