class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dmy = new ListNode(-1);
        ListNode p = dmy;
        while (head != null) {
            if (head.val != val) {
                p.next = head;
                p = head;
            }
            head = head.next;
        }
        p.next = null;
        return dmy.next;
    }
}
