import java.util.*;
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int v: nums) {
            cnts.put(v, cnts.getOrDefault(v, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return cnts.get(i1) - cnts.get(i2);
            }
        });
        Set<Integer> keyset = cnts.keySet();
        for (Integer key: keyset) {
            pq.offer(key);
            if (pq.size() > k) pq.poll();
        }
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }
        Collections.reverse(list);
        return list;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        List list;
        list = so.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        System.out.println(list);
    }
}
