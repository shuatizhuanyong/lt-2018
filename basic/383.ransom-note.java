class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;
        if (ransomNote.length() > magazine.length()) return false;
        int[] cnts = int[26];
        for (char c: magazine.toCharArray()) {
            cnts[c - 'a']++;
        }
        for (char c: ransomNote.toCharArray()) {
            if (--cnts[c - 'a'] < 0) return false;
        }
        return true;
    }
}
