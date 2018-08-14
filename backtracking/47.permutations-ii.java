class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>  res = new ArrayList<>();
        Arrays.sort(nums);
        searchSolutions(nums, new ArrayList<Integer>(), res, new boolean[nums.length]);
        return res;
    }
    void searchSolutions(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0 ; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            list.add(nums[i]);
            searchSolutions(nums, list, res, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
