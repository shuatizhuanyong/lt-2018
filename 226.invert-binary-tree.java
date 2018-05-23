class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        invertTree(left);
        invertTree(right);
        root.left = right;
        root.right = left;
        return root;
    }
}
