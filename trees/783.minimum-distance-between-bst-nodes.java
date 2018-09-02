class Solution {
    int minDf = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if (root == null) return minDf;
        minDiffInBST(root.left);
        if (pre != null) {
            minDf = Math.min(minDf, root.val - pre.val);
        }
        pre = root;
        minDiffInBST(root.right);
        return minDf;
    }
    TreeNode pre = null;
}
