import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); //nlogn

        for (int i = 0 ; i < nums.length ; i++) { 
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1 ; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int m = j + 1, n = nums.length - 1;
                while (m < n){
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum == target) {
                        List list = Arrays.asList(nums[i], nums[j], nums[m], nums[n]);
                        res.add(list);
                        while (m < n && nums[m] == nums[m + 1]) {
                            m++;
                        }
                        while (m < n && nums[n] == nums[n - 1]) {
                            n--;
                        }
                        m++;
                        n--;
                    } else if (sum > target) {
                        n--;
                    } else {
                        m++;
                    }
                }
                
            }
        }
        return res;
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        List<List<Integer>> res = so.fourSum(new int[]{1, 1, 2, 1, 4, 3, 2}, 7);
        System.out.println(res);
        res = so.fourSum(new int[]{1, 1, 2, 1, 4, 3, 2}, 6);
        System.out.println(res);
    }
}
