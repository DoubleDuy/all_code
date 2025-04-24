public class main {
    public static void main(String[] args) throws Exception {
        //เรียกใช้คลาสที่มี static
        //circle.radius = 5.5;
        //System.out.println("Static Radius is " + circle.getArea());
        
        //ประกาศObjของคลาส circle
        //circle objCircle = new circle(2.0);
        //double area = circle.getArea();
        //System.out.println("Constructor Radius " + "Area is " + area);

        //circle objCircle2 = new circle(10.0);
        //area = objCircle.getArea();
        //System.out.println("Objectcircle area is "+area);

        
        //ประกาศ obj ของคลาส circle จำนวน 2 obj
        circle obj1 = new circle(2.5);
        circle obj2 = new circle(5.0);

        System.out.println("Radius of Object 1 is " + obj1.getRadius());
        System.out.println("Radius of Object 2 is " + obj2.getRadius());

        System.out.println("Area of Object 1 is " + obj1.getArea());
        System.out.println("Area of Object 1 is " + obj2.getArea());
    }
}
