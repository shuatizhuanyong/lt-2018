
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        //ERROR missing for input: "", []
        if (s.length() == 0 || words.length == 0) return res;

        int wholeLen = 0;
        for (String w : words){
            wholeLen += w.length();
        }
        for (int i = 0 ; i <= s.length() - wholeLen; i++) {
            boolean isFound = searchres(s, i, words, new HashSet<Integer>());
            if (isFound) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean searchres(String s, int start, String[] words, Set<Integer> foundIndexes) {
        if (foundIndexes.size() == words.length) {
            return true;
        }

        for (int i = 0 ; i < words.length ; i++) {
            if (foundIndexes.contains(i)) continue;
            String w = words[i];
            if (start + w.length() > s.length()) {
                continue;
            }
            if (s.substring(start, start + w.length()).equals(w)) {
                foundIndexes.add(i);
                if(searchres(s, start + w.length(), words, foundIndexes)){
                    return true;
                }
            }
            foundIndexes.remove(i);
        }
        return false;
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        
        List<Integer> res = so.findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
        System.out.println(res);
    }
}
