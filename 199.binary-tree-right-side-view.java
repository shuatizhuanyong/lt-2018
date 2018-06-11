class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode r = null;
            while (size-- > 0) {
                r = q.poll();
                if (r.left != null) q.offer(r.left);
                if (r.right != null) q.offer(r.right);
            }
            res.add(r.val);
        }
        return res;
    }
}



class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        searchRightSide(root, res, 0);
        return res;
    }
    private void searchRightSide(TreeNode node, List<Integer> res, int depth) {
        if (node == null) return;
        if (res.size() <= depth) {
            res.add(node.val);
        }
        searchRightSide(node.right, res, depth + 1);
        searchRightSide(node.left, res, depth + 1);
    }
}
