import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        int[] dp = new int[s.length() + 1];
        int longest = 0;
        for (int i = 0 ; i < chs.length ; i++) {
            if (chs[i] == '(') continue;
            if (i > 0 && chs[i - 1] == '(') {
                dp[i] = 2;
                if (i - 2 >= 0) {
                    dp[i] += dp[i - 2];
                }
            } else if ( i - 1 >= 0 && dp[i - 1] > 0 && i - dp[i - 1] - 1 >= 0) {
                if (chs[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + 2;
                    int left = i - dp[i - 1] - 1;
                    if (left - 1 >= 0) {
                        dp[i] += dp[left - 1];
                    }

                }
            } 

            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int rs = 0;
        rs =  so.longestValidParentheses("(()");
        System.out.println(rs);
        rs =  so.longestValidParentheses("(()()");
        System.out.println(rs);
        rs =  so.longestValidParentheses("(()())");
        System.out.println(rs);
        rs =  so.longestValidParentheses("()(())");
        System.out.println(rs);


    }
}
