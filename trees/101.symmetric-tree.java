class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}


class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root);
        q2.offer(root);
        while (!q1.isEmpty()) {
           TreeNode n1 = q1.poll(); 
           TreeNode n2 = q2.poll(); 
           if (n1 == null && n2 == null) continue;
           if (n1 == null || n2 == null) return false;
           if (n1.val != n2.val ) return false;
           q1.offer(n1.left);
           q1.offer(n1.right);
           q2.offer(n2.right);
           q2.offer(n2.left);
        }
        return true;
    }
}
