class Solution {
    public String countAndSay(int n) {
        if (n < 1) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        int i = 1;
        while (i < n) {
            char[] chs = sb.toString().toCharArray();
            StringBuilder nxtsb = new StringBuilder();
            int j = 0, k = 0;
            while (k < chs.length) {
                if (chs[k] != chs[j]) {
                    int count = k - j;
                    nxtsb.append(count).append(chs[j]);
                    j = k;
                    continue;
                }
                k++;
            }
            nxtsb.append(k - j).append(chs[j]);
            sb = nxtsb;
            i++;
        }
        return sb.toString();
    }

    public static void main (String[] args) {
        Solution so = new Solution();
        String res ;
        res = so.countAndSay(3);
        System.out.println(res);
    }
}
