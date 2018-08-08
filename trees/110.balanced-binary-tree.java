class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root, new int[]{0});
    }
    private boolean isBalanced(TreeNode node, int[] height) {
        if (node == null) {
            return true;
        }
        int[] lh = new int[]{height[0]};
        int[] rh = new int[]{height[0]};
        boolean isBalanced = isBalanced(node.left, lh) && isBalanced(node.right, rh) && Math.abs(lh[0] - rh[0]) <= 1;
        height[0] = Math.max(lh[0], rh[0]) + 1;
        return isBalanced;
    }
}
class Solution1 {
    public boolean isBalanced(TreeNode root) {
        int height = getMaxDepth(root);
        if (height < 0) return false;
        return true;
    }
    private int getMaxDepth(TreeNode node) {
        if (node == null) return 0;
        int lh = getMaxDepth(node.left);
        int rh = getMaxDepth(node.right);
        if (lh < 0 || rh < 0 || Math.abs(lh - rh) > 1) return -1;
        return Math.max(lh, rh) + 1;
    }
}
