import java.util.Map;
import java.util.HashMap;
import java.util.Arrays; 

// only thing want to say before coding: try 'template'
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return null;
        Map<Character, Integer> map = new HashMap<>();
        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        String window = "";

        Map<Character, Integer> wmap = new HashMap<>();
        int count = 0;
        int start = 0, end = 0;
        String res = s + "a";

        while (end < s.length()) {
            char ch = s.charAt(end);

            if (map.get(ch) != null) {
                if (wmap.getOrDefault(ch, 0) < map.get(ch)) count++;
                wmap.put(ch, wmap.getOrDefault(ch, 0) + 1);
            }
            while (count == t.length()) {
                if(end - start + 1 < res.length()) {
                    res = s.substring(start, end + 1);
                }
                char startc = s.charAt(start);
                if (map.containsKey(startc)) {
                    wmap.put(startc, wmap.getOrDefault(startc, 0) - 1);
                    if (wmap.get(startc) < map.get(startc)) count--;
                }
                start++;
            }
            end++;
        } 
        return res.length() > s.length() ? "" : res ;
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        String w = so.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(w);

    }
}
