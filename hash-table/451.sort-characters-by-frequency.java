import java.util.*;
/*
 * [tags]: heap
 * */
class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return s;
        int[] cnts = new int[128];
        for (char c: s.toCharArray()) cnts[c]++;
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            public int compare(Character c1, Character c2) {
                return cnts[c1] - cnts[c2];
            }
        });

        for (int i = 0 ; i < cnts.length ; i++) {
            if (cnts[i] > 0) {
                pq.add((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            int num = cnts[c];
            for (int j = 0 ; j < num; j++) {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
    public static void main (String[] args) {
        Solution so = new Solution();

        String res;
        res  = so.frequencySort("asdfsf1312afasdf");
        System.out.println(res);
    }
}
