class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) return true;
        char[] chs = s.toCharArray();
        int left = 0, right = chs.length - 1;
        while (left < right) {
            //char lc = chs[left];
            while (left < right && !isValid(chs[left])) left++;
            while (left < right && !isValid(chs[right])) right--;
            if (left >= right) return true;
            if (toLower(chs[left]) != toLower(chs[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    char toLower(char c) {
        if (c >= 'A' && c <= 'Z') {
            int os = c - 'A';
            return (char)( 'a' + os );
        }
        return c;
    }

    boolean isValid(char c) {
        if (c >= '0' && c <= '9') return true;
        if (c >= 'a' && c <= 'z') return true;
        if (c >= 'A' && c <= 'Z') return true;
        return false;
    }

    public static void main (String args[]) {
        Solution so = new Solution();
        boolean r = false;

        r = so.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(r);
        r = so.isPalindrome("A m,=a");
        System.out.println(r);
        r = so.isPalindrome("A mxm,x=a");
        System.out.println(r);
    }
}
