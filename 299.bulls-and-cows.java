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
        Solution2 so = new Solution2();
        String res = null;
        res = so.getHint("1807", "7810");
        System.out.println(res);

    }
}


class Solution2 {
    public String getHint(String secret, String guess) {
        //int[] posMap = new int[secret.length()];
        int[] valueMap = new int[10];
        int bulls = 0, cows = 0;
        char[] arr1 = secret.toCharArray();
        char[] arr2 = guess.toCharArray();
        for (int i = 0 ; i < arr1.length ; i++) {
            if (arr1[i] == arr2[i]) {
                bulls++;
            }else {
                char ch1 = arr1[i];
                char ch2 = arr2[i];
                if (valueMap[ch1 - '0']++ < 0) {
                    cows++;
                } 
                if (valueMap[ch2 - '0']-- > 0) {
                    cows++;
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls).append('A').append(cows).append('B');
        return sb.toString();
    }
}
