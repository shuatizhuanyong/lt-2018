import java.util.*;
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.length() == 0) return "";
        Set<String> bdict = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        int max = 0; 
        String w = null;
        for (String b: banned) bdict.add(b);
        int i = 0;
        char[] chs = paragraph.toCharArray();
        while (i < chs.length) {
            while (i < chs.length && !Character.isLetter(chs[i])) {
                i++;
            }
            int j = i;
            while (j < chs.length && Character.isLetter(chs[j])) {
                j++;
            }
            String word = new String(chs, i, j - i);
            word = toLowerCase(word);
            if (!bdict.contains(word))  {
              map.put(word, map.getOrDefault(word, 0) + 1);
              if (map.get(word) > max) {
                  max = map.get(word);
                  w = word;
              }
            }
            i = j;
        }
        return w;
    }
    String toLowerCase(String w) {
        char[] chs = w.toCharArray();
        for (int i = 0 ; i < chs.length ; i++) {
            chs[i] = Character.toLowerCase(chs[i]);
        }
        return new String(chs);
    }
    public static void main (String[] args) {
        char[] arr = new char[]{'a', 'b', 'c', 'd', 'e'};
        System.out.println(new String(arr, 2, 1));
        Solution so = new Solution();
        String res = null;
        res = so.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
        System.out.println(res);
    }
}
