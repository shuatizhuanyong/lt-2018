class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {
            if (cur == null) {
                cur = st.pop();
            }
            if (cur.right != null) {
                st.push(cur.right);
            }
            if (cur.left != null) {
                cur.right = cur.left;
                TreeNode left = cur.left;
                cur.left = null;
                cur = left;
            } else {
                if (!st.isEmpty()) {
                    cur.right = st.pop();
                }
                cur = cur.right;
            }
        }
    }
}
