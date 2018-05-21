import java.util.*;
public class Helper {
    public static void print(int[][] arr) {
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }
    public static void print(TreeNode node) {
        if (node == null) {
            System.out.println("null");
        } else 
            System.out.println(node.toString());
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(this);
        int level = 0;
        while (!q.isEmpty()) {
            sb.append("`" + level + "`:[");
            int size = q.size();
            while (size > 0) {
                TreeNode node = q.poll();
                sb.append(node.val);
                if (size != 1) sb.append(", ");
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                size--;
            }
            sb.append(']').append(" ");

            level++;
        }
        sb.append("||");
        return sb.toString();
    }
}
