class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 2) return res;
        char[] chs = s.toCharArray();
        for (int i = 0 ; i < chs.length - 1; i++) {
           if (chs[i] != chs[i + 1] || chs[i] == '-') continue;
           flipTwo(chs, i);
           res.add(new String(chs));
           flipTwo(chs, i);
        }
        return res;
    }
    void flipTwo(char[] chs, int i) {
        char ori = chs[i];
        char c = (ori == '+' ? '-' : '+');
        chs[i] = c;
        chs[i + 1] = c;
    }
}
