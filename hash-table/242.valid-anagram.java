class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] map = new int[26];
        char[] chsarr = s.toCharArray();
        char[] chtarr = t.toCharArray();
        for (int i = 0 ; i < chsarr.length ; i++) {
            char cs = chsarr[i];
            char ct = chtarr[i];
            map[cs - 'a']++;
            map[ct - 'a']--;
        }
        for (int i : map) {
            if (i != 0) return false;
        }
        return true;
    }
}
