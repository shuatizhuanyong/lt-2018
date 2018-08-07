class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0) return true;
        if(nums.length == 1) return true;
        int max = nums[0], i = 0;
        while (i <= max) {
            if (max >= nums.length - 1) return true;
            if (i == max && nums[i] == 0) break;
            max = Math.max(i + nums[i], max);
            i++;
        }
        return false;
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        boolean res = false;
        res = so.canJump(new int[]{2,3,1,1,4});
        System.out.println(res);
    }
}
