class Solution {
    public int climbStairs(int n) {
        if (n < 2) return n;
        int num = 2, num0 = 1;
        for (int i = 3 ; i <= n; i++) {
            int t = num + num0;
            num0 = num;
            num = t;
        }
        return num;
    }
}
