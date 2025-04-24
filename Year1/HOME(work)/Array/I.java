package Array;

import java.util.Arrays;

public class I {
    public static void main(String[] args) {
        // การบ้านในโจทย์ข้อ4
        int i;
        int[] mynum = new int[] { 12, 0, 25, 17, 30, 6, 19, 1, 0, 17 };
        Arrays.sort(mynum);
        for (i = 0; i <= mynum.length; i++) {
            System.out.print(mynum[i] + " ");
        }
        // System.out.println();
    }
}
