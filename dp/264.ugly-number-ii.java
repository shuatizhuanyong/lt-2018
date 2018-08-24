class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 5) return n;
        boolean[] dp = new boolean[n + 1];
        for (int i = 1 ; i <= 5 ; i++) dp[i] = true;
        for (int i = 1 ;  i < n + 1; i++ ) {
            if (i * 2 < n + 1 && dp[i]) {
                dp[i * 2] = true;
            }
            if (i * 3 < n + 1 && dp[i]) {
                dp[i * 3] = true;
            }
            if (i * 5 < n + 1 && dp[i]) {
                dp[i * 5] = true;
            }
        }
        int total = 0;
        for (boolean isUgly : dp) if(isUgly) total++;
        return total;
        
    }
}
