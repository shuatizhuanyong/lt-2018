import java.util.*;
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            String range = (lower) + "";
            if (lower < upper)  {
                range = range + "->" + upper;
            }
            res.add(range);
            return res;
        }
        List<Long> list = new ArrayList<>();

        long llow = (long)lower;
        long lupper = (long)upper;
        list.add(--llow);
        for(int num: nums) list.add((long)num);
        list.add(++lupper);

        for (int i = 1; i < list.size() ; i++) {
            if (list.get(i) == llow) continue;
            if (list.get(i) == llow + 1) {
                llow++;
                continue;
            }
            res.add(getRange(llow, list.get(i)));
            llow = list.get(i);
        }
       // if (upper > lower) {
       //     res.add(getRange(lower, upper + 1));
       // }
        return res;
    }
    String getRange(long lower, long upper) {
        StringBuilder sb = new StringBuilder();
        sb.append(lower + 1);
        if (upper - 1 > lower + 1) {
            sb.append("->").append(upper - 1);
        }
        return sb.toString();
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        List<String> res;
        res = so.findMissingRanges(new int[]{ 0, 1, 3, 50, 75 }, 0, 99);
        System.out.println(res);
        res = so.findMissingRanges(new int[]{}, 0, 0);
        System.out.println(res);
        res = so.findMissingRanges(new int[]{-1}, -2, -1);
        System.out.println(res);
        res = so.findMissingRanges(new int[]{ 2147483647}, -2147483648, 2147483647);
        System.out.println(res);
    }
}
