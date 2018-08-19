class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0) return;
        k = k % nums.length;
        if (k == 0) return;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }
    void rotate(int[] nums, int start, int end) {
        while (start < end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }
}
