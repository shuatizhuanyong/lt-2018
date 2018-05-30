class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        searchSolutions(root, res, new ArrayList<Integer>(), sum);
        return res;
    }
    private void searchSolutions(TreeNode node, List<List<Integer>> res, List<Integer> list, int sum) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (node.val == sum) {
                List<Integer> r = new ArrayList<>(list);
                r.add(node.val);
                res.add(r);
            }
            return;
        }

        list.add(node.val);
        searchSolutions(node.left, res, list, sum - node.val);
        searchSolutions(node.right, res, list, sum - node.val);
        list.remove(list.size() - 1);
    }

}
