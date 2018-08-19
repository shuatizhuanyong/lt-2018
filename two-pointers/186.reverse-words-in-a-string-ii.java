import java.util.*;
class Solution {
    public void reverseWords(char[] str) {
        if (str.length <= 1) return;
        reverse(str, 0, str.length - 1);
        
        int start = 0;
        while (start < str.length) {
            while (start < str.length && str[start] == ' ') start++;
            int end = start;
            if (start == str.length) break;
            while (end + 1 < str.length && str[end + 1] != ' ') end++;
            reverse(str, start, end);
            start = end + 1;
        }
    }
    void reverse(char[] chs, int start, int end){
        while (start < end) {
            char t = chs[start];
            chs[start] = chs[end];
            chs[end] = t;
            start++;
            end--;
        }
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        String a = "the sky is blue";
        a = "the sky is  blue";
        char[] chs = a.toCharArray();
        so.reverseWords(chs);
        System.out.println(Arrays.toString(chs));
    }
}
