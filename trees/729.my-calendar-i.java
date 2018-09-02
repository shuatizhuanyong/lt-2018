/*
 * [tags]: treemap 
 * */
class MyCalendar {
    public MyCalendar() {
        
    }
    List<int[]> list = new ArrayList<>();
    public boolean book(int start, int end) {
        int i = 0;
        while (i < list.size()) {
            int[] interval = list.get(i);
            if (interval[0] < end && start < interval[1]) {
                return false;
            }
        }
        list.add(new int[]{start, end});
        return true;
    }
}
class Solution {
    public static void main (String[] args) {
        MyCalendar mc = new MyCalendar();

    }
}

class MyCalendar0 {
    public MyCalendar() { }
    TreeMap<Integer, Integer> tm = new TreeMap<>();
    public boolean book(int start, int end) {
        Integer pre = tm.floorKey(start);
        Map.Entry<Integer, Integer> lower = tm.lowerEntry(end);
            //        Integer nxt = tm.ceilingKey(start);
        if (lower != null && lower.getValue() > start) {
            return false;
        }
        tm.put(start, end);
        return true;
    } 
}
class Solution {
    public static void main (String[] args) {
        MyCalendar mc = new MyCalendar();

    }
}
