// looks binary search
import java.util.*;
class Solution {
    public int hIndex(int[] citations) {
        
        List<Integer> list = new ArrayList<>();
        for (int i: citations) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                return j - i;
            }
        });
        int hindex = 0;
        int left = 0, right = citations.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) > mid) {
                hindex = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return hindex;
    }
    public static void main (String args[]) {
        Solution so = new Solution();
        int res;
        res = so.hIndex(new int[]{3,0,6,1,5});
        System.out.println(res);
    }
}
class Solution1 {
    public int hIndex(int[] citations) {
        int [] cnts = new int[citations.length + 1];
        for (int i = 0 ; i < citations.length ; i++) {
            int val = citations[i];
            cnts[Math.min(val, cnts.length - 1)]++;
        }
        int sum = 0;
        for (int i = cnts.length - 1; i >= 0 ; i--) {
            sum += cnts[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;


    }
}
