class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        searchSolutions(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    void searchSolutions(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<Integer>(list));
        for (int i = index ; i < nums.length ; i++) {
            list.add(nums[i]);
            searchSolutions(nums, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
