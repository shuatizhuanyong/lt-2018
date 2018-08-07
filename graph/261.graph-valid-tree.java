// try adjence list firstly
import java.util.*;
class Solution { 
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) return true;
        Set<Integer>[] adj = new Set[n];
        for (int i = 0 ; i < n; i++){
            adj[i] = new HashSet<Integer>();
        }
        for (int i = 0 ; i < edges.length; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            adj[n1].add(n2);
            adj[n2].add(n1);
        }
        boolean hasCycle = false;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while (!q.isEmpty()) {
            int node = q.poll();
            Set<Integer> neis = adj[node];
            for (int neighbor : neis) {
                if (!visited.add(neighbor)) return false;
                adj[neighbor].remove(node);
                q.offer(neighbor);
            }
        }
        return visited.size() == n;
    }
    public static void main (String args[]) {
        Solution0 so = new Solution0();
        boolean res = false;
        res = so.validTree(5, new int[][]{{ 0,1 }, { 0,2 }, { 0,3 }, { 1,4 }});
        System.out.println(res);
        res = so.validTree(5, new int[][]{{ 0,1 }, { 1,2 }, { 2,3 }, { 1,3 }, {1,4}});
        System.out.println(res);
    }
}

class Solution0 { 
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) return true;
        if (edges.length != n - 1) return false;

        int[] uf = new int[n];
        for (int i = 0 ; i < n; i++) {
            uf[i] = i;
        }
        for (int i = 0 ; i < edges.length ; i++) {
            int n0 = edges[i][0];
            int n1 = edges[i][1];
            int root0 = find(n0, uf);
            int root1 = find(n1, uf);
            if (root0 == root1) return false;
            //union
            uf[root0] = root1;
        }
        return true;
    }
    private int find(int n, int[] roots) {
        while (roots[n] != n) {
            roots[n] = roots[roots[n]];
            n = roots[n]; 
        }
        return n;
    }
}
