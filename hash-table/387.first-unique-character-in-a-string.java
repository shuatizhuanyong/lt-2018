import java.util.*;
class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        char[] chs = s.toCharArray();
        int[] indexs = new int[26];
        // -1 not showed, -2 showed more than 1 once, passtive represent showed index
        Arrays.fill(indexs, -1);
        for (int i = 0 ; i < chs.length ; i++) {
            char c = chs[i];
            if (indexs[c - 'a'] == -1) {
                indexs[c - 'a'] = i;
            } else if (indexs[c - 'a'] >= 0) {
                indexs[c - 'a'] = -2;
            }
        }
        int res = -1;
        for (int i = 0 ; i < indexs.length ; i++) {
            if (indexs[i] >= 0) {
                if (res == -1) {
                    res = indexs[i];
                } else {
                    res = Math.min(res, indexs[i]);
                }
            }
        }
        return res;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int res = - 1;
        res = so.firstUniqChar("leetcode");
        System.out.println(res);
        res = so.firstUniqChar("loveleetcode");
        System.out.println(res);
    }
}
