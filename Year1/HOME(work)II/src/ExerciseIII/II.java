package ExerciseIII;

public class II {
    public static void main(String[] args) {
        char A='A',B='t';
        float C=-5.5f,D=-2.5f;
        int X=256,Y=8;
        boolean resultA,resultB,resultC,resultD;

        //a.
        resultA = (!(A != 'A')) && ((C % 2) > D);
        //b.
        resultB = !((B <= 'T') || (D - C > 0));
        //d.
        resultC = !((A <= 'a') || ((A != B) && ((C + D) == 3)));
        //d.
        //resultD = (X^Y)>0&&X>0; ERROR

        System.out.println(resultA);
        System.out.println(resultB);
        System.out.println(resultC);
        //System.out.println(resultD); ERROR
    }
}
