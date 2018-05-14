
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        copyNode(head, map);
        return map.get(head);
    }

    private void copyNode(RandomListNode node, Map<RandomListNode, RandomListNode> map) {
        if (node == null) return;
        if (map.containsKey(node)) {
            return;
        }
        RandomListNode cpyNode = new RandomListNode(node.label);
        map.put(node, cpyNode);
        copyNode(node.next, map);
        copyNode(node.random, map);
        cpyNode.next = map.get(node.next);
        cpyNode.random = map.get(node.random);

    }
}
