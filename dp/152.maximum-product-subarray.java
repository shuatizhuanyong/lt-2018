class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxp = nums[0];
        int max = maxp, min = maxp;
        for (int i = 1; i < nums.length ; i++) {
            int orMax = max;
            max = max(max * nums[i], nums[i], min * nums[i]);
            min = min(min * nums[i], nums[i], orMax * nums[i]);
            maxp = Math.max(maxp, max);
        }
        return maxp;
    }
    int max(int ...args) {
        int max = args[0];
        for (int v : args) {
            max = Math.max(v, max);
        }
        return max;
    }
    int min(int ...args) {
        int min = args[0];
        for (int v : args) {
            min = Math.min(v, min);
        }
        return min;
    }
}
