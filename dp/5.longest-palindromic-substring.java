class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        if (s == null || s.length() == 0) return sb.toString();
        int m = s.length();
        boolean[][] dp = new boolean[m][m];
        int maxLength = 1, start = 0;
        char[] chs = s.toCharArray();
        for (int i = 0 ; i < m ; i++) {
            dp[i][i] = true;
            for (int j = i - 1 ; j >= 0 ; j--) {
                if (j == i - 1) {
                    dp[i][j] = chs[i] == chs[j];
                } else {
                    dp[i][j] = dp[i - 1][j + 1] && chs[i] == chs[j];
                }
                if (dp[i][j]) {
                    if (i - j + 1 > maxLength) {
                        maxLength = i - j + 1;
                        start = j;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        String res = null;
        res = so.longestPalindrome("babad");
        System.out.println(res);
        res = so.longestPalindrome("cbb");
        System.out.println(res);
    }
}
