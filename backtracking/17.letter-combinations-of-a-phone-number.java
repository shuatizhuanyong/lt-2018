class Solution {
    String[] dc = new String[]{ "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        findSolutions(digits, "", 0, res);
        return res;
    }
    void findSolutions(String digits, String cur, int index, List<String> res) {
        if (index == digits.length()) {
            res.add(cur);
            return;
        }
        char[] chs = dc[digits.charAt(index) - '0'].toCharArray();
        for (char c : chs) {
            findSolutions(digits, cur + c, index + 1, res);
        }
    }
}
