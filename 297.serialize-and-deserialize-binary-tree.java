import java.util.*;
class Codec {

    static final String Null = "#";
    static final String Split = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        List<String> list = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                list.add(Null);
            } else {
                list.add(node.val + "");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        int end = list.size() - 1, i = 0;
        while (end >= 0) {
            if (!list.get(end).equals(Null)) {
                break;
            } 
            end--;
        }
        while (i <= end) {
            sb.append(list.get(i));
            if (i < end) {
                sb.append(Split);
            }
            i++;
        }
        return sb.toString();
    }

    private TreeNode createNode(String v) {
        return (v.equals(Null) ? null : new TreeNode(Integer.parseInt(v)));
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] vals = data.split(Split);
        TreeNode root = null;
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        while (i < vals.length) {
            TreeNode node = createNode(vals[i++]);
            if (q.isEmpty()) {
                root = node;
                q.offer(root);
                continue;
            } 
            TreeNode parent = q.poll();
            parent.left = node;
            if (i < vals.length) {
                parent.right = createNode(vals[i]);
            }
            if (parent.left != null) {
                q.offer(parent.left);
            }
            if (parent.right != null) {
                q.offer(parent.right);
            }
            i++;
        }
        return root;
    }
}

class Codec0 {

    // Encodes a tree to a single string.
    static final String SP = ",";
    static final String NULL = "#";
    public String serialize(TreeNode root) {
        if (root == null) return NULL;
        return root.val + SP + serialize(root.left) + SP + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] arr = data.split(SP);
        LinkedList<String> dq = new LinkedList<>();
        for (String val : arr) {
            dq.offer(val);
        }
        //String v = dq.poll();
        //TreeNode root = createNode(v);
        return buildTree(dq);
        //return root;
    }
    private TreeNode buildTree (LinkedList<String> dq) {
        if (dq.size() == 0){
            return null;
        };
        String v = dq.poll();
        if (NULL.equals(v)) return null;
        TreeNode node = createNode(v);
        node.left = buildTree(dq);
        node.right = buildTree(dq);
        return node;
    }
    private TreeNode createNode (String v) {
        if (v.equals(NULL)) return null;
        return new TreeNode(Integer.parseInt(v));
    }
    public static void main(String args[]) {
        Codec co = new Codec();
        TreeNode root = co.deserialize("1,2,3,#,4,7,3,#,#");
        System.out.println(root);

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
