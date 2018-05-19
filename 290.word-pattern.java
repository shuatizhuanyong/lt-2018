import java.util.*;
class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern.length() == 0 && str.length() == 0) return true;
        if (pattern.length() == 0 || str.length() == 0) return false;
        String[] arr = str.split(" ");
        if (arr.length != pattern.length()) return false;
        String[] map = new String[26];
        Map<String, Character> stc = new HashMap<>();
        for (int i = 0 ; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String s = arr[i];
            if (map[ch - 'a'] == null && stc.get(s) == null) {
                map[ch - 'a'] = s;
                stc.put(s, Character.valueOf(ch));
            } else if (s.equals(map[ch - 'a']) && ch == stc.get(s)){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main (String args[]) {
        Solution so = new Solution();
        boolean res = false;
        res = so.wordPattern("abba", "dog cat cat dog");
        System.out.println(res);
        res = so.wordPattern("abba", "dog dog dog dog");
        System.out.println(res);
        
    }
}
