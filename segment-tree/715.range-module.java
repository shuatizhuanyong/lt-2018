import java.util.*;
class RangeModule {
    TreeMap<Integer, Integer> tm = new TreeMap<>();

    public RangeModule() { }
    
    public void addRange(int left, int right) {
        if (right <= left) return;
        Integer start = tm.floorKey(left);
        Integer end = tm.floorKey(right);
        if (start == null && end == null) {
            tm.put(left, right);
        } else if (start != null && tm.get(start) >= left) {
            tm.put(start, max(tm.get(end), tm.get(start), right));
        } else {
            tm.put(left, max(tm.get(end), right));
        }
        Map<Integer, Integer> subMap = tm.subMap(left, false, right, true);
       // tm.removeAll(subMap.keySet());
        //System.out.println("sub map:" + subMap);
        //System.out.println("tree map:" + tm);
        List<Integer> keys = new ArrayList<>(subMap.keySet());
        for (Integer key: keys) {
            tm.remove(key);
        }
    //    System.out.println(tm);
    }
    int max(Integer ... args) {
        int max = args[0];
        for (int arg: args) {
            max = Math.max(arg, max);
        }
        return max;
    }
    
    public boolean queryRange(int left, int right) {
        Integer start = tm.floorKey(left);
        if (start == null) return false;
        return tm.get(start) >= right;
    }
    
    public void removeRange(int left, int right) {
        if (right <= left) return;
        Integer start = tm.floorKey(left);
        Integer end = tm.floorKey(right);
        if (start == null && end == null) return;
        if (end != null && tm.get(end) > right) {
            tm.put(right, tm.get(end));
        }
        if (start != null && tm.get(start) > left) {
            tm.put(start, left);
        }
        Map<Integer, Integer> subMap = tm.subMap(left, false, right, true);
        List<Integer> keys = new ArrayList<>(subMap.keySet());
        for (Integer key: keys) {
            tm.remove(key);
        }
    }
}
class Solution {
    public static void main (String[] args) {
        RangeModule rm = new RangeModule();
        rm.addRange(1, 5);
        rm.addRange(7, 8);
        rm.addRange(8, 12);
        boolean r = false;
        r = rm.queryRange(4,5);
        System.out.println(r);
        r = rm.queryRange(7, 8);
        System.out.println(r);
        r = rm.queryRange(7, 12);
        System.out.println(r);
        rm.addRange(13, 15);
        rm.addRange(12, 16);

        rm = new RangeModule();
        rm.addRange(6, 8);
        rm.removeRange(7, 8);
        rm.removeRange( 8, 9);
        rm.addRange( 8, 9);
        rm.removeRange(1, 3 );
        rm.addRange(1, 8);
    }

}

