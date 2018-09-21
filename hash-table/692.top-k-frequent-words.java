import java.util.*;
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || k <= 0) return res;
        Map<String, Integer> map = new HashMap<>();
        for (String s: words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String s1, String s2) {
                int d = map.get(s1) - map.get(s2);
                if (d != 0) return d;
                return s2.compareTo(s1);
            }
        });
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            pq.offer(entry.getKey());
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            res.add(0, pq.poll());
        }
        return res;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        List<String> res = null;
        res = so.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        System.out.println(res);
        //System.out.println("i".compareTo("love"));
        res = so.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
        System.out.println(res);

    }
}
