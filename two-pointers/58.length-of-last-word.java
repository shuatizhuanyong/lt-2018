class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int end = s.length() - 1;
        while (end >= 0) {
            char c = s.charAt(end);
            if (c != ' ') break;
            c--;
        }
        if (end < 0) return 0;
        int start = end;
        while (start >= 0) {
            if (s.charAt(start) != ' ') {
                start--;
            } else break;
        }
        return end - start;
    }
    public static void main (String[] args) {
        Solution0 so = new Solution0();
        int len = 0;
        len = so.lengthOfLastWord("hello world");
        System.out.println(len);
    }
}


class Solution0 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int start = s.length() - 1, end = s.length() - 1;
        while (start >= 0 && end >= 0) {
            if (s.charAt(end) == ' ') {
                end--;
                start--;
            } else if (s.charAt(start) != ' ') {
                start--;
            } else break;
        }
        return end < 0 ? 0 : ( end - start );
    }
}
