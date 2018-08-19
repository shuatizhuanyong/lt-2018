class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        Interval pre = intervals.get(0);
        for (int i = 1;  i < intervals.size() ; i++) {
            Interval cur = intervals.get(i);
            if (cur.start > pre.end) {
                res.add(pre);
                pre = cur;
            } else {
                pre.end = Math.max(pre.end, cur.end);
            } 
        }
        res.add(pre);
        return res;
    }
}
