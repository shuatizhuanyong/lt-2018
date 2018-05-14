
class Solution {
    public boolean isHappy(int n) {
        return isHappy(n, new HashSet<Integer>());
    }
    private boolean isHappy(int n, Set<Integer> cache) {
        if (n == 1) return true;
        if (!cache.add(n)) return false;

        int nxt = 0;
        while (n != 0) {
            int last = n % 10;
            n /= 10;
            nxt += (last * last);
        }
        return isHappy(nxt, cache);
    }
}


class Solution0 {
    public boolean isHappy(int n) {
        Set<Integer> cache = new HashSet<Integer>();
        while (cache.add(n)) {
            int tmp = n;
            n = 0;
            while (tmp > 0) {
                n += ((tmp % 10) * (tmp % 10));
                tmp /= 10;
            }
            if (n == 1) return true;
        }
        return false;
    }
}


// slow/fast 2 pointers solution
class Solution1 {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        while (fast != 1) {
            slow = calSq(slow);
            fast = calSq(calSq(fast));
            if (slow == 1 || fast == 1) return true;
            if (slow == fast) return false;
        }
        return true;
    }

    private int calSq(int n) {
        int res = 0;
        while (n > 0) {
            res += ((n % 10) * (n % 10));
            n /= 10;
        }
        return res;
    }
}
