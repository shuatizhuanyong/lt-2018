
// should bfs/dfs both
// dfs is easy? 
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        List leftlist = inorderTraversal(root.left);
        if (leftlist.size() > 0) res.addAll(leftlist);
        res.add(root.val);
        List rightlist = inorderTraversal(root.right);
        if (rightlist.size() > 0) res.addAll(rightlist);
        return res;
    }
}
class Solution0 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        
        List leftlist = inorderTraversal(root.left);
        if (leftlist.size() > 0) res.addAll(leftlist);
        res.add(root.val);
        List rightlist = inorderTraversal(root.right);
        if (rightlist.size() > 0) res.addAll(rightlist);
        return res;
    }
}
class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(res, root);
        
        return res;
    }
    
    private void traverse(List<Integer> res, TreeNode node) {
        if (node == null) return;
        traverse(res, node.left);
        res.add(node.val);
        traverse(res, node.right);
    }
}

class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        Set<TreeNode> visited = new HashSet<>();
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            if (!visited.add(node)) {
                res.add(node.val);
                continue;
            }

            if (node.right != null) {
                st.push(node.right);
            }
            st.push(node);
            if (node.left != null) {
                st.push(node.left);
            }
        }
        return res;
    }
}

class Solution3 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
