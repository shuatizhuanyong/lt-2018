class Solution {
    // you need treat n as an unsigned value
    /*
     * no sign right shift
     */
    public int reverseBits(int n) {
        int res = 0, i = 0;
        while (i < 32) {
            res = res * 2 + (n & 1);
            n >>>= 1;
            i++;
        }
        return res;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int res ;
        res = so.reverseBits(312312);
        System.out.println(res);
    }
}
