import java.util.*;
class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();

        if (n == 0) return res;
        if (n == 1) return new ArrayList<String>(Arrays.asList("1", "8", "0"));
        List<String> loop = new ArrayList<>();
        int i = 0;
        if (n % 2 == 0) res.add("");
        else{ 
            res = new ArrayList<>(Arrays.asList("1", "8", "0"));
            i++;
        }
        for (; i < n ; i += 2) {
            for (String s: res) {
                if (i + 2 < n)  loop.add("0" + s + "0");
                loop.add("1" + s + "1");
                loop.add("6" + s + "9");
                loop.add("8" + s + "8");
                loop.add("9" + s + "6");
            }
            res = new ArrayList<>(loop);
            loop.clear();
        }
        return res;
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        List<String> list;
        list = so.findStrobogrammatic(4);
        System.out.println(list);
        list = so.findStrobogrammatic(2);
        System.out.println(list);
        list = so.findStrobogrammatic(3);
        System.out.println(list);
    }
}
