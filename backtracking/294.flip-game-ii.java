class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) return false;
        char[] chs = s.toCharArray();
        return canWin(chs);
    }
    boolean canWin(char[] chs) {
        for (int i = 0 ; i < chs.length - 1; i++) {
            if (chs[i] == '-' || chs[i + 1] == '-') continue;
            chs[i] = '-';
            chs[i + 1] = '-';
            boolean win = !canWin(chs);
            if (win) return true;
            chs[i] = '+';
            chs[i + 1] = '+';
        }
        return false;
    }
}
class Solution0 {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) return false;
        Map<String, Boolean> mem = new HashMap<>();
        return canWin(s, mem);
    }
    boolean canWin(String s, Map<String, Boolean> mem) {
        if (mem.containsKey(s)) return mem.get(s);
        for (int i = 0 ; i < s.length() - 1; i++) {
            if (s.charAt(i) == '-' || s.charAt(i + 1) == '-') continue;
            boolean win = !canWin(s.substring(0, i) + "--" + s.substring(i + 1), mem);
            if (win) return true;
        }
        return false;
    }
}
