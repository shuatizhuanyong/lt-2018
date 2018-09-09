import java.util.*;
/*
 * [tags] graph, dfs
 * */
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes.length == 0) return true;
        int m = dislikes.length;
        Map<Integer, List<Integer>> adjs = new HashMap<>();
        for (int i = 1 ; i <= N ; i++) {
            adjs.put(i, new ArrayList<Integer>());
        }
        for (int i = 0 ; i < m ; i++) {
            int[] dl = dislikes[i];
            adjs.get(dl[0]).add(dl[1]);
            //adjs.get(dl[1]).add(dl[0]);
        }
        int[] visited = new int[N + 1];
        // 0 not visited, 1: group1, 2: group2
        //System.out.println(adjs);
        for (Map.Entry<Integer, List<Integer>> entry: adjs.entrySet()) {
            int node = entry.getKey();
            if (visited[node] != 0) continue;
            Queue<Integer> q = new LinkedList<>();
            visited[node] = 1;
            q.offer(node);
            while (!q.isEmpty()){
                int cur = q.poll();
                List<Integer> neigbors = adjs.get(cur);
                for (int nei : neigbors) {
                    if (visited[nei] == 0) {
                        visited[nei] = (visited[cur] == 1 ? 2: 1);
                        q.offer(nei);
                    } else {
                        //System.out.println(Arrays.toString(visited));
                        //System.out.println(nei + ", cur: " + cur);
                        if (visited[nei] == visited[cur]) return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        boolean res = false;
        res = so.possibleBipartition(4, new int[][]{ { 1,2 },{ 1,3 },{ 2,4 } });
        System.out.println(res);
    }
}
