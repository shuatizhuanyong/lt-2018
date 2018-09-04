import java.util.*;
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list1.length == 0 || list2 == null || list2.length == 0) return new String[0];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0 ; i < list1.length ; i++){
            map.put(list1[i], i);
        }
        Map<Integer, List<String>> res = new HashMap<>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0 ; i < list2.length ; i++) {
            String s2 = list2[i];
            if (map.containsKey(s2)) {
                int lclSum = map.get(s2) + i;
                if (lclSum > minSum) continue;
                minSum = lclSum;
                if (res.get(lclSum) == null) {
                    res.put(lclSum, new ArrayList<String>());
                }
                res.get(lclSum).add(s2);
            }
        }
        if (minSum == Integer.MAX_VALUE) return new String[0];
        return res.get(minSum).toArray(new String[res.get(minSum).size()]);
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        String[] rs = null;
        rs = so.findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                new String[]{"KFC","Shogun","Burger King"} );
        System.out.println(Arrays.toString(rs));
    }
}
