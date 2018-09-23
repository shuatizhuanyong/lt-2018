class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        int[] dp = new int[chs.length + 1];
        if (chs[0] == '0') return 0;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2 ; i <= chs.length ; i++) {
            if (chs[i - 1] == '0') {
                if (chs[i - 2] != '1' && chs[i - 2] != '2') return 0;
                dp[i] = dp[i - 2];
            } else if (chs[i - 2] == '1' || (chs[i - 2] == '2' && chs[i - 1] >= '1' && chs[i - 1] <= '6')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        System.out.println(java.util.Arrays.toString(dp));
        return dp[dp.length - 1];
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int res = -1 ;
        res = so.numDecodings("226");
        System.out.println(res);
    }
}
