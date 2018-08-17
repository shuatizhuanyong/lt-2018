import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        List list ;
        list = so.threeSum(new int[]{1,1,2,2,2,-1,-1,-2,-2,0,0,0});
        System.out.println(list);
    }
}
