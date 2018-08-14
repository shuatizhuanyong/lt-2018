class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k || n > 9 * n) return res;
        searchSolutions(k, 1, new ArrayList<Integer>(), res, n);
        return res;
    }
    void searchSolutions(int k, int cur, List<Integer> list, List<List<Integer>> res, int sum) {
        if (k == 0) {
            if (sum == 0) {
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }
        if (sum < 0) return;
        for (int i = cur ; i <= 9 ; i++) {
            list.add(i);
            searchSolutions(k - 1, i + 1, list, res, sum - i);
            list.remove(list.size() - 1);
        }
    }
}
