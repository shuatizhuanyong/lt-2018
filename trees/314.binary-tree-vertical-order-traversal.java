
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> rs = new ArrayList<>();
        if (root == null) return rs;
        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{root, 0});
        int minLevel = 0, maxLevel = 0;
        while (!q.isEmpty()) {
            Object[] arr = q.poll();
            TreeNode node = (TreeNode)arr[0];
            int level = (Integer)arr[1];
            minLevel = Math.min(minLevel, level);
            maxLevel = Math.max(maxLevel, level);
            if (!map.containsKey(level)) {
                map.put(level, new ArrayList<Integer>());
            }
            map.get(level).add(node.val);
            if (node.left != null) {
                q.offer(new Object[]{node.left, level - 1});
            }
            if (node.right != null) {
                q.offer(new Object[]{node.right, level + 1});
            }
        }
        for (int i = minLevel ; i <= maxLevel; i++) {
            rs.add(map.get(i));
        }
        return rs;
    }
}
