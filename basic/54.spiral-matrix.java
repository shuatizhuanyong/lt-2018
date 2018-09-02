import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        int top = 0, left = 0, bottom = m - 1, right = n - 1;
        //int i = 0, j = 0;
        int dir = 0;
        while (left <= right && top <= bottom) {
            if (dir == 0) {
                for (int i = left ; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                top++;
                dir++;
            } else if (dir == 1) {
                for (int i = top ; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
                dir++;
            } else if (dir == 2) {
                for (int i = right ; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
                dir++;
            } else {
                for (int i = bottom ; i >= top ; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
                dir = 0;
            }

        }
        return res;
    }
    public static void main (String[] args) {
        Solution0 so = new Solution0();
        List list;
        list = so.spiralOrder(new int[][]{
            {1, 2, 3}, 
                {4, 5, 6}, 
                {7, 8, 9}});
        System.out.println(list);
        list = so.spiralOrder(new int[][]{
            {7, 8, 9}});
        System.out.println(list);
    }
}


class Solution0 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (top <= bottom && left <= right) {
            for (int i = left ; i <= right ; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top ; i <= bottom ; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom && left <= right) { 
                for (int i = right ; i >= left ; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
                for (int i = bottom ; i >= top ; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
