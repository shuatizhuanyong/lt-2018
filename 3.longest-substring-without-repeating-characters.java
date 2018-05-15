import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int dis = 0, start = 0, end = 0;
        while (end < s.length()) {
            char ch = s.charAt(end);
            if (set.add(ch)) {
                dis = Math.max(dis, end - start + 1);
            } else {
                while (s.charAt(start) != ch) {
                    set.remove(s.charAt(start++));
                }
                start++;
            }
            end++;
        }
        return dis;
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        System.out.println(so.lengthOfLongestSubstring("bbbbbb"));
        System.out.println("aaabcbasdf");
        System.out.println(so.lengthOfLongestSubstring("aaabcbaab"));
    }
}
