class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        searchSolutions(nums, 0, new ArrayList<Integer>(), res, new boolean[nums.length]);
        return res;
    }
    void searchSolutions(int[] nums, int index, List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        res.add(new ArrayList<Integer>(list));
        for (int i = index ; i < nums.length ; i++) {
            if (i != index && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            list.add(nums[i]);
            searchSolutions(nums, i + 1, list, res, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
