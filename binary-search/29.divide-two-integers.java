//[tag]: math
class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) throw new IllegalArgumentException("Divisor is Zero");
        if (dividend == 0) return 0;
        boolean isNeg = ((divisor > 0) ^ (dividend > 0));
        long ldr = Math.abs((long)divisor);
        long ldd = Math.abs((long)dividend);
        if (ldd < ldr) return 0;
        long temp = ldr;
        long res = 0;
        while (ldr <= ldd) {
            int step = 1;
            while ((temp << 1) < ldd) {
                temp <<= 1;
                step <<= 1;
            }
            ldd -= temp;
            temp = ldr;
            res += step;
        }
        if (res > Integer.MAX_VALUE) {
            if (isNeg) return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
        return isNeg ? 0 - (int)res : (int)res;

    }
    public static void main (String args[]) {
        Solution so = new Solution();
        int rs = 0;
        rs = so.divide(10, 3);
        System.out.println(rs);
        rs = so.divide(10, -3);
        System.out.println(rs);
        rs = so.divide(Integer.MIN_VALUE, -1);
        System.out.println(rs);
    }
}
