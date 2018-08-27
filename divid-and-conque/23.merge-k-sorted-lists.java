class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dmy = new ListNode(-1);
        ListNode p = dmy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for (ListNode node: lists) { 
            if (node == null) continue;
            pq.add(node); 
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.add(node.next);
            }
            p.next = node;
            p = p.next;
        }
        return dmy.next;
    }
}
