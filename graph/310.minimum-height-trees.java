
import java.util.*;
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n <= 0)  return res;
        if (n == 1) {
            res.add(0);
            return res;
        }
        if (n <= 2 ) {
            if( edges.length == n - 1 ){
                res.add(0);
                res.add(1);
            }
            return res;
        }
        if (edges.length != n - 1) return res;
        Set<Integer>[] graph = new Set[n];
        for (int i = 0 ; i < n; i++) graph[i] = new HashSet<Integer>();
        for (int i = 0 ; i < edges.length ; i++) {
            int p = edges[i][0];
            int q = edges[i][1];
            graph[p].add(q);
            graph[q].add(p);
        }
        int deepest = n;
        for (int i = 0 ; i < n; i++) {
            if (graph[i].size() > 1) {
                int idp = findDeepest(graph, i, new int[n], 0);
                if (idp < deepest) {
                    deepest = idp;
                    res.clear();
                    res.add(i);
                } else if (idp == deepest){
                    res.add(i);
                }
            }
        }
        return res;
    }
    private int findDeepest (Set<Integer>[] graph, int node, int[] visited, int cur) {
        if (visited[node] == 1) return 0;
        visited[node] = 1;
        int deep = cur;
        for (int nxt: graph[node]) {
            deep = Math.max(deep, findDeepest(graph, nxt, visited, cur + 1));
        }
        return deep;
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        List<Integer> list = null;

        list = so.findMinHeightTrees(4, new int[][]{{ 1, 0 }, { 1, 2 }, { 1, 3 }});
        System.out.println(list);
        list = so.findMinHeightTrees(6, new int[][]{ { 0, 3 }, { 1, 3 }, { 2, 3 }, { 4, 3 }, { 5, 4 } });
        System.out.println(list);
        list = so.findMinHeightTrees(6, new int[][]{ { 0,1 },{ 0,2 },{ 0,3 },{ 3,4 },{ 4,5 } });
        System.out.println(list);

 
    }
}



class Solution0 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        if (n <= 0 || n - 1 != edges.length)  return list;
        if (n == 1) {
            list.add(0);
            return list;
        }
        List<Integer>[] graph = new List[n];
        for (int i = 0 ; i < n ; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        int[] indegrees = new int[n];
        for (int i = 0 ; i < edges.length ; i++) {
            int n0 = edges[i][0];
            int n1 = edges[i][1];
            graph[n0].add(n1);
            graph[n1].add(n0);
            indegrees[n0]++;
            indegrees[n1]++;
        }
        LinkedList<Integer> q = new LinkedList<>();
        int unvst = n;
        for (int i = 0 ; i < n ; i++) {
            if (indegrees[i] == 0) return list;
            if (indegrees[i] == 1) {
                q.offer(i);
            }
        }
        while (unvst > 2) {
            int lsize = q.size();
            for (int i = 0 ; i < lsize ; i++ ) {
                int node = q.poll();
                unvst--;
                for (int neighbor: graph[node]) {
                    indegrees[neighbor]--;
                    if (indegrees[neighbor] == 1) {
                        q.offer(neighbor);
                    }
                }
            }
        }
        return q;
    }
}

