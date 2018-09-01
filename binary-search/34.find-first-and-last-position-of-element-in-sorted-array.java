class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        int l = -1, r = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (mid == 0) {
                    l = mid;
                    break;
                } else if (nums[mid - 1] < target) {
                    l = mid;
                    break;
                } else {
                    right = mid - 1;
                }
            }
        }

        if (l < 0) {
            return new int[]{-1, -1};
        }
        left = l; 
        right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (mid == nums.length - 1) {
                    r = mid;
                    break;
                } else if (nums[mid + 1] > target) {
                    r = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            }
        }
        return new int[]{l, r};
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int[] res;
        res = so.searchRange(new int[]{ 5,7,7,8,8,10 }, 8);
        System.out.println(java.util.Arrays.toString(res));
        res = so.searchRange(new int[]{5, 10}, 5);
        res = so.searchRange(new int[]{5, 5}, 5);
        System.out.println(java.util.Arrays.toString(res));
        res = so.searchRange(new int[]{3, 5, 5}, 5);
        System.out.println(java.util.Arrays.toString(res));
        res = so.searchRange(new int[]{3, 5, 5, 7}, 5);
        System.out.println(java.util.Arrays.toString(res));
    }
}
