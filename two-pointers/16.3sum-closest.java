class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return Integer.MAX_VALUE;
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0 ; i < nums.length ; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == target) return sum;
                int lclGap = Math.abs(sum - target);
                if (lclGap < Math.abs(res - target)) {
                    res = sum;
                }
               // while (left < right && nums[left] == nums[left + 1]) left++;
               // while (left < right && nums[right] == nums[right - 1]) right--;
                if (sum < target) {
                    left++;
                } else right--;
            }
        }
        return res;
        
    }
}
