class HitCounter {

    /** Initialize your data structure here. */
    public HitCounter() {
        
    }
    
    Map<Integer, Integer> cnts = new HashMap<>();
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        cnts.put(timestamp, cnts.getOrDefault(timestamp, 0) + 1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int i = timestamp;
        int total = 0;
        while (i > timestamp - 300 && i >= 0) {
            total += cnts.getOrDefault(i, 0);
            i--;
        }
        return total;
    }
}
class HitCounter0 {


    /** Initialize your data structure here. */
    public HitCounter() {
        
    }
    
    LinkedHashMap<Integer, Integer> cnts = new LinkedHashMap<>();
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        cnts.put(timestamp, cnts.getOrDefault(timestamp, 0) + 1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        Set<Integer> keys = cnts.keySet<Integer>();
        for (int k : keys) {
            if (k <= timestamp - 300) break; 
            total += cnts.get(k);
        }
        return total;
    }
}
class HitCounter1 {


    /** Initialize your data structure here. */
    public HitCounter() {
        
    }
    LinkedList<Integer> list = new LinkedList<>();
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        list.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = list.size() - 1 ; i >= 0 ; i--) {
            if (list.get(i) <= timestamp && list.get(i) > timestamp - 300) {
                total++;
            }
            if (list.get(i) <= timestamp - 300) break;
        }
        return total;
    }
}
/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
