import java.util.*;
//not right, getrandome will be O(n)
class RandomizedSet {

    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        int lastVal = list.get(list.size() - 1);
        list.set(index, lastVal);
        map.put(lastVal, index);
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        int rindex = r.nextInt(list.size());
        return list.get(rindex);
    }
}
class Solution {
    public static void main (String[] args) {
        RandomizedSet rs = new RandomizedSet();
        rs.insert(1);
        rs.insert(2);
        rs.insert(3);
        rs.insert(4);
        int r = rs.getRandom();
        System.out.println(r);
        r = rs.getRandom();
        System.out.println(r);
        r = rs.getRandom();
        System.out.println(r);
        r = rs.getRandom();
        System.out.println(r);
        r = rs.getRandom();
        System.out.println(r);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
