class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if (nums[start] <= nums[mid]) {
                    start = mid + 1;
                } else if (nums[end] < target) { 
                    end = mid;
                } else { // nums[end] >= target
                    start = mid + 1;
                } 
            } else { // nums[mid] > target
                if (nums[mid] <= nums[end]) {
                    end = mid;
                } else if (nums[start] > target){
                    start = mid + 1;
                } else { // nums[start] <= target
                    end = mid;
                }
            } 
        }
        return nums[start] == target ? start : -1;
    }
    public static void main (String args[]) {
        Solution0 so = new Solution0();
        int res = -1;
        res = so.search(new int[]{1, 2, 4, 6, -4, -2}, -3);
        System.out.println(res);
        res = so.search(new int[]{1, 2, 4, 6, -4, -2}, -4);
        System.out.println(res);
        res = so.search(new int[]{1, 2, 4, 6, -4, -2}, 6);
        System.out.println(res);
        res = so.search(new int[]{5, 1, 3}, 3);
        System.out.println(res);
    }
        
}


class Solution0 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && nums[right] >= target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return (nums[left] == target) ? left : -1;
    }
}
