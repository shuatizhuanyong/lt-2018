import java.util.*;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] rs = new int[nums.length - k + 1];
        if (nums == null || nums.length == 0) return new int[0];
        if (nums.length <= k) {
            int mx = nums[0];
            for (int n: nums) {
                mx = Math.max(mx, n);
            }
            Arrays.fill(rs, mx);
            return rs;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer i0, Integer i1) {
                return nums[i1] - nums[i0];
            }
        });
        
        for (int i = 0 ; i < nums.length; i++) {
            pq.offer(i);
            while (pq.peek() <= i - k) {
                pq.poll();
            }
            if (i >= k - 1) {
                rs[i - k + 1] = nums[pq.peek()];
            }
        }
        return rs;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int[] rs = null;
        rs = so.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        System.out.println(Arrays.toString(rs));
        rs = so.maxSlidingWindow(new int[]{1, -1}, 1);
        System.out.println(Arrays.toString(rs));


    }
}
