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
        //Codec cc = new Codec();
        //Strincc.serialize(this);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(this);
        int level = 0;
        List<String> res = new ArrayList<>();
        while (!q.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            //sb.append("'" + level + "':[");
            int size = q.size();
            while (size > 0) {
                TreeNode node = q.poll();
                if (node == null) {
                    sb.append("#");
                    if (size != 1) sb.append(", ");
                } else {
                    sb.append(node.val + "");
                    if (size != 1) sb.append(", ");
                    q.offer(node.left);
                    q.offer(node.right);
                }
               // if (node.left != null) q.offer(node.left);
               // if (node.right != null) q.offer(node.right);
                size--;
            }
           // sb.append(']').append(" ");
            level++;
            res.add(sb.toString());
        }
        StringBuilder sbres = new StringBuilder();
        for (String l : res) {
            sbres.append(l).append("\n");
        }
        return sbres.toString();
        //sb.append("||");
        //return sb.toString();
    }
    public static void main (String args[] ) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(root);
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
