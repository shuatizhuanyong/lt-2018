import java.util.*;
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if (B.length == 0) return new int[0][0];
        int[][] rs = new int[A.length][B[0].length];
        
        for (int i = 0 ; i < A.length ; i++) {
            for (int j = 0 ; j < A[0].length ; j++) {
                int anum = A[i][j];
                if (anum == 0) {
                    continue;
                }
                for (int m = 0 ; m < B[0].length; m++) {
                    rs[i][m] += anum * B[j][m];
                }
            }
        }
        return rs;
    }
    public static void main (String args[]) {
        Solution so = new Solution();
        int[][] rs;
        rs = so.multiply(new int[][]{{1, 0, 0}, {-1, 0, 3}}, new int[][]{{7, 0, 0}, {0, 0, 0}, {0, 0, 1}});

        Helper.print(rs);
        rs = so.multiply(new int[][]{ { 2,1 },{ 4,3 } }, new int[][]{ { 1,2 },{ 1, 0 } });
        Helper.print(rs);
    }
}
