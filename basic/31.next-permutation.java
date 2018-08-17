import java.util.*;
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int pi = nums.length - 1;
        while (pi >= 0) {
            if (pi == 0 || nums[pi] > nums[pi - 1]) break;
            pi--;
        }
        if (pi == 0) {
            Arrays.sort(nums);
            return;
        }
        int pn = pi, i = nums.length - 1;
        //System.out.println(nums[pi] + ", pn:" + nums[pn]);
        while (i >= pi) {
            if (nums[i] > nums[pi - 1] && nums[i] < nums[pn])  {
                pn = i;
            }
            i--;
        }
        swap(nums, pn, pi - 1);
        Arrays.sort(nums, pi, nums.length);
    }
    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] =nums[j];
        nums[j] = t;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int[] p = new int[]{3,4,7,2,4,5};
        for (int i = 0 ; i < 10; i++) {
            so.nextPermutation(p);
            System.out.println(Arrays.toString(p));
        }
        int[] t= new int[]{9,8,7,5,3,2,1};
        Arrays.sort(t, 4, 6);
        System.out.println(Arrays.toString(t));
    }
}
