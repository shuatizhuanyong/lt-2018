public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 1) return n;
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            boolean isBad = isBadVersion(mid);
            if (isBad) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
