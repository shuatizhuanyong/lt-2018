import java.util.*;

class Solution {
    public int countComponents(int n, int[][] edges) {
        Uf uf = new Uf(n);
        for (int i = 0 ; i < edges.length ; i++) {
            int node = edges[i][0];
            int node0 = edges[i][1];
            uf.union(node, node0);
        }
        return uf.groups();
    }
    class Uf {
        int[] unions;
        public Uf(int size) {
            this.unions = new int[size];
            for (int i = 0 ; i < size; i++) {
                unions[i] = i;
            }
        }
        public void union(int p, int q) {
            int pr = find(p);
            int qr = find(q);
            if (pr != qr) {
                unions[qr] = pr;
            }
        }
        public int find(int p) {
            while (p != unions[p]) {
                p = unions[p];
                unions[p] = unions[unions[p]];
            }
            return p;
        }
        public int groups() {
            Set<Integer> rs = new HashSet<>();
            for (int i = 0 ; i < unions.length ; i++) {
                rs.add(find(i));
            }
            return rs.size();
        }

    }
    public static void main(String args[]) {
        Solution0 so = new Solution0();
        int rs = 0;
        rs = so.countComponents(5,  new int[][]{ { 0, 1 }, { 1, 2 }, { 3, 4 } });
        System.out.println(rs);
        rs = so.countComponents(5,  new int[][]{ { 0, 1 }, { 1, 2 }, {2, 3}, { 3, 4 } });
        System.out.println(rs);
    }
}
class Solution0 {
    public int countComponents(int n, int[][] edges) {

        int[] unions = new int[n];
        int[] ranks = new int[n];
        for (int i = 0 ; i < n; i++) {
            unions[i] = i;
            ranks[i] = 1;
        }
        int groups = n;
        for (int i = 0 ; i < edges.length ; i++) {
            int p = edges[i][0];
            int q = edges[i][1];
            int pr = find(unions, p);
            int qr = find(unions, q);
            if (pr != qr) {
                if (ranks[pr] > ranks[qr]) {
                    unions[qr] = pr;
                    ranks[pr] += ranks[qr];
                } else {
                    unions[pr] = qr;
                    ranks[qr] += ranks[pr];
                }
                groups--;
            }
        }
        return groups;
    }

    public int find(int[] unions, int p) {
        while (p != unions[p]) {
            p = unions[p];
            unions[p] = unions[unions[p]];
        }
        return p;
    }
}
