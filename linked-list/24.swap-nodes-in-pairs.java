class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dmy = new ListNode(-1);
        ListNode p = dmy;
        while (head != null && head.next != null) {
            ListNode n0 = head;
            ListNode n1 = head.next;
            ListNode nxt = n1.next;
            p.next = n1;
            n1.next = n0;
            n0.next = null;
            p = n0;
            head = nxt;
        }
        if (head != null) p.next = head;
        return dmy.next;

        
    }
}
