/*
 * */
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int notZero = 0, notTwo = nums.length - 1;
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] == 0) {
                swap(nums, i, notZero++);
            }
        }
        for (int i = nums.length - 1 ; i >= notZero ; i--) {
            if (nums[i] == 2) {
                swap(nums, i, notTwo--);
            }
        }
    }
    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
class Solution0 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int notZero = 0, notTwo = nums.length - 1;
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] == 0) {
                swap(nums, i, notZero++);
            } else if (nums[i] == 2) {
                swap(nums, i--, notTwo--);
            }
        }
    }
    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
