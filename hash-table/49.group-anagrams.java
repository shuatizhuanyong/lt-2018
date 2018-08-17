import java.util.Map;
import java.util.HashMap;
import java.util.Arrays; 
import java.util.ArrayList; 
import java.util.List; 
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>();

        for (String s: strs) {
            int[] map = new int[26];
            for (char c : s.toCharArray()) {
                map[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int ct : map) {
                sb.append(ct).append('#');
            }
            String mapstr = sb.toString();
            if (!hash.containsKey(mapstr)) {
                hash.put(mapstr, new ArrayList<String>());
            }
            hash.get(mapstr).add(s);
        }
        return new ArrayList<List<String>>( hash.values() );

    }
    public static void main(String args[]) {
        Solution so = new Solution();
        List res = so.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(res);
    }
}
