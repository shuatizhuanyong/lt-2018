class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        searchSolutions(candidates, 0, new ArrayList<Integer>(), res, target);
        return res;
    }
    void searchSolutions(int[] cands, int index, List<Integer> curlist, List<List<Integer>> res, int target) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(curlist));
            return;
        }
        if (target < 0) return;
        for (int i = index ; i < cands.length; i++) {
            curlist.add(cands[i]);
            searchSolutions(cands, i, curlist, res, target - cands[i]);
            curlist.remove(curlist.size() - 1);
        }
    }
}
