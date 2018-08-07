//[tags]: linkedlist
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int len = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            len++;
        }
        if (n > len) n = n % len;
        ListNode dmy = new ListNode(-1);
        dmy.next = head;
        ListNode fast = head, slow = head, pre = dmy;
        System.out.println(n);
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            pre = pre.next;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = slow.next;
        return dmy.next;
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        ListNode head = null, res = null;
        head = ListNodeHelper.createNode(1,2,3,4,5);
        //res = so.removeNthFromEnd(head, 2);
        System.out.println(res);

        head = ListNodeHelper.createNode(1);
        res = so.removeNthFromEnd(head, 1);
        System.out.println(res);
    }
}
