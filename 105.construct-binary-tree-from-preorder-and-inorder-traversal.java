import java.util.*;
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inMap = new HashMap<>();
        for (int i = 0 ; i < inorder.length ; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(inMap, preorder, 0, preorder.length - 1, 0);
    }
    private TreeNode buildTree(Map<Integer, Integer> inMap, int[] pre, int pStart, int pEnd, int inStart) {
        if (pStart > pEnd) return null;
        int val = pre[pStart];
        TreeNode node = new TreeNode(val);
        int inRoot = inMap.get(val);
        int leftLength = inRoot - inStart;
        node.left = buildTree(inMap, pre, pStart + 1, pStart + leftLength, inStart);
        node.right = buildTree(inMap, pre, pStart + leftLength + 1, pEnd, inRoot + 1);
        return node;
    }
    public static void main (String args[]) {
        Solution0 so = new Solution0();
        TreeNode tree = so.buildTree(new int[]{ 3,9,20,15,7 }, new int[]{ 9,3,15,20,7 }); 
        System.out.println(tree);

    }
}
