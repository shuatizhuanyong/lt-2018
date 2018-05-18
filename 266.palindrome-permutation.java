class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] cnts = new int[128];
        for (char ch : s.toCharArray()) {
            cnts[ch]++;
        }
        int single = 0;
        for (int cnt: cnts) {
            if (cnt % 2 == 1) single++;
        }
        return single < 2;
    }
}
