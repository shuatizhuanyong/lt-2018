/*
 *
 * analysis: 
 * */
import java.util.*;
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k == 1) return true;
        if (k > nums.length) return false;
        int total = 0;
        for (int e: nums) {
            total += e;
        }
//        System.out.println("len(nums): "+ nums.length +", array:" + Arrays.toString(nums) + ", sum:" + total);
        //System.out.println("group SUM :" + groupSum);
        if (total % k != 0) return false;
        int groupSum = total / k;
   //     Arrays.sort(nums);
 //       System.out.println("len(nums): "+ nums.length +", array:" + Arrays.toString(nums));
  //      System.out.println("group SUM :" + groupSum);

        boolean[] visited = new boolean[nums.length];
        return searchSolutions(nums, visited, 0, 0, groupSum, k); 
    }
    
    int cnt = 0;
    boolean searchSolutions(int[] nums, boolean[] visited,int index, int curSum, int groupSum, int group) {
        cnt++;
        if (group == 1) return true;
        if (curSum > groupSum) return false;
        if (curSum == groupSum) {
            return searchSolutions(nums, visited, 0, 0, groupSum, group - 1);
        }
        for (int i = index; i < nums.length ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(searchSolutions(nums, visited, i + 1, curSum + nums[i], groupSum, group))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }
    public static void main (String args[]) {
        Solution so = new Solution();
        boolean res = false;
        res= so.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4);
        System.out.println(res);
        res= so.canPartitionKSubsets(new int[]{815,625,3889,4471,60,494,944,1118,4623,497,771,679,1240,202,601,883}, 3);
        System.out.println(res);
        res= so.canPartitionKSubsets(new int[]{1, 2, 2, 3, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, 13);
        System.out.println(res);
        System.out.println(so.cnt);
    }
}
