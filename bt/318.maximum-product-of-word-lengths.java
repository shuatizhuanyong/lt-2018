/**/
import java.util.*;
class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) return 0;
        BitSet[] cnts = new BitSet[words.length];
        for (int i = 0 ; i < words.length ; i++) {
            cnts[i] = new BitSet(26);
            char[] chs = words[i].toCharArray();
            for (int j = 0 ; j < chs.length ; j++) {
                cnts[i].set(chs[j] - 'a');
            }
        }
        int maxProduct = 0;
        for (int i = 0 ; i < cnts.length ; i++) {
            BitSet bsi = cnts[i];
            for (int j = i + 1 ; j < cnts.length ; j++) {
                BitSet bsj = cnts[j];
                if (bsi.intersects(bsj)) continue;
                if (words[i].length() * words[j].length() > maxProduct) {
                    maxProduct = words[i].length() * words[j].length();
                }
            }
        }
        return maxProduct;
    }
    public static void main (String[] args) {
        Solution0 so = new Solution0();
        int r = 0;
        r = so.maxProduct(new String[]{ "a","ab","abc","d","cd","bcd","abcd" });
        System.out.println(r);
    }
}
class Solution0 {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) return 0;
        boolean[][] cnts = new boolean[words.length][26];
        for (int i = 0 ; i < words.length ; i++) {
            char[] chs = words[i].toCharArray();
            for (int j = 0 ; j < chs.length ; j++) {
                cnts[i][chs[j] - 'a'] = true;
            }
        }
        int maxProduct = 0;
        for (int i = 0 ; i < cnts.length ; i++) {
            boolean[] bsi = cnts[i];
            for (int j = i + 1 ; j < cnts.length ; j++) {

                boolean[] bsj = cnts[j];
                if (intersects(bsi, bsj)) continue;
                if (words[i].length() * words[j].length() > maxProduct) {
                    maxProduct = words[i].length() * words[j].length();
                }
            }
        }
        return maxProduct;
    }
    boolean intersects(boolean[] a, boolean[] b) {
        for (int i = 0 ; i < 26; i++){
            if (a[i] == true && b[i] == true) return true;
        }
        return false;
    }
}


class Solution1 {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) return 0;
        int[] cnts = new int[words.length];
        for (int i = 0 ; i < words.length ; i++) {
            char[] chs = words[i].toCharArray();
            for (int j = 0 ; j < chs.length ; j++) {
                // set 1 in this position
                cnts[i] |= (1 << (chs[j] - 'a'));
            }
        }
        int maxProduct = 0;
        for (int i = 0 ; i < cnts.length ; i++) {
            for (int j = i + 1 ; j < cnts.length ; j++) {
                if ((cnts[i] & cnts[j]) != 0) continue;
                if (words[i].length() * words[j].length() > maxProduct) {
                    maxProduct = words[i].length() * words[j].length();
                }
            }
        }
        return maxProduct;
    }
}
