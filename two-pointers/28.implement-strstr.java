class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.length() > haystack.length()) return -1;
        if (needle.length() == 0) return 0;
        char[] hs = haystack.toCharArray();
        char[] ns = needle.toCharArray();
        int i = 0;
        while (i < hs.length) {
            int j = i, k = 0;
            while (j < hs.length && k < ns.length) {
                if (hs[j] != ns[k]) break;
                j++;
                k++;
            }
            if (k == ns.length) return i;
            i++;
        }
        return -1;
    }
}
