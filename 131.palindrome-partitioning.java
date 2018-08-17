import java.util.*;
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        searchSolutions(s, 0, new ArrayList<String>(), res);
        return res;
    }
     void searchSolutions(String s, int index, List<String> list, List<List<String>> res) {
         if (index == s.length()) {
             res.add(new ArrayList<String>(list));
             return;
         }
         for (int i = index + 1; i <= s.length() ; i++) {
             String sub = s.substring(index, i);
             if(isPal(sub)) {
                 list.add(sub);
                 searchSolutions(s, i, list, res);
                 list.remove(list.size() - 1);
             }
         }
    }
    boolean isPal(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        List<List<String>> list = so.partition("aab");
        System.out.println(list);
    }
}
