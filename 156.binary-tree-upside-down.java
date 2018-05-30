class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        return shift(root, left, right);
    }
    private TreeNode shift(TreeNode node, TreeNode left, TreeNode right) {
        if (node == null || left == null) return node;
        TreeNode subRight = left.right;
        TreeNode subLeft = left.left;
        left.right = node;
        left.left = right;
        return shift(left, subLeft, subRight);
    }
}
