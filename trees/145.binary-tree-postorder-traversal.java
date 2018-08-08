//non recursive
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> stk = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode node = stk.peek();
            if (visited.add(node)) {
                if (node.right != null) stk.push(node.right);
                if (node.left != null) stk.push(node.left);
                if (stk.peek() != node) continue;
            }
            stk.pop();
            res.add(node.val);
        }
        return res;
    }
}

//non recursive -- standard iterative - 1
class Solution0 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode p = root;
        while (!stk.isEmpty() || p != null) {
            if (p != null){
                stk.push(p);
                res.add(0, p.val);
                p = p.right;
            } else {
                TreeNode node = stk.pop();
                p = node.left;
            }

        }
        return res;
    }
}

//non recursive -- standard iterative - 2
class Solution0 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            res.addFirst(node.val);
            if (node.left != null) stk.push(node.left);
            if (node.right != null) stk.push(node.right);
        }
        return res;
        
    }
}


class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        postorderTraversal(root, res);
        return res;
    }
    private void postorderTraversal(TreeNode node, List<Integer> res) {
        if (node == null) return;
        postorderTraversal(node.left, res);
        postorderTraversal(node.right, res);
        res.add(node.val);
    }
}
