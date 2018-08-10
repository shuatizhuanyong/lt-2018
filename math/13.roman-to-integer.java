class Solution {
    String[] RS = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    int[] DS = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    
    public int romanToInt(String s) {
        int res = 0;
        int i = 0, j = 0 ;
        while (i < s.length()) {
            int len = RS[j].length();
            if (i + len > s.length()) {
                j++;
                continue;
            }
            String cur = s.substring(i, i + len);
            if(cur.equals(RS[j])) {
                res += DS[j];
                i += len;
            } else {
                j++;
            }
        }
        return res;
    }
}

class Solution0 {
    
    char[] RS = new char[]{'M',  'D',  'C',  'L', 'X',  'V', 'I' };
    int[] DS = new int[]{1000, 500, 100, 50, 10, 5, 1};
    Map<Character, Integer> createMap() {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i < RS.length ; i++)  {
            map.put(RS[i], DS[i]);
        }
        return map;
    }
    public int romanToInt(String s) {
        int res = 0;
        Map<Character, Integer> map = createMap();
        for (int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            int cur = map.get(ch);
            if (i < s.length() - 1) {
                int nxt = map.get(s.charAt(i + 1));
                if (cur < nxt) {
                    res -= cur;
                } else {
                    res += cur;
                }
            } else {
                res += cur;
            }
        }
        return res;
    }
    
}
