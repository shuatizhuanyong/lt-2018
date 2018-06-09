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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        findAndRemoveLeaves(root, res);
        return res;
    }
    private int findAndRemoveLeaves(TreeNode node, List<List<Integer>> res) {
        if (node == null) return -1;
        int level = Math.max(findAndRemoveLeaves(node.left, res), findAndRemoveLeaves(node.right, res)) + 1;
        if (res.size() <= level) {
            res.add(new ArrayList<Integer>());
        }
        List<Integer> list = res.get(level);
        list.add(node.val);
        return level;

    }
}
