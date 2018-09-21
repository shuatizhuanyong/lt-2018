class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode head = null;
    int len = 0;
    Random r = new Random();
    public Solution(ListNode head) {
        this.head = head;
        while (head != null) {
            head = head.next;
            len++;
        }
        
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int rIndex = r.nextInt(len);
        ListNode node = head;
        while (rIndex > 0) {
            node = node.next;
            rIndex--;
        }
        return node.val;
    }
}
