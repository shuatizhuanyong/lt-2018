class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode dmy = new ListNode(-1);
        ListNode p = dmy;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                p.next = l2;
                break;
            }
            if (l2 == null) {
                p.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        return dmy.next;
        
    }
}
