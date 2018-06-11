class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean seq = true;

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> list = LinkedList<>();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (seq) list.offer(node.val);
                else list.push(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(list);
            seq = !seq;
        }
        return res;
    }
}


class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        zigzagTraverse(root, res, 0);
        return res;
    }
    private void zigzagTraverse(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (res.size() == level) {
            res.add(new LinkedList<Integer>());
        }
        LinkedList<Integer> list = (LinkedList<Integer>)res.get(level);
        if (level % 2 == 0) {
            list.offer(root.val);
        } else {
            list.push(root.val);
        }
        zigzagTraverse(root.left, res, level + 1);
        zigzagTraverse(root.right, res, level + 1);
    }
}
