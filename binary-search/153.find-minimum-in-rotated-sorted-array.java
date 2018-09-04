class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("invalid argument");
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < nums[right]) {
                if (mid == 0 || nums[mid] < nums[mid - 1]) return nums[mid];
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int rs = -1;
        rs = so.findMin(new int[]{0});
        System.out.println(rs);
        rs = so.findMin(new int[]{1, 0});
        System.out.println(rs);
        rs = so.findMin(new int[]{1, 0, 2});
        System.out.println(rs);
        rs = so.findMin(new int[]{5, 2, 4, 12, 16});
        System.out.println(rs);
        rs = so.findMin(new int[]{1, 2, 20, 12});
        System.out.println(rs);
    }
}
