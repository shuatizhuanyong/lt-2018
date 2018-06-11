class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        int[] max = new int[]{0};
        //int[] range = new int[]{root.val, root.val}
        largestBSTSubtree(root, max);
        return max[0];
    }
    private int[] largestBSTSubtree(TreeNode node, int[] largest){
        if (node == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] lMax = new int[]{0}; 
        int[] rMax = new int[]{0}; 
        int[] lrange = largestBSTSubtree(node.left, lMax);
        int[] rrange = largestBSTSubtree(node.right, rMax);
        if (( node.val > Math.max(lrange[1], lrange[0]) || lrange[2] == 0) &&  ( rrange[2] == 0||node.val < Math.min(rrange[1], rrange[0] ) )) {
            largest[0] = lMax[0] + rMax[0] + 1;
            return new int[]{Math.min(node.val, lrange[0]), Math.max(node.val, rrange[1]), lrange[2] + rrange[2] + 1};
        } else {
            largest[0] = Math.max(lMax[0], rMax[0]);
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, lrange[2] + rrange[2] + 1};
        }
    }
    public static void main (String args[]) {
        Solution so = new Solution();
        TreeNode root = new TreeNode(10);
        int total = 0;
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(7);
        total = so.largestBSTSubtree(root);
        System.out.println(total);
    }
        

}
