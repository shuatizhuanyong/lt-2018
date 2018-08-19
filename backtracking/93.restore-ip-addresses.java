import java.util.*;
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 16) return res;
        searchSolutions(s, 0, 0, "", res);
        return res;
    }
    void searchSolutions(String s, int index, int segNum, String cur, List<String> res) {
        if (index == s.length()) {
            if (segNum == 4) {
                res.add(cur);
            }
            return;
        }
        int mEnd = Math.min(index + 3, s.length());
        int end = index + 1;
        while (end <= mEnd){
            String sub = s.substring(index, end);
            if (sub.length() > 1 && sub.charAt(0) == '0') {
                end++;
                continue;
            }
            int n = Integer.valueOf(sub);
            if (n >= 0 && n <= 255) {
                searchSolutions(s, end, segNum + 1, cur.length() > 0 ? cur + "." + n: "" + n, res);
            }
            end++;
        }
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        List res;
        res = so.restoreIpAddresses("0000");
        System.out.println(res);
        res = so.restoreIpAddresses("02000");
        System.out.println(res);
    }
}
