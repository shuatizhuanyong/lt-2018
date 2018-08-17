



import java.util.*;



class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) return 0;
        if (s.length() < 3) return s.length();
        int start = 0, end = 0, len = 0;
        Map<Character, Integer> window = new HashMap<>();
        
        
        while (end < s.length()) {
            char ch = s.charAt(end);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            while (window.size() > 2) {
                char startChar = s.charAt(start);
                window.put(startChar, window.get(startChar) - 1);
                if (window.get(startChar) == 0) {
                    window.remove(startChar);
                }
                start++;
            }
            if (window.size() <= 2 ) {
                len = Math.max(len, end - start + 1);
            }
            end++;
        }
        return len;
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        System.out.println(so.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        System.out.println(so.lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}
class Solution2 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) return 0;
        if (s.length() < 3) return s.length();
        int start = 0, end = 0, len = 0;
        int[] window = new int[128];
        int curTypes = 0;
        
        
        while (end < s.length()) {
            char ch = s.charAt(end++);
            if (window[ch] >= 0) {
                if (window[ch] == 0) curTypes++;
                window[ch]++;
            }
            if (curTypes <= 2) {
                len = Math.max(len, end - start);
            }
            while (curTypes > 2) {
                char startChar = s.charAt(start++);
                if (--window[startChar] == 0)  {
                    curTypes--;
                }

            }
        }
        return len;
    }
    public static void main(String args[]) {
        Solution2 so = new Solution2();
        System.out.println(so.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        System.out.println(so.lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}
