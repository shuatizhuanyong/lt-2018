/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.val == q.val && isSameTree(p.left, q.left)  && isSameTree(p.right, q.right);
    }
}
class Solution1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> sp = new Stack<>();
        Stack<TreeNode> sq = new Stack<>();
        sp.push(p);
        sq.push(q);
        while (!sp.isEmpty()) {
            TreeNode pnode = sp.pop();
            TreeNode qnode = sq.pop();
            if (pnode == null && qnode == null) {
                continue;
            } else if (pnode == null || qnode == null) {
                return false;
            } else {
                if (pnode.val != qnode.val) return false;
                sp.push(pnode.left);
                sq.push(qnode.left);
                sp.push(pnode.right);
                sq.push(qnode.right);
            }
        }
        return true;
    }
}
