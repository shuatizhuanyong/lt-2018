class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    private int leftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
    private int rightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
    public static void main(String args[]) {
        Solutiontest so = new Solutiontest();
        
    }
}
class Solution0 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }
        int rightLeftheight = leftHeight(root.right);
        if (rightLeftheight == leftHeight - 1) {
            return 1 + (1 << rightLeftheight) - 1 + countNodes(root.right);
        }
        return 1 + countNodes(root.left) + (1 << rightLeftheight) - 1;
    }
    private int leftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
    private int rightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}


class Solution1 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int num = 0;
        while (root != null) {
            int h = leftHeight(root);
            int righth = leftHeight(root.right);
            if (h == righth + 1) {
                num += (1 << righth);
                root = root.right;
            } else {
                num += (1 << righth);
                root = root.left;
            }
        }
        return num;
    }

    private int leftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
}
class Solutiontest {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode>  q = new LinkedList<>();
        q.offer(root);
        int cnt = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.val != -100) {
                node.val = -100;
                if (node.left != null) {
                    cnt++;
                    q.offer(node.left);
                }
                if (node.right != null) {
                    cnt++;
                    q.offer(node.right);
                }
            }
        }
        return cnt;
    }
}

