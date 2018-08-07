class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode leftp = left, rightp = right;
        while(head != null) {
            ListNode nxt = head.next;
            if (head.val < x) {
                leftp.next = head;
                leftp = leftp.next;
            } else {
                rightp.next = head;
                rightp = rightp.next;
            }
            head = nxt;
        }
        leftp.next = right.next;
        rightp.next = null;
        return left.next;
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        ListNode head, res;
        head = ListNodeHelper.createNode(5, 4, 3, 2, 1);
        res = so.partition(head, 3);
        System.out.println(res);
    }
}
