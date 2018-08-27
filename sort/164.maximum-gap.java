// memory limited
/*
 * [tags]: review
 * */
import java.util.*;
class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        boolean[] bucket = new boolean[max - min + 1];
        for (int num: nums) {
            bucket[num - min] = true;
        }
        int maxDiff = 0;
        int pre = 0;
        for (int i = 1; i < bucket.length; i++) {
            if (bucket[i] == true) {
                maxDiff = Math.max(i - pre, maxDiff);
                pre = i;
            }
        }
        return maxDiff;
    }
    public static void main (String[] args) {
        Solution0 so = new Solution0();
        int diff;
        diff = so.maximumGap(new int[]{9, 6, 3, 1});
        System.out.println(diff);
    }
}

class Solution0 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int gap = (int)Math.ceil((double)(max - min) / ( nums.length - 1 ));
        int[] btmin = new int[nums.length];
        int[] btmax = new int[nums.length];
        Arrays.fill(btmin, Integer.MAX_VALUE);
        Arrays.fill(btmax, Integer.MIN_VALUE);
        for (int i = 0 ; i < nums.length ; i++) {
            int num = nums[i];
            if (num == min || num == max) continue;
            int inx = (num - min) / gap;
            btmin[inx] = Math.min(btmin[inx], num);
            btmax[inx] = Math.max(btmax[inx], num);
        }
        int pre = min;
        int maxGap = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            // empty bucket
            if (btmin[i] == Integer.MAX_VALUE && btmax[i] == Integer.MIN_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, btmin[i] - pre);
            pre = btmax[i];
        }
        maxGap = Math.max(maxGap, max - pre);
        return maxGap;
    }
}
