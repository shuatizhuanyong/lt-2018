class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode node0 = split(head);
        head = sortList(head);
        node0 = sortList(node0);
        ListNode dmy = new ListNode(-1);
        ListNode p = dmy;
        while (head != null && node0 != null) {
            if (head.val < node0.val) {
                p.next = head;
                head = head.next;
            } else {
                p.next = node0;
                node0 = node0.next;
            }
            p = p.next;
        }
        if (head != null) {
            p.next = head;
        }
        if (node0 != null) {
            p.next = node0;
        }
        return dmy.next;
    }
    ListNode split (ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        return slow;
    }
}
