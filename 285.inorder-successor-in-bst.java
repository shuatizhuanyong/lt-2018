class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode l = root;
        while (l != null) {
            stk.push(l);
            l = l.left;
        }
        boolean isP = false;
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            if (isP) return node;
            if (node == p) isP = true;

            TreeNode r = node.right;
            while (r != null) {
                stk.push(r);
                r = r.left;
            }
        }
        return null;
    }
}
