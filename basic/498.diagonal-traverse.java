import java.util.*;
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        int index = 0, startRow = 0, startCol = 0;
        List<List<Integer>> flist = new ArrayList<>();
        int step = 0;
        while (startRow + startCol < m + n - 1) {
            int i = startRow, j = startCol;
            List<Integer> list = new ArrayList<>();
            while (i < m && j >= 0 && i >= 0 && j < n) {
                list.add(matrix[i][j]);
                //res[index++] = matrix[i][j];
                i++;
                j--;
            }
            startCol++;
            if (startCol == n) {
                startCol--;
                startRow++;
            }
            if (step++ % 2 == 0) Collections.reverse(list);
            for (Integer num: list) res[index++] = num;
        }

        return res;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int[] res;
        res = so.findDiagonalOrder(new int[][]{
            { 1, 2, 3 }, 
                { 4, 5, 6 }, 
                { 7, 8, 9 }});
        System.out.println(Arrays.toString(res));
    }
}
