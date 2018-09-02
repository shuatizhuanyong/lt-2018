class Solution {
    int mindf = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return mindf;
        searchMinDiff(root.left, Integer.MIN_VALUE, root.val);
        searchMinDiff(root.right, root.val, Integer.MAX_VALUE);
        return mindf;
    }
    void searchMinDiff(TreeNode node, int min, int max) {
        if (node == null) return;
        int localDiff = Integer.MAX_VALUE;
        if (min != Integer.MIN_VALUE){
            localDiff = node.val - min;
        }
        if (max != Integer.MAX_VALUE){
            localDiff = Math.min(localDiff, max - node.val);
        }
        mindf = Math.min(mindf, localDiff);
        searchMinDiff(node.left, min, node.val);
        searchMinDiff(node.right, node.val, max);
    }
}
