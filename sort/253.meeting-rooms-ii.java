class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length < 1) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });
        for (int i = 0 ; i < intervals.length ; i++) {
            Interval curr = intervals[i];
            if (pq.isEmpty()) {
                pq.offer(curr);
                continue;
            }
            Interval pre = pq.peek();
            if (curr.start >= pre.end) {
                pq.poll();
            } 
            pq.offer(curr);
        }
        
        return pq.size();
    }
    public static void main (String[] args) {
        Solution so = new Solution();
    }
}
