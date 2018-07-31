class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) return head;
        int len = 0;
        ListNode node = head, tail = null;
        while (node != null) {
            if (node.next == null) tail = node;
            node = node.next;
            len++;
        }
        k = k % len;
        // k
        if (k == 0) return head;
        ListNode dmy = new ListNode(-1);
        dmy.next = head;
        ListNode fast = head, pre = dmy, slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = null;
        tail.next = head;
        return slow;
    }
    public static void main (String args[]) {
        Solution so = new Solution();
        ListNode head = ListNodeHelper.createNode(1,2,3,4,5);
        ListNode res;
        res = so.rotateRight(head, 3);
        System.out.println(res);
        head = ListNodeHelper.createNode(1,2,3,4,5);
        res = so.rotateRight(head, 1);
        System.out.println(res);
    }
}
