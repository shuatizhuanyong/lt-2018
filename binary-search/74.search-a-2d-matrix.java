class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return matrix[start / n][start % n] == target;
    }
}
class Solution0 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
