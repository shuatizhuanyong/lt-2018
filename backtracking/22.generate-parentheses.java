class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        generateParenthesis(2 * n, 0, "", res);
        return res;
    }
    void generateParenthesis(int total, int left, String cur, List<String> res) {
        if (cur.length() == total) {
            res.add(cur);
            return;
        }
        int len = cur.length(), right = len - left;
        if (left == right) {
            generateParenthesis(total, left + 1, cur + "(", res);
        } else {
            generateParenthesis(total, left, cur + ")", res);
            if (total > left * 2) {
                generateParenthesis(total, left + 1, cur + "(", res);
            }
        }

    }
}
