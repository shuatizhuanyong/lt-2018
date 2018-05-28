class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0, 0);
    }
    private int sumNumbers(TreeNode node, int total, int pathSum) {
        if (node == null) return total;
        if (node.left == null && node.right == null) {
            pathSum = pathSum * 10 + node.val;
            return total + pathSum;
        }
        if (node.left != null) {
            total = sumNumbers(node.left, total, pathSum * 10 + node.val );
        }
        if (node.right != null) {
            total = sumNumbers(node.right, total, pathSum * 10 + node.val );
        }
        return total;
    }
}


class Solution0 {
    int total = 0;
    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return total;
    }
    private void sumNumbers(TreeNode node, int pathSum) {
        if (node == null) return;
        pathSum = pathSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            total += pathSum;
            return;
        }
        sumNumbers(node.left, pathSum);
        sumNumbers(node.right, pathSum);
    }
}


class Solution1 {

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    private int sumNumbers(TreeNode node, int sum) {
        if (node == null) return 0;
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }
        return sumNumbers(node.left, sum) + sumNumbers(node.right, sum);
    }
}
