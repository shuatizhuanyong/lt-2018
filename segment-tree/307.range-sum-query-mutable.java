class NumArray {
    int[] nums;
    TreeNode root;

    public NumArray(int[] nums) {
        this.nums = nums;
        root = buildTree(nums, 0, nums.length - 1);
    }
    class TreeNode {
        int start, end;
        int sum;
        TreeNode left, right;
    }
    TreeNode buildTree (int[] nums, int start, int end) {
        if (start > end) return null;
        TreeNode node = new TreeNode();
        node.start = start;
        node.end = end;
        if (start == end) {
            node.sum = nums[start];
        } else {
            int mid = (start + end) / 2;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }
    
    public void update(int i, int val) {
        if (i < 0 || i >= nums.length) {
            throw new IllegalArgumentException("Invalid argument");
        }
        update(root, i, val);
    }
    void update(TreeNode node, int index, int val) {
        if(node.start == node.end) {
            node.sum = val;
            return;
        }
        int mid = (node.start + node.end) / 2 ;
        if (index <= mid) {
            update(node.left, index, val);
        } else {
            update(node.right, index, val);
        }
        node.sum = node.left.sum + node.right.sum;
    }
    
    public int sumRange(int i, int j) {
        int res = sumRange(root, i, j);
        return res;
    }

    int sumRange(TreeNode node, int start, int end) {
        if (node.start == start && node.end == end) {
            return node.sum;
        }
        int mid = (node.start + node.end) / 2;
        if (end <= mid) {
            return sumRange(node.left, start, end);
        } else if (mid < start) {
            return sumRange(node.right, start, end);
        } else {
            return sumRange(node.left, start, mid) + sumRange(node.right, mid + 1, end);
        }
    }
}
