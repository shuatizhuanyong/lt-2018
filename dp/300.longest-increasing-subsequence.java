import java.util.*;
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length ; i++) {
            int j = i - 1;
            int index  = -1;
            while (j >= 0) {
                if (nums[j] < nums[i] && (index == -1 ||dp[j] > dp[index])) {
                    index = j;
                }
                j--;
            }
            if (index >= 0) {
            dp[i] = dp[index] + 1;

            res = Math.max(res, dp[i]);
            }
            //System.out.println("i:" + i + ", dp[i]:"+ dp[i]);
        }
        return res;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int res = 0;
        res = so.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        System.out.println(res);
    }
}
