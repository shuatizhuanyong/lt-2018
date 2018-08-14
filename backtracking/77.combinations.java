class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        searchSolutions(n, k, 1, new ArrayList<Integer>(), res, new boolean[n + 1]);
        return res;
    }
    void searchSolutions(int total, int k, int cur, List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = cur ; i <= total ; i++) {
            if(visited[i]) continue;
            list.add(i);
            visited[i] = true;
            searchSolutions(total, k - 1, i + 1, list, res, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
