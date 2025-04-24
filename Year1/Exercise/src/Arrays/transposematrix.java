package Arrays;

public class transposematrix {
    public static void main(String[] args) {
        // TODO code application logic here
        // ประกาศอา์เรย์ 2 มิติไพร้อมกับกำหนดค่าเริ่มต้น
        int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
        // ประกาศอาร์เรย์ 2 มิติที่ไม่กำหนดค่าเริ่มต้นใดๆ
        int[][] transpose = new int[4][2];
        int i, j;
        // transpose matrix
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix[i].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        // print original matrix
        System.out.println("----------Original Matrix----------");
        for (i = 0; i <= 1; i++) {
            for (j = 0; j <= 3; j++) {
                System.out.print(matrix[i][j] + "          ");
            }
            System.out.println("");
        }
        System.out.println("---------Transpose Matrix---------");
        for (i = 0; i <= 3; i++) {
            for (j = 0; j <= 1; j++) {
                System.out.print(transpose[i][j] + "          ");
            }
            System.out.println("");
        }
    }
}
