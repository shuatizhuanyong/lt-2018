class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0, sum = 0, res = nums.length + 1;
        for (int i = 0 ; i < nums.length ; i++) {
            sum += nums[i];
            while (sum >= s) {
                res = Math.min(res, i - start + 1);
                sum -= nums[start++];
            }
        }
        return res > nums.length ? 0 : res;
    }
}
