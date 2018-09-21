import java.util.*;
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) return 0;
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f: flights) {
            int s = f[0];
            int d = f[1];
            int p = f[2];
            if (!graph.containsKey(s)) {
                graph.put(s, new ArrayList<int[]>());
            }
            graph.get(s).add(new int[]{d, p});
        }
        int[] ps = new int[n];
        Arrays.fill(ps, -1);
        ps[src] = 0;
        int step = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while (!q.isEmpty()) {
            int size = q.size();
            //System.out.println(q);
            //System.out.println(Arrays.toString(ps));
            int[] temps = cloneArray(ps);
            while (size-- > 0) {
                int s = q.poll();
                List<int[]> nexts = graph.get(s);
                if (nexts == null) continue;
                for (int[] dp: nexts) {
                    if (ps[dp[0]] < 0 || temps[dp[0]] > ps[s] + dp[1]) {
                        temps[dp[0]] = ps[s] + dp[1];
                        q.offer(dp[0]);
                    }
                }
            }
            ps = cloneArray(temps);
            if (step == K) {
                break;
            }
            step++;
        }
        return ps[dst];
    }
    int[] cloneArray(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0 ; i < res.length ; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int res = -1;
        res = so.findCheapestPrice(3, new int[][]{ { 0,1,100 },{ 1,2,100 },{ 0,2,500 } }, 0, 2, 1);
        System.out.println(res);
        res = so.findCheapestPrice(3, new int[][]{ { 0,1,100 },{ 1,2,100 },{ 0,2,500 } }, 0, 2, 0);
        System.out.println(res);
        res = so.findCheapestPrice(4, new int[][]{ { 0,1,1 },{ 0,2,5 },{ 1,2,1 }, {2,3,1} }, 0, 3, 1);
        System.out.println(res);
        res = so.findCheapestPrice(5, new int[][]{ { 0,1,5 },{ 1,2,5 },{ 0,3,2 }, {3,1,2}, {1, 4, 1}, {4, 2, 1} }, 0, 2, 2);
        System.out.println(res);
//5
//[[0,1,5],[1,2,5],[0,3,2],[3,1,2],[1,4,1],[4,2,1]]
//0
//2
//2
    }
}
