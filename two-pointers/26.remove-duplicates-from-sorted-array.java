class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return -1;
        if (nums.length < 2) return nums.length;
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
                j++;
            } else {
                j++;
            }
        }
        return i + 1;
    }
}
