import java.util.*;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        Set<String> set = new HashSet<>();
        for (String str: wordDict) set.add(str);
        boolean[] dp = new boolean[s.length() + 1];
        /*
         dp[i] = ( dp[j] && set.contains(s[j, i]) ) || (j -> 0, i - 1)
         *
         * */
        dp[0] = true;
        for (int i = 1 ; i <= s.length() ; i++) {
            for (int j = 0 ; j < i ; j++) {
                //String sub = ;
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
    public static void main (String[] args) {
        Solution so = new Solution();
//s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
        boolean r = false;
        r = so.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        System.out.println(r);
        r = so.wordBreak("applepenapple", Arrays.asList("apple", "pen"));
        System.out.println(r);
    }
}
