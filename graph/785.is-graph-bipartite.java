import java.util.*;
/*
 * [tags] dfs, bfs
 * 
 * */
class Solution {

    public boolean isBipartite(int[][] graph) {
        if (graph.length == 0) return false;
        int m = graph.length;
        Map<Integer, Set<Integer>> adjs = new HashMap<>();
        for (int j = 0 ; j < m ; j++) {
            int[] edges = graph[j];
            for (int i = 0 ; i < edges.length ; i++) {

                if (!adjs.containsKey(edges[i])) {
                    adjs.put(edges[i], new HashSet<Integer>());
                }
                if (!adjs.containsKey(j)) {
                    adjs.put(j, new HashSet<Integer>());
                }
                adjs.get(edges[i]).add(j);
                adjs.get(j).add(edges[i]);
            }
        }
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        if (adjs.size()  == 0) return false;
        int start = adjs.keySet().iterator().next();
        s1.add(start);
        visited.add(start);
        for (Map.Entry<Integer, Set<Integer>> entry: adjs.entrySet()) {
            
            int node = entry.getKey();
            if (!s1.contains(node)) {
                Set<Integer> tmp = s1;
                s1 = s2;
                s2 = tmp;
            }
            Set<Integer> neibgors = entry.getValue();
            for (Integer nei : neibgors) {
                if (visited.contains(nei)) continue;
                if (s1.contains(nei)) return false;
                s2.add(nei);
                visited.add(nei);
            }

        }
       // System.out.println(s1);
       // System.out.println(s2);
       // System.out.println(adjs);
        return s1.size() + s2.size() == adjs.size();
    }
    public static void main (String[] args) {
        Solution0 so = new Solution0();
        boolean res = false;
        res = so.isBipartite(new int[][]{ { 0, 1 }, { 0, 3}, { 1, 3 }, {1, 2 } });
        System.out.println(res);
    }
}
class Solution0 {

    public boolean isBipartite(int[][] graph) {
        if (graph.length == 0) return false;
        int m = graph.length;
        boolean[] visited = new boolean[m];
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int i = 0 ; i < m; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            s1.add(i);
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            while (!q.isEmpty()) {
                int node = q.poll();
                if (s2.contains(node)) {
                    Set<Integer> tmp = s1;
                    s1 = s2;
                    s2 = tmp;
                }
                for (int nei : graph[node]) {
                    if (visited[nei]) {
                        if (s1.contains(nei)) return false;
                    } else {
                        visited[nei] = true;
                        s2.add(nei);
                        q.offer(nei);
                    }
                }
            }
        }
        return true;
    }
}
