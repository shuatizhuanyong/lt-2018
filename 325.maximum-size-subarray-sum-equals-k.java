import java.util.*;
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0, max = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            sum += nums[i];
            if (sum == k) {
                max = i + 1;
            } else if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }

            if (map.containsKey(sum)) continue;
            map.put(sum, i);
        }
        return max;
    }
    public static void main (String args[]) {
        Solution so = new Solution();
        int rs = 0;
        rs = so.maxSubArrayLen(new int[]{-2,-1,2,1}, 1);
        System.out.println(rs);
        rs = so.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3);
        System.out.println(rs);

        
    }
}
