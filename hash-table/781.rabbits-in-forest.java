import java.util.*;
class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int an: answers) {
            map.put(an, map.getOrDefault(an, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> en: map.entrySet()) {
            int same = en.getKey();
            int n = en.getValue();
            int base = n / (same + 1);
            if (n % (same + 1) > 0) {
                base++;
            }
            res += base * (same + 1);
        }
        return res;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int res = -1;
        res = so.numRabbits(new int[]{2, 2, 2});
        System.out.println(res);
        res = so.numRabbits(new int[]{2, 2, 2, 2});
        System.out.println(res);
        res = so.numRabbits(new int[]{10, 10, 10});
        System.out.println(res);
        res = so.numRabbits(new int[]{1, 1, 2});
        System.out.println(res);
        
        
    }
}
