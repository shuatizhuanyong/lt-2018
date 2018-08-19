import java.util.*;
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 1) {
            res.add(Arrays.asList("Q"));
            return res;
        }
        if (n < 4) return res;
        int[] qs = new int[n];
        Arrays.fill(qs, -1);
        searchSolutions(qs, 0, res);
        return res;
    }
    void searchSolutions(int[] qs, int index, List<List<String>> res) {
        if (index == qs.length) {
            res.add(convertIndextoList(qs));
            return;
        }
        for (int i = 0 ; i < qs.length ; i++) {
            if (check(qs, index, i)) {
                qs[index] = i;
                searchSolutions(qs, index + 1, res);
                qs[index] = -1;
            }
        }
    }
    boolean check(int[] qs, int index, int row) {
        int step = 1;
        while (index + step < qs.length) {
            if (qs[index + step] == row) return false;
            if (qs[index + step] == row + step) return false;
            if (qs[index + step] >= 0 && qs[index + step] == row - step) return false;
            step++;
        }
        step = 1;
        while (index - step >= 0) {
            if (qs[index - step] == row) return false;
            if (qs[index - step] == row + step) return false;
            if (qs[index - step] >= 0 && qs[index - step] == row - step) return false;
            step++;
        }
        return true;
    }
    List<String> convertIndextoList(int[] qs) {
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < qs.length ; i++) {
            char[] chs = new char[qs.length];
            Arrays.fill(chs, '.');
            chs[qs[i]] = 'Q';
            list.add(new String(chs));
        }
        return list;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        List list;
        list = so.solveNQueens(4);
        System.out.println(list);
    }
}
