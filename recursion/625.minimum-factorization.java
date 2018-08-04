/*
 * Q : 
 *  input is positive?
 *
 * Analysis: only number need to try: 2, 3, 5, 7
 * if has prime number which > 10, like 13, 17. in this case, it doesnot satisfy condition
 * possible numbers: 9, 8, 6, 5 4 3 2
 *
 *     
 * */

class Solution {
    public int smallestFactorization(int a) {
        if (a < 10) return a;
        int[] digits = new int[10];
        for (int i = 9 ; i >= 2 ; i--) {
            while(a % i == 0) {
                digits[i]++;
                a /= i;
            }
            if (a == 1) break;
        }
        if (a > 10) return 0;
        long res = 0;
        for (int i = 2 ; i <= 9 ; i++) {
            while (digits[i] > 0) {
                res = res * 10 + i;
                if (res > Integer.MAX_VALUE) return 0;
                digits[i]--;
            }
        }
        return (int)res;
    }

    public static void main(String args[]) {
        Solution so = new Solution();
        int res;
        res = so.smallestFactorization(64);
        System.out.println(res);
    }
}
