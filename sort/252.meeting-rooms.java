class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length < 2) return true;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        Interval pre = intervals[0];
        for (int i = 1 ; i < intervals.length ; i++) {
            Interval cur = intervals[i];
            if (cur.start < pre.end) return false;
            pre = cur;
        }
        return true;
    }
}
