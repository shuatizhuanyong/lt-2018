import java.util.*;
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0 ; i < inorder.length ; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(inMap, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode buildTree(Map<Integer, Integer> inMap, int inEnd, int[] postorder, int pstart, int pend) {
        if (pstart > pend) return null;
        int val = postorder[pend];
        TreeNode node = new TreeNode(val);
        int index = inMap.get(val);
        int rightLength = inEnd - index;
        node.left = buildTree(inMap, index - 1, postorder, pstart, pend - rightLength - 1);
        node.right = buildTree(inMap, inEnd, postorder, pend - rightLength, pend - 1);
        return node;
    }
    public static void main (String args[]) {
        Solution so = new Solution();
        int[] ino = { 9,3,15,20,7 };
        int[] post = { 9,15,7,20,3 };
        TreeNode node = so.buildTree(ino, post);
        System.out.println(node);
    }
}
