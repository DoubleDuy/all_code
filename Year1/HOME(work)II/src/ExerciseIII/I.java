package ExerciseIII;

public class I {
    public static void main(String[] args) {
        int a=2,b=1,c=3;
        float d=2.5f,e=3.5f;
        float answerA,answerB,answerC;
        
        //a. a*b+e/b+d*c
        answerA = (a * b + e / b + d * c);

        System.out.println(answerA);

        //b. (c-1)+(3*a%2)+e*d
        answerB = ((c - 1) + (3 * a % 2) + e * d);

        System.out.println(answerB);

        //c. 6-(a%2)+(b%2)+(c%2)
        answerC = (6 - (a % 2) + (b % 2) + (c % 2));

        System.out.println(answerC);
    }
}
