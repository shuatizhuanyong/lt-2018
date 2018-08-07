class Solution {
    int longest = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        longestUnivaluePath(root, new int[]{0});
        return longest - 1;
    }
    void longestUnivaluePath(TreeNode node, int[] sideLongest) {
        if (node == null) {
            return;
        }
        int[] leftLongest = new int[]{0};
        int[] rightLongest = new int[]{0};
        if (node.left != null) {
            longestUnivaluePath(node.left, leftLongest);
            if (node.left.val != node.val) {
                leftLongest[0] = 0;
            }
        }

        if (node.right != null) {
            longestUnivaluePath(node.right, rightLongest);
            if (node.right.val != node.val) {
                rightLongest[0] = 0;
            }
        }

        sideLongest[0] = 1 + Math.max(leftLongest[0], rightLongest[0]);
        longest = Math.max(longest, leftLongest[0] + rightLongest[0] + 1);
    }
    public static void main(String args[] ) {
        Solution0 so = new Solution0();
        int res;
        res = so.longestUnivaluePath(new TreeNode(0));
        System.out.println(res);
    }
}

class Solution0 {

    int lg = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        sideLongest(root);
        return lg - 1;
    }
    int sideLongest(TreeNode node) {
        if (node == null) return 0;
        int leftLst = sideLongest(node.left);
        int rightLst = sideLongest(node.right);
        int localLongest = 1, sideLst = 0;
        
        if (node.left != null && node.left.val == node.val) {
            localLongest += leftLst;
            sideLst = leftLst;
        }
        if (node.right != null && node.right.val == node.val) {
            localLongest += rightLst;
            sideLst = Math.max(sideLst, rightLst);
        }
        lg = Math.max(lg, localLongest);
        return sideLst + 1;
    }

}
