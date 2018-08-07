public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        cloneGraph(node, map);
        return map.get(node);
    }
    private void cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (node == null) return;
        if (map.containsKey(node)) return ;
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        for (UndirectedGraphNode nei : node.neighbors) {
            cloneGraph(nei, map);
            newNode.neighbors.add(map.get(nei));
        }
        return;
    }
}
