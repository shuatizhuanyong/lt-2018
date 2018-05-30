
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        if (root == null || k <= 0) return -1;
        Stack<TreeNode> stk = new Stack<>();
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            if (list.size() == k - 1) {
                return node.val;
            }
            list.add(node.val);
            TreeNode nxt = node.right;
            while (nxt != null) {
                stk.push(nxt);
                nxt = nxt.left;
            }
        }
        return -1;
    }
}
class Solution0 {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) return -1;
        Stack<TreeNode> stk = new Stack<>();
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            k--;
            if (k == 0) {
                return node.val;
            }
            TreeNode nxt = node.right;
            while (nxt != null) {
                stk.push(nxt);
                nxt = nxt.left;
            }
        }
        return -1;
    }
}
