class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        searchSolutions(candidates, 0, new ArrayList<Integer>(), res, target);
        return res;
    }
    void searchSolutions(int[] cans, int index, List<Integer> list, List<List<Integer>> res, int target) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = index ; i < cans.length ; i++) {
            if (i != index && cans[i] == cans[i - 1]) continue;
            list.add(cans[i]);
            searchSolutions(cans, i + 1, list, res, target - cans[i]);
            list.remove(list.size() - 1);
        }
    }
}
