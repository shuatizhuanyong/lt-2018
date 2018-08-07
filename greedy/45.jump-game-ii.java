class Solution {
    public int jump(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int step = 0, i = 0, max = 0;
        while (i <= max) {
            if (max >= nums.length - 1) return step;
            if (i == max && nums[i] == 0) break;
            int stepMax = max;
            while (i <= stepMax) {
                max = Math.max(max, i + nums[i]);
                i++;
            }
            step++;
        }
        return -1;
    }
}
// [1, 0]
// assume you can always  reach the last index
class Solution0 {
    public int jump(int[] nums) {
        int furthest = 0, step = 0, stepFurthest = 0;
        for (int i = 0 ;  i < nums.length ; i++) {
            if (i > furthest) break;
            if (i > stepFurthest) {
                step++;
                stepFurthest = furthest;
            }
            furthest = Math.max(furthest, i + nums[i]);
        }
        return step;
    }
}
