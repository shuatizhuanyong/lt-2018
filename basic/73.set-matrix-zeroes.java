/*
 * it requires a constant space usage at best.
 * let me start m + n space
 * use the first row/ column to mark is zero or not
 * */
class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        boolean[] zr = new boolean[m];
        boolean[] zc = new boolean[n];
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zr[i] = true;
                    zc[j] = true;
                }
            }
        }
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n; j++) {
                if (zr[i] || zc[j]) matrix[i][j] = 0;
            }
        }
        
    }
}
