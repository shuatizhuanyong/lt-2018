class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            sb.append(node.val).append(',');
            node = node.next;
        }
        if (sb.length() > 0)  sb.setCharAt(sb.length() - 1, ']');
        else sb.append(']');
        sb.insert(0, '[');
        return sb.toString();
    }
}

class ListNodeHelper {
    public static ListNode createNode (int... vals) {
        if (vals.length == 0) return null;
        ListNode dmy = new ListNode(-1);
        ListNode head = new ListNode(0);
        dmy.next = head;
        for (int i = 0 ; i < vals.length ; i++) {
            head.val = vals[i];
            if (i != vals.length - 1) {
                head.next = new ListNode(0);
            }
            head = head.next;
        }
        return dmy.next;
    }
    public static void main(String args[]) {
        ListNode head = ListNodeHelper.createNode(1,2,3,4,5);
        System.out.println(head);
    }
}
