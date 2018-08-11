class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        boolean neg = false;
        int start = 0, res = 0;
        char[] chs = str.toCharArray();
        while (start < chs.length) {
            if (chs[start] == ' ') start++;
            else break;
        }
        if (start == chs.length) return 0;
        if (chs[start] == '+' || chs[start] == '-') {
            neg = (chs[start] == '-');
            start++;
        }
        for (int i = start; i < chs.length ; i++) {
            if (!Character.isDigit(chs[i])) break;
            if (res > Integer.MAX_VALUE / 10) 
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            if (res == Integer.MAX_VALUE / 10 && Integer.valueOf(chs[i] + "") > Integer.MAX_VALUE % 10) 
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            res = res * 10 + Integer.valueOf(chs[i] + "");
        }
        return neg ? 0 - res : res;
    }
}
