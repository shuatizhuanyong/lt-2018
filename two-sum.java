import java.util.Map;
import java.util.HashMap;
import java.util.Arrays; 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) return new int[]{-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++) {
            int n = nums[i];
            if (map.containsKey(target - n)) {
                return new int[]{map.get(target - n), i};
            }
            map.put(n ,i);
        }
        return new int[]{-1, -1};
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        int[] res;
        res = so.twoSum(new int[]{1, 3, 4, 6, 2, -3}, 3);
        System.out.println(Arrays.toString(res));
    }

}
