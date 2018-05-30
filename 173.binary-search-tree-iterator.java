public class BSTIterator {

    private Stack<TreeNode> st = null;
    public BSTIterator(TreeNode root) {
        st = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
        
    }

    /** @return the next smallest number */
    public int next() {
        if (!hasNext()) return -1;
        TreeNode node = st.pop();
        int val = node.val;
        TreeNode nr = node.right;
        while (nr != null) {
            st.push(nr);
            nr = nr.left;
        }
        return val;
        
    }
}

public class BSTIterator0 {

    private List<Integer> list = null;
    private int index = -1;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        index = 0;
    }

    private void inorder(TreeNode node) {
        Stack<TreeNode> stk = new Stack<>();
        while (node != null || !stk.isEmpty()) {
            while (node != null) {
                stk.push(node);
                node = node.left;
            } 
            node = stk.pop();
            list.add(node.val);
            node = node.right;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < list.size();
        
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index++);
    }
}
