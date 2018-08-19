class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("argument is empty");
        }
        int max = nums[0], lcl = nums[0];
        for (int i = 1 ; i < nums.length ; i++) {
            if (lcl < 0) {
                lcl = nums[i];
            } else {
                if (lcl + nums[i] >= 0) {
                    lcl += nums[i];
                } else {
                    lcl = nums[i];
                }
            }
            max = Math.max(max, lcl);
        }
        return max;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int max = -1;
        max = so.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(max);
    }
}
