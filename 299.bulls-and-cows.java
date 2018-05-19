import java.util.*;
//
class Solution {
    public String getHint(String secret, String guess) {
        int[] posMap = new int[secret.length()];
        int[] valueMap = new int[10];
        char[] chs = secret.toCharArray();
        for (int i = 0 ; i< chs.length ; i++ ) {
            char c = chs[i];
            valueMap[c - '0']++;
            //int intc = c - '0';
        }
        int anum = 0, bnum = 0;
        for (int i = 0; i < guess.length() ; i++) {
            char gs = guess.charAt(i);
            if (gs == chs[i]) {
                anum++;
            }
            if(valueMap[gs - '0'] > 0) {
                valueMap[gs - '0']--;
                bnum++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(anum).append('A').append((bnum - anum)).append('B');
        return sb.toString();
    }
    public static void main (String args[]) {
        Solution so = new Solution();
        String res = null;
        res = so.getHint("1807", "7810");
        System.out.println(res);

    }
}

