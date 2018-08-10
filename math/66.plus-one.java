import java.util.*;
class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }
        if (carry == 0) return digits;
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        for (int i = 1; i < res.length ; i++ ) {
            res[i] = digits[i - 1];
        }
        return res;
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        int[] res = null;
        res = so.plusOne(new int[]{8, 9, 9, 9});
        System.out.println(Arrays.toString(res));
        res = so.plusOne(new int[]{9, 9, 9, 9});
        System.out.println(Arrays.toString(res));
    }
}
