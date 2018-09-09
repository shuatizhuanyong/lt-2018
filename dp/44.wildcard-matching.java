class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        if (s.length() == 0 && p.length() == 0) return true;
        if (p.length() == 0) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        dp[0][0] = true;
        for (int i = 0 ; i < chp.length; i++){
            if(chp[i] == '*') {
                dp[0][i + 1] = true;
            } else break;
        }
        //if (chp[0] == '*') {
        //    for (int i = 0 ; i < dp.length; i++){
        //        dp[i][1] = true;
        //    }
        //}

        for (int i = 1 ; i <= chs.length ; i++) {
            for (int j = 1 ; j <= chp.length ; j++) {
                if (chp[j - 1] == chs[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (chp[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (chp[j - 1] == '*') {
                    //if (i == 2) {
                    //  for (boolean[] d: dp)  {
                    //      System.out.println(java.util.Arrays.toString(d));
                    //  }
                    //}
                    if (dp[i - 1][j] || dp[i][j - 1]) {
                        dp[i][j] = true;
                    }
                }
                
            }
        }
        return dp[chs.length][chp.length];
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        boolean res = false;
    //    res = so.isMatch("abc", "abc");
    //    System.out.println(res);
    //    res = so.isMatch("abc", "a*c");
    //    System.out.println(res);
    //    res = so.isMatch("abc", "e*c");
    //    System.out.println(res);
    //    res = so.isMatch("abc", "a*cd");
    //    System.out.println(res);
    //    res = so.isMatch("abc", "a*c*");
    //    System.out.println(res);
    //    res = so.isMatch("abc", "ab*c*");
    //    System.out.println(res);
    //    res = so.isMatch("abc", "*");
    //    System.out.println(res);
    //    res = so.isMatch("a", "*a");
    //    System.out.println(res);
        res = so.isMatch("ab", "a*");
        System.out.println(res);
    }
}
