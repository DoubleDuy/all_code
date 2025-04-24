public class App {
    public static void main(String[] args) throws Exception {
        //declare instance object of Mypoint
        Mypoint objMypoint=new Mypoint(2,4);
        //invoke overloading method distance
        //send two arguments

        double result=0;
        result=objMypoint.distance(10,10);
        System.out.println("Distance between"+ "givenpoint(10,10) and thispoint "+objMypoint.toString()+" is "+result);
        //does not sent any arguments
        objMypoint.setX(4);
        result=objMypoint.distance();
        System.out.println("Distance between"+ "givenpoint(0,0) and thispoint "+objMypoint.toString()+" is "+result);

        Mypoint givenpoint=new Mypoint(7,9);
        result=objMypoint.distance(givenpoint);
        System.out.println("Distance between"+ "givenpoint"+givenpoint.toString()+" and thispoint "+objMypoint.toString()+" is "+result);
    }
}