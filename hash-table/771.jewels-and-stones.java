class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) return 0;
        boolean[] types = new boolean[128];
        for (char c : J.toCharArray()){
            types[c] = true;
        }
        int res = 0;
        for (char c: S.toCharArray()) {
            if(types[c]) {
                res++;
            }
        }
        return res;
    }
}
