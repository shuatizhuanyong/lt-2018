class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
        int m = cost.length;
        int[] dp = new int[m + 1];
        dp[0] = 0; dp[1] = 0;
        for (int i = 2 ; i <= m ; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]); 
        }
        return dp[m];
    }
}
