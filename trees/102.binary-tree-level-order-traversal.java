//basic level travse
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left !=null) {
                    q.offer(node.left);
                }
                if (node.right !=null) {
                    q.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        buildLevelOrderResult(root, res, 0);
        return res;
    }
    private void buildLevelOrderResult (TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) return;
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }
        List<Integer> lvlList = res.get(level);
        lvlList.add(node.val);
        buildLevelOrderResult(node.left, res, level + 1);
        buildLevelOrderResult(node.right, res, level + 1);

    }
}
