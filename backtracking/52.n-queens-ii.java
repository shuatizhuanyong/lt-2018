import java.util.*;


class Solution {

    int count = 0;
    public int totalNQueens(int n) {
        if (n == 1)  return 1;
        if (n < 4) return 0;
        int[] qs = new int[n];
        Arrays.fill(qs, -1);
        searchSolutions(qs, 0);
        return count;
    }
    void searchSolutions(int[] qs, int index) {
        if (index == qs.length) {
            //System.out.println(Arrays.toString(qs));
            count++;
            return;
        }
        for (int i = 0 ; i < qs.length ; i++) {
            if(check(qs, index, i)) {
                qs[index] = i;
                searchSolutions(qs, index + 1);
                qs[index] = -1;
            }
        }
    }
    boolean check(int[] qs, int index, int row) {
        int step = 1;
        while ( index - step >= 0) {
            if(qs[index - step] == -1 ) {
                step++;
                continue;
            }
            if (qs[index - step] == row) return false;
            if (qs[index - step] == row + step || qs[index - step] == row - step) return false;
            step++;
        }
        return true;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int total = 0;
        total = so.totalNQueens(3);
        System.out.println(total);
        total = so.totalNQueens(4);
        System.out.println(total);
        total = so.totalNQueens(5);
        System.out.println(total);
        
        
    }
    
}
