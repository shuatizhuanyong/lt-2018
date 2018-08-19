import java.util.*;

/*
 * [tags] array
 * */
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length;
        int rowEdge = m / 2 + (m % 2 == 1 ? 1: 0);
        for (int i = 0 ; i < rowEdge ; i++) {
            for (int j = 0 ; j < m / 2 ; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[m - 1 - j][i];
                matrix[m - 1 - j][i] = matrix[m - i - 1][m - j - 1];
                matrix[m - i - 1][m - j - 1] = matrix[j][m - i - 1];
                matrix[j][m - i - 1] = t;
            }
        }
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int[][] matrix = new int[][]{{ 1,2,3 }, { 4,5,6 }, { 7,8,9 } };
        so.rotate(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        matrix = new int[][]{{ 1,2,3,4 }, { 5,6, 7, 8 }, { 9, 10 , 11, 12 },{ 13 , 14 , 15, 16 } };
        so.rotate(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
