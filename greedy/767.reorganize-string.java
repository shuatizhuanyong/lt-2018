import java.util.*;
/*
 * [tags]: heap
 * [*/
class Solution {
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) return S;
        char[] chs = S.toCharArray();
        int[] cnts = new int[26];
        for (char c: chs) {
            cnts[c - 'a']++;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>(){
            public int compare(Character c1, Character c2) {
                return cnts[c2 - 'a'] - cnts[c1 - 'a'];
            }
        });
        for (int i = 0 ; i < 26; i++) {
            if(cnts[i] > 0) {
                pq.offer((char)(i + 'a'));
            }
        }
        int index = 0;
        while (!pq.isEmpty()) {
            char c = pq.peek();
            if (cnts[c - 'a'] > (chs.length / 2 + chs.length % 2)) return "";
            while (cnts[c - 'a'] > 0) {
                chs[index] = c;
                cnts[c - 'a']--;
                index += 2;
                if (index > chs.length - 1) {
                    index = 1;
                }
            }
            pq.poll();
        }
        return new String(chs);
        
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        String res = null;
        res = so.reorganizeString("aab");
        System.out.println(res);
        res = so.reorganizeString("aaba");
        System.out.println(res);
    }
}
