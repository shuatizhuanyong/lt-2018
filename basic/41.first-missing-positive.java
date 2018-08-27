import java.util.*;
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 0 ; i < nums.length ; i++) {
            //int index = i;
            while (nums[i] != i + 1) {
                if (nums[i] > 0 && nums[i] - 1 < nums.length)  {
                    if (nums[nums[i] - 1] == nums[i]) break;
                    swap(nums, i, nums[i] - 1);
                }
                else break;
            }
        }
        System.out.println(Arrays.toString(nums));
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
            i++;
        }
        return nums.length + 1;
    }
    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main (String[] args) {
        Solution0 so = new Solution0();
        int r = 0;
        r = so.firstMissingPositive(new int[]{3, 2, 1});
        System.out.println(r);
        r = so.firstMissingPositive(new int[]{1, 1, 2, 2});
        System.out.println(r);
        r = so.firstMissingPositive(new int[]{1, 1, 3, 3});
        System.out.println(r);
        r = so.firstMissingPositive(new int[]{1, 2, 3});
        System.out.println(r);
    }
}
class Solution0 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        boolean existLast = false;
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] == nums.length) existLast = true;
            while (nums[i] != i) {
                if (nums[i] >= 1 && nums[i] < nums.length) {
                    if (nums[i] == nums[nums[i]]) break;
                    swap(nums, i, nums[i]);
                    if (nums[i] == nums.length) existLast = true;
                } else 
                    break;

            }
        }
        for (int i = 1 ; i < nums.length ; i++) {
            if (nums[i] != i) return i;
        }
        //System.out.println(Arrays.toString(nums) + ", last:" + existLast);
        return existLast ? nums.length + 1: nums.length;
    }
    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
