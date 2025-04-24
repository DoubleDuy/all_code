package ExerciseV;

public class XI {
    public static void main(String[] args) {
        int i,sum=0;
        for ( i = 1; i <= 100; i++) {
            if (i % 2 == 1) {
                System.out.println("Round " + i);

                sum += i;
            }
        }
        System.out.print(sum);
    }
}
