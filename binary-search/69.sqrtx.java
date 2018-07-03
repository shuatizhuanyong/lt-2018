//[tag]: math
class Solution {
    public int mySqrt(int x) {
        if (x < 0) throw new IllegalArgumentException("invalid paramter: " + x);
        if (x <= 1) return x;
        long lx = x;
        long start = 0, end = lx;
        while (start < end) {
            long mid = (start + end) / 2;
            if (mid * mid == lx) {
                return (int)mid;
            } else if (mid * mid < lx) {
                if ((mid + 1) * (mid + 1) > lx) return (int)mid;
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return (int)start;
    }
}
