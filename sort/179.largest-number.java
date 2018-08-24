import java.util.*;
class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if (nums == null || nums.length == 0) return sb.toString();
        List<Integer> list = new ArrayList<>();
        for (int n : nums) list.add(n);
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                String s12 = i1 + "" + i2;
                String s21 = i2 + "" + i1;
                return s21.compareTo(s12);
            }
        });
        //System.out.println(list);
        int start = 0;
        while ( start < list.size()) {
            int n = list.get(start);
            if (sb.length() == 0 && n == 0) {
                start++;
                continue;
            }
            sb.append(n);
            start++;
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        String r = null;
        r = so.largestNumber(new int[]{2, 10});
        System.out.println(r);
    }
}
