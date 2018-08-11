/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dmy = new ListNode(-1);
        ListNode p = dmy;
        int sign = 0;
        while (l1 != null || l2 != null) {
            int i1 = (l1 != null) ? l1.val : 0;
            int i2 = (l2 != null) ? l2.val : 0;
            int val = (i1  +  i2 + sign) % 10;
            sign = (i1 + i2 + sign) / 10;
            p.next = new ListNode(val);
            p = p.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (sign > 0) p.next = new ListNode(sign);
        return dmy.next;
        
    }
}
