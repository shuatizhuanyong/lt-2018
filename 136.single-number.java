import java.util.*;
class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        int ngtct = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            int n = nums[i], j = 31;
            if (n < 0) {
                ngtct++;
            }
            while (n != 0) {
                int b = n & 1;
                bits[j--] += b;
                n /= 2;
            }
        }
        int res = 0;
        for (int i = 0 ; i < 32 ; i++) {
            bits[i] %= 2;
            res = (res<< 1) + bits[i];
        }
        return ngtct % 2 == 0 ? res : 0 - res;
    }
    public static void main(String args[]) {
        Solution so = new Solution();

        int s = so.singleNumber(new int[]{1, 3, 4, 1, 3});
        System.out.println(s);
        s = so.singleNumber(new int[]{-1,-1,-2});
        System.out.println(s);
        //int i = -1;
        //String bs = Integer.toBinaryString(i);
        //String bs = Integer.toBinaryString(-2);

        //System.out.println(( bs ));
        //System.out.println(( i >> 1 ));
        
        //s = so.singleNumber(new int[]{-1});
        //System.out.println(s);
    }
}
