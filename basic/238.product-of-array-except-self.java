class Solution {
    /**
     * dp[left] = dp[left - 1] * nums[left - 1]
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] output = new int[nums.length];
        //Arrays.fill(output, 1);
        output[0] = 1;
        for (int i = 1; i < nums.length ; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        int pre = 1;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            int tmp = pre * nums[i + 1];
            output[i] *= tmp;
            pre = tmp;
        }
        return output;
    }
}
