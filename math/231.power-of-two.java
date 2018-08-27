class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 == 1) return false;
        return isPowerOfTwo(n / 2);
    }
    public static void main (String[] args) {
        Solution0 so = new Solution0();
        boolean res ; 
        res = so.isPowerOfTwo(2 << 29);
        System.out.println(res);
    }
}


class Solution0 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n > 0) {
            if (( n & 1 ) == 1 && (n >> 1) > 0) return false;
            n >>= 1;
        }
        return true;
    }
}
