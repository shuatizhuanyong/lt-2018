class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[nums.length];
        searchSolutions(nums, new ArrayList<Integer>(), res, visited);
        return res;
    }
    void searchSolutions(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0 ; i < nums.length ; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            list.add(nums[i]);
            searchSolutions(nums, list, res, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
