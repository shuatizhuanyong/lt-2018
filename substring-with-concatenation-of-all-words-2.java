import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * if all word in array has same length, sliding window should be fine
 * input - 1:
 *  "foobarfoo"
 *  ["foo", "bar']
 *  return [0, 3]
 * */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0 || s.length() < 1) {
            return res;
        }
        int wlen = words[0].length();
        if (s.length() < wlen) {
            return res;
        }
        Map<String, Integer> template = new HashMap<>();
        int total = 0;
        for (String w: words){
            template.put(w, template.getOrDefault(w, 0) + 1);
        }

        int i = 0;
        while (i < wlen) {
            String sub = s.substring(i, i + wlen);
            Map<String, Integer> map = new HashMap<>();
            total = 0;
            int j = i, start = i;
            while (j <= s.length() - wlen) {
                String sb = s.substring(j, j + wlen);

                if (!template.containsKey(sb)) {
                    map = new HashMap<>();
                    j += wlen;
                    start = j;
                    total = 0;
                    continue;
                }
                while (map.getOrDefault(sb, 0) >= template.get(sb)) {
                    String begin = s.substring(start, start + wlen);
                    map.put(begin, map.get(begin) - 1);
                    start += wlen;
                    total--;
                }
                total++;
                map.put(sb, map.getOrDefault(sb, 0) + 1);

                if (total == words.length) {
                    res.add(start);
                    String begin = s.substring(start, start + wlen);
                    map.put(begin, map.get(begin) - 1);
                    start += wlen;
                    total--;
                }
                j += wlen;
            }
            i++;
        }
        return res;
        
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        
        List<Integer> res = so.findSubstring("barfoothefoobaraaa", new String[]{"foo","bar"});
        System.out.println(res);
        res = so.findSubstring("barfoobar", new String[]{"foo","bar"});
        System.out.println(res);
        res = so.findSubstring("barfoofoobar", new String[]{"foo","bar"});
        System.out.println(res);
        res = so.findSubstring("aaabarfoo", new String[]{"foo","bar"});
        System.out.println(res);
        res = so.findSubstring("aaa", new String[]{"aa","aa"});
        System.out.println(res);
    }
}
