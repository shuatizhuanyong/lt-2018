class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        if (target > nums[right]) return right + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;;
            if (nums[mid] == target)  {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else { 
                right = mid;
            }
        }
        return left;
    }
    public static void main (String args[]) {
        Solution so = new Solution();
        int p = -1;
        p = so.searchInsert(new int[]{1}, 5);
        System.out.println(p);
        p = so.searchInsert(new int[]{10}, 5);
        System.out.println(p);
    }
}
