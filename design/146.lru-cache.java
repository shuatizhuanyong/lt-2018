class LRUCache {

    ListNode head, tail;
    Map<Integer, ListNode> map = new HashMap<>();
    int capacity;

    class ListNode {
        int key, val;
        ListNode pre, next;
    }

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be more than zero");
        }
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        int val = node.val;
        moveToHead(node);
        return val;
        
    }
    
    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (node == null) {
            node = new ListNode();
            map.put(key, node); //error: forgot this line
            node.key = key;
        }
        node.val = value;
        moveToHead(node);
        if (map.size() > this.capacity) {
            deleteTail();
        }
    }

    void moveToHead(ListNode node){
        if (node == head) return;
        ListNode pre = node.pre;
        ListNode nxt = node.next;
        if (pre != null) pre.next = nxt;
        if (nxt != null) nxt.pre = pre;
        if (head != null) {
            head.pre = node;
        }
        node.next = head;
        head = node;
        if (node == tail) {
            if (pre != null) tail = pre;
        }
        if (tail == null) tail = node;
        node.pre = null;
    }
    void deleteTail() {
        int key = tail.key;
        ListNode pre = tail.pre;
        pre.next == null;
        tail.pre = null;
        tail = pre;
        map.remove(key);
    }
    public static void main (String[] args) {
        
    }
}
