import java.util.*;
class Solution {
    int[] times = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
    //int[] minutes = new int[]{};
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        if (num < 0 || num > 10) return res;
        searchSolutions(res, new int[2], 0, new boolean[10], num);
        return res;
    }
    void searchSolutions(List<String> res, int[] cur, int index, boolean[] visited, int n) {
        if (n == 0) {
            res.add(convertToTime(cur));
            return;
        }
        for (int i = index ; i < times.length; i++) {
            if (visited[i]) continue;
            if (i < 4 && cur[0] + times[i] > 11) continue;
            if (i >= 4 && cur[1] + times[i] > 59) continue;
            visited[i] = true;
            if (i < 4) {
                cur[0] += times[i];
            } else {
                cur[1] += times[i];
            }
            searchSolutions(res, cur, i + 1, visited, n - 1);
            visited[i] = false;
            if (i < 4) {
                cur[0] -= times[i];
            } else {
                cur[1] -= times[i];
            }
        }
    }
    String convertToTime(int[] cur) {
        StringBuilder sb = new StringBuilder();
        sb.append(cur[0]).append(":");
        if (cur[1] < 10) {
            sb.append('0');
        }
        sb.append(cur[1]);
        return sb.toString();
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        List<String> res; 
        res = so.readBinaryWatch(1);
        System.out.println(res);
        res = so.readBinaryWatch(3);
        System.out.println(res);
        res = so.readBinaryWatch(0);
        System.out.println(res);
        
    }

}
