
import java.util.*;
/*
 * [tags] heap, divide and conquer
 * [important]
 * */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int pi = partition(nums, start, end);
            if (pi == k - 1) return nums[pi];
            else if (pi < k - 1) {
                start = pi + 1;
            } else {
                end = pi - 1;
            }

        }
        //System.out.println("before return:" + Arrays.toString(nums));
        return nums[start];
    }
    int partition(int[] nums, int start, int end) {
        int povit = nums[end]; 
        int p = start;
        int i = end - 1;
        //System.out.println(start + "===" + end + " , povit=" + povit);
        while (i >= p) {
            if (nums[i] > povit) {
         //       System.out.println(Arrays.toString(nums));
         //       System.out.println(i + ", " + p);
                swap(nums, i, p);
                p++;
            } else {
                i--;
            }
        }
        swap(nums, p, end);
        return p;
    }
    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int v = -1;
        v = so.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);
        System.out.println(v);
    }
}
