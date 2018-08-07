// so stupid approach
class Solution {
    public int closestValue(TreeNode root, double target){
        if (root == null) return -1;
        List<Integer> vals = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            vals.add(node.val);
            TreeNode r = node.right;
            while (r != null) {
                stk.push(r);
                r = r.left;
            }
        }
        int left = 0, right = vals.size() - 1;
        if (target < vals.get(left)) return vals.get(0); 
        if (target > vals.get(right)) return vals.get(right); 
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (vals.get(mid) < target) {
                if (vals.get(mid + 1) > target) {
                    int s = vals.get(mid);
                    int b = vals.get(mid + 1);
                    double sd = Math.abs(s - target);
                    double bd = Math.abs(b - target);
                    return (sd < bd)? s: b;
                }
                left = mid + 1;
            } else if (vals.get(mid) == target){
                return vals.get(mid);
            } else {
                right = mid;
            }

        }
        return -1;
            
    } 
}

class Solution0 {
    public int closestValue(TreeNode root, double target){
        if (root == null) return -1;
        return range(root, target, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private int range(TreeNode node, double target, long less, long more) {
        if (node.val == target) return node.val;
        else if (node.val > target ) {
            more = Math.min(more, node.val);
            if (node.left == null) {
                return (int)closestValue(target, less, more);
            }
            return range(node.left, target, less, more);
        } else {
            less = Math.max(less, node.val);
            if (node.right == null) return (int)closestValue(target, less, more);
            return range(node.right, target, less, more);
        }
    }
    private long closestValue(double t, long a, long b) {
        double ad = Math.abs(t - a);
        double bd = Math.abs(t - b);
        return ad < bd ? a : b;

    }
}

class Solution1 {
    public int closestValue(TreeNode root, double target) {
        if (root == null) return -1;
        int closest = root.val;
        double ds = Math.abs(root.val - target);
        while (root != null) {
            if (root.val == target) return root.val;
            if (root.val < target) {  
                double d = Math.abs(root.val - target);
                if (d < ds) {
                    closest = root.val;
                    ds = d;
                }
                root = root.right;
            } else {
                double d = Math.abs(root.val - target);
                if (d < ds) {
                    closest = root.val;
                    ds = d;
                }
                root = root.left;
            }
        }
        return closest;
    }
}
class Solution2 {
    public int closestValue(TreeNode root, double target) {
        if (root == null) return -1;
        return closestValue(root, target, root.val);

    }
    private int closestValue(TreeNode node, double target, int cur) {
        double curdf = Math.abs(target - cur);
        double df = Math.abs(target - node.val);
        if (df < curdf) {
            cur = node.val;
        }
        if (node.val > target && node.left != null) {
            return closestValue(node.left, target, cur);
        }
        if (node.val < target && node.right != null) {
            return closestValue(node.right, target, cur);
        }
        return cur;
    }
}
