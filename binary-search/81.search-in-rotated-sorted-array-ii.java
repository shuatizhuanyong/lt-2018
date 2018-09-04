class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return true;
            if (nums[left] < nums[mid]) {
                if (nums[mid] > target && nums[left] <= target) { 
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] == nums[mid]){
                left++;
            } else {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[left] == target;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        boolean res = false;
        res = so.search(new int[]{2,5,6,0,0,1,2}, 0);
        System.out.println(res);
        res = so.search(new int[]{0,0,0,0,1,0}, 1);
        System.out.println(res);
        res = so.search(new int[]{4, 6, 8 , 10, 0, 1}, 6);
        System.out.println(res);
        res = so.search(new int[]{4, 6, 8 , 10, 0, 1}, 7);
        System.out.println(res);
        res = so.search(new int[]{4, 6, 8 , 10, 0, 1}, 1);
        System.out.println(res);
        res = so.search(new int[]{6, 8 , 10, 0, 1, 2, 3, 5}, 1);
        System.out.println(res);
        res = so.search(new int[]{6, 8 , 10, 0, 1, 2, 3, 5}, 7);
        System.out.println(res);
    }
}
