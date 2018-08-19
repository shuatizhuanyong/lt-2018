
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            int r = n & 1;
            if (r == 1) res++;
            n >>>= 1;
        }
        return res;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int r = -1;
        r = so.hammingWeight(128);
        System.out.println(r);
    }
}
