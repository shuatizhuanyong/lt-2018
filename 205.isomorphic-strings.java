import java.util.*;
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> opmap = new HashMap<>();

        for (int i = 0 ; i < s.length() ; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            //System.out.println(ct == null);
            if (map.get(cs) == null && opmap.get(ct) == null) {
                map.put(cs, ct);
                opmap.put(ct, cs);
            } else if (new Character(ct).equals(map.get(cs)) && new Character(cs).equals(opmap.get(ct))) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        System.out.println(so.isIsomorphic("ab", "aa"));
    }
}



//use int[] to replace hashmap
class Solution1 {
    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[128];
        int[] remap = new int[128];
        Arrays.fill(map, -1);
        Arrays.fill(remap, -1);
        for (int i = 0 ; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (map[cs] == -1 && remap[ct] == -1) {
                map[cs] = ct;
                remap[ct] = cs;
            } else if (map[cs] == ct && remap[ct] == cs) {
                continue;
            } else {
                return false;
            }
        }
        return true;

    }
}



class Solution2 {
    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[128];
        int[] remap = new int[128];
        //Arrays.fill(map, -1);
        //Arrays.fill(remap, -1);
        for (int i = 0 ; i < s.length() ; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (map[cs] != remap[ct]) {
                return false;
            }
            map[cs] = remap[ct] = i + s.length();//
        }
        return true;
    }
}
