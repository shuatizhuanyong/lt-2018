class Solution {
    public int reverse(int x) {
        int sign = (x < 0) ? -1 : 1;
        int res = 0;
        while (x != 0) {
            int cur = (x % 10) * sign;
            if (res > (Integer.MAX_VALUE / 10)) return 0;
            if (res == (Integer.MAX_VALUE / 10) && cur > (Integer.MAX_VALUE % 10) + (sign < 0 ? 1: 0)) return 0;
            res = res * 10 + cur;
            x /= 10;
        }
        return res * sign;
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        int res = 0;

        res = so.reverse(1463847422);
        System.out.println(res);
        System.out.println(new StringBuilder(Integer.MAX_VALUE + "" ).reverse().toString());
    }
}
