class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (underNode(root.left, p)) {
            return underNode(root.left, q) ? lowestCommonAncestor(root.left, p, q): root;
        }
        return underNode(root.right, q)? lowestCommonAncestor(root.right, p, q): root;
    }
    private boolean underNode(TreeNode root, TreeNode node) {
        if (root == node) return true;
        if (root == null) return false;
        return underNode(root.left, node) || underNode(root.right, node);
    }
}
class Solution0 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        List<TreeNode> plist = new ArrayList<>();
        List<TreeNode> qlist = new ArrayList<>();
        findPath(root, p, plist);
        findPath(root, q, qlist);
        int i = 0;
        TreeNode res = root;
        while (i < Math.min(plist.size(), qlist.size())) {
            if (plist.get(i) != qlist.get(i)) break;
            res = plist.get(i);
            i++;
        }
        return res;
    }
    private boolean findPath(TreeNode root, TreeNode node, List<TreeNode> list) {
        if (root == null ) return false;
        list.add(root);
        if (root == node ) {
            return true;
        }

        boolean findInLeft = findPath(root.left, node, list);
        if (findInLeft) {
            return true;
        }
        boolean findInRight = findPath(root.right, node, list);
        if (findInRight) {
            return true;
        }
        list.remove(list.size() - 1);
        return false;

    }
}

class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode leftAnc = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAnc = lowestCommonAncestor(root.right, p, q);
        if (leftAnc != null && rightAnc != null) {
            return root;
        }
        return (leftAnc != null) ? leftAnc: rightAnc;
    }
}
