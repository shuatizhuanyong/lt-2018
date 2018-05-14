class Solution {
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        boolean[] noprimes = new boolean[n];
        int res = 0;
        for (int i = 2 ; i < noprimes.length ; i++) {
            if (noprimes[i]) continue;
            if (!noprimes[i]) res++;
            for (int j = 2 ; j * i < noprimes.length ; j++) {
                noprimes[i * j] = true;
            }
        }
        return res;
    }
}
