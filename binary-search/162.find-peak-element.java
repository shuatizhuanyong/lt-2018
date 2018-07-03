class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1 || nums[0] > nums[1]) return nums[0];
        int len = nums.length;
        int start = 0, end = len - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                start = mid + 1; 
            } else {
                end = mid;
            }
        }
        return start;
    }
    public static void main (String args[]) {
        Solution so = new Solution();
        int rs = -1;
        rs = so.findPeakElement(new int[]{1, 2, 1});
        System.out.println(rs);
    }
}
