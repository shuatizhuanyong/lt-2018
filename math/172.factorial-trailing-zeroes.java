class Solution {
    public int trailingZeroes(int n) {
        if (n < 5)  return 0;
        int[] zarr = new int[n + 1];
        int total = 0;
        for (int i = 1 ; i * 5 < n + 1; i++) {
            zarr[i * 5] = 1 + zarr[i];
            total += zarr[i * 5];
        }
        return total;
    }
    public static void main (String[] args) {
        Solution0 so = new Solution0();
        int r = -1;
        r = so.trailingZeroes(10);
        System.out.println(r);
        r = so.trailingZeroes(26);
        System.out.println(r);
    }
}
class Solution0 {
    public int trailingZeroes(int n) {
        int total = 0;
        while (n >= 5) {
            total += n / 5;
            n = n /5;
        }
        return total;
    }
}
