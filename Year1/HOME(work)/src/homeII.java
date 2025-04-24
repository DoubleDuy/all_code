public class homeII {
    public static void main(String[] args) {
        float a = 12, b = 10, c = 15, d = 2.5f, e = 3.5f;
        String str = "Total is ";
        char x = 'X', Y = 'y';
        boolean test = false;

        float answer1, answer2, answer3, answer4;
        boolean answer5, answer6, answer7, answer8, answer9, answer10, answer11, answer13, answer14, answer15;
        String answer12;

        answer1 = a * c + e / b + d * b % 3;
        answer2 = (c - 1) + (3 * a % 2) + e * b;
        answer3 = 6 - (a % 7) + (b % 4) + (c % 2);
        answer4 = ((a - 1 + 2 * e) % (e * 2) + b) - c * 1 / 2;
        answer5 = (!(a != 12) && ((c % 2) > d));
        answer6 = !((b <= c) || (d - 1 > 0));
        answer7 = (a <= 12) || ((a != b) && ((c + d) == 1));
        answer8 = a > e;
        answer9 = b != c;
        answer10 = (!((b % d) >= (b - (d * 4)))) || test;
        answer11 = test != true;
        answer12 = str;
        // answer13 = a * str;
        answer14 = !(x != 'x') && !(Y == 'y');
        answer15 = !((x == 'x') || (Y != 'y'));

        System.out.println("Answer1 is = " + answer1);
        System.out.println("Answer2 is = " + answer2);
        System.out.println("Answer3 is = " + answer3);
        System.out.println("Answer4 is = " + answer4);
        System.out.println("Answer5 is = " + answer5);
        System.out.println("Answer6 is = " + answer6);
        System.out.println("Answer7 is = " + answer7);
        System.out.println("Answer8 is = " + answer8);
        System.out.println("Answer9 is = " + answer9);
        System.out.println("Answer10is = " + answer10);
        System.out.println("Answer11 is = " + answer11);
        System.out.println("Answer12 is = " + answer12);
        // System.out.print("Answer13 is = " + answer13);
        System.out.println("Answer14 is = " + answer14);
        System.out.println("Answer15 is = " + answer15);

    }
}
