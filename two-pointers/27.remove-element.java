class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = nums.length - 1;
        //while (i < j) {
        while (i <= j) {
            while (i <= j && nums[i] != val) {
                i++;
            }
            while (i <= j && nums[j] == val) {
                j--;
            }
            if (i > j) break;
            swap(nums, i, j);
        }
        return i;
    }
    void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
