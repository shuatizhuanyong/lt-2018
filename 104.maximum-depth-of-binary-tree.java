class Solution {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }
    private int maxDepth(TreeNode node, int depth) {
        if (node == null) return depth;
        int leftDepth = maxDepth(node.left, depth + 1);
        int rightDepth = maxDepth(node.right, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }
}



// 
class Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
