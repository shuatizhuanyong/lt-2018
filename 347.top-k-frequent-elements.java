import java.util.*;
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> rs = new ArrayList<>();
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int n : nums) {
            cnts.put(n, cnts.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> pr = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return cnts.get(i1) - cnts.get(i2); 
            }
        });
        for (Integer key: cnts.keySet()) {
            pr.add(key);
            if (pr.size() > k) {
                pr.poll();
            }
        }
        while (!pr.isEmpty()) {
            rs.add(pr.poll());
        }
        Collections.reverse(rs);
        return rs;
    }
    public  static void main (String args[]) {
        Solution2 so = new Solution2();
        List<Integer> rs = null;
        rs = so.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        System.out.println(rs);
    }
}


class Solution1 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> rs = new ArrayList<>();
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int n : nums) {
            cnts.put(n, cnts.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int n: cnts.keySet()) {
            int total = cnts.get(n);
            if (buckets[total] == null) {
                buckets[total] = new LinkedList<Integer>();
            }
            buckets[total].add(n);
        }
        for (int i = buckets.length - 1 ; i >= 0 ; i--) {
            if (buckets[i] != null) {
                rs.addAll(buckets[i]);
            }
            if (rs.size() >= k) {
                rs = rs.subList(0, k);
            }
        }
        return rs;
    }
}
class Solution2 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> rs = new ArrayList<>();
        Map<Integer, Integer> cnts = new HashMap<>();
        TreeMap<Integer, List<Integer>> tmap = new TreeMap<>();
        for (int n : nums) {
            cnts.put(n, cnts.getOrDefault(n, 0) + 1);
        }
        for (int n: cnts.keySet()) {
            int freq = cnts.get(n);
            if (!tmap.containsKey(freq)) {
                tmap.put(freq, new ArrayList<Integer>());
            }
            tmap.get(freq).add(n);
        }
        while (rs.size() < k) {
            List<Integer> list = tmap.pollLastEntry().getValue();
            rs.addAll(list);
        }
        return rs;
    }
}
