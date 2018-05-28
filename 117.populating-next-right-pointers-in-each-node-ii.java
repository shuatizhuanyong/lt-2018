class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode levelStart = root;
        while (levelStart != null) {
            TreeLinkNode cur = levelStart;
            TreeLinkNode pre = null;
            TreeLinkNode nxtLevel = null;
            while (cur != null) {
                if (cur.left != null) {
                    if (pre != null) {
                        pre.next = cur.left;
                    }
                    pre = cur.left;
                } 
                if (pre != null && nxtLevel == null) {
                    nxtLevel = pre;
                }
                if (cur.right != null){
                    if (pre != null) pre.next = cur.right;
                    pre = cur.right;
                }
                if (pre != null && nxtLevel == null) {
                    nxtLevel = pre;
                }
                cur = cur.next;
            }
            levelStart = nxtLevel;
        }
    }
    public static void main (String args[]) {
        Solution so = new Solution();
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode left = new TreeLinkNode(2);
        TreeLinkNode right = new TreeLinkNode(3);
        root.left = left;
        root.right = right;
        so.connect(root);
    }
}

class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dmp = new TreeLinkNode(-1);
        TreeLinkNode pre = dmp;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if (root == null) {
                pre = dmp;
                root = dmp.next;
                dmp.next = null;
            }
        }
    }
}
