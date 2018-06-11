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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        return generateTrees(1, n);
    }
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            TreeNode node = new TreeNode(start);
            list.add(node);
            return list;
        }

        for (int i = start ; i <= end ; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode ln : leftTrees) {
                for (TreeNode rn: rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = ln;
                    root.right = rn;
                    list.add(root);
                }
            }

        }
        return list;
    }
    public static void main(String args[]){
        Solution so = new Solution();
        List<TreeNode> list;
        list = so.generateTrees(3);
        System.out.println(list);
        list = so.generateTrees(0);
        System.out.println(list);

    }
}
