import java.util.*;
class Solution {

    /** Initialize your data structure here. */
    Map<Integer, Integer> map = null;
    public Solution() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        this.map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int v : map.keySet()) {
            if (v == value - v) {
                if(map.get(v) > 1) return true;
                continue;
            }
            int left = value - v;
            if (map.containsKey(left)) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String args[]) {
         Solution ts = new Solution();
         ts.add(1);
         ts.add(3);
         ts.add(5);
         System.out.println(ts.find(4));
         System.out.println(ts.find(5));
         System.out.println(ts.find(2));
         System.out.println(ts.find(8));

         

    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
