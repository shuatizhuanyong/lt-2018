import java.util.*;

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
       Arrays.sort(strings, new Comparator<String>() {
           public int compare(String s1, String s2) {
               return (s1 + s2).compareTo(s2 + s1);
           }
       });
        Map<String, List<String>> resMap = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s: strings) {
            if (!map.containsKey(s)) {
                continue;
            }
            map.put(s, map.get(s) - 1);
            if (map.get(s) == 0) {
                map.remove(s);
            }
            resMap.put(s, new ArrayList<String>());
            resMap.get(s).add(s);
            for (int i = 0 ; i < 26; i++) {
                char[] chs = s.toCharArray();
                for (int j = 0 ; j < chs.length; j++) {
                    chs[j] = (char)(chs[j] + i);
                    if (chs[j] > 'z') chs[j] = (char)(chs[j] - 26);
                }
                String nstr = new String(chs);
                while (map.containsKey(nstr)) {
                    map.put(nstr, map.get(nstr) - 1);
                    if (map.get(nstr) == 0) map.remove(nstr);
                    resMap.get(s).add(nstr);
                }
                
            }
        }
        return new ArrayList<List<String>>(resMap.values());
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        List<List<String>> rs;
        rs = so.groupStrings(new String[]{"bcd","abc", "acef", "xyz", "az", "ba", "a", "z"});
        System.out.println(rs);
        rs = so.groupStrings(new String[]{"ab","ba"});
        System.out.println(rs);
        rs = so.groupStrings(new String[]{"a","a"});
        System.out.println(rs);
        rs = so.groupStrings(new String[]{"a","b", "b"});
        System.out.println(rs);

    }
}


class Solution2 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strings) {
            char[] chs = s.toCharArray();
            int offset = chs[0] - 'a';
            for (int i = 0 ; i < chs.length; i++) {
                chs[i] = (char)( chs[i] - offset );
                if (chs[i] < 'a') {
                    chs[i] = (char)(chs[i] + 26);
                }
            }
            String key = new String(chs);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        for (String key: map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
    public static void main(String args[]) {
        Solution2 so = new Solution2();
        List<List<String>> rs;
        rs = so.groupStrings(new String[]{"bcd","abc", "acef", "xyz", "az", "ba", "a", "z"});
        System.out.println(rs);
        rs = so.groupStrings(new String[]{"ab","ba"});
        System.out.println(rs);
        rs = so.groupStrings(new String[]{"a","a"});
        System.out.println(rs);
        rs = so.groupStrings(new String[]{"a","b", "b"});
        System.out.println(rs);

    }
}
