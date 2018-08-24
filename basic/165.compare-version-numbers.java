class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version1.length() == 0) return -1;
        if (version2 == null || version2.length() == 0) return 1;
        int start1 = 0, start2 = 0, i = 1, j = 1;
        while (i < version1.length() || j < version2.length()) {
            while (i < version1.length() && version1.charAt(i) != '.') {
                i++;
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                j++;
            }
            int v1 = Integer.valueOf(version1.substring(start1, i));
            int v2 = Integer.valueOf(version2.substring(start2, j));
            if (v1 > v2) return 1;
            else if (v1 < v2) return -1;
            else {
                start1 = i;
                start2 = j;
            }
        }
        return 0;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int r = -100;
        r = so.compareVersion("1.0.1", "1.0.1.0");
        System.out.println(r);
    }
}
