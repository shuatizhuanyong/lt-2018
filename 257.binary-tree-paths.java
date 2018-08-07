/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        binaryTreePaths(root, res, "");
        return res;
    }
    private void binaryTreePaths(TreeNode node, List<String> res, String cur) {
        if (node == null) return;
       
       if (node.left == null && node.right == null)  {
           cur += node.val;
           res.add(cur);
           return;
       }
       binaryTreePaths(node.left, res, cur + node.val + "->");
       binaryTreePaths(node.right, res, cur + node.val + "->");
    }
}
