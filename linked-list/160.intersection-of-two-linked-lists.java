public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int m = 0, n = 0;
        ListNode node = headA;
        while (node != null) {
            node = node.next;
            m++;
        }
        node = headB;
        while (node != null) {
            node = node.next;
            n++;
        }
        if (n > m) {
            return getIntersectionNode(headB, n, headA, m);
        } 
        return getIntersectionNode(headA, m, headB, n);
    }
    ListNode getIntersectionNode(ListNode headA, int m, ListNode headB, int n) {
        while (headA != null && headB != null) {
            if (m > n) {
                headA = headA.next;
                m--;
            } else {
                if (headA == headB) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
